package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield1 = new JLabel();

    JLabel textfield2 = new JLabel();

    JButton[] buttons = new JButton[9];
    boolean player1_turn;



    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        frame.setMinimumSize(new Dimension(800, 800));
        frame.setMaximumSize(new Dimension(800, 800));



        title_panel.setLayout(new GridLayout(1, 2));
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(15,55,50));

        for(int i = 0; i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Quicksand Thin", Font.PLAIN, 150));
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.BLACK); // Set the background color to black
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener((this));
        }

        JPanel textfield1Panel = new JPanel(new BorderLayout());
        JPanel textfield2Panel = new JPanel(new BorderLayout());

        textfield1.setBackground(new Color(25, 25, 25));
        textfield1.setForeground(new Color(125, 155, 150));
        textfield1.setFont(new Font("Ink Free", Font.BOLD, 70));
        textfield1.setHorizontalAlignment(JLabel.CENTER); // Center horizontally
        textfield1.setVerticalAlignment(JLabel.CENTER);
        textfield1.setText("tictactoe");
        textfield1.setPreferredSize(new Dimension(400, 100)); // Set preferred size to 400x100
        textfield1.setOpaque(true);
        textfield1Panel.add(textfield1, BorderLayout.WEST); // Add textfield1 to the left side of its panel

        textfield2.setBackground(new Color(25, 25, 25));
        textfield2.setFont(new Font("Ink Free", Font.BOLD, 70));
        textfield2.setForeground(new Color(125, 155, 150));
        textfield2.setHorizontalAlignment(JLabel.CENTER); // Center horizontally
        textfield2.setVerticalAlignment(JLabel.CENTER);
        textfield2.setPreferredSize(new Dimension(400, 100)); // Set preferred size to 400x100
        textfield2.setOpaque(true);
        textfield2Panel.add(textfield2, BorderLayout.EAST);

        title_panel.add(textfield1Panel);
        title_panel.add(textfield2Panel);

        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9 ; i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(235,219,240));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield2.setText("O turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(new Color(235,219,240));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield2.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn(){
        if(random.nextInt(2)==0){
            player1_turn = true;
            textfield2.setText("X turn");
        } else {
            player1_turn = false;
            textfield2.setText("O turn");
        }
    }

    public void check(){
        if(
                (buttons[0].getText().equals("X")) &&
                (buttons[1].getText().equals("X")) &&
                (buttons[2].getText().equals("X"))
        ) {
            xWin(0,1,2);
        }
        if(
                (buttons[3].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[5].getText().equals("X"))
        ) {
            xWin(3,4,5);
        }
        if(
                (buttons[6].getText().equals("X")) &&
                (buttons[7].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))
        ) {
            xWin(6,7,8);
        }
        if(
                (buttons[0].getText().equals("X")) &&
                (buttons[3].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))
        ) {
            xWin(0,3,6);
        }
        if(
                (buttons[1].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[7].getText().equals("X"))
        ) {
            xWin(1,4,7);
        }
        if(
                (buttons[2].getText().equals("X")) &&
                (buttons[5].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))
        ) {
            xWin(2,5,8);
        }
        if(
                (buttons[0].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))
        ) {
            xWin(0,4,8);
        }
        if(
                (buttons[2].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))
        ) {
            xWin(2,4,6);
        }
        // o wins
        if(
                (buttons[0].getText().equals("O")) &&
                (buttons[1].getText().equals("O")) &&
                (buttons[2].getText().equals("O"))
        ) {
            oWin(0,1,2);
        }
        if(
                (buttons[3].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[5].getText().equals("O"))
        ) {
            oWin(3,4,5);
        }
        if(
                (buttons[6].getText().equals("O")) &&
                (buttons[7].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))
        ) {
            oWin(6,7,8);
        }
        if(
                (buttons[0].getText().equals("O")) &&
                (buttons[3].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))
        ) {
            oWin(0,3,6);
        }
        if(
                (buttons[1].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[7].getText().equals("O"))
        ) {
            oWin(1,4,7);
        }
        if(
                (buttons[2].getText().equals("O")) &&
                (buttons[5].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))
        ) {
            oWin(2,5,8);
        }
        if(
                (buttons[0].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))
        ) {
            oWin(0,4,8);
        }
        if(
                (buttons[2].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))
        ) {
            oWin(2,4,6);
        }

    }


    public void xWin(int a, int b, int c){
        buttons[a].setBackground(Color.white);
        buttons[b].setBackground(Color.white);
        buttons[c].setBackground(Color.white);
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textfield2.setText("x win");
    }

    public void oWin(int a, int b, int c){
        buttons[a].setBackground(Color.white);
        buttons[b].setBackground(Color.white);
        buttons[c].setBackground(Color.white);
        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textfield2.setText("o win");
    }


}
