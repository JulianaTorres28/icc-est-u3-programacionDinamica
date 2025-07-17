import java.util.List;

public class Maze {
    private boolean[][] grid;

    public Maze(boolean[][] predefinedGrid) {
        this.grid = predefinedGrid;
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void printMaze() {
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                System.out.print(cell ? " - " : " * ");
            }
            System.out.println();
        }
    }

    public void printMazeWithPath(List<Cell> path) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell c = new Cell(i, j);
                if (!grid[i][j]) {
                    System.out.print("#");
                } else if (path.contains(c)) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
