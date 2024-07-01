package Task_1;

import java.util.*;

class Quiz {    //It is used to create a quiz
    String title;
    ArrayList<Question> questions;
    public Quiz(String title) {  //constructor
        this.title = title;
        this.questions = new ArrayList<>();
    }
    public void addQuestion(Question question) {//to add questions to a quiz
        questions.add(question);
    }
}
class Question { //It is used to store the questions of the quiz
    String text;
    ArrayList<String> options=new ArrayList<>();
    String correctAnswer;
    public Question(String questionText, String answer, String option1, String option2, String option3, String option4) {
        this.text = questionText;
        this.correctAnswer = answer;
        this.options = new ArrayList<>();
        this.options.add(option1);
        this.options.add(option2);
        this.options.add(option3);
        this.options.add(option4);
    }

    
}

public class QuizGenerator {   //driver class(main class) for quiz application
    static ArrayList<Quiz> quizzes = new ArrayList<>();
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("1. Create Quiz");
        System.out.println("2. Take Quiz");
        System.out.println("3. Exit");
        int choice = getIntInput(sc);
        switch (choice) {
            case 1:
                createQuiz(sc);
                break;
            case 2:
                takeQuiz(sc);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
            }
        }
    }
    static void createQuiz(Scanner sc) {
        System.out.println("Enter quiz title:");
        String title = sc.nextLine();

        Quiz quiz = new Quiz(title);
        quizzes.add(quiz);

        while (true) {
            System.out.println("Add question (y/n)?");
            String response = sc.nextLine();

            if (response.equalsIgnoreCase("y")) {
                System.out.println("Enter question:");
                String questionText = sc.nextLine();
                System.out.println("Enter correct answer (A, B, C, D):");
                String answer = sc.nextLine().toUpperCase();

                System.out.println("Enter options:");
                System.out.println("A:");
                String option1 = sc.nextLine();
                System.out.println("B:");
                String option2 = sc.nextLine();
                System.out.println("C:");
                String option3 = sc.nextLine();
                System.out.println("D:");
                String option4 = sc.nextLine();

                quiz.addQuestion(new Question(questionText, answer, option1, option2, option3, option4));
            } else {
                break;
            }
        }
    }
    static void takeQuiz(Scanner sc) {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available");
            return;
        }
        System.out.println("Select quiz:");
        for (int i = 0; i < quizzes.size(); i++) {
            System.out.println((i + 1) + ". " + quizzes.get(i).title);
        }

        int quizChoice = sc.nextInt() - 1;
        Quiz quiz = quizzes.get(quizChoice);

        int score = 0;
        for (Question question : quiz.questions) {
            char[] optionLabels = {'A', 'B', 'C', 'D'};
            System.out.println(question.text);
            for (int i = 0; i < question.options.size(); i++) {
                System.out.println(optionLabels[i] + ": " + question.options.get(i));
            }

            String userAnswer = sc.next().toUpperCase();
            if (userAnswer.equals(question.correctAnswer)) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + quiz.questions.size());
    }
    static int getIntInput(Scanner sc) {
        int input = -1;
        while (true) {
            try {
                input = sc.nextInt();
                sc.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number:");
                sc.next(); 
            }
        }
        return input;
    }
   
    
}

              