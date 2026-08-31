package ScrewAroundCode.GUIPrac.AGAClicker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainGame extends JFrame implements ActionListener{

    JButton button;
    JPanel count;
    JLabel amount;

    int agas = 0;


    MainGame(){

        Border border = BorderFactory.createLineBorder(new Color(175, 147, 75), 5);
        count = new JPanel();
        button = new JButton();
        amount = new JLabel();
        JPanel upgradeMenu = new JPanel();



        ImageIcon aga = new ImageIcon(MainGame.class.getResource("aga.png"));


        button.setBounds(150,175,220,120);
        button.addActionListener(this);
        button.setIcon(aga);
        button.setText("aga");
        button.setFocusable(false);
        button.setFont(new Font("Cambria Math", Font.BOLD,30));
        button.setBackground(new Color(255, 222, 139));
        button.setBorder(border);

        count.setBackground(new Color(240, 200, 100));
        count.setBounds(0,50,500,50);
        count.setBorder(border);
        count.add(amount);

        amount.setText(agas+" agas");
        amount.setFont(new Font("Cambria Math", Font.PLAIN,25));
        amount.setHorizontalTextPosition(JLabel.CENTER);
        amount.setHorizontalAlignment(JLabel.CENTER);

        upgradeMenu.setBackground(new Color(241, 201, 98));
        upgradeMenu.setBounds(500,0,300,460);
        upgradeMenu.setBorder(border);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800,500);
        this.setResizable(false);
        this.setTitle("AGA Clicker");
        this.setIconImage(aga.getImage());
        this.getContentPane().setBackground(new Color(61, 85, 147));


        this.setVisible(true);

        this.add(button);
        this.add(count);
        this.add(upgradeMenu);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        agas+=1;
        if (agas == 1){
            amount.setText(agas+" aga");
        } else {
            amount.setText(agas+" agas");
        }

    }
}
