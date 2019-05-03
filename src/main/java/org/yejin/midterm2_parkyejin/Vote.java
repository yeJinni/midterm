package org.yejin.midterm2_parkyejin;

public class Vote {
	// 문항번호
	String pollId;
	// 투표자 아이디
	String userId;
	// 이름
	String name;
	// 투표내용
	String choice;

	/* * Getter and Setter methods */
	public String getPollId() {
		return pollId;
	}
	public void setPollId(String pollId) {
		this.pollId = pollId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}

	@Override
	public String toString() {
		return "Vote [pollId=" + pollId + ", userId=" + userId + ", name="
				+ name + ", choice=" + choice + "]\n";
	}
}