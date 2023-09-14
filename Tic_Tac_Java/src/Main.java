import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] array = new char[3][3];
        int countEmpty = 9;
        char x = 'X';
        char o = 'O';
        char em = ' ';
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                array[i][j] = ' ';
                System.out.print("  ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");

        boolean xWin = false;
        boolean oWin = false;
        boolean draw = false;
        char currentPlayer = x;

        int wonByX = 0;
        int wonByO = 0;
        while (!xWin && !oWin && !draw) {
            int inputX, inputY;
            boolean validInput = false;

            do {
                System.out.print("> ");
                inputX = scanner.nextInt();
                inputY = scanner.nextInt();

                if (inputX < 1 || inputX > 3 || inputY < 1 || inputY > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (array[inputX - 1][inputY - 1] != em) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    validInput = true;
                }
            } while (!validInput);

            array[inputX - 1][inputY - 1] = currentPlayer;
            countEmpty--;
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.print("|\n");
            }
            System.out.println("---------");

            // Checking for wins
            int sumX;
            int sumO;
            wonByX = 0;
            wonByO = 0;

            // Checking horizontally
            for (int i = 0; i < 3; i++) {
                sumX = 0;
                sumO = 0;
                for (int j = 0; j < 3; j++) {
                    if (array[i][j] == x) {
                        sumX++;
                    }
                    if (array[i][j] == o) {
                        sumO++;
                    }
                    if (sumX == 3) {
                        xWin = true;
                        wonByX += 1;
                    }
                    if (sumO == 3) {
                        oWin = true;
                        wonByO += 1;
                    }
                }
            }

            // Checking vertically
            for (int i = 0; i < 3; i++) {
                sumX = 0;
                sumO = 0;
                for (int j = 0; j < 3; j++) {
                    if (array[j][i] == x) {
                        sumX++;
                    }
                    if (array[j][i] == o) {
                        sumO++;
                    }
                    if (sumX == 3) {
                        xWin = true;
                        wonByX += 1;
                    }
                    if (sumO == 3) {
                        oWin = true;
                        wonByO += 1;
                    }
                }
            }

            // Checking diagonals
            if (array[0][0] == x && array[1][1] == x && array[2][2] == x) {
                xWin = true;
                wonByX += 1;
            }
            if (array[0][0] == o && array[1][1] == o && array[2][2] == o) {
                oWin = true;
                wonByO += 1;
            }
            if (array[2][0] == x && array[1][1] == x && array[0][2] == x) {
                xWin = true;
                wonByX += 1;
            }
            if (array[2][0] == o && array[1][1] == o && array[0][2] == o) {
                oWin = true;
                wonByO += 1;
            }

            if (!xWin && !oWin && countEmpty == 0) {
                draw = true;
            }

            // Switching players
            currentPlayer = (currentPlayer == x) ? o : x;
        }

        // Output
        if (xWin && !oWin && wonByX == 1) {
            System.out.println("X wins");
        } else if (oWin && !xWin && wonByO == 1) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");
        }
    }
}
