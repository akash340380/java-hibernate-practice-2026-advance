package org.example;

import javax.persistence.*;

@Entity
public class Question
{
    public Question() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int questionId;
    String question;

    @OneToOne(cascade = CascadeType.ALL)
    Answer answer;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
