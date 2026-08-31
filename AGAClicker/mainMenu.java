package ScrewAroundCode.GUIPrac.AGAClicker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu extends JFrame implements ActionListener{
    
    
    ImageIcon aga = new ImageIcon(MainGame.class.getResource("aga.png"));
    Border border = BorderFactory.createLineBorder(new Color(175, 147, 100), 5);
    JButton enterGame = new JButton();
    JPanel titleCard = new JPanel();
    JLabel title = new JLabel();
    public boolean enteringGame;
    mainMenu(){


        enterGame.setBounds(200,200,400,100);
        enterGame.addActionListener(this);
        enterGame.setText("Start?");
        enterGame.setFocusable(false);
        enterGame.setFont(new Font("Cambria Math", Font.BOLD,50));
        enterGame.setBackground(new Color(255, 222, 139));
        enterGame.setBorder(border);

        titleCard.setBounds(0,50,800,120);
        titleCard.setBackground(new Color(61, 85, 147));
        titleCard.add(title);

        title.setText("AGA Clicker");
        title.setIcon(aga);
        title.setFont(new Font("Cambria Math", Font.PLAIN,100));
        title.setForeground(Color.WHITE);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800,500);
        this.setResizable(false);
        this.setTitle("AGA Clicker");
        this.setIconImage(aga.getImage());
        this.getContentPane().setBackground(new Color(61, 85, 147));
        this.setVisible(true);

        this.add(enterGame);
        this.add(titleCard);

    }

    public void actionPerformed(ActionEvent e) {
        enteringGame = true;
        new MainGame();
        this.dispose();
    }
}
