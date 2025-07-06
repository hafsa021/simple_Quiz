import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String question;
    private List<String> option;
    private int corrOpt;

    public Question(String question, List<String> option, int corrOpt) {
        this.question = question;
        this.option = option;
        this.corrOpt = corrOpt;
    }

    public void display() {
        System.out.println("\n" + question);
        for (int i = 0; i < option.size(); i++) {
            System.out.println(" " + (i + 1) + ". " + option.get(i));
        }
    }

    public boolean answer(int choice) {
        return (choice - 1) == corrOpt;
    }
}

public class Quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> qList = crtQues();
        int score = 0;
        System.out.println("**************************************************************************************");
        System.out.println("welcome to the Quiz");
        System.out.println("**************************************************************************************");
        for (int i = 0; i < qList.size(); i++) {
            Question question = qList.get(i);
            System.out.println("Question. " + (i + 1) + ":");
            question.display();
            int ans = getInput(sc);
            if (question.answer(ans)) {
                System.out.println("Correct. \n");
                score++;
            } else {
                System.out.println("wrong. \n");
            }
        }
        System.out.println("**************************************************************************************");
        System.out.println("Quiz Complete!!");
        System.out.println("**************************************************************************************");
        System.out.println("Your score:" + score + " out of " + qList.size());
        System.out.printf("Percentage: %.2f%%\n", (score * 100.0 / qList.size()));
        System.out.println("\n Thank You!!");
    }

    private static List<Question> crtQues() {
        List<Question> question = new ArrayList<>();
        question.add(new Question("Father of Java?", List.of("James Gosling",
                "Dennis Ritchie", "Guido van Rossum", "Bjarne Stroustrup"), 0));
        question.add(new Question("Initially Java was called as?", List.of("Java",
                "Cofee", "Oak", "None of these"), 2));
        question.add(new Question("What is Java?", List.of(" Programming Language",
                " Paradigm Language", "A Program", "All of these"), 0));
        question.add(new Question("Full form of Java?", List.of("Just Another View Age",
                "Just Another Virtual Accelerator", "Job Accuracy Virtual Anchor", "Just Another Version Accumulator"),
                1));
        question.add(new Question("Now Java is owned by?", List.of("sun microsystems",
                "Microsoft", "Oracle", "Google"), 2));
        question.add(
                new Question("Which API introduced in 2006 allowed Java to be run on SIM cards and other smart cards?",
                        List.of("Java Media API",
                                "Telephony API", "Card API", "Web API"),
                        2));
        question.add(new Question(
                "Which programming paradigm did Java 8 introduce with the inclusion of lambda expressions?",
                List.of("Object Oriented Programming",
                        "Procedural programming", "Functional Programing", "Decvlarative Programming"),
                2));
        question.add(new Question(" In 2014, which version of Java introduced lambda expressions and the Streams API?",
                List.of("Java 6",
                        "Java 7", "Java 8", "Java 9"),
                2));
        question.add(new Question("Full form of OOPs?", List.of("Object Oriented Programming",
                "Object Oriented Paradigm", "Object Of Program", "None of these"), 0));
        question.add(new Question("Pillars of OOPs?", List.of("Abstraction",
                "Inheritance", "Polymorphism and encapsulation", "All of the above"), 3));
        return question;
    }

    private static int getInput(Scanner sc) {
        int choice;
        while (true) {
            System.out.println("Your answer is: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 4) {
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("please enter a number between 1 to 4");
        }
        return choice;

    }
}
