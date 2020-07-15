package com.zhangxx.java8;

import javax.swing.*;

public class SwingTest {
    public static void main(String[] args) {
        System.out.println("Holle Java8");

        JFrame jframe= new JFrame("My JFrame");

        JButton jButton= new JButton("My JButton");



        jButton.addActionListener(event -> {
            System.out.println("Button Pressed!");
            System.out.println("L");
            System.out.println("L");
            System.out.println("L");
        });

        jframe.add(jButton);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
