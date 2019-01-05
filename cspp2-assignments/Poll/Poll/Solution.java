import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Quiz quiz = new Quiz();

		int questions = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < questions; i++) {
			String question = scan.nextLine();
			String[] options = new String[4];
			for (int j = 0; j < options.length; j++) {
				options[j] = scan.nextLine();
			}
			quiz.addQuestion(new Question(question, options));
		}

		int participants = Integer.parseInt(scan.nextLine());
		for (int k = 0; k < participants; k++) {
			String name = scan.nextLine();
			for (int l = 0; l < questions; l++) {
				String[] lines = scan.nextLine().split(" ");
				int q = Integer.parseInt(lines[0]);
				Participant p = new Participant(name, q-1, lines[1]);
				Question question = quiz.getQuestion(q-1);
				question.setOptionVotes(question.indexOf(lines[1]));
			}
		}

		for (int i = 0; i < questions; i++) {
			System.out.println("Highest number of votes for question : "+ quiz.getQuestion(i).getText()
			 + " : " + quiz.getQuestion(i).commonSelectedOption());
		}

	}
}
class Participant {
	String pname;
	int qno;
	String opting;
	Participant(String n, int q, String ans) {
		this.pname = n;
		this.qno = q;
		this.opting = ans;
	}

}
class Quiz{
	Question[] ques= new Question[10];
	int size =0;
	Quiz() {
	}

	void addQuestion(Question q) {
		ques[size] = q;
		size++;
	}
	Question getQuestion(int i) {
		return ques[i];
	}
}
class Question{
	String question;
	String[] options;
	Question(String que, String[] opt) {
		this.question = que;
		this.options = opt;
	}
	String getText() {
		return question;
	}
	String commonSelectedOption() {

		return options[setOptionVotes(0)];

	}
	int indexOf(String op) {
		for (int i=0;i<4;i++) {
			if(options[i].equals(op)) {
				return i;
			}
			
		}
		return 0;
	}

	int setOptionVotes(int q) {
		int option1=0;
		int option2=0;
		int option3=0;
		int option4=0;

		if(q==0) {
			option1++;
		}
		else if(q==1) {
			option2++;
		}
		else if(q==2) {
			option3++;
		}
		else {
			option4++;

		}
		int max=0;
		if(option1> option2) {
			
				if(option1 > option3) {
					if(option1 >option4) {
						max=0;
					}
				
			}
		}

		if(option2> option1) {
			if(option2 >  option3) {
				if(option3 > option4) {
					
						max=1;
					
				}
			}
		}

		return max;

	}
}



