package bbs.dao;

import java.util.List;

import bbs.model.content;

public  interface ContentDao {
		public boolean addContent(content comm);
		/**
		 * ��ȡ�ظ�
		 */
		public List<content> getContentByNewsId(int newsid);
		/**
		 * ɾ���ظ�
		 */
		public boolean deleteContentById(int id);
		/**
		 * ����newsidɾ���ظ�
		 * 
		 */
		public void deleteContentByNewsId(int newsid);
	}
