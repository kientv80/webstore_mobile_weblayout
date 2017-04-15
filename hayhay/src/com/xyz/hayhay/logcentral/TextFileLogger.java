package com.xyz.hayhay.logcentral;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.xyz.hayhay.util.ConfigurationHelper;

public class TextFileLogger {
	private static TextFileLogger instance;
	BlockingQueue<String> logingQueue = new ArrayBlockingQueue<>(1000);
	public static TextFileLogger getInstance(){
		if(instance == null)
			instance = new TextFileLogger();
		return instance;
	}
	public void log(String data){
		try {
			if(data != null)
			logingQueue.put(data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void consumeLog(){
		new Thread(){
			@Override
			public void run() {
				while(true){
					FileOutputStream writer = null;
					try {
						String log = logingQueue.take();
						File f = new File(ConfigurationHelper.getInstance().getValue("appDir")+"activitylog.log");
						writer = new FileOutputStream(f, true);
						writer.write(log.getBytes());
						writer.flush();
						long fileSizeInKB = f.length() / 1024;
						// Convert the KB to MegaBytes (1 MB = 1024 KBytes)
						long fileSizeInMB = fileSizeInKB / 1024;
						if(fileSizeInMB > 2){//> 2MB
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd: HH-mm-ss");
							f.renameTo(new File(ConfigurationHelper.getInstance().getValue("appDir")+"activitylog" + df.format(new Date(System.currentTimeMillis())) + ".log"));
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						if(writer != null)
							try {
								writer.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}
					
				}
			}
		}.start();;
		
	}
	public TextFileLogger() {
		consumeLog();
	}
}
