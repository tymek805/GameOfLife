public class Main {
    public static void main(String[] args) throws InterruptedException {
        gameOfLife game = new gameOfLife();//Tworzenie obiektu klasy

        boolean[][] board = game.createEmpty();//Stworzenie tablicy samych Falsów
        game.fillWithRand(board);//Wypełnienie losowo False i True
        game.writeDown(board);//Wypisanie zawartości tablicy
        System.out.println();

        while (true){
            game.startGame(board);
            System.out.println();
            Thread.sleep(1000);
        }
    }
}
