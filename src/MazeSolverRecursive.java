import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeSolverRecursive implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        if (findPath(grid, start.getRow(), start.getCol(), end, path, visited)) {
            Collections.reverse(path); 
            return path;
        } else {
            return new ArrayList<>();
        }
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end,
                             List<Cell> path, boolean[][] visited) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
                || !grid[row][col] || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        Cell current = new Cell(row, col);
        path.add(current);

        if (row == end.getRow() && col == end.getCol()) {
            return true;
        }

        if (findPath(grid, row, col + 1, end, path, visited) ||  
            findPath(grid, row + 1, col, end, path, visited) ||  
            findPath(grid, row, col - 1, end, path, visited) || 
            findPath(grid, row - 1, col, end, path, visited)) {  
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
