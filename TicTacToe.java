import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 3;
    private final char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[SIZE][SIZE];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private void printBoard() {
        System.out.println("\n  1   2   3");
        for (int row = 0; row < SIZE; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col]);
                if (col < SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < SIZE - 1) {
                System.out.println(" ---+---+---");
            }
        }
        System.out.println();
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == ' ';
    }

    private void makeMove(int row, int col) {
        board[row][col] = currentPlayer;
    }

    private boolean hasWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        return (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    private boolean isBoardFull() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Players take turns entering row and column numbers (1-3).");

        while (true) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", enter row and column (e.g., 2 3): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter valid numbers.");
                scanner.nextLine();
                continue;
            }
            int row = scanner.nextInt() - 1;

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter valid numbers.");
                scanner.nextLine();
                continue;
            }
            int col = scanner.nextInt() - 1;

            if (!isValidMove(row, col)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            makeMove(row, col);

            if (hasWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
