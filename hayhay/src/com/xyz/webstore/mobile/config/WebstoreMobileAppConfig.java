package com.xyz.webstore.mobile.config;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.simple.JSONObject;

import com.xyz.hayhay.db.dummydata.MappingHelper;
import com.xyz.hayhay.entirty.NewsTypes;
import com.xyz.hayhay.entirty.WebsiteInfo;
import com.xyz.hayhay.util.JSONHelper;

public class WebstoreMobileAppConfig {
	public static final String CURRENT_VERSION = "1.0";
	
	public static JSONObject getConfig(String version) throws JSONException{
		JSONObject conf = new JSONObject();
		if(CURRENT_VERSION.equals(version)){
			conf.put("errorCode", "1");
			conf.put("errorMsg", "No update");
			return conf;
		}
			
		List<Item> news = new ArrayList<>();
		news.add(new Item("news", "Tin Tức", "http://360hay.com/news/tintuc"));
		news.add(new Item("economic", "Kinh Tế", "http://360hay.com/news/kinhte"));
		news.add(new Item("kd", "Kinh Doanh", "http://360hay.com/news/KINH_DOANH"));
		news.add(new Item("tech", "Công Nghệ", "http://360hay.com/news/congnghe"));
		news.add(new Item("sport", "Thể Thao", "http://360hay.com/news/thethao"));
		news.add(new Item("xe", "Xe", "http://360hay.com/news/xe"));
		news.add(new Item("nhadat", "Nhà Đất", "http://360hay.com/news/batdongsan"));
		news.add(new Item("khoinghiep", "Khởi Nghiệp", "http://360hay.com/news/KHOINGHIEP"));
		news.add(new Item("ngoisao", "Ngôi Sao", "http://360hay.com/cate/ngoisao"));
		Category newsCate = new Category("news", "Tin Tức", null,"");
		newsCate.setItems(news);
		newsCate.setIcon("http://360hay.com/images/icons/mobile/ic_update.png");
		
		List<Item> entertainment = new ArrayList<>();
		entertainment.add(new Item("ngoisao", "Ngôi Sao", "http://360hay.com/cate/ngoisao"));
		entertainment.add(new Item("tinhyeu", "Tình Yêu", "http://360hay.com/cate/tinhyeu"));
		entertainment.add(new Item("cuoi", "Chuyện Cười", "http://360hay.com/cate/funystory"));
		Category entertainmentCate = new Category("entertainment", "Giải Trí", null,"");
		entertainmentCate.setItems(entertainment);
		entertainmentCate.setIcon("http://360hay.com/images/icons/mobile/ic_smile.png");
		
		List<Item> music = new ArrayList<>();
		music.add(new Item("nhac", "Nghe Nhạc", "http://360hay.com/cate/nhac"));
		music.add(new Item("film", "Xem Phim", "http://360hay.com/cate/film"));
		music.add(new Item("galaxy", "Galaxy", "http://360hay.com/cate/movie"));
		Category musicCate = new Category("music_film", "Giải Trí", null,"");
		musicCate.setItems(music);
		musicCate.setIcon("http://360hay.com/images/icons/mobile/ic_music.png");
		
		List<Item> kienthuc = new ArrayList<>();
		kienthuc.add(new Item("baithuoc", "Sức Khỏe-Bài Thuốc", "http://360hay.com/cate/suckhoe"));
		kienthuc.add(new Item("nauan", "Nấu Ăn", "http://360hay.com/cate/nauan"));
		Category kienthucCate = new Category("knowledge", "Giải Trí", null,"");
		kienthucCate.setItems(kienthuc);
		kienthucCate.setIcon("http://360hay.com/images/icons/mobile/ic_books.png");
		
		List<Item> tienich = new ArrayList<>();
		tienich.add(new Item("xoso", "Xổ Số", "http://360hay.com/webstore/lottery"));
		tienich.add(new Item("lichtv", "Lịch TV", "http://360hay.com/entertainment/tvprogram"));
		tienich.add(new Item("tudien", "Từ Điển", "http://m.dict.laban.vn"));
		tienich.add(new Item("timquanhday", "Tìm Quanh Đây", "http://360hay.com/location/nearby"));
		Category tienichCate = new Category("util", "Tiện Ích", null,"");
		tienichCate.setItems(tienich);
		tienichCate.setIcon("http://360hay.com/images/icons/mobile/ic_apps.png");
		
		List<Category> categories = new ArrayList<>();
		categories.add(newsCate);
		categories.add(entertainmentCate);
		categories.add(musicCate);
		categories.add(kienthucCate);
		Category findAround = new Category("findaround","Tình Quanh Đây","http://360hay.com/location/nearby","");
		findAround.setIcon("http://360hay.com/images/icons/mobile/ic_location.png");
		categories.add(findAround);
		
		categories.add(tienichCate);
		Category web = new Category("webstore","WebStore","http://360hay.com/webstore","");
		web.setIcon("http://360hay.com/images/icons/mobile/ic_web.png");
		categories.add(web);
		
		conf.put("errorCode", "0");
		conf.put("errorMsg", "");
		conf.put("version", CURRENT_VERSION);
		conf.put("categories",JSONHelper.toJSONArray(categories).toString());
		
		return conf;
	}
	public static List<Category> getCaterofies(String version) throws JSONException{
		List<Category> categories = new ArrayList<>();
		Category tintuc = new Category(MappingHelper.TINTUC,"Tin Tức","http://360hay.com/mobile/article/"+MappingHelper.TINTUC,"http://360hay.com/images/icons/category/ic_news.png");
		Category kinhte = new Category(MappingHelper.KINHTE,"Kinh Tế","http://360hay.com/mobile/article/"+MappingHelper.KINHTE,"http://360hay.com/images/icons/category/ic_economy.png");
		Category kinhdoanh = new Category(NewsTypes.KINH_DOANH,"Kinh Doanh","http://360hay.com/mobile/article/"+NewsTypes.KINH_DOANH,"http://360hay.com/images/icons/category/ic_kinhdoanh.png");
		Category congnghe = new Category(MappingHelper.CONGNGHE,"Công Nghệ","http://360hay.com/mobile/article/"+MappingHelper.CONGNGHE,"http://360hay.com/images/icons/category/ic_tech.png");
		Category thethao = new Category(MappingHelper.THETHAO,"Thể Thao","http://360hay.com/mobile/article/"+MappingHelper.THETHAO,"http://360hay.com/images/icons/category/ic_sport.png");
		Category xe = new Category(MappingHelper.XE,"Ô Tô-Xe Máy","http://360hay.com/mobile/article/"+MappingHelper.XE,"http://360hay.com/images/icons/category/ic_xe.png");
		Category nhadat = new Category(MappingHelper.BATDONGSAN,"Nhà Đất","http://360hay.com/mobile/article/"+MappingHelper.BATDONGSAN,"http://360hay.com/images/icons/category/ic_building.png");
		Category khoinghiep = new Category(NewsTypes.KHOINGHIEP,"Khởi Nghiệp","http://360hay.com/mobile/article/" +NewsTypes.KHOINGHIEP,"http://360hay.com/images/icons/category/ic_ngoisao.png");
		Category ngoisao = new Category(MappingHelper.NGOISAO,"Ngôi Sao","http://360hay.com/mobile/article/"+MappingHelper.NGOISAO,"http://360hay.com/images/icons/category/ngoisao.png");
		Category suckhoe = new Category(MappingHelper.SUCKHOE,"Sức Khỏe","http://360hay.com/mobile/article/"+MappingHelper.SUCKHOE,"http://360hay.com/images/icons/category/ic_suckhoe.png");
		Category tinhyeugiadinh = new Category(MappingHelper.TINHYEU,"Tinh Yêu-Gia Đình","http://360hay.com/mobile/article/" + MappingHelper.TINHYEU,"http://360hay.com/images/icons/category/ic_love.png");
		Category nauan = new Category(NewsTypes.NAUAN,"Nấu Ăn","http://360hay.com/mobile/article/"+NewsTypes.NAUAN,"http://360hay.com/images/icons/category/cooking.png");
		Category nhac = new Category(MappingHelper.NHAC,"Nghe Nhạc","http://360hay.com/mobile/article/"+MappingHelper.NHAC,"http://360hay.com/images/icons/category/ic_music.png");
		
		Category soxo = new Category(MappingHelper.NHAC,"Kết Qủa Sổ Xố","http://360hay.com/webstore/lottery","http://360hay.com/images/icons/category/ic_lottery.png");
		soxo.setOpenLink(true);
		Category tv = new Category(MappingHelper.NHAC,"Lịch Phát Sóng TV","http://360hay.com/entertainment/tvprogram","http://360hay.com/images/icons/category/ic_tv.png");
		tv.setOpenLink(true);
		
		categories.add(tintuc);
		categories.add(kinhte);
		categories.add(kinhdoanh);
		categories.add(congnghe);
		categories.add(thethao);
		categories.add(xe);
		categories.add(nhadat);
		categories.add(khoinghiep);
		categories.add(ngoisao);
		categories.add(suckhoe);
		categories.add(tinhyeugiadinh);
		categories.add(nauan);
		categories.add(nhac);
		return categories;
	}
	public static List<WebsiteInfo> getWebsiteInfo(String version) throws JSONException{
		List<WebsiteInfo> webs = new ArrayList<>();
		webs.add(new WebsiteInfo("ngoisao.net", "", "http://360hay.com/images/website_icon/ngoisaonet.jpg", "cover", "url"));
		webs.add(new WebsiteInfo("muabannhadat.vn", "", "", "cover", "url"));
		webs.add(new WebsiteInfo("galaxycine.vn", "", "icon", "cover", "url"));
		webs.add(new WebsiteInfo("ictnews.vn", "", "http://360hay.com/images/website_icon/ictnews.png", "cover", "url"));
		webs.add(new WebsiteInfo("news.zing.vn", "", "http://360hay.com/images/website_icon/zingnews.jpg", "cover", "url"));
		webs.add(new WebsiteInfo("tuoitre.vn", "", "http://360hay.com/images/website_icon/tuoitre.jpg", "cover", "url"));
		webs.add(new WebsiteInfo("dantri.com.vn", "", "http://360hay.com/images/website_icon/dantri.jpg", "cover", "url"));
		webs.add(new WebsiteInfo("bizlive.vn", "", "http://360hay.com/images/website_icon/bizlive.png", "cover", "url"));
		webs.add(new WebsiteInfo("vneconomy.vn", "", "http://360hay.com/images/website_icon/vneconomy.png", "cover", "url"));
		webs.add(new WebsiteInfo("cafebiz.vn", "", "", "cover", "url"));
		webs.add(new WebsiteInfo("suckhoedoisong.vn", "", "", "cover", "url"));
		webs.add(new WebsiteInfo("thethao247.vn", "", "http://360hay.com/images/website_icon/thethao247.png", "cover", "url"));
		webs.add(new WebsiteInfo("24h.com.vn", "", "", "cover", "url"));
		webs.add(new WebsiteInfo("afamily.vn", "", "http://360hay.com/images/website_icon/afamily.png", "cover", "url"));
		webs.add(new WebsiteInfo("monngonmoingay.com", "", "", "cover", "url"));
		webs.add(new WebsiteInfo("nhaccuatui.com", "", "http://360hay.com/images/website_icon/nhaccuatui.jpg", "cover", "url"));
		webs.add(new WebsiteInfo("nhac.vn", "", "http://360hay.com/images/website_icon/nhac.png", "cover", "url"));
		webs.add(new WebsiteInfo("kinhdoanh.vnexpress.net", "", "http://360hay.com/images/website_icon/vnexpress.png", "cover", "url"));
		webs.add(new WebsiteInfo("vnexpress.net", "", "http://360hay.com/images/website_icon/vnexpress.png", "cover", "url"));
		webs.add(new WebsiteInfo("phimmoi.net", "", "http://360hay.com/images/website_icon/phimmoi.png", "cover", "url"));
		webs.add(new WebsiteInfo("baoxaydung.com.vn", "", "http://360hay.com/images/website_icon/xaydung.png", "cover", "url"));
		webs.add(new WebsiteInfo("pcworld.com.vn", "", "http://360hay.com/images/website_icon/pcworld.png", "cover", "url"));
		webs.add(new WebsiteInfo("bongda24h.vn", "", "http://360hay.com/images/website_icon/bongda24h.png", "cover", "url"));
		webs.add(new WebsiteInfo("suckhoegiadinh.com.vn", "", "http://360hay.com/images/website_icon/suckhoegiadinh.jpg", "cover", "url"));

		return webs;
	}
}