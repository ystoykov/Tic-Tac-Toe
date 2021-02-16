package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] grid = new char[3][3];
        int count = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
                count++;
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
        double charNum = 10;
        for (int i = 0; i < 9; i++) {
            if (charNum % 2 == 0) {
                move(grid, 'X');
                printGrid(grid);
                charNum++;
            } else {
                move(grid, 'O');
                printGrid(grid);
                charNum++;
            }
            if (result(grid).equals("X wins") || result(grid).equals("O wins")) {
                break;
            } else if (result(grid).equals("Draw")) {
                move(grid,'X');
                printGrid(grid);
                break;
            }
        }
        System.out.println(result(grid));
    }
    public static String result(char[][] chars){
        String fin = null;
        int countX = 0;
        int countO = 0;
        int count_ = 0;
        for (char[]tic:chars) {
            for (char x:tic) {
                if (x == 'X') {
                    countX++;
                } else if (x == 'O') {
                    countO++;
                } else if (x == '_' || x == ' ') {
                    count_++;
                }
            }
        }
        boolean winX = whoWin(chars, 'X') == 'X';
        boolean winO = whoWin(chars, 'O') == 'O';
        if (Math.abs(countO - countX) > 1) {
            fin = "Impossible";
        } else if (winX && winO) {
            fin = "Impossible";
        } else if (winX) {
            fin = "X wins";
        } else if (winO) {
            fin = "O wins";
        } else if (winO != true && winX != true && count_ > 1) {
            fin = "Game not finished";
        } else if (winO != true && winX != true) {
            fin = "Draw";
        }
        return fin;
    }
    public static char whoWin(char[][] chars, char c) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (chars[i][0] == c && chars[i][1] == c && chars[i][2] == c) {
                return c;
            } else if (chars[0][i] == c && chars[1][i] == c && chars[2][i] == c) {
                return c;
            } else if (chars[i][i] == c) {
                count++;
                if (count == 3) {
                    return c;
                }
            }
        }
        if (chars[0][2] == c && chars[1][1] == c && chars[2][0] == c) {
            return c;
        } else return ' ';
    }
    public static void move(char[][] chars, char c) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int y = 0;
        while (true) {
            System.out.println("Enter the coordinates:");
            while (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                scanner.next();
            }
            x = scanner.nextInt();
            while (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                scanner.next();
            }
            y = scanner.nextInt();
            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (chars[x - 1][y - 1] == 'X' || chars[x - 1][y - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                chars[x - 1][y - 1] = c;
                break;
            }
        }
    }
    static void printGrid(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }
}
