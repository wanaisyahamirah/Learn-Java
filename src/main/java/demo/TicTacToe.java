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
                { 1, 1, 0 },
                { 0, 1, 0 },
                { 1, 0, 1 }
        };

        int winner = evaluateWinner(arrBoard);

        printBoard(arrBoard);

        System.out.println("\nwin by row is : " + is_win_by_row(arrBoard));
        System.out.println("win by column is : " + is_win_by_column(arrBoard));
        System.out.println("win by diagonal is : " + is_win_by_diagonal(arrBoard));

        if (winner == X) {
            System.out.print("\nX (1) Won");
        } else if (winner == O) {
            System.out.print("\nO (-1) Won");
        } else {
            System.out.print("It's a tie ! No one wins ! Please try again.");
        }

        if (is_win_by_row(arrBoard)) {

            System.out.println(" (" + get_winner_evidence_by_row(get_row_number_starter(arrBoard), arrBoard) + ")");
        } else if (is_win_by_column(arrBoard)) {

            System.out
                    .println(" (" + get_winner_evidence_by_column(get_column_number_starter(arrBoard), arrBoard) + ")");
        } else {

            System.out
                    .println(" (" + get_winner_evidence_by_diagonal(get_diagonal_number_starter(arrBoard), arrBoard)
                            + ")");
        }

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
            if (arrBoard[0][i] != 0 &&
                    arrBoard[0][i] == arrBoard[1][i] && arrBoard[1][i] == arrBoard[2][i]) { // check rows
                return arrBoard[0][i];
            } else if (arrBoard[i][0] != 0 &&
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

    public static boolean is_win_by_row(int[][] arrBoard) {

        // start value with false
        boolean win = false;

        // loop through each rows
        for (int row_index = 0; row_index < arrBoard.length; row_index++) {

            // no need to go next row if we find the matched row already
            if (win) {
                break;
            }

            // loop through each column
            for (int column_index = 0; column_index < arrBoard.length; column_index++) {

                // the logic is to compare column 1 and the next column (at the same row)
                // so once we reach the second last column, that should be the last loop (for
                // checking column)
                if (column_index == arrBoard.length - 1) {
                    break;
                }

                // compare one column next to each other
                // eg: column 1 and column 2,
                // if value in column 1 = value in column 2,
                // then we want to continue the loop until last loop
                if (arrBoard[row_index][column_index] != 0
                        && arrBoard[row_index][column_index] == arrBoard[row_index][column_index + 1]) {

                    // once reach this line, means each checking is match until the last loop,
                    // so we know now this row is match (all value match)
                    // so we declare win = true to break the row loop (don't want to check other
                    // row)
                    if (column_index == arrBoard.length - 2) {
                        win = true;
                        break;
                    }
                } else {
                    // once not match, go next row
                    break;
                }
            }
        }
        return win;
    }

    public static int get_row_number_starter(int[][] arrBoard) {

        // assign number each time enter new row (so we get number starter for that row)
        int starter_number = 0;
        // start with zero, will increment this with each loop below to keep track of
        // where we are (matrix)
        int matrix = 0;

        // once we set this to true / we find the matched row, we want to break the
        // loop.
        boolean match = false;

        // loop through each rows
        for (int row_index = 0; row_index < arrBoard.length; row_index++) {

            // no need to go next row if we find the matched row already
            if (match) {
                break;
            }

            // loop through each column
            for (int column_index = 0; column_index < arrBoard.length; column_index++) {
                // keep track of where we are
                matrix++;

                if (column_index == 0) {
                    // get matrix number starter for that row, only applicable when column index =
                    // 0,
                    // if column index = 1, then we are not at the start of the row
                    starter_number = matrix;
                }

                // the logic is to compare column 1 and the next column (at the same row)
                // so once we reach the second last column, that should be the last loop (for
                // checking column)
                if (column_index == arrBoard.length - 1) {
                    break;
                }

                // compare one column next to each other
                // eg: column 1 and column 2,
                // if value in column 1 = value in column 2,
                // then we want to continue the loop until last loop
                if (arrBoard[row_index][column_index] != 0
                        && arrBoard[row_index][column_index] == arrBoard[row_index][column_index + 1]) {

                    // once reach this line, means each checking is match until the last loop,
                    // so we know now this row is match (all value match)
                    // so we declare match = true to break the row loop (don't want to check other
                    // row)
                    if (column_index == arrBoard.length - 2) {
                        match = true;
                        break;
                    }
                } else {
                    // once not match, we want to skip/break the loop
                    // then assume that we finish the whole row
                    // so matrix now should be at the last column of the row
                    matrix = starter_number + arrBoard.length - 1;
                    break;
                }
            }
        }
        return starter_number;
    }

    public static String get_winner_evidence_by_row(int row_number, int[][] arrboard) {
        String evidence = "";
        for (int i = 0; i < arrboard.length; i++) {
            if (i == 0) {
                evidence = String.valueOf(row_number);
            } else {
                evidence = evidence.concat(", " + row_number);
            }
            row_number++;
        }
        return evidence;
    }

    public static boolean is_win_by_column(int[][] arrBoard) {

        // start value with false
        boolean win = false;

        // loop through each columns
        for (int column_index = 0; column_index < arrBoard.length; column_index++) {

            // no need to go next col if we find the matched col already
            if (win) {
                break;
            }

            // loop through each row
            for (int row_index = 0; row_index < arrBoard.length; row_index++) {

                // the logic is to compare row 1 and the next row (at the same column)
                // so once we reach the second last row, that should be the last loop (for
                // checking row)
                if (row_index == arrBoard.length - 1) {
                    break;
                }

                // compare one row next to each other
                // eg: row 1 and row 2,
                // if value in row 1 = value in row 2,
                // then we want to continue the loop until last loop
                if (arrBoard[row_index][column_index] != 0
                        && arrBoard[row_index][column_index] == arrBoard[row_index + 1][column_index]) {

                    // once reach this line, means each checking is match until the last loop,
                    // so we know now this column is match (all value match)
                    // so we declare win = true to break the column loop (don't want to check other
                    // column)
                    if (row_index == arrBoard.length - 2) {
                        win = true;
                        break;
                    }
                } else {
                    // once not match, go next row
                    break;
                }
            }
        }
        return win;
    }

    public static int get_column_number_starter(int[][] arrBoard) {

        // assign number each time enter new column (so we get number starter for that
        // column)
        int starter_number = 0;

        // start with zero, will increment this with each loop below to keep track of
        // where we are (matrix)
        int matrix = 0;

        // once we set this to true / we find the matched column, we want to break the
        // loop.
        boolean match = false;

        // loop through each columns
        for (int column_index = 0; column_index < arrBoard.length; column_index++) {

            // no need to go next columns if we find the matched columns already
            if (match) {
                break;
            }

            // loop through each rows
            for (int row_index = 0; row_index < arrBoard.length; row_index++) {

                // keep track of where we are
                matrix++;

                if (row_index == 0) {
                    // get matrix number starter for that column, only applicable when row index =
                    // 0,
                    // if row index = 1, then we are not at the start of the column
                    starter_number = matrix;
                }

                // the logic is to compare row 1 and the next row (at the same row)
                // so once we reach the second last row, that should be the last loop (for
                // checking row)
                if (row_index == arrBoard.length - 1) {
                    break;
                }

                // compare one row next to each other
                // eg: row 1 and row 2,
                // if value in row 1 = value in row 2,
                // then we want to continue the loop until last loop
                if (arrBoard[row_index][column_index] != 0
                        && arrBoard[row_index][column_index] == arrBoard[row_index + 1][column_index]) {

                    // once reach this line, means each checking is match until the last loop,
                    // so we know now this column is match (all value match)
                    // so we declare match = true to break the column loop (don't want to check
                    // other column)
                    if (row_index == arrBoard.length - 2) {
                        match = true;
                        break;
                    }
                } else {
                    // proceed to break
                    // no need to set stater number
                    // because we can always get starter number when we move to new column
                    // the starter number for column is in sequence (1,2,3)
                    // which is already set at line 278 (matrix incremental)
                    break;
                }
            }
        }
        return starter_number;
    }

    public static String get_winner_evidence_by_column(int column_number, int[][] arrboard) {
        String evidence = "";
        for (int i = 0; i < arrboard.length; i++) {
            if (i == 0) {
                evidence = String.valueOf(column_number);
            } else {
                evidence = evidence.concat(", " + column_number);
            }
            column_number = column_number + 3;
        }
        return evidence;
    }

    public static boolean is_win_by_diagonal(int[][] arrBoard) {

        // start value with false
        boolean win = false;

        // use the method to check winner, dont really need to use for loop
        if (arrBoard[1][1] != 0 &&
                ((arrBoard[0][0] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][2])
                        || (arrBoard[0][2] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][0]))) {
            win = true;
        }
        return win;
    }

    public static int get_diagonal_number_starter(int[][] arrBoard) {

        // assign number each time enter new column (so we get number starter for that
        // column)
        int starter_number = 0;

        if ((arrBoard[1][1] != 0 && ((arrBoard[0][0] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][2])))) {
            starter_number = 1;
        } else if ((arrBoard[1][1] != 0 && ((arrBoard[0][2] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][0])))) {
            starter_number = 3;
        }

        return starter_number;
    }

    public static String get_winner_evidence_by_diagonal(int diagonal_number, int[][] arrboard) {
        String evidence = "";
        int starter_number = diagonal_number;
        for (int i = 0; i < arrboard.length; i++) {

            if (i == 0) {
                evidence = String.valueOf(diagonal_number);
            } else {
                evidence = evidence.concat(", " + diagonal_number);
            }

            if (starter_number == 1) {
                diagonal_number = diagonal_number + 4;
            } else if (starter_number == 3) {
                diagonal_number = diagonal_number + 2;
            }

        }
        return evidence;
    }

}