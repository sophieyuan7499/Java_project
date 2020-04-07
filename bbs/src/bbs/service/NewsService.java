package bbs.service;

import java.util.List;

import bbs.model.news;

public interface NewsService {
	public boolean addNews(news new_0);

	/**
	 * �༭
	 */
	public boolean editNews(news new_0);

	/**
	 * ��ȡ �Жc(��ҳ��ʾ)
	 */
	public List<news> getNews(int PageIndex, int pageSize);
	/**
	 * ��ȡ  ����
	 */
	public List<news> getNewsByTitle(String title,int PageIndex, int pageSize);
	/**
	 * ��ȡ    ����id
	 */
	public news getNewsByNewsId(int newsid);
	/**
	 * ɾ��   newsid
	 */
	public boolean deleteByNewsId(int newsid);
	/**
	 * �鿴���Լ�����ĳ��е�����(���ֶ�)
	 */
	
	public List<news> getNewsByUserId(int userid,int pageIndex,int pageSize) ;   
	/**
	 * �������ӵ���
	 */
	public int getCountAllNews();
	public int getCountByTitle(String title);
}
