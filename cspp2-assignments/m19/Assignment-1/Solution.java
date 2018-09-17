import java.util.Scanner;
import java.util.Arrays;
class Quiz {
    Question[] questions;
    int numberOfQuestions;
    String[] answers;
    int size;
    /*Question[] choices;
    int numberOfChoices;*/
    Quiz() {
        questions = new Question[100];
        //choices=new String[100];
        answers= new String[100];
        numberOfQuestions = 0;
        size = 0;
    }

    public void addQuestion(Question question) {
        questions[numberOfQuestions++] = question;
    }
    public void  display() {
        for (int i = 0; i < numberOfQuestions; i++) {
            System.out.println(questions[i].getQuestion() + "(" + questions[i].getMaximumMarks() + ")");
            String[] view = questions[i].getchoices();

            for (int j = 0; j < view.length-1; j++) {
                System.out.print(view[j] + "        ");
            }
            System.out.print(view[view.length-1]);
            System.out.println("\n");
        }
    }
    public void add(String value) {
        answers[size++] = value;
    }
    public void storeAnswer(String[] answer) {
        for(int i=0;i<answer.length;i++) {
            add(answer[i]);
        }
       // answers[size++]=answer;
    }
    public void score() {

       
        int totalScore = 0;
        int value = 0;
        for (int i = 0; i < numberOfQuestions; i++) {
            System.out.println(questions[i].getQuestion());
            //System.out.println(questions[i].getchoices());
            String[] view = questions[i].getchoices();
            /*for(int k=0;k<view.length;k++)
                System.out.println(view[k]);
            System.out.println(answers[i]);*/
            for (int j = 0; j < view.length; j++) {
                //System.out.print(answers[i]);
                if (answers[i].equals(view[j])) {
                    //System.out.println(j);
                    value = j+1;
                    break;
                }
            }
            if (questions[i].getCorrectAnswer() == value) {
                System.out.println(" Correct Answer! - Marks Awarded: " + questions[i].getMaximumMarks());
                totalScore = totalScore + questions[i].getMaximumMarks();
            } else {
                System.out.println("Wrong Answer! - Penalty: "+questions[i].getPenalty());
                totalScore = totalScore+ questions[i].getPenalty();
            }
        }
            System.out.println("Total Score: " + totalScore);
        
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
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
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
        int n = 0;
        for (int i = 0; i < questionCount; i++) {
            String[] tokens1 = s.nextLine().split(":");
            String[] choices = tokens1[1].split(",");
            /*if (choices.length == 1) {
                System.out.println(tokens1[0] + " does not have enough answer choices");
                n = 1;
            } else if (Integer.parseInt(tokens1[2]) > 5) {
                System.out.println("Error! Correct answer choice number is out of range for question text 1");
                n = 1;
            }
             else if(questionCount==0) {
            System.out.println("Quiz does not have questions");
            n=1;
                }

            else if (Integer.parseInt(tokens1[3]) < 0) {
                System.out.println("Invalid max marks for " + tokens1[0]);
                n = 1;
            } else if (Integer.parseInt(tokens1[4]) > 0) {
                System.out.println("Invalid penalty for " + tokens1[0]);
                n = 1;
            } else if (tokens1[0].equals("")) {
                System.out.println("Error! Malformed question");
                n = 1;

            }*/ 
                quiz.addQuestion(new Question(tokens1[0], choices, Integer.parseInt(tokens1[2]), Integer.parseInt(tokens1[3]), Integer.parseInt(tokens1[4])));

            
        }
        if (n != 1) {
            System.out.println(questionCount + " are added to the quiz");
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
        String[] line=new String[100];
        for (int i = 0; i < answerCount; i++) {
            line[i] = s.nextLine();
            //System.out.println(line);
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
