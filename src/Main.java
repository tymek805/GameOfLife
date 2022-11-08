public class Main {
    public static void main(String[] args) {
        gameOfLife game = new gameOfLife();//Tworzenie obiektu klasy
        
        boolean[][] board = game.createEmpty();//Stworzenie tablicy samych Falsów
        game.fillWithRand(board);//Wypełnienie losowo False i True
        game.writeDown(board);//Wypisanie zawartości tablicy
    }
}
