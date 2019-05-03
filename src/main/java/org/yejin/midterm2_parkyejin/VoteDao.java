package org.yejin.midterm2_parkyejin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


/**
 * Data Access Object.<br>
 * 데이터베이스에 접속해서 데이터를 조작하는 인터페이스.
 */
@Repository
public class VoteDao {
	static final String ADD_VOTE = "INSERT vote(pollId, userId, name, choice) VALUES(?,?,?,?)";

	static final String LIST_VOTES = "SELECT pollId,userId,name, choice FROM vote WHERE pollId=?";

	static final String GET_AVERAGE = "SELECT avg(choice) FROM vote WHERE pollId=?";
	
	RowMapper<Vote> voteRowMapper = new BeanPropertyRowMapper<>(Vote.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * vote 테이블에 저장
	 */
	public int addVote(Vote vote) {
		return jdbcTemplate.update(ADD_VOTE, vote.getPollId(), vote.getUserId(),
				vote.getName(), vote.getChoice());
	}
	
	/**
	 * 
	 * vote목록
	 */
	List<Vote> listVotes(String pollId){
		return jdbcTemplate.query(LIST_VOTES, voteRowMapper, pollId);
	}

	/**
	 * vote.choice평균값
	 */
	public double getAverage(String pollId) {
		return jdbcTemplate.queryForObject(GET_AVERAGE, Double.class, pollId);
}

}