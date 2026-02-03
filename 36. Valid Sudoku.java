import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<List<Set<Integer>>> cells = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            List<Set<Integer>> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(new HashSet<>());
            }
            cells.add(row);
        }

        // Check all columns
        for (int column = 0; column < 9; column++) {
            Set<Integer> found = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (board[row][column] == '.') {
                    continue;
                }
                int item = Character.getNumericValue(board[row][column]);
                if (found.contains(item)) {
                    return false;
                } else {
                    found.add(item);
                }
            }
        }

        // Check all rows
        for (int row = 0; row < 9; row++) {
            Set<Integer> found = new HashSet<>();
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    continue;
                }
                int item = Character.getNumericValue(board[row][column]);
                if (found.contains(item)) {
                    return false;
                } else {
                    found.add(item);
                }
            }
        }

        // Check all cells
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    continue;
                }

                Set<Integer> currentCell = cells.get(row / 3).get(column / 3);
                int item = Character.getNumericValue(board[row][column]);

                if (currentCell.contains(item)) {
                    return false;
                } else {
                    currentCell.add(item);
                }
            }
        }

        return true;
    }
}