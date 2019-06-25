package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Authority;
import domain.Teacher;
import domain.Score;

public interface ScoreDao {
	
	
	List<Score> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows);
	Integer findCount(DetachedCriteria detachedCriteria);
	/*void save(Authority authority);
	Authority findBySelectId(String id);
	void update(Authority authority);*/
	void save(Score score);
	List<Score> findById(String[] arr);
	void delete(List<Score> list);
	Score findBySelectId(String id);
	void update(Score score);
	int findCounts(Score score);
	int findCounts(DetachedCriteria detachedCriteria);
	int findScoreCounts();
	List<Score> getRandomScoreList();
	void saveScoreAfterTest(Score score);
	List<Score> findByScore(DetachedCriteria detachedCriteria);
	void updateScoreAfterTest(Score score2);
}
