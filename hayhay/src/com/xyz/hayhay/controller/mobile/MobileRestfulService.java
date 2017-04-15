package com.xyz.hayhay.controller.mobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyz.hayhay.controller.BaseController;
import com.xyz.hayhay.db.dummydata.MappingHelper;
import com.xyz.hayhay.entirty.News;
import com.xyz.hayhay.entirty.NewsTypes;
import com.xyz.hayhay.entirty.WebsiteInfo;
import com.xyz.hayhay.service.article.NewsService;
import com.xyz.hayhay.util.JSONHelper;
import com.xyz.hayhay.util.MyUtil;
import com.xyz.webstore.mobile.config.Category;
import com.xyz.webstore.mobile.config.WebstoreMobileAppConfig;

@Controller
public class MobileRestfulService extends BaseController {
	@ResponseBody
	@RequestMapping(value = "/mobile/category", method = RequestMethod.GET)
	public void getMobileConfig(String version, HttpServletResponse resp) {
		try {
			List<Category> categories = WebstoreMobileAppConfig.getCaterofies(version);
			JSONObject conf = new JSONObject();
			// if (version != null && !version.isEmpty() &&
			// WebstoreMobileAppConfig.CURRENT_VERSION.equals(version)) {
			// conf.put("errorCode", "1");
			// conf.put("errorMsg", "No update");
			// } else {
			conf.put("errorCode", "0");
			conf.put("errorMsg", "");
			conf.put("version", WebstoreMobileAppConfig.CURRENT_VERSION);
			conf.put("categories", JSONHelper.toJSONArray(categories).toString());
			// }
			writeJSONResponsed(resp, conf);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/mobile/websiteinfo", method = RequestMethod.GET)
	public void getWebsites(String version, HttpServletResponse resp) {
		try {
			List<WebsiteInfo> webinfo = WebstoreMobileAppConfig.getWebsiteInfo(version);
			JSONObject conf = new JSONObject();
			// if (version != null && !version.isEmpty() &&
			// WebstoreMobileAppConfig.CURRENT_VERSION.equals(version)) {
			// conf.put("errorCode", "1");
			// conf.put("errorMsg", "No update");
			// } else {
			conf.put("errorCode", "0");
			conf.put("errorMsg", "");
			conf.put("version", WebstoreMobileAppConfig.CURRENT_VERSION);
			conf.put("webinfo", JSONHelper.toJSONArray(webinfo).toString());
			// }
			writeJSONResponsed(resp, conf);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/mobile/article/{category}", method = RequestMethod.GET)
	public void getArticles(@PathVariable String category, String userid, String from, HttpServletResponse resp) {
		try {
			if (category == null || category.isEmpty())
				category = MappingHelper.TINTUC;
			int fromIndex;
			if (from == null || from.isEmpty())
				fromIndex = 0;
			else
				fromIndex = Integer.parseInt(from);

			try {

				List<String> categories = MappingHelper.cateGroup.get(category);
				JSONObject result = null;
				if (categories != null && categories.size() > 0) {
					result = newsService.getNews(category + "article" + fromIndex, categories, 10, fromIndex);
				}
				if (result != null)
					writeSimpleJSONObjectResponse(resp, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/mobile/article/update", method = RequestMethod.GET)
	public void getArticles(String userid, String time, HttpServletResponse resp) {
		try {
			long filterTime = System.currentTimeMillis() - 5 * 60 * 1000;
			if (time != null && !time.isEmpty()) {
				filterTime = Long.parseLong(time);
			}
			try {
				List<String> categories = MappingHelper.cateGroup.get(MappingHelper.TINTUC);
				JSONObject result = null;
				if (categories != null && categories.size() > 0) {
					result = newsService.getLatestNews(categories,10,filterTime);
				}
				if (result != null)
					writeSimpleJSONObjectResponse(resp, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println((System.currentTimeMillis()-60*60*1000));
	}
}
