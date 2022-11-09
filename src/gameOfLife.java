import java.util.Random;

public class gameOfLife {
    final private int x; //height of board
    final private int y; //width of board

    final private boolean[][] board;

    public gameOfLife(int x, int y){
        this.x = x;
        this.y = y;
        this.board = new boolean[x][y];

        fillWithRand();
    }

    // Dopóki nie stworzymy inputu urzytkownika nie ma co tej funkcji inicjalizować
    private boolean[][] createEmpty(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = false;
            }
        }
        return board;
    }

    private void fillWithRand(){
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = random.nextBoolean();
            }
        }
    }

    public void writeDown(boolean[][] x){
        for (int i = 0; i <= y; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < x.length; i++) {
            System.out.print("|");
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j]) System.out.print("■ ");
                else System.out.print("  ");
            }
            System.out.print("|");
            System.out.println();
        }

        for (int i = 0; i <= y; i++) {
            System.out.print("--");
        }
    }

    private int howManyLive(int x1, int y1){
        int suma = 0;
        for (int k = -1; k < 2; k++) {
            for (int i = -1; i < 2; i++) {
                if (i != 0 || k != 0){
                    if (board[x1+k][y1+i]) suma++;
                }
            }
        }
        return suma;
    }

    public void startGame(){
        boolean[][] future_board = new boolean[x][y];
        for (int i = 1; i < x - 2; i++) {
            for (int j = 1; j < y - 2; j++) {
                int num_of_alive = howManyLive(i, j);
                if (board[i][j]){
                    if (num_of_alive == 2 || num_of_alive == 3) future_board[i][j] = true;
                    else future_board[i][j] = false;
                }else {
                    if (num_of_alive == 3) future_board[i][j] = true;
                    else future_board[i][j] = false;
                }
            }
        }
        changeArray(future_board);
        writeDown(board);
    }

    private void changeArray(boolean[][] future_board){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                board[i][j] = future_board[i][j];
            }
        }
    }
}
