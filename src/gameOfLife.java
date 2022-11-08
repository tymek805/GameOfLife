import java.util.Random;

public class gameOfLife {
    final public int x = 16; //height of board
    final public int y = 16; //width of board

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
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j]) System.out.print("X  ");
                else System.out.print("0  ");
            }
            System.out.println();
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
}

