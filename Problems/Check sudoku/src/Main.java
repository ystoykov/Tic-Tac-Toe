import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        boolean res = true;
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int capacity = start * start;
        int[] compare = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            compare[i] = i + 1;
        }
        int[] tempArray = new int[capacity];
        int[] tempSecArray = new int[capacity];

        //fill the sudoku field
        int[][] grid = new int[capacity][capacity];
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int countTemp = 0;
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                tempArray[countTemp] = grid[i][j];
                tempSecArray[countTemp] = grid[j][i];
                countTemp++;
            }
            countTemp = 0;
            Arrays.sort(tempArray);
            Arrays.sort(tempSecArray);
            if (Arrays.equals(tempArray, compare) && Arrays.equals(tempSecArray, compare)) {
                continue;
            } else {
                res = false;
                break;
            }
        }
        res = blockCheck(res, start, grid);
        if (!res) {
            System.out.println("NO");
        }

    }
    static boolean blockCheck(boolean res, int start, int[][] grid) {
        boolean rest = res;
        int capacity = start * start;
        int[] compare = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            compare[i] = i + 1;
        }
        int[] tempArray = new int[capacity];
        int countField = 0;
        int countTemp = 0;
        if (rest) {
            for (int k = 0; k < start; k++) {
                for (int i = countField; i < countField + start; i++) {
                    for (int j = 0; j < start; j++) {
                        tempArray[countTemp] = grid[j][i];
                        countTemp++;
                    }
                }
                countTemp = 0;
                Arrays.sort(tempArray);
                if (Arrays.equals(tempArray, compare)) {
                    continue;
                } else {
                    rest = false;
                    break;
                }
            }

            if (rest) {
                System.out.println("YES");
            }
        }
        return rest;
    }
}