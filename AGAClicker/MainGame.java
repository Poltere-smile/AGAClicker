package ScrewAroundCode.GUIPrac.AGAClicker;

import ScrewAroundCode.GUIPrac.AGAClicker.Upgrades.clickAdder;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainGame extends JFrame implements ActionListener{

    JButton mainButton;
    JButton clickADDbutton;
    JButton infoADD;
    JPanel count;
    JPanel infoADDpanel;
    JLabel amount;
    JLabel plusOne;
    JLabel infoADDtitle;
    JLabel infoADDtext;


    public int amountADD = clickAdder.amountADD;
    public int bonusADD = clickAdder.bonusADD;
    public double priceADD = clickAdder.priceADD;
    public double priceADDMult = clickAdder.priceADDMult;

    Border purchaseAvailable;


    int agas = 0;


    MainGame(){

        Border border = BorderFactory.createLineBorder(new Color(175, 147, 75), 5);
        purchaseAvailable = BorderFactory.createLineBorder(new Color(215, 240, 255), 5);
        count = new JPanel();
        mainButton = new JButton();
        clickADDbutton = new JButton();
        infoADD = new JButton();
        amount = new JLabel();
        plusOne = new JLabel();
        infoADDtitle = new JLabel();
        infoADDtext = new JLabel();
        infoADDpanel = new JPanel();
        JPanel upgradeMenu = new JPanel();



        ImageIcon aga = new ImageIcon(MainGame.class.getResource("aga.png"));
        ImageIcon clickADDicon = new ImageIcon(MainGame.class.getResource("clickADD.png"));
        ImageIcon info = new ImageIcon(clickAdder.class.getResource("info.png"));

        mainButton.setBounds(150,175,220,120);
        mainButton.addActionListener(this);
        mainButton.setIcon(aga);
        mainButton.setText("aga");
        mainButton.setFocusable(false);
        mainButton.setFont(new Font("Cambria Math", Font.BOLD,30));
        mainButton.setBackground(new Color(255, 222, 139));
        mainButton.setBorder(border);

        clickADDbutton.setBounds(30,20,200,100);
        clickADDbutton.setBackground(new Color(0,0,0));
        clickADDbutton.setText("Costs:"+priceADD);
        clickADDbutton.setFont(new Font("Cambria Math", Font.BOLD,25));
        clickADDbutton.setForeground(new Color(255, 255, 255));
        clickADDbutton.addActionListener(this);

        infoADD.setBounds(10,100,20,20);
        infoADD.setIcon(info);
        infoADD.setBackground(new Color(241, 201, 98));
        infoADD.addActionListener(this);

        plusOne.setBounds(230,20,50,100);
        plusOne.setBackground(new Color(0,0,0));
        plusOne.setIcon(clickADDicon);
        plusOne.setOpaque(true);
        plusOne.setHorizontalAlignment(JLabel.CENTER);

        count.setBackground(new Color(240, 200, 100));
        count.setBounds(0,50,500,50);
        count.setBorder(border);
        count.add(amount);

        amount.setText(agas+" agas");
        amount.setFont(new Font("Cambria Math", Font.PLAIN,25));
        amount.setHorizontalTextPosition(JLabel.CENTER);
        amount.setHorizontalAlignment(JLabel.CENTER);

        infoADDtitle.setText("+1 AGA per Click");
        infoADDtitle.setFont(new Font("Cambria Math", Font.BOLD,25));
        infoADDtitle.setForeground(new Color(255,255,255));
        infoADDtitle.setBounds(10,10,490,55);

        infoADDtext.setBounds(10,65,490,100);
        infoADDtext.setText("Gain One AGA every click. (Price Scales by Amount*1.5)");
        infoADDtext.setVerticalAlignment(JLabel.TOP);
        infoADDtext.setForeground(new Color(255,255,255));
        infoADDtext.setFont(new Font("Cambria Math", Font.BOLD,15));

        upgradeMenu.setBackground(new Color(241, 201, 98));
        upgradeMenu.setBounds(500,0,300,460);
        upgradeMenu.setBorder(border);
        upgradeMenu.setLayout(null);
        upgradeMenu.add(clickADDbutton);
        upgradeMenu.add(plusOne);
        upgradeMenu.add(infoADD);

        infoADDpanel.setBounds(0,310,500,125);
        infoADDpanel.setBackground(Color.black);
        infoADDpanel.setBorder(purchaseAvailable);
        infoADDpanel.setLayout(null);
        infoADDpanel.setVisible(false);
        infoADDpanel.add(infoADDtitle);
        infoADDpanel.add(infoADDtext);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800,500);
        this.setResizable(false);
        this.setTitle("AGA Clicker");
        this.setIconImage(aga.getImage());
        this.getContentPane().setBackground(new Color(61, 85, 147));

        this.setVisible(true);

        this.add(mainButton);
        this.add(count);
        this.add(upgradeMenu);
        this.add(infoADDpanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==mainButton){
            agas+=1+(amountADD*bonusADD);
            if (agas == 1){
                amount.setText(agas+" aga");
            } else {
                amount.setText(agas+" agas");
            }
            if (agas==priceADD){
                clickADDbutton.setBorder(purchaseAvailable);
            } else if (agas>=priceADD){
                clickADDbutton.setBorder(purchaseAvailable);
            }
            if(infoADDpanel.isVisible()){
                infoADDpanel.setVisible(false);
            }
        } else if (e.getSource() == clickADDbutton) {
            if (agas>=priceADD){
                agas-=priceADD;
                priceADD*=priceADDMult;
                amountADD+=1;
                amount.setText(agas+ ((agas==1) ? " aga": " agas"));
                clickADDbutton.setText("Costs:"+priceADD);
                System.out.println(priceADD);
            }
            if (agas==priceADD){
                clickADDbutton.setBorder(purchaseAvailable);
            } else if (agas>=priceADD){
                clickADDbutton.setBorder(purchaseAvailable);
            }else{
                clickADDbutton.setBorder(null);
            }
        } else if (e.getSource()==infoADD) {
            if (!infoADDpanel.isVisible()){
                infoADDpanel.setVisible(true);
            }else{
                infoADDpanel.setVisible(false);
            }
        }
    }
}
