package bbs.dao;

import java.util.List;
import java.util.Map;

import bbs.model.News;

public interface NewsDao {
	public News getNewsById(int id);
	//根据新闻标题查询新闻
	//如果传入新闻标题为空则查询所有新闻
	public List<News> getNewsByTitle(String title);
	//两个参数，根据用户id和新闻标题查询新闻
	//在mybatis中，如果方法传递的参数为两个或者多个一般使用map，把参数封装为Map
	public List<News> getNewsByUserdAndTitle(Map<String, Object> m);
	
}
