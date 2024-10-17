import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
        char[][] xoArray = new char[3][3];
        // Use capital X and O 
        // any other character for empty space
        System.out.println("Enter the state of the game : ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < xoArray.length; i++) {
            for (int j = 0; j < xoArray[i].length; j++) {
                xoArray[i][j] = scanner.next().charAt(0);
            }
        }
        scanner.close();
        GameState game = new GameState(xoArray);
        game.printState();
        
    }
}