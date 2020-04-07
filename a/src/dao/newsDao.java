package dao;

import java.awt.print.Book;
import java.util.List;

import model.User;
import model.news;

public interface newsDao {
	// 增帖子
	public void addnews(news n);

	// 根据id删除帖子
	public void deletenews(int id);

	// 根据id编辑帖子
	public void updatenews(String content,String title,int id);

	// 查询所有帖子

	public List<news> selectAllnews();

	// 查询Id帖子
	public news selectidnews(int id);

	// 根据uersid查询帖子
	public List<news> selectueridnews(int userid);
	//根据标题查询帖子
	
	
	public  List<news> selectuertitlenews(String title);
}
