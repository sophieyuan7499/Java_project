package bbs.service;

import java.util.List;

import bbs.model.content;

public interface ContentService {
	/**
	 * 新增回复
	 */
	public boolean addContent(content comm);
	/**
	 * 获取回复
	 */
	public List<content> getContentByNewsId(int newsid);
	/**
	 * 删除回复
	 */
	public boolean deleteContentById(int id);
	
}
