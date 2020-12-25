package mypack.model;

import java.util.List;

/**
 * Created by Peter MOUEZA on 05/10/20 04:24
 *  
 */
public class Question {
    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;


    /**
     * robustesse
     */
    public Question() {
        /** assert mChoiceList.size() >= 0;

         assert mAnswerIndex >= 0;
         assert mAnswerIndex >= 0;
         assert mAnswerIndex < mChoiceList.size();
         */

    }

    /**
     * 1:07
     */
    public Question(String question, List<String> choiceList, int answerIndex) {
        /**  mQuestion = question;
         mChoiceList = choiceList;
         mAnswerIndex = answerIndex;*/
        this.setQuestion(question);
        this.setChoiceList(choiceList);
        this.setAnswerIndex(answerIndex);
    }

    /**
     * cf astuce pr enlever le m ds getter setter
     */
    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        mChoiceList = choiceList;
    }

    public int getAnswerIndex() {
        return mAnswerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        mAnswerIndex = answerIndex;
    }
}
