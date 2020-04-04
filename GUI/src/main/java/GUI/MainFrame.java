/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.event.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author afaro
 */
public class MainFrame extends JFrame {

    //MenuBar
    private JMenu fileMenu;
    private JMenu aboutMenu;
    private JMenuBar menuBar;
    private JMenuItem fileItem;
    private JMenuItem AboMenuItem;
    private JMenuItem fontItem;
    private JMenuItem colorItem;
    private JMenuItem labelColor;
    private JMenuItem historyItem;

    //TextComponents   
    private JTextArea messageArea;
    private JTextField enterMessageField;

    //ScrollPane    
    private JScrollPane scrollTextArea;

    //Table    
    private JTable historyTable;

    //ComboBox
    private JComboBox < String > emojis;

    //List
    private JList < String > labelColorList;
    private JList < String > colorList;

    //Panels
    private JPanel historyPanel;
    private JPanel fontPanel;
    private JPanel colorPanel;
    private JPanel labelColorPanel;
    private JPanel imagesPanel;
    

    //Buttons
    private JButton enterMessageBtn;
    private JButton sendImage;
    private JRadioButton font1Button;
    private JRadioButton font2Button;
    private JRadioButton font3Button;

    //Instances    
    private DB database;
    private String nickname;
    private JFileChooser imageChooser;
    public MainFrame() {

        //ForMainFrame
        super("Messenger");
        nickname = JOptionPane.showInputDialog("Enter Nickname");
        ImageIcon messengerIcon = new ImageIcon("C:\\Users\\afaro\\Downloads\\messenger.png");
        setIconImage(messengerIcon.getImage());
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout(0, 3));

        //ForMenuBar
        fileMenu = new JMenu("File");
        fileMenu.setForeground(new Color(57, 113, 177));
        aboutMenu = new JMenu("About");
        aboutMenu.setForeground(new Color(57, 113, 177));
        menuBar = new JMenuBar();
        menuBar.setForeground(new Color(57, 113, 177));
        menuBar.setBackground(Color.BLACK);

        //TextComponents
        messageArea = new JTextArea();
        enterMessageField = new JTextField();
        enterMessageField.setBackground(new Color(126, 87, 194));
        enterMessageField.setForeground(Color.BLACK);
        enterMessageField.setFont(new Font("TimesRoman", Font.BOLD, 14));
        messageArea.setBackground(Color.BLACK);
        messageArea.setForeground(new Color(57, 113, 177));
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        scrollTextArea = new JScrollPane(messageArea);

        //Table
        String[] columnNames = {
            "Name",
            "Message",
            "Time"
        };
        historyTable = new JTable();

        //Panels
        JPanel sendingPanel = new JPanel();
        fontPanel = new JPanel();
        colorPanel = new JPanel();
        labelColorPanel = new JPanel();
        historyPanel = new JPanel();
        colorPanel.add(new JScrollPane(colorList));
        sendingPanel.setLayout(new BorderLayout());
        imagesPanel =  new JPanel();
        


        //List
        String colorsName[] = {
            "Black",
            "White",
            "Red",
            "Green",
            "Blue",
            "Cyan",
            "Yellow"
        };
        String emojisString[] = {
            ":)",
            ":P",
            ":(",
            ":D",
            "_|_",
            "(:",
            "):"
        };
        Color colors[] = {
            Color.BLACK,
            Color.WHITE,
            Color.red,
            Color.GREEN,
            Color.BLUE,
            Color.CYAN,
            Color.YELLOW
        };
        colorList = new JList < > (colorsName);
        labelColorList = new JList < > (colorsName);
        labelColorPanel.add(new JScrollPane(labelColorList));

        //ComboBox
        emojis = new JComboBox < > (emojisString);
        emojis.setBackground(new Color(126, 87, 194));

        //Buttons
        Icon sendIcon = new ImageIcon("C:\\Users\\afaro\\Downloads\\right-arrow (1).png");
        enterMessageBtn = new JButton(sendIcon);
        enterMessageBtn.setBackground(new Color(126, 87, 194));
        enterMessageBtn.setToolTipText("Send Message");
        enterMessageBtn.setEnabled(false);
        sendImage = new JButton("Send Image");
        font1Button = new JRadioButton("TimesRoman");
        font2Button = new JRadioButton("Courier");
        font3Button = new JRadioButton("Helvetica");
        ButtonGroup bg = new ButtonGroup();
        bg.add(font1Button);
        bg.add(font2Button);
        bg.add(font3Button);

        //MenubarItems
        fileItem = new JMenuItem("Close");
        fileItem.setForeground(new Color(57, 113, 177));
        fileItem.setBackground(Color.BLACK);

        fontItem = new JMenuItem("Fonts option");
        fontItem.setForeground(new Color(57, 113, 177));
        fontItem.setBackground(Color.BLACK);

        colorItem = new JMenuItem("Color option");
        colorItem.setForeground(new Color(57, 113, 177));
        colorItem.setBackground(Color.BLACK);

        labelColor = new JMenuItem("Label Color option");
        labelColor.setForeground(new Color(57, 113, 177));
        labelColor.setBackground(Color.BLACK);

        historyItem = new JMenuItem("Messages History");
        historyItem.setForeground(new Color(57, 113, 177));
        historyItem.setBackground(Color.BLACK);

        AboMenuItem = new JMenuItem("About me");
        AboMenuItem.setForeground(new Color(57, 113, 177));
        AboMenuItem.setBackground(Color.BLACK);
        
        //JFileChooser
        imageChooser = new JFileChooser();

        //ComponentAddition
        fontPanel.add(font1Button);
        fontPanel.add(font2Button);
        fontPanel.add(font3Button);

        fileMenu.add(fontItem);
        fileMenu.add(labelColor);
        fileMenu.add(colorItem);
        fileMenu.add(historyItem);
        fileMenu.add(fileItem);

        sendingPanel.add(emojis, BorderLayout.WEST);
        sendingPanel.add(enterMessageField, BorderLayout.CENTER);
        sendingPanel.add(enterMessageBtn, BorderLayout.EAST);
        sendingPanel.add(sendImage, BorderLayout.SOUTH);
        
        colorPanel.add(colorList);
        historyPanel.add(new JScrollPane(historyTable));
        aboutMenu.add(AboMenuItem);
        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);
        add(menuBar, BorderLayout.NORTH);
        add(scrollTextArea, BorderLayout.CENTER);
        add(sendingPanel, BorderLayout.SOUTH);

        //EventHandling
        fontItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JOptionPane.showMessageDialog(MainFrame.this, fontPanel);
            }
        });

        fileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                System.exit(0);

            }
        });

        colorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JOptionPane.showMessageDialog(MainFrame.this, colorPanel);
            }
        });
        labelColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JOptionPane.showMessageDialog(MainFrame.this, labelColorPanel);
            }
        });

        historyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {

                    String query = "SELECT * FROM `messages`";
                    database.ps = database.con.prepareStatement(query);
                    database.rs = database.ps.executeQuery(query);


                } catch (Exception e) {

                    System.out.println(e);
                }

                historyTable.setModel(DbUtils.resultSetToTableModel(database.rs));
                JOptionPane.showMessageDialog(MainFrame.this, historyPanel);

            }
        });

        AboMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                AboutFrame aboutFrame = new AboutFrame();

                aboutFrame.setSize(300, 100);
                aboutFrame.setResizable(false);
                aboutFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                aboutFrame.setVisible(true);
                aboutFrame.setLocationRelativeTo(MainFrame.this);
            }
        });

        colorList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                getContentPane().setBackground(colors[colorList.getSelectedIndex()]);
                messageArea.setBackground(colors[colorList.getSelectedIndex()]);
                menuBar.setBackground(colors[colorList.getSelectedIndex()]);


            }
        });

        labelColorList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {

                fileItem.setForeground(colors[labelColorList.getSelectedIndex()]);
                fileMenu.setForeground(colors[labelColorList.getSelectedIndex()]);
                aboutMenu.setForeground(colors[labelColorList.getSelectedIndex()]);
                AboMenuItem.setForeground(colors[labelColorList.getSelectedIndex()]);
                colorItem.setForeground(colors[labelColorList.getSelectedIndex()]);
                fontItem.setForeground(colors[labelColorList.getSelectedIndex()]);
                labelColor.setForeground(colors[labelColorList.getSelectedIndex()]);
                menuBar.setForeground(colors[labelColorList.getSelectedIndex()]);
                messageArea.setForeground(colors[labelColorList.getSelectedIndex()]);
                historyItem.setForeground(colors[labelColorList.getSelectedIndex()]);

            }
        });

        emojis.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                enterMessageField.setText(enterMessageField.getText() + emojis.getSelectedItem());
                enterMessageBtn.setEnabled(true);
            }
        });
        
      
        
        fontSelection fs = new fontSelection();
        btnEnableHandler enableHandler = new btnEnableHandler();
        font1Button.addActionListener(fs);
        font2Button.addActionListener(fs);
        font3Button.addActionListener(fs);
        enterMessageField.addKeyListener(enableHandler);
        database = new DB();
        SendingMessageSocket();
        //END of Constructor    
    }
    private class btnEnableHandler extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            if (enterMessageField.getText().isEmpty()) {
                enterMessageBtn.setEnabled(false);
            } else {
                enterMessageBtn.setEnabled(true);

            }

        }
        



    }

    private class fontSelection implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            if (font1Button.isSelected()) {

                messageArea.setFont(new Font("TimesRoman", Font.PLAIN, 14));

            }
            if (font2Button.isSelected()) {
                messageArea.setFont(new Font("Courier", Font.PLAIN, 14));

            }

            if (font3Button.isSelected()) {

                messageArea.setFont(new Font("Helvetica", Font.PLAIN, 14));

            }
        }
    }
    private void SendingMessageSocket() {

        try {

            //AddressOfGroupChat
            InetAddress groupAddress = InetAddress.getByName("230.0.0.0");

            //PortNumber
            int port = 4321;

            //Socket
            MulticastSocket multicastSocket = new MulticastSocket(port);

            multicastSocket.setTimeToLive(0);

            multicastSocket.joinGroup(groupAddress);

            //ForRecivingMessages
            ListeningMessage t = new ListeningMessage(multicastSocket, groupAddress, port);
            t.start();

            enterMessageBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                        
                    database.AddtoDB(nickname, enterMessageField.getText());
                    String message = nickname + ": " + enterMessageField.getText();
                    
                    
                    if (!(enterMessageField.getText().isEmpty())) {
                        byte[] messageInBytes = message.getBytes();
                        DatagramPacket messageToSocketLine = new DatagramPacket(messageInBytes, messageInBytes.length, groupAddress, port);

                        try {
                            multicastSocket.send(messageToSocketLine);
                        } catch (IOException ex) {

                        }
                    }
                    enterMessageField.setText("");
                }
            });
            sendImage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    imageChooser.showOpenDialog(fileMenu);
                    File FileToRead =imageChooser.getSelectedFile();
                    try {
                        BufferedImage image =  ImageIO.read(FileToRead);
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        ImageIO.write(image, "jpg", bos );
                        byte [] data = bos.toByteArray();
                          DatagramPacket messageToSocketLine = new DatagramPacket(data, data.length, groupAddress, port);
                          multicastSocket.send(messageToSocketLine);
                    } catch (IOException ex) {
                        
                    }
                    
                    
                }
            });
            enterMessageField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    database.AddtoDB(nickname, enterMessageField.getText());
                    String message = nickname + ": " + enterMessageField.getText();

                    if (!(enterMessageField.getText().isEmpty())) {
                        byte[] messageInBytes = message.getBytes();
                        DatagramPacket messageToSocketLine = new DatagramPacket(messageInBytes, messageInBytes.length, groupAddress, port);

                        try {
                            multicastSocket.send(messageToSocketLine);
                        } catch (IOException ex) {

                        }
                    }
                    enterMessageField.setText("");
                }
            });


        } catch (SocketException se) {

            JOptionPane.showMessageDialog(null, "Error creating Socket");

        } catch (IOException ie) {
            JOptionPane.showMessageDialog(null, ie);

        }
    }

    private class ListeningMessage extends Thread {
        private MulticastSocket socket;
        private InetAddress groupAddress;
        private int port;
        private String listeningMessage;
        public ListeningMessage(MulticastSocket socket, InetAddress groupAddress, int port) {
            this.socket = socket;
            this.groupAddress = groupAddress;
            this.port = port;
        }

        @Override
        public void run() {
            try {

                while (true) {
                    byte[] listeningMessageBytes = new byte[65000];

                    DatagramPacket datagramPacket = new DatagramPacket(listeningMessageBytes, listeningMessageBytes.length, groupAddress, port);

                    socket.receive(datagramPacket);
                    
                    if(datagramPacket.getLength() > 500){
                    BufferedImage img = null;
                        try {
                            img = ImageIO.read(new ByteArrayInputStream(datagramPacket.getData()));
                           
                            ImageIcon icon = new ImageIcon(img);
                            JLabel label = new JLabel(icon);
                            imagesPanel.setLayout(new BoxLayout(imagesPanel, BoxLayout.Y_AXIS));
                            imagesPanel.setSize(400, 400);
                             imagesPanel.add(label);
                            imagesPanel.revalidate();
                            imagesPanel.repaint();
                            JScrollPane jp =  new JScrollPane();
                            jp.setViewportView(imagesPanel);
                            jp.setSize(400, 400);
                            jp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                            
                            JOptionPane.showMessageDialog(rootPane, jp);
                        } catch (IOException ex) {
                            
                        }
                    }
                    else{
                    listeningMessage = new String(datagramPacket.getData());
                    messageArea.append(listeningMessage + "\n");
                    }
                }
            } catch (IOException io) {

                JOptionPane.showMessageDialog(null, io);

            }



        }
    }
}