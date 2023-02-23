import java.util.Random;
import java.util.Scanner;

public class Minesweeper {

    Random random = new Random();

    Scanner scanner = new Scanner(System.in);
    int rowCount;
    int columnCount;
    int gridSize;
    int[][] map;
    int[][] board;
    boolean game = true;

    public Minesweeper(int rowCount, int columnCount){

        this.rowCount = rowCount;

        this.columnCount = columnCount;

        this.gridSize = rowCount * columnCount;

        this.map = new int[rowCount][columnCount];

        this.board = new int[rowCount][columnCount];

    }

    public void run() {
        int success = 0;
        prepare();
        print(map);
        System.out.println("Game Started");
        while (game) {
            print(board);
            System.out.println("Enter Row:");
            int row = scanner.nextInt();
            System.out.println("Enter Column:");
            int col = scanner.nextInt();
            if (map[row][col] != -1) {
                checkBoard(row, col);
                success++;
                if ( success == (gridSize - ( gridSize / 4 ))) {
                    System.out.println("WON");
                    break;
                }
            } else {
                game = false;
                System.out.println("GAME OVER");
            }
        }
    }

    public void checkBoard(int r, int c) {
        if ((c < columnCount -1 ) && (map[r][c + 1] == -1)) {
            board[r][c]++;
        }
        if ((r < rowCount -1 ) && (map[r + 1][c] == -1)) {
            board[r][c]++;
        }
        if ((r > 0 ) && (map[r - 1][c] == -1)) {
            board[r][c]++;
        }
        if ((r > 0 ) && (map[r][c - 1] == -1)) {
            board[r][c]++;
        }
        if (board[r][c] == 0) {
            board[r][c] = -2;
        }
    }

    public void prepare() {
        int randRow, rancdCol;
        int count = 0;
        while (count != (gridSize/4)) {
            randRow = random.nextInt(rowCount);
            rancdCol = random.nextInt(columnCount);
            if (map[randRow][rancdCol] != -1) {
                map[randRow][rancdCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr ){
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] > 0 ) {
                    System.out.println("          ");
                }
                System.out.print(arr[i][j]+ "    " );
            }
            System.out.println();
        }
    }
}
