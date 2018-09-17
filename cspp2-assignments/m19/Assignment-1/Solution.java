/**
 * @author:manojbandari.
 */
import java.util.Scanner;

/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int TEMP=100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int numberOfQuestions;
    /**
     * { var_description }.
     */
    private String[] answers;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[TEMP];
        answers = new String[TEMP];
        numberOfQuestions = 0;
        size = 0;
    }

    /**
     * Adds a question.
     *
     * @param      question  The question.
     */
    public void addQuestion(final Question question) {
        questions[numberOfQuestions++] = question;
    }

    /**
     * { function_description }.
     */
    public void  display() {
        for (int i = 0; i < numberOfQuestions; i++) {
            System.out.println(questions[i].getQuestion()
                              + "(" + questions[i].getMaximumMarks() + ")");
            String[] view = questions[i].getchoices();

            for (int j = 0; j < view.length - 1; j++) {
                System.out.print(view[j] + "\t");
            }
            System.out.print(view[view.length - 1]);
            System.out.println("\n");
        }
    }

    /**
     * { function_description }.
     *
     * @param      value  The value
     */
    public void add(final  String value) {
        answers[size++] = value;
    }

    /**
     * Stores an answer.
     *
     * @param      answer  The answer
     */
    public void storeAnswer(final String[] answer) {
        for (int i = 0; i < answer.length; i++) {
            add(answer[i]);
        }
    }
    /**
     * { function_description }.
     */
    public void score() {
        int totalScore = 0;
        int value = 0;
        for (int i = 0; i < numberOfQuestions; i++) {
            System.out.println(questions[i].getQuestion());
            String[] view = questions[i].getchoices();
            for (int j = 0; j < view.length; j++) {
                if (answers[i].equals(view[j])) {
                    value = j + 1;
                    break;
                }
            }
            if (questions[i].getCorrectAnswer() == value) {
                System.out.println(" Correct Answer! - Marks Awarded: " + questions[i].getMaximumMarks());
                totalScore = totalScore + questions[i].getMaximumMarks();
            } else {
                System.out.println(" Wrong Answer! - Penalty: " + questions[i].getPenalty());
                totalScore = totalScore + questions[i].getPenalty();
            }
        }
        System.out.println("Total Score: " + totalScore);

    }
}
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private final  String questionText;
    /**
     * { var_description }.
     */
    private final String[] choices;
    /**
     * { var_description }.
     */
    private final int maximumMarks;
    /**
     * { var_description }.
     */
    private final int penalty;
    /**
     * { var_description }.
     */
    private final int correctAnswer;

    /**
     * Constructs the object.
     *
     * @param      questionText   The question text
     * @param      choices        The choices
     * @param      correctAnswer  The correct answer
     * @param      maximumMarks   The maximum marks
     * @param      penalty        The penalty
     */
    Question(final String questionText, final String[] choices,
             final int correctAnswer, final int maximumMarks, final int penalty) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.maximumMarks = maximumMarks;
        this.penalty = penalty;
    }
    /**
     * Gets the question.
     *
     * @return     The question.
     */
    public String getQuestion() {
        return questionText;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String[] getchoices() {
        return choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaximumMarks() {
        return maximumMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * { var_description }.
     */
    static boolean flag = true;
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) throws Exception {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                try {
                    loadQuestions(s, q, Integer.parseInt(tokens[1]));
                    System.out.println(Integer.parseInt(tokens[1]) + " are added to the quiz");
                } catch (Exception e) {
                    flag = false;
                    System.out.println(e.getMessage());
                }
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                if (flag) {
                    startQuiz(s, q, Integer.parseInt(tokens[1]));
                }
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                if (flag) {
                    displayScore(q);
                }
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz,
                                     final int questionCount) throws Exception {
        //Scanner console= new Scanner(System.in)
        if (questionCount == 0) {
            throw new Exception("Quiz does not have questions");
        }
        for (int i = 0; i < questionCount; i++) {
            String[] tokens1 = s.nextLine().split(":");
            String[] choices = tokens1[1].split(",");
            if (choices.length == 1) {
                throw new Exception(tokens1[0] + " does not have enough answer choices");
            } else if (Integer.parseInt(tokens1[2]) > 5) {
                throw new Exception("Error! Correct answer choice number is out of range for " + tokens1[0]);
            } else if (tokens1.length < 5) {
                throw new Exception("Error! Malformed question");
            } else if (Integer.parseInt(tokens1[3]) < 0) {
                throw new Exception("Invalid max marks for " + tokens1[0]);
            } else if (Integer.parseInt(tokens1[4]) > 0) {
                throw new Exception("Invalid penalty for " + tokens1[0]);
            } else if (tokens1[0].equals("")) {
                throw new Exception("Error! Malformed question");
            }
            quiz.addQuestion(new Question(tokens1[0], choices,
                                          Integer.parseInt(tokens1[2]),
                                          Integer.parseInt(tokens1[3]),
                                          Integer.parseInt(tokens1[4])));
        }
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
    }
    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        quiz.display();
        String[] line = new String[100];
        for (int i = 0; i < answerCount; i++) {
            line[i] = s.nextLine();
        }
        quiz.storeAnswer(line);
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        quiz.score();
    }
}
