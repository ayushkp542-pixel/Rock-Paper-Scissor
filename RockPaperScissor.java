
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor {
    static int won=0;
    static int lost=0;
    static int draws=0;
    static void game(Scanner sc){
        Random num=new Random();
        System.out.printf("The computer has made its choice.Choose:\n1.For rock\n2.For paper\n3.For scissor\n");
        int option = sc.nextInt();
        if (option < 1 || option > 3) {
            System.out.println("Invalid Input. Please choose 1, 2, or 3.");

            return;
        }

        int random = num.nextInt(1,4);
        String[] choices = {"rock", "paper", "scissor"};
        System.out.println("The computer choice is " + choices[random - 1]);
        System.out.println("Your choice is " + choices[option - 1]);
        if (random == option) {
            System.out.println("Game Draws");
            draws++;
        } 
        else if ((option == 1 && random == 3) || (option == 2 && random == 1) || (option == 3 && random == 2)) {
            System.out.println("Congo! You won the game.");
            won++;
        } 
        else {
            System.out.println("Sorry! You lost.");
            lost++;
        }   
    }

    static void menu(Scanner sc){
        while(true){
            System.out.println("Welcome to the menu");
            System.out.printf("Please choose:\n1.Start Game\n2.Show Score\n3.Score Reset\n4.Exit\n");
            int a=sc.nextInt();
            switch(a){
            case 1:
                do {
                    game(sc);
                    System.out.println("Do you want to play again? (y/n)");
                    } while (sc.next().equalsIgnoreCase("y"));
                break;
            case 2:
                System.out.println("Game Stats are:-");
                System.out.println("Games Played="+(won+lost+draws));
                System.out.println("Games Won="+won);
                System.out.println("Games Lost="+lost);
                System.out.println("Games Draw="+draws);
                break;
            case 3:
                won=lost=draws=0;
                break;
            case 4:
                System.out.println("Thank you for playing the game exiting now.");
                return;
            default:
                System.out.println("Invalid Input");
            }
        }
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("Welcome to the Rock Paper Scissor game.");
        System.out.println("The instructions to play the game are as follows:-");
        System.out.println("1.The computer will make a choice between Rock or Paper or Scissor.");
        System.out.println("You must make your choice by entering 1, 2 or 3 only.");
        menu(sc);
    }
}     