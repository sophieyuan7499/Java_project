package bbs.service;

import java.util.List;

import bbs.model.content;

public interface ContentService {
	/**
	 * �����ظ�
	 */
	public boolean addContent(content comm);
	/**
	 * ��ȡ�ظ�
	 */
	public List<content> getContentByNewsId(int newsid);
	/**
	 * ɾ���ظ�
	 */
	public boolean deleteContentById(int id);
	
}
