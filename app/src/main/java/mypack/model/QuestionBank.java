package mypack.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter MOUEZA on 05/10/20 05:58
 *  
 */
public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;
    List<Question> mUsedQuestionsMoi = new ArrayList<Question>();
    List<Integer> mUsedIndexMoi = new ArrayList<Integer>();

    public List<Question> getQuestionList() {
        return mQuestionList;
    }

    public void setQuestionList(List<Question> questionList) {
        mQuestionList = questionList;
    }

    public int getNextQuestionIndex() {
        return mNextQuestionIndex;
    }

    public void setNextQuestionIndex(int nextQuestionIndex) {
        mNextQuestionIndex = nextQuestionIndex;
    }

    /**TODO irerator https://www.journaldev.com/2389/java-8-features-with-examples#iterable-forEach*/
    /**
     * TODO Sortable
     */
    public QuestionBank(List<Question> questionList) {
        // Shuffle the question list before storing it
       /* List<Item> itemCollection=new ArrayList<>();
        Question item = null;
        for (Question quest:questionList) {

        }*/
        List<Question> questionListRandom = new ArrayList<Question>();
        List<Question> questionListDecrSubstractedTAIL = new ArrayList<Question>();
        questionListDecrSubstractedTAIL = questionList;

        Integer indexRand = null;
        for (int indxMax = questionList.size() - 1; indxMax <= 0; indxMax--) {
            indexRand = randomIndexMoi(questionListDecrSubstractedTAIL);
            /**https://stackoverflow.com/questions/45646577/show-android-studio-full-method-description/45646611*/
            questionListDecrSubstractedTAIL.remove(indexRand);
            questionListRandom.add(questionList.get((Integer) indexRand));
        }
        this.setQuestionList(questionListRandom);
    }

    public int randomIndexMoi(List ll) {
        int indxMax = ll.size() - 1;
        Integer indexRand = null;
        indexRand = (int) Math.round(Math.random() * (indxMax));
        return indexRand;
    }

    /**
     * does not repeat even after a cycle
     * TODO Generic
     * TODO modulo 4 last, because incr there
     * TODO no double shuffle ? index vs
     */
    public Question getQuestion() {
        // Loop over the questions and return a new one at each call
        int choicePos = this.randomIndexMoi(this.mQuestionList);
        Question choiceQuestion = this.mQuestionList.get(choicePos);
        int indexLast = this.mUsedIndexMoi.get(this.mUsedIndexMoi.size() - 1);
        while (choicePos == indexLast) {
            choicePos = this.randomIndexMoi(this.mQuestionList);
        }
        this.mUsedIndexMoi.add(choicePos);
        Question questionsCollectionTAIL = this.mQuestionList.remove(choicePos);
        choiceQuestion = this.mQuestionList.get(choicePos);
        return choiceQuestion;
    }

    /**
     * for testing
     * DYNAMIC assert ?
     * all different, one the other
     * combination
     * pr tt x, x is not included in ListTail recursive functional
     */
    public boolean isAllDifferentMoiTest(ArrayList<Question> questionsCollectionn) {
        return false;
    }
}