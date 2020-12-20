package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class example extends JFrame{
    JButton confirm=new JButton("Подтвердить");
    JTextField field=new JTextField(10);
    JLabel label=new JLabel("Введите число от 0 до 20." );
    JPanel panel=new JPanel();
    public example(){
     super("Игра-угадайка");
     setVisible(true);
     int rnd=(int)(Math.random()*20);
        System.out.println(rnd);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setSize(new Dimension(800,400));
     confirm.addActionListener(new ActionListener() {
         int k=3;
         @Override
         public void actionPerformed(ActionEvent e) {
            if(k>0){
                 String str=field.getText();
                 int  number=Integer.parseInt(str);
                 if(rnd==number) {
                     JOptionPane.showMessageDialog(field,"Вы угадали!");
                     setVisible(false);
                     dispose();
                 } else{
                     k--;
                     if(k==0){
                         JOptionPane.showMessageDialog(field, "Вы проиграли!");
                         setVisible(false);
                         dispose();
                     } else if(number>rnd){
                         JOptionPane.showMessageDialog(field,"Вы не угадали!Ваше число"+" Больше."+"Осталось попыток: "+k);
                     } else if(number<rnd){
                         JOptionPane.showMessageDialog(field,"Вы не угадали!Ваше число"+" Меньше."+"Осталось попыток: "+k);
                     }
                 }
             }
         }
     });
     panel.add(label);
     panel.add(field);
     panel.add(confirm);
     setContentPane(panel);
    }
}
