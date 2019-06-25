package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


import domain.PageBean;
import domain.Score;


public interface ScoreService {
	
	
	
	PageBean<Score> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);

	void save(Score score);

	List<Score> findById(String[] arr);

	void delete(List<Score> list);

	Score findBySelectId(String id);

	void update(Score score);

	int findCounts(Score score);

	int findCounts(DetachedCriteria detachedCriteria);

	List<Score> getRandomScoreList();

	void saveScoreAfterTest(Score score);

	List<Score> findByScore(DetachedCriteria detachedCriteria);

	void updateScoreAfterTest(Score score2);



}
