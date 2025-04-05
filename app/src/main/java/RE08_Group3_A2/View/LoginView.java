package RE08_Group3_A2.View;

import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.User.User;
import RE08_Group3_A2.VendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

public class LoginView extends JFrame {
    VendingMachine vendingMachine;

    //panel
    SpringLayout springLayout = new SpringLayout();
    JPanel panel = new JPanel(springLayout);
    //BorderLayout borderLayout = new BorderLayout(50,50);
    //JPanel panel = new JPanel();

    //component
    JLabel nameLable = new JLabel("Vending Machine (Lite Snacks) Software ",JLabel.CENTER);
    JLabel userLable = new JLabel("UserName:");
    JLabel passwordLable = new JLabel("Password:");

    JTextField userText = new JTextField();
    JPasswordField passwordText = new JPasswordField();


    JButton loginButton = new JButton("Login");
    JButton signinButton = new JButton("Sign in");

    public LoginView(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void LoginViewPlot(){
        Container container = getContentPane();

        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        //set font
        nameLable.setFont(new Font("Arial",Font.PLAIN,30));
        passwordText.setEchoChar('*');
        //title
        setTitle("Re 08    Group 3    Project 2");

        //size of input box
        userText.setPreferredSize(new Dimension(200,30));
        passwordText.setPreferredSize(new Dimension(200,30));

        panel.add(userLable);
        panel.add(userText);
        panel.add(passwordLable);
        panel.add(passwordText);
        panel.add(loginButton);
        panel.add(signinButton);

        //putConstraint(e1,c1,pad,e2,c2)
        // Link edge E1 of component C1 to edge E2 of component C2 with fixed distance between edges
        springLayout.putConstraint(SpringLayout.WEST,userLable,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,userLable,100,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,userText,10,SpringLayout.EAST,userLable);
        springLayout.putConstraint(SpringLayout.NORTH,userText,95,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordLable,150,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,passwordLable,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.WEST,passwordText,10,SpringLayout.EAST,passwordLable);
        springLayout.putConstraint(SpringLayout.NORTH,passwordText,145,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,loginButton,350,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,loginButton,200,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,signinButton,200,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,signinButton,200,SpringLayout.NORTH,panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==loginButton) {
                    ReadTXT r = new ReadTXT();
                    HashMap<Integer, User> users = r.readUserTXT();
                    Boolean temp = false;
                    for (int i = 0; i < users.size(); i++) {
                        String psw = "";
                        for (int j = 0; j < passwordText.getPassword().length; j++) {
                            psw = psw + passwordText.getPassword()[j];
                        }

                        //0 user
                        if (users.get(i).getName().equals(userText.getText()) && users.get(i).getPassword().equals(psw) && users.get(i).getType() == 0) {
                            temp = true;
                            CustomeView customeView = new CustomeView(vendingMachine, userText.getText(),Integer.toString(users.get(i).getAccount()));
                            customeView.CustomeViewPlot();
                            dispose();
                        }
                        //1 user
                        else if (users.get(i).getName().equals(userText.getText()) && users.get(i).getPassword().equals(psw) && users.get(i).getType() == 1) {
                            JOptionPane.showMessageDialog(panel, "You can obtain two reports in the following paths:\n app/src/main/resources/sellerCurrentItemsReport.txt \napp/src/main/resources/sellerSoldReport.txt", "Message!", JOptionPane.INFORMATION_MESSAGE);

                            temp = true;
                            SellerView sellerView = new SellerView();
                            sellerView.SellerViewPlot(vendingMachine);
                            dispose();
                        }
                        //2 user
                        else if (users.get(i).getName().equals(userText.getText()) && users.get(i).getPassword().equals(psw) && users.get(i).getType() == 2) {
                            JOptionPane.showMessageDialog(panel, "You can obtain two reports in the following paths:\n app/src/main/resources/money_in_VendingMachine.txt \napp/src/main/resources/transactionReport.txt", "Message!", JOptionPane.INFORMATION_MESSAGE);

                            temp = true;
                            CashierView cashierView = new CashierView();
                            cashierView.CashierViewPlot(vendingMachine);
                            dispose();
                        }
                        //3 user
                        else if (users.get(i).getName().equals(userText.getText()) && users.get(i).getPassword().equals(psw) && users.get(i).getType() == 3) {
                            JOptionPane.showMessageDialog(panel, "You can obtain two reports in the following paths:\n app/src/main/resources/ownerCancelTransactionReport.txt \napp/src/main/resources/ownerUsersReport.txt", "Message!", JOptionPane.INFORMATION_MESSAGE);

                            temp = true;
                            OwnerView ownerView = new OwnerView();
                            ownerView.OwnerViewPlot(vendingMachine);
                            dispose();
                        }
//                        else if(users.get(i).getName().equals("")&&users.get(i).getPassword().equals("")){
//                            temp = true;
//                            CustomeView customeView = new CustomeView(vendingMachine,"temp user");
//                            customeView.CustomeViewPlot();
//                            dispose();
//                        }

                    }
                    //login fail
                    if (!temp) {
                        JOptionPane.showMessageDialog(panel, "Please check your username and password!", "Logon failed!", JOptionPane.WARNING_MESSAGE);

                    }
                }
            }
        });
        signinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==signinButton){
                                        dispose();
                    SigninView signinView = new SigninView();
                    signinView.SignViewPlot(vendingMachine);
                }
            }
        });

        JButton tempuser = new JButton("Anonymous login");
        springLayout.putConstraint(SpringLayout.WEST,tempuser,450,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,tempuser,200,SpringLayout.NORTH,panel);
        tempuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==tempuser){
                    CustomeView customeView = new CustomeView(vendingMachine,"-1","tempuser");
                    customeView.CustomeViewPlot();
                }
            }
        });
        panel.add(tempuser);


        //container
        container.add(nameLable,BorderLayout.NORTH);
        container.add(panel);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        LoginView LV = new LoginView();
//        LV.LoginViewPlot();
//    }
}
