package org.greengin.senseitweb.logic.project.challenge;

import java.util.Collection;

import org.greengin.senseitweb.entities.activities.challenge.ChallengeAnswer;

public class NewChallengeAnswerResponse {
	Collection<ChallengeAnswer> answers;
	Long newAnswer;
	
	public Collection<ChallengeAnswer> getAnswers() {
		return answers;
	}
	public void setAnswers(Collection<ChallengeAnswer> answers) {
		this.answers = answers;
	}
	public Long getNewAnswer() {
		return newAnswer;
	}
	public void setNewAnswer(Long newAnswer) {
		this.newAnswer = newAnswer;
	}
}
