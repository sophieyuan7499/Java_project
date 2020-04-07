package bbs.service;

import java.util.List;

import bbs.model.news;

public interface NewsService {
	public boolean addNews(news new_0);

	/**
	 * 编辑
	 */
	public boolean editNews(news new_0);

	/**
	 * 获取 承朿(分页显示)
	 */
	public List<news> getNews(int PageIndex, int pageSize);
	/**
	 * 获取  标题
	 */
	public List<news> getNewsByTitle(String title,int PageIndex, int pageSize);
	/**
	 * 获取    帖子id
	 */
	public news getNewsByNewsId(int newsid);
	/**
	 * 删除   newsid
	 */
	public boolean deleteByNewsId(int newsid);
	/**
	 * 查看我自己发表的承有的帖子(带分顿)
	 */
	
	public List<news> getNewsByUserId(int userid,int pageIndex,int pageSize) ;   
	/**
	 * 计算帖子的数
	 */
	public int getCountAllNews();
	public int getCountByTitle(String title);
}
