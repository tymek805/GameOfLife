import java.util.Random;

public class gameOfLife {
    final public int x = 32; //height of board
    final public int y = 64; //width of board

    public boolean[][] createEmpty(){
        boolean[][] myArray = new boolean[x][y];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = false;
            }
        }
        return myArray;
    }

    public void writeDown(boolean[][] x){
        for (int i = 0; i < x[1].length; i++) {
            System.out.print("--");
        }

        for (int i = 0; i < x.length; i++) {
            System.out.print("|");
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j]) System.out.print("■ ");
                else System.out.print("  ");
            }
            System.out.print("|");
            System.out.println();
        }

        for (int i = 0; i < x[1].length; i++) {
            System.out.print("--");
        }
    }

    public void fillWithRand(boolean[][] x){
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                x[i][j] = random.nextBoolean();
            }
        }
    }

    public int howManyLive(boolean[][] x,int x1, int y1){
        int suma = 0;
        for (int k = -1; k < 2; k++) {
            for (int i = -1; i < 2; i++) {
                if (i != 0 || k != 0){
                    if (x[x1+k][y1+i]){
                        suma++;
                    }
                }
            }
        }
        return suma;
    }

    public void startGame(boolean[][] x){
        boolean[][] myArray = new boolean[x.length][x[0].length];
        for (int i = 1; i < (x.length-2); i++) {
            for (int j = 1; j < (x[i].length-2); j++) {
                if (x[i][j]){
                    if (howManyLive(x,i,j) < 4 && howManyLive(x,i,j) > 2) myArray[i][j] = true;
                    else myArray[i][j] = false;
                }else {
                    if (howManyLive(x,i,j) == 3) myArray[i][j] = true;
                    else myArray[i][j] = false;
                }
            }
        }
        changeArray(x,myArray);
        writeDown(x);
    }

    public boolean[][] changeArray(boolean[][] x,boolean[][] y){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                x[i][j] = y[i][j];
            }
        }
        return x;
    }
}
