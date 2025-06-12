package poo.lecon08;

import java.util.Scanner;

public class ConnectFour {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Grid grid = new Grid();

        int turn = 1;
        Checker player = Checker.RED;
        boolean winner = false;

        //play a turn
        while (winner == false && turn <= 42){
            boolean validPlay;
            int play;
            do {
               System.out.println(grid);

                System.out.print("Player " + player + ", choose a column: ");
                play = in.nextInt();

                //validate play
                validPlay = grid.validate(play);

            }while (validPlay == false);

            //drop the checker
            grid.dropTheChecker(player, play);

            //determine if there is a winner
            winner = grid.isWinner(player);

            //switch players
            if (player == Checker.RED){
                player = Checker.BLACK;
            }else{
                player = Checker.RED;
            }

            turn++;
        }
        System.out.println(grid);

        if (winner){
            
            System.out.println(player.getOpposite() + " won");
            
        }else{
            System.out.println("Tie game");
        }

        in.close();
    }

	
    
}