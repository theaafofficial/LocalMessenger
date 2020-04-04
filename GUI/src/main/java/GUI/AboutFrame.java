/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author afaro
 */
public class AboutFrame extends JFrame {
    private JLabel aboutlabel;

    public AboutFrame() {
    
        super("About Me");
        setLayout(new FlowLayout());
        aboutlabel =  new JLabel("Created By\nAhmad Amin");
        add(aboutlabel);
    }
    
    
}
