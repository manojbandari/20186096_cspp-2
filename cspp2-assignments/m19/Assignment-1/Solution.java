import java.util.Scanner;
import java.util.Arrays;
class Quiz {
    Question[] questions;
    int numberOfQuestions;
    String[] answers;
    int totalScore;
    int size;
    /*Question[] choices;
    int numberOfChoices;*/
    Quiz() {
        questions = new Question[100];
        //choices=new String[100];
        answers = new String[4];
        numberOfQuestions = 0;
        totalScore = 0;
        size = 0;
    }

    public void addQuestion(Question question) {
        questions[numberOfQuestions++] = question;
    }
    public void  display() {
        for (int i = 0; i < numberOfQuestions; i++) {
            System.out.println(questions[i].getQuestion() + "(" + questions[i].getMaximumMarks() + ")");
            String[] view = questions[i].getchoices();
            for (int j = 0; j < view.length; j++) {
                System.out.print(view[i] + "  ");
            }
            System.out.println("\n");
        }
    }
    public void add(String value) {
        answers[size++] = value;
    }
    public void storeAnswer(String answer) {
        add(answer);
    }
    public void score() {
        if (numberOfQuestions==1) {
            return;
        }
        int value = 0;
        for (int i = 0; i < numberOfQuestions; i++) {
            System.out.println(questions[i].getQuestion());

            String[] view = questions[i].getchoices();
            for (int j = 0; j < view.length; j++) {
                if (answers[i].equals(view[j])) {
                    value = i;
                    break;
                }
            }
            if (questions[i].getCorrectAnswer() == value) {
                System.out.println("Correct Answer! - Marks Awarded: " + questions[i].getMaximumMarks());
                totalScore = totalScore + questions[i].getMaximumMarks();
            } else {
                System.out.println("Wrong Answer");
            }
        }
        if(numberOfQuestions!=1) {
        System.out.println("Total Score:" + totalScore);
        }
    }
}
class Question {
    String questionText;
    String[] choices;
    int maximumMarks;
    int penalty;
    int correctAnswer;
    Question(String questionText, String[] choices, int correctAnswer, int maximumMarks, int penalty) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.maximumMarks = maximumMarks;
        this.penalty = penalty;
    }
    public String getQuestion() {
        return questionText;
    }
    public String[] getchoices() {
        return choices;
    }
    public int getMaximumMarks() {
        return maximumMarks;
    }
    public int getPenalty() {
        return penalty;
    }
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    /*public int getNumberOfQuestions() {
        return numberOfQuestions;
    }
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions=numberOfQuestions
    }
    public int getNumberOfChoices() {
        return numberOfChoices
    }
    public int setNumberOfChoices(int numberOfChoices) {
        this.numberOfChoices=numberOfChoices
    }*/

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
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
    public static void main(final String[] args) {
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
                if (Integer.parseInt(tokens[1]) < 2) {
                    System.out.println("Error! Malformed question");
                } else {
                    loadQuestions(s, q, Integer.parseInt(tokens[1]));
                }
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                if (Integer.parseInt(tokens[1]) < 2);
                else {
                    startQuiz(s, q, Integer.parseInt(tokens[1]));
                }
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                
                    displayScore(q);
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
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        //Scanner console= new Scanner(System.in)

        for (int i = 0; i < questionCount; i++) {
            String[] tokens = s.nextLine().split(":");
            String[] choices = tokens[1].split(",");
            quiz.addQuestion(new Question(tokens[0], choices, Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])));
        }
        System.out.println(questionCount + " are added to the quiz");
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
        for (int i = 0; i < answerCount; i++) {
            quiz.storeAnswer(s.nextLine());
        }
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
