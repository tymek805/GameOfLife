public class Main {
    public static void main(String[] args) throws InterruptedException {
        gameOfLife game = new gameOfLife(32, 64);// Tworzenie obiektu klasy

        while (true){
            game.startGame();
            System.out.println();
            Thread.sleep(1000);
        }
    }
}
