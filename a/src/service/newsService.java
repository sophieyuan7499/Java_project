package  service;

import java.util.List;

import  model.news;

public interface newsService {
	
		//增帖子
		public void add(news n);

		// 根据id删除帖子
		public void delete(int id);

		// 根据id编辑帖子
		public void update( String content,String tile,int id);

		// 查询所有帖子

		public List<news> selectAllnews();

		// 查询Id帖子
		public news selectidnews(int id);

		// 根据uersid查询帖子
		public List<news> selectueridnews(int userid);
		//根据标题查询帖子
		public List<news> selectuertitlenews(String  title);
	
}
