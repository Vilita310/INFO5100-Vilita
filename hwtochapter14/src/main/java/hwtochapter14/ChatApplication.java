//Usually, you will require both swing and awt packages
// even if you are working with just swings.
package hwtochapter14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class gui {
    public static void main(String args[]) {
        //Create Login Page
        createLoginGUI();
    }

    public static void createLoginGUI() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create header panel
        JPanel headerPanel = new JPanel();
        JLabel header = new JLabel("Welcome to Chat Application! Please login with two users.");
        headerPanel.add(header);
        frame.getContentPane().add(BorderLayout.NORTH, headerPanel);

        // Create text panel
        JPanel textPanel = new JPanel();

        JLabel usernameLabel1 = new JLabel("Username1");
        JTextField usernameField1 = new JTextField(10);
        JLabel passwordLabel1 = new JLabel("Password1");
        JPasswordField passwordField1 = new JPasswordField(10);
        JLabel usernameLabel2 = new JLabel("Username2");
        JTextField usernameField2 = new JTextField(10);
        JLabel passwordLabel2 = new JLabel("Password2");
        JPasswordField passwordField2 = new JPasswordField(10);

        textPanel.setLayout(new GridLayout(0, 2));
        textPanel.add(usernameLabel1);
        textPanel.add(usernameField1);
        textPanel.add(passwordLabel1);
        textPanel.add(passwordField1);
        textPanel.add(usernameLabel2);
        textPanel.add(usernameField2);
        textPanel.add(passwordLabel2);
        textPanel.add(passwordField2);

        frame.getContentPane().add(BorderLayout.CENTER, textPanel);


        JPanel loginPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username1 = usernameField1.getText();
                String password1 = new String(passwordField1.getPassword());
                String username2 = usernameField2.getText();
                String password2 = new String(passwordField2.getPassword());
                System.out.println("You have logged in with two users:");
                System.out.println("\tusername1: " + username1 + " and password1: " + password1);
                System.out.println("\tusername2: " + username2 + " and password2: " + password2);
                frame.dispose();
                createChatGUI(username1, username2);
            }
        }); 
        loginPanel.add(loginButton);

        frame.getContentPane().add(BorderLayout.SOUTH, loginPanel);
        frame.setVisible(true);
    }

    public static void createChatGUI(String username1, String username2) {
        JFrame frame = new JFrame("Chat Frame" + username1 + " and " + username2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new GridLayout(0, 2));

        // User panel1
        JPanel userPanel1 = new JPanel();
        userPanel1.setBorder(BorderFactory.createTitledBorder(username1));

        JTextArea ta1 = new JTextArea();
        userPanel1.add(ta1, BorderLayout.CENTER);

        JLabel label1 = new JLabel("Enter Text");
        JTextField tf1 = new JTextField(10);
        JButton send1 = new JButton("Send");

        JButton reset1 = new JButton("Reset");
        reset1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
            }
        });

        userPanel1.add(label1, BorderLayout.SOUTH);
        userPanel1.add(tf1, BorderLayout.SOUTH);
        userPanel1.add(send1, BorderLayout.SOUTH);
        userPanel1.add(reset1, BorderLayout.SOUTH);

        // User panel2
        JPanel userPanel2 = new JPanel();
        userPanel2.setBorder(BorderFactory.createTitledBorder(username2));

        JTextArea ta2 = new JTextArea();
        userPanel2.add(ta2, BorderLayout.CENTER);

        JLabel label2 = new JLabel("Enter Text");
        JTextField tf2 = new JTextField(10);
        JButton send2 = new JButton("Send");

        JButton reset2 = new JButton("Reset");
        reset2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf2.setText("");
            }
        });

        userPanel2.add(label2, BorderLayout.SOUTH);
        userPanel2.add(tf2, BorderLayout.SOUTH);
        userPanel2.add(send2, BorderLayout.SOUTH);
        userPanel2.add(reset2, BorderLayout.SOUTH);

        // setup send events
        send1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tf1.getText();
                ta1.append(username1 + ": " + text + "\n");
                ta2.append(username1 + ": " + text + "\n");
                tf2.setText("");
            }
        });

        send2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tf2.getText();
                ta1.append(username2 + ": " + text + "\n");
                ta2.append(username2 + ": " + text + "\n");
                tf1.setText("");
            }
        });

        frame.getContentPane().add(BorderLayout.WEST, userPanel1);
        frame.getContentPane().add(BorderLayout.EAST, userPanel2);
        frame.setVisible(true);
    }
}
