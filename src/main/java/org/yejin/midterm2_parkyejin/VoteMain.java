package org.yejin.midterm2_parkyejin;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VoteMain {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"vote.xml");
		VoteService pollService = context.getBean("voteService",
				VoteService.class);

		pollService.voteFor();
		pollService.listVotes();
		context.close();
}
}
