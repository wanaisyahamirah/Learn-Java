package demo;

/*
    [0][0] [0][1] [0][2]
    [1][0] [1][1] [1][2]
    [2][0] [2][1] [2][2]
*/

public class TicTacToe {

    public static void main(String[] args) {

        int X = 1;
        int O = -1;

        int[][] arrBoard = {
                { -1, 1, 0 },
                { 1, -1, 1 },
                { 0, 0, -1 }
        };

        int winner = evaluateWinner(arrBoard);

        printBoard(arrBoard);

        if (winner == X) {
            System.out.print("\nX (1) Won");
        } else if (winner == O) {
            System.out.print("\nO (-1) Won");
        } else {
            System.out.print("It's a tie ! No one wins ! Please try again.");
        }

        System.out.println(" (" + getWinnerMatrix(getWinningStarterNumber(arrBoard), arrBoard) + ") ");

    }

    public static void printBoard(int[][] arrBoard) {
        for (int i = 0; i < arrBoard.length; i++) { // this equals to the row in our matrix.
            for (int j = 0; j < arrBoard[i].length; j++) { // this equals to the column in each row.
                System.out.print(arrBoard[i][j] + " ");
            }
            System.out.println(); // change line on console as row comes to end in the matrix.
        }
    }

    public static int evaluateWinner(int[][] arrBoard) {

        // Check for rows and columns
        for (int i = 0; i < arrBoard.length; i++) {
            if (0 != arrBoard[0][i] &&
                    arrBoard[0][i] == arrBoard[1][i] && arrBoard[1][i] == arrBoard[2][i]) { // check rows
                return arrBoard[0][i];
            } else if (0 != arrBoard[i][0] &&
                    arrBoard[i][0] == arrBoard[i][1] && arrBoard[i][1] == arrBoard[i][2]) { // check columns
                return arrBoard[i][0];
            }
        }

        // check diagonal upper left to lower right
        // check diagonal lower left to upper right
        if (arrBoard[1][1] != 0 &&
                ((arrBoard[0][0] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][2])
                        || (arrBoard[0][2] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][0]))) {
            return arrBoard[1][1];
        }
        return 0;
    }

    public static int getWinningStarterNumber(int[][] arrBoard) {
        int number = 0;
        boolean win = false;
        for (int i = 0; i < arrBoard.length; i++) {
            if (win)
                break;
            for (int j = 0; j < arrBoard.length; j++) {
                if (j == arrBoard.length - 1) {
                    break;
                }
                if (arrBoard[i][j] != 0 && arrBoard[i][j] == arrBoard[i][j + 1]) {
                    if (j == arrBoard.length - 2) {
                        win = true;
                        number = number - 1;
                        break;
                    }
                    number++;
                } else {
                    number = number + arrBoard.length;
                    break;
                }
            }
        }
        if (number == 0) {
            number = 1;
        }
        return number;
    }

    public static String getWinnerMatrix(int winningStarterNumber, int[][] arrboard) {
        String evidence = "";
        for (int i = 0; i < arrboard.length; i++) {
            if(i == 0) {
                evidence = String.valueOf(winningStarterNumber);
            } else {
                evidence = evidence.concat("," + winningStarterNumber);
            }
            winningStarterNumber++;
        }
        return evidence;
    }

}