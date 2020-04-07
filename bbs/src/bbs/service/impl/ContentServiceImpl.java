package bbs.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import bbs.dao.ContentDao;
import bbs.dao.ipml.ContentDaoImpl;
import bbs.model.content;
import bbs.service.ContentService;

public class ContentServiceImpl implements ContentService {
	private ContentDao commdao = new ContentDaoImpl();

	public boolean addContent(content comm) {
		
		return commdao.addContent(comm);
	}
	//ªÒ»°∆¿¬€
	@Override
	public List<content> getContentByNewsId(int newsid) {
		List<content> lst = commdao. getContentByNewsId(newsid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		for(int i=0;i<lst.size();i++){
			lst.get(i).setDateStr(sdf.format(lst.get(i).getDate()));
			
		}
		return lst;
	}

	@Override
	public boolean deleteContentById(int id) {
		// TODO Auto-generated method stub
		return commdao.deleteContentById(id);
	}

}
