package exam.dao;

import exam.model.News;

public interface NewsDao {
public News getNews(int newsid);
public void addNews(News news);
public void editNews(int newsid);

}
