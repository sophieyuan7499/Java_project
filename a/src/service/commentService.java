package  service;

import java.util.List;

import  model.comment;

public interface commentService {
	//��
	public void add(comment c) ;
		
		
	//��ѯĳ�����ӵ��������ۣ�newid��
	public comment selectALLcommect(int newsid);
	
}
