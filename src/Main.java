public class Main {
    public static void main(String[] args) throws InterruptedException {
        gameOfLife game = new gameOfLife(10, 10); // Tworzenie obiektu klasy
        boolean isnotEmpty = true;
        while (isnotEmpty){
            game.startGame();
            System.out.println();
            isnotEmpty = game.is_not_Empty();
            Thread.sleep(1000);
        }
    }
}
