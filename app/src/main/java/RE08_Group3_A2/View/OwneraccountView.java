package RE08_Group3_A2.View;

import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.ReadAndWriteTXT.WriteTXT;
import RE08_Group3_A2.User.Owner;
import RE08_Group3_A2.User.User;
import RE08_Group3_A2.VendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;

public class OwneraccountView extends JFrame{
    Container container = getContentPane();
    SpringLayout springLayout = new SpringLayout();
    JPanel panel = new JPanel(springLayout);



    public void OwneraccountPlot(VendingMachine vendingMachine){
        setSize(500,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Re 08    Group 3    Project 2");

        HashMap<Integer, User> users = (new ReadTXT()).readUserTXT();


        JLabel adduserLabel = new JLabel("Add user");


        JLabel usernameLabel = new JLabel("Username:");
        springLayout.putConstraint(SpringLayout.WEST,usernameLabel,50,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,usernameLabel,50,SpringLayout.NORTH,panel);

        JTextField usernameText = new JTextField(20);
        springLayout.putConstraint(SpringLayout.WEST,usernameText,30,SpringLayout.EAST,usernameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,usernameText,50,SpringLayout.NORTH,panel);


        JLabel passwordLabel = new JLabel("Password:");
        springLayout.putConstraint(SpringLayout.WEST,passwordLabel,50,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordLabel,100,SpringLayout.NORTH,panel);

        JPasswordField passwordText = new JPasswordField(20);
        springLayout.putConstraint(SpringLayout.WEST,passwordText,30,SpringLayout.EAST,usernameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordText,100,SpringLayout.NORTH,panel);

        JLabel userTypeLabel = new JLabel("Type:");
        springLayout.putConstraint(SpringLayout.WEST,userTypeLabel,50,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,userTypeLabel,150,SpringLayout.NORTH,panel);

        JComboBox<String> type = new JComboBox<>();
        type.addItem("Cashier");
        type.addItem("Seller");
        type.addItem("Owner");
        springLayout.putConstraint(SpringLayout.WEST,type,50,SpringLayout.EAST,userTypeLabel);
        springLayout.putConstraint(SpringLayout.NORTH,type,150,SpringLayout.NORTH,panel);

        JButton adduser = new JButton("add");
        springLayout.putConstraint(SpringLayout.WEST,adduser,60,SpringLayout.EAST,usernameLabel);
        springLayout.putConstraint(SpringLayout.NORTH,adduser,250,SpringLayout.NORTH,panel);

        adduser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==adduser){
                    User user = new User();
                    int accountnum = 0;
                    for (int i = 0; ; i++) {
                        if (users.get(i)==null){
                            accountnum = i;
                            break;
                        }
                    }
//                    user.setAccount(accountnum);
//                    user.setName(usernameText.getText());
//                    user.setType(Integer.parseInt(type.getSelectedItem().toString()));
//                    user.setPassword(String.valueOf(passwordText.getPassword()));
//                    users.put(user.getAccount(),user);

                    int t = 0;
                    if (type.getSelectedItem().equals("Cashier")){
                        t = 1;
                    }else if(type.getSelectedItem().equals("Seller")){
                        t = 2;
                    }
                    else if(type.getSelectedItem().equals("Owner")){
                        t = 3;
                    }

                    String s = accountnum + "," +t+ "," + usernameText.getText() + "," + String.valueOf(passwordText.getPassword()) + "\n";
                    Owner owner = new Owner("",4,"");
                    owner.addUser(s,vendingMachine);
                    WriteTXT writeTXT = new WriteTXT();
                    writeTXT.writeUserTXT(vendingMachine.getUsers());

                    JOptionPane.showMessageDialog(panel,"ok!","ok!",1);
                    owner.getUsersReport(vendingMachine);
                    dispose();
                    OwneraccountView owneraccountView = new OwneraccountView();
                    owneraccountView.OwneraccountPlot(vendingMachine);
                }
            }
        });






        JLabel deluserLabel = new JLabel("Del user");
        springLayout.putConstraint(SpringLayout.NORTH,deluserLabel,400,SpringLayout.NORTH,panel);



        JLabel userIDLabel = new JLabel("user account id:");
        springLayout.putConstraint(SpringLayout.WEST,userIDLabel,50,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,userIDLabel,50,SpringLayout.SOUTH,deluserLabel);



        JComboBox<Integer> useridText= new JComboBox<>();
        Iterator<Integer> key = users.keySet().iterator();
        while (key.hasNext()){
            int i = key.next();
            useridText.addItem(i);
        }

        springLayout.putConstraint(SpringLayout.WEST,useridText,50,SpringLayout.EAST,userIDLabel);
        springLayout.putConstraint(SpringLayout.NORTH,useridText,50,SpringLayout.SOUTH,deluserLabel);


        JButton deluser = new JButton("del");

        deluser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==deluser){
                    if (users.get(useridText.getSelectedItem()).getType()==0){
                        System.out.println("you can not del this user,because it is customer");
                    }
                    else {
//                        users.remove(useridText.getSelectedItem());
//                        WriteTXT writeTXT = new WriteTXT();
//                        writeTXT.writeUserTXT(users);

                        Owner owner = new Owner("",4,"");
                        owner.removeUser((Integer) useridText.getSelectedItem(),vendingMachine);
                        owner.getUsersReport(vendingMachine);
                        JOptionPane.showMessageDialog(panel,"ok!","ok!",1);
                        WriteTXT writeTXT = new WriteTXT();
                        writeTXT.writeUserTXT(vendingMachine.getUsers());
                        dispose();
                        OwneraccountView owneraccountView = new OwneraccountView();
                        owneraccountView.OwneraccountPlot(vendingMachine);
                    }

                }
            }
        });

        springLayout.putConstraint(SpringLayout.WEST, deluser ,50,SpringLayout.EAST,useridText);
        springLayout.putConstraint(SpringLayout.NORTH, deluser ,50,SpringLayout.SOUTH,deluserLabel);


        panel.add(adduserLabel);
        panel.add(usernameLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(userTypeLabel);
        panel.add(type);

        panel.add(deluserLabel);
        panel.add(userIDLabel);
        panel.add(useridText);
        panel.add(adduser);
        panel.add(deluser);



        JButton exit = new JButton("Exit!");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==exit){
                    dispose();
                    LoginView loginView = new LoginView(vendingMachine);
                    loginView.LoginViewPlot();
                }
            }
        });

        springLayout.putConstraint(SpringLayout.WEST, exit  ,50,SpringLayout.EAST,useridText);
        springLayout.putConstraint(SpringLayout.NORTH, exit ,50,SpringLayout.SOUTH,deluser);
        panel.add(exit);






        container.add(panel);

        setVisible(true);
    }

//    public static void main(String[] args) {
//        OwneraccountView owneraccountView = new OwneraccountView();
//        owneraccountView.OwneraccountPlot();
//    }
}

