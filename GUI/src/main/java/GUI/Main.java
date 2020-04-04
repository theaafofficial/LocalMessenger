/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;

/**
 *
 * @author afaro
 */
public class Main {

  
    public static void main(String[] args) {
        LoginForm lf =  new LoginForm();
        lf.setSize(240, 150);
        lf.setResizable(false);
        lf.setLocationRelativeTo(null);
        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lf.setVisible(true);
       
    }
    
}
