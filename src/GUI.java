import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class gui implements ActionListener{
    JFrame frame;
    JPanel buttonPanel;
    JPanel panelDolny;
    JButton[][] buttons;
    int size;
    Boolean[][] ifAlive;

    gui(){
        //Interfejs jest podzielony na panel z przyciskami i panel dolny pod nim
        size = 32;//Rozmiar planszy
        ifAlive=new Boolean[size][size];//Tablica zawierająca informacje czy komórka żyje czy nie

        frame=new JFrame();//Inicjacja całego okienka
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Koniec procesu przy wciśnięciu krzyzyka
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());//Ustalenie layoutu okna na Border (łatwo rozmieścic pozostałe panele)

        panelDolny = new JPanel();//Dolny panel który będzie zawierał guziki START, RESET, STOP
        panelDolny.setVisible(true);

        //START button
        JButton start = new JButton("START");//Utworzenie przycisku
        panelDolny.add(start);//Przypisanie przycisku do panelu dolnego
        start.addActionListener(this::start);//Dodanie eventu(przy przyciśnięciu wykona się metoda this::start)

        //STOP button
        JButton stop = new JButton("STOP");
        panelDolny.add(stop);
        start.addActionListener(this::stop);

        //RESET button
        JButton reset = new JButton("RESET");
        panelDolny.add(reset);
        start.addActionListener(this::reset);

        buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(size, size));//Plansza przycisków

        buttons=new JButton[size][size];//Tablica przycisków
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j]=new JButton();
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this::actionPerformed);
                buttons[i][j].setBackground(Color.WHITE);
                
                ifAlive[i][j]=false;//Zmienia ustawia domyślnie wartość przysiku jako martwy

                buttonPanel.add(buttons[i][j]);//Wstawia przycisk o powyższych wartościach do panelu --> buttonPanel
            }
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(panelDolny, BorderLayout.PAGE_END);
        frame.setSize(500,500);
        frame.revalidate();//Odświerza okienko i jego zawartość
        frame.setLocationRelativeTo(null);//Ustawia okienko gry na środku ekranu

    }

    private void stop(ActionEvent actionEvent) {
    }

    private void reset(ActionEvent actionEvent) {
        
    }

    public static void main(String[] args) {
        new gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (e.getSource()==buttons[i][j]){
                    if (ifAlive[i][j]){
                        buttons[i][j].setBackground(Color.WHITE);
                        ifAlive[i][j]=false;
                    }else{
                        buttons[i][j].setBackground(Color.BLACK);
                        ifAlive[i][j]=true;
                    }
                }
            }
        }
    }

    public void start(ActionEvent e){

    }
}
