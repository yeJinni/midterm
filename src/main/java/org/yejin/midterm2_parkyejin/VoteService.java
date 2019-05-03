package org.yejin.midterm2_parkyejin;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class VoteService {
	
	static final Logger logger = LogManager.getLogger();
	
	@Autowired
	VoteDao voteDao;

	/**
	 * 투표 하기
	 */
	public void voteFor() {
		Vote vote = new Vote();
		vote.setPollId("1");
		vote.setUserId("7");
		vote.setName("예진");
		vote.setChoice("5");
	
		try {
			voteDao.addVote(vote);
			logger.debug("투표가 잘 되었습니다.");
		} catch (DuplicateKeyException e) { // 중복 투표할 경우
			logger.error("이미 투표하셨습니다.");
		}
	}
	/**
	 *투표결과 출력
	 */
	public void listVotes() {
		final String pollId = "1";
		List<Vote> voteList = voteDao.listVotes(pollId);
		double average = voteDao.getAverage(pollId);
		
		logger.debug(voteList);
		logger.debug("Average = {}",average);
	}
}
