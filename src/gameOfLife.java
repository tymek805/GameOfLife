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

    public void writeDown(){
        for (int i = 0; i <= y; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < x; i++) {
            System.out.print("|");
            for (int j = 0; j < y; j++) {
                if (board[i][j]) System.out.print("■ ");
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
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (j != 0 || i != 0){

                    // 00 01 02 03 04
                    // 10 11 12 13 14
                    // 20 21 22 23 24
                    // 30 31 32 33 34
                    // 40 41 42 43 44

                    if (x1 == 0 && y1 == 0 && i == -1 && j == -1){              // Górny lewy róg
                        if (board[x - 1][y - 1]) suma++;

                    } else if (x1 == 0 && y1 == y - 1 && i == -1 && j == 1){    // Górny prawy róg
                        if (board[x - 1][y - 1]) suma++;


                    } else if (x1 == x - 1 && y1 == 0 && i == 1 && j == -1){    // Dolny lewy róg
                        if (board[x - 1][y - 1]) suma++;

                    } else if (x1 == x - 1 && y1 == y - 1 && i == 1 && j == 1){ // Dolny prawy róg
                        if (board[x - 1][y - 1]) suma++;

                    }else if (x1 == 0 && i == -1){      // Górna krawędź bez rogów
                        if (board[x - 1][y1 + j]) suma++;

                    }else if (x1 == x - 1 && i == 1){   // Dolna krawędź bez rogów
                        if (board[0][y1 + j]) suma++;

                    }else if (y1 == 0 && j == -1){      // Lewa krawędź bez rogów
                        if (board[x1 + i][y - 1]) suma++;

                    }else if (y1 == y - 1 && j == 1){   // Prawa krawędź bez rogów
                        if (board[x1 + i][0]) suma++;

                    } else{ // Wnętrze planszy
                        if (board[x1 + i][y1 + j]) suma++;
                    }
                }
            }
        }
        return suma;
    }

    public void startGame(){
        boolean[][] future_board = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int num_of_alive = howManyLive(i, j);
                if (board[i][j]){
                    future_board[i][j] = num_of_alive == 2 || num_of_alive == 3;
                }else {
                    future_board[i][j] = num_of_alive == 3;
                }
            }
        }
        changeArray(future_board);
        writeDown();
    }

    private void changeArray(boolean[][] future_board){
        for (int i = 0; i < x - 1; i++) {
            for (int j = 0; j < y - 1; j++) {
                board[i][j] = future_board[i][j];
            }
        }
    }
}
