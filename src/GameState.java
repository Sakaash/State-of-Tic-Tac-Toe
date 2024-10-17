public class GameState {
    char[][] xoArray = new char[3][3];
    GameState(char[][] xoArray) {
        this.xoArray = xoArray;
    }
    public void printState(){
        int[] countXO = countXO(xoArray);
        if(countXO[1]>countXO[0]) {
            System.out.println("Invalid!!!");
            System.out.println("Wrong turn order");
                               
        }
        else if (xMatch(xoArray) && oMatch(xoArray) ) {
            System.out.println("Invalid!!!"); 
            System.out.println("Continued playing after win");
        }
        else if(xMatch(xoArray) || oMatch(xoArray)) {
            System.out.println("Win");
        }
        else if(countXO[0] == 5 && countXO[1] == 4) {
            System.out.println("Draw");
        }
        else {
            System.out.println("Ongoing game");
        }
        System.out.println();
    }
    // returns the count in an array Eg : [3 Xs,2 Os]
    private int[] countXO(char[][] xoArray) {
        int[] arr = new int[2];
        for (int i = 0; i < xoArray.length; i++) {
            for (int j = 0; j < xoArray[i].length; j++) {
                if (xoArray[i][j] == 'X') {
                    arr[0]++;
                }
                else if(xoArray[i][j] == 'O') {
                    arr[1]++;
                }
            }
        }
        return arr;
    }
    // returns if there are any Xs matching in current state
    private boolean xMatch(char[][] xoArray){
        // Horizontal & Vertical Check
        for(int i = 0; i<xoArray.length; i++) {
            if(xoArray[i][0] == 'X' && xoArray[i][1] == 'X' && xoArray[i][2] == 'X'){
                return true;
            }
            else if(xoArray[0][i] == 'X' && xoArray[1][i] == 'X' && xoArray[2][i] == 'X') {
                return true;
            }
        }
        // Both Diagonal Check
        if((xoArray[0][0] == 'X' && xoArray[1][1] == 'X' && xoArray[2][2] == 'X') || 
           (xoArray[0][2] == 'X' && xoArray[1][1] == 'X' && xoArray[2][0] == 'X')) {
            return true;
        }
        else {
            return false;
        }
    }
    // return if there are any Os matching in current state
    private static boolean oMatch(char[][] xoArray) {
        // Horizontal & Vertical Check
        for(int i = 0; i<xoArray.length; i++) {
            if(xoArray[i][0] == 'O' && xoArray[i][1] == 'O' && xoArray[i][2] == 'O'){
                return true;
            }
            if(xoArray[0][i] == 'O' && xoArray[1][i] == 'O' && xoArray[2][i] == 'O') {
                return true;
            }
        }
        // Both Diagonal Check
        if((xoArray[0][0] == 'O' && xoArray[1][1] == 'O' && xoArray[2][2] == 'O') || 
           (xoArray[0][2] == 'O' && xoArray[1][1] == 'O' && xoArray[2][0] == 'O')) {
            return true;
        }
        else {
            return false;
        }
    }
}
