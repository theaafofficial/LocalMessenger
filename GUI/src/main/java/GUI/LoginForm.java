/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
/**
 *
 * @author afaro
 */
public class LoginForm extends JFrame {
    private JLabel userLabel;
    private JLabel passLabel;
    private JLabel connectionJLabel;

    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;
    private String toMF;

    private final String username;
    private final String password;

    LoginForm() {
        super("Login!");
        ImageIcon messengerIcon = new ImageIcon("C:\\Users\\afaro\\Downloads\\messenger.png");
        setIconImage(messengerIcon.getImage());
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.BLACK);

        userLabel = new JLabel("Username: ");
        userLabel.setToolTipText("Username");
        userLabel.setForeground(new Color(57, 113, 177));
        passLabel = new JLabel("Password: ");
        passLabel.setToolTipText("Password");
        passLabel.setForeground(new Color(57, 113, 177));

        connectionJLabel = new JLabel("Enter Connection Credentials:");
        connectionJLabel.setForeground(new Color(57, 113, 177));
        userText = new JTextField("Enter Username here");
        passText = new JPasswordField("Enter Password here");
        passText.setToolTipText("Enter Password here");

        Icon loginIcon = new ImageIcon("C:\\Users\\afaro\\Downloads\\login-button.png");
        loginButton = new JButton(loginIcon);
        loginButton.setBackground(new Color(126, 87, 194));
        add(connectionJLabel);
        add(userLabel);
        add(userText);
        add(passLabel);
        add(passText);
        add(loginButton);
        username = "";
        password = "";
        buttonHandler bh = new buttonHandler();
        texterarseHandler teh = new texterarseHandler();
        userText.addMouseListener(teh);
        passText.addMouseListener(teh);
        loginButton.addActionListener(bh);
        passText.addActionListener(bh);

    }



    private class buttonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if ((userText.getText().equals(username)) && (passText.getText().equals(password))) {


                MainFrame();
            } else {
                JOptionPane.showMessageDialog(LoginForm.this, "Login unsuccesfully");
            }



        }

    }
    private class texterarseHandler extends MouseAdapter {



        @Override
        public void mouseClicked(MouseEvent arg0) {
            if (arg0.getComponent() == userText) {
                if ((userText.getText().equals("Enter Username here"))) {
                    userText.setText(null);
                }
            }
            if (arg0.getComponent() == passText) {
                if ((passText.getText().equals("Enter Password here"))) {
                    passText.setText(null);
                }
            }


        }

    }
    private void MainFrame() {

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(LoginForm.this);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 500);
        setVisible(false);
    }

}