// Zespol:
// Wojciech Krzos
// Filip Kubecki
// Tymoteusz Lango

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class GUI implements ActionListener{
    JFrame frame;
    JPanel buttonPanel, functionPanel;
    JButton[][] buttons;
    int size;
    boolean[][] ifAlive; // Tablica zawierająca informacje czy komórka żyje czy nie
    boolean[][] initial;
    boolean canPlay = true;
    gameOfLife game;

    // Konstruktor klasy
    public GUI(int size){
        this.size = size;
        this.ifAlive = new boolean[size][size];
        this.initial = new boolean[size][size];
        startGUI();
    }

    private void startGUI(){
        //Interfejs jest podzielony na panel z przyciskami i panel dolny pod nim

        frame = new JFrame(); // Inicjacja całego okienka
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Koniec procesu przy wciśnięciu krzyzyka
        frame.setVisible(true);
        frame.setLayout(new BorderLayout()); // Ustalenie layoutu okna na Border (łatwo rozmieścic pozostałe panele)

        functionPanel = new JPanel(); // Dolny panel który będzie zawierał guziki START, RESET, STOP
        functionPanel.setVisible(true);

        //START button
        JButton startBT = new JButton("START"); //Utworzenie przycisku
        functionPanel.add(startBT); //Przypisanie przycisku do panelu dolnego
        startBT.addActionListener(this::start); //Dodanie eventu(przy przyciśnięciu wykona się metoda this::start)

        //STOP button
        JButton stopBT = new JButton("STOP");
        functionPanel.add(stopBT);
        stopBT.addActionListener(this::stop);

        //RESET button
        JButton resetBT = new JButton("RESET");
        functionPanel.add(resetBT);
        resetBT.addActionListener(this::reset);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(size, size)); // Plansza przycisków

        buttons = new JButton[size][size]; // Tablica przycisków
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this::actionPerformed);
                buttons[i][j].setBackground(Color.WHITE);

                ifAlive[i][j] = false; // Zmienia ustawia domyślnie wartość przysiku jako martwy
                buttonPanel.add(buttons[i][j]); // Wstawia przycisk o powyższych wartościach do panelu --> buttonPanel
            }
        }
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(functionPanel, BorderLayout.PAGE_END);
        frame.setSize(500,500);
        frame.revalidate(); // Odświerza okienko i jego zawartość
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Ustawia okienko gry na środku ekranu
    }
    public class MyThread implements Runnable{
        public void run(){
            if (canPlay){
                buttonStatusUpdate(ifAlive);

                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }
                ifAlive = game.startGame();
                Runnable r1 = new MyThread();
                Thread th = new Thread(r1);
                th.start();
            }
        }
    }
    private void buttonStatusUpdate(boolean[][] board){
        buttonPanel.removeAll();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(board[i][j]){
                    buttons[i][j].setBackground(Color.BLACK);
                }else{
                    buttons[i][j].setBackground(Color.WHITE);
                }
                buttonPanel.add(buttons[i][j]);
            }
        }
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    public void start(ActionEvent event) {
        System.out.println("START");

        for (int i = 0; i < size; i++){
            for ( int j = 0 ; j < size; j++){
                initial[i][j] = ifAlive[i][j];
            }
        }
        canPlay = true;
        game = new gameOfLife(size, size, ifAlive);
        ifAlive = game.startGame();
        Runnable r1 = new MyThread();
        Thread th = new Thread(r1);
        th.start();
    }

    private void stop(ActionEvent actionEvent) {
        System.out.println("STOP");
        canPlay = false;
    }

    private void reset(ActionEvent actionEvent) {
        System.out.println("RESET");
        canPlay = false;
        buttonStatusUpdate(initial);
    }


    // Zmiana początkowa statusu przycisków
    @Override
    public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (event.getSource()==buttons[i][j]){
                    if (ifAlive[i][j]){
                        buttons[i][j].setBackground(Color.WHITE);
                        ifAlive[i][j] = false;
                    }else{
                        buttons[i][j].setBackground(Color.BLACK);
                        ifAlive[i][j] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI(25);
    }
}
