package dao;

import java.awt.print.Book;
import java.util.List;

import model.User;
import model.news;

public interface newsDao {
	// ������
	public void addnews(news n);

	// ����idɾ������
	public void deletenews(int id);

	// ����id�༭����
	public void updatenews(String content,String title,int id);

	// ��ѯ��������

	public List<news> selectAllnews();

	// ��ѯId����
	public news selectidnews(int id);

	// ����uersid��ѯ����
	public List<news> selectueridnews(int userid);
	//���ݱ����ѯ����
	
	
	public  List<news> selectuertitlenews(String title);
}
