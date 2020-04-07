package bbs.dao;

import java.util.List;

import bbs.model.content;

public  interface ContentDao {
		public boolean addContent(content comm);
		/**
		 * 获取回复
		 */
		public List<content> getContentByNewsId(int newsid);
		/**
		 * 删除回复
		 */
		public boolean deleteContentById(int id);
		/**
		 * 根据newsid删除回复
		 * 
		 */
		public void deleteContentByNewsId(int newsid);
	}
