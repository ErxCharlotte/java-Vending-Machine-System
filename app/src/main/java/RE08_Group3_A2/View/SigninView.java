package RE08_Group3_A2.View;

import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.ReadAndWriteTXT.WriteTXT;
import RE08_Group3_A2.User.User;
import RE08_Group3_A2.VendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SigninView extends JFrame {
    SpringLayout springLayout = new SpringLayout();
    JPanel panel = new JPanel(springLayout);
    //BorderLayout borderLayout = new BorderLayout(50,50);
    //JPanel panel = new JPanel();

    //component
    JLabel nameLable = new JLabel("Set up a new account",JLabel.CENTER);
    JLabel userLable = new JLabel("UserName:");
    JLabel passwordLable = new JLabel("Password:");
    JLabel repeatPasswordLable = new JLabel("Repeat:");

    JTextField userText = new JTextField();
    JPasswordField passwordText = new JPasswordField();
    JPasswordField repratPasswordText = new JPasswordField();

    JButton loginButton = new JButton("Login");

    JButton exit = new JButton("Exit");

    public void SignViewPlot(VendingMachine vendingMachine){
        Container container = getContentPane();

        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        nameLable.setFont(new Font("Arial",Font.PLAIN,30));
        passwordText.setEchoChar('*');
        repratPasswordText.setEchoChar('*');

        setTitle("Re 08    Group 3    Project 2");

        userText.setPreferredSize(new Dimension(200,30));
        passwordText.setPreferredSize(new Dimension(200,30));
        repratPasswordText.setPreferredSize(new Dimension(200,30));

        panel.add(userLable);
        panel.add(userText);
        panel.add(passwordLable);
        panel.add(passwordText);
        panel.add(loginButton);
        panel.add(repeatPasswordLable);
        panel.add(repratPasswordText);


        springLayout.putConstraint(SpringLayout.WEST,userLable,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,userLable,100,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,userText,10,SpringLayout.EAST,userLable);
        springLayout.putConstraint(SpringLayout.NORTH,userText,95,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordLable,150,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,passwordLable,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.WEST,passwordText,10,SpringLayout.EAST,passwordLable);
        springLayout.putConstraint(SpringLayout.NORTH,passwordText,145,SpringLayout.NORTH,panel);
        //repeatPasswordLable
        springLayout.putConstraint(SpringLayout.NORTH,repeatPasswordLable,195,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,repeatPasswordLable,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.WEST,repratPasswordText,28,SpringLayout.EAST,repeatPasswordLable);
        springLayout.putConstraint(SpringLayout.NORTH,repratPasswordText,190,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,loginButton,350,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,loginButton,250,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,exit,200,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,exit,250,SpringLayout.NORTH,panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==loginButton){
                    String psw = "";
                    for (int j = 0; j < passwordText.getPassword().length; j++) {
                        psw = psw + passwordText.getPassword()[j];
                    }

                    String repsw = "";

                    for (int j = 0; j < repratPasswordText.getPassword().length; j++) {
                        repsw = repsw + repratPasswordText.getPassword()[j];
                    }

                    if(userText.getText()!=null && psw.equals(repsw)){

                        ReadTXT readTXT = new ReadTXT();
                        HashMap<Integer, User> map = readTXT.readUserTXT();

                        WriteTXT writeTXT = new WriteTXT();
                        map.put(map.size()-1,new User(userText.getText(), map.size()+1, 0, psw));

                        writeTXT.writeUserTXT(map);
                        vendingMachine.getUsers().put(map.size()-1,new User(userText.getText(), map.size()+1, 0, psw));
                        dispose();
                        LoginView loginView = new LoginView(vendingMachine);
                        loginView.LoginViewPlot();
                    }
                    else {
                        JOptionPane.showMessageDialog(panel, "Error!", "Message!", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == exit){
                    dispose();
                    LoginView loginView = new LoginView(vendingMachine);
                    loginView.LoginViewPlot();
                }
            }
        });
        panel.add(exit);

        container.add(nameLable,BorderLayout.NORTH);
        container.add(panel);
        setVisible(true);
    }


}
