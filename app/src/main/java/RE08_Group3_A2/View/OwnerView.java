package RE08_Group3_A2.View;

import RE08_Group3_A2.User.Cashier;
import RE08_Group3_A2.User.Owner;
import RE08_Group3_A2.VendingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerView extends JFrame {
    Container container = getContentPane();
    SpringLayout springLayout = new SpringLayout();
    JPanel panel = new JPanel(springLayout);
    public void OwnerViewPlot(VendingMachine vendingMachine){
        Owner owner = new Owner("",1,"");
        owner.getUsersReport(vendingMachine);

        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Re 08    Group 3    Project 2");

        JButton ACCOUNT = new JButton("change account");
        JButton Money = new JButton("change money");
        JButton Product = new JButton("change Product");
        JButton Exit = new JButton("exit");

        springLayout.putConstraint(SpringLayout.WEST,ACCOUNT,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,ACCOUNT,50,SpringLayout.NORTH,panel);

        springLayout.putConstraint(SpringLayout.WEST,Money,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,Money,100,SpringLayout.NORTH,panel);

        springLayout.putConstraint(SpringLayout.WEST,Product,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,Product,150,SpringLayout.NORTH,panel);

        springLayout.putConstraint(SpringLayout.WEST,Exit,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,Exit,200,SpringLayout.NORTH,panel);
        panel.add(ACCOUNT);
        panel.add(Money);
        panel.add(Product);
        panel.add(Exit);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==Exit){
                    dispose();
                    LoginView loginView = new LoginView(vendingMachine);
                    loginView.LoginViewPlot();
                }
            }
        });

        ACCOUNT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==ACCOUNT){
                    dispose();
                    OwneraccountView owneraccountView = new OwneraccountView();
                    owneraccountView.OwneraccountPlot(vendingMachine);
                }
            }
        });

        Money.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==Money){
                    dispose();
                    CashierView cashierView = new CashierView();
                    cashierView.CashierViewPlot(vendingMachine);
                }
            }
        });

        Product.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==Product){
                    dispose();
                    SellerView sellerView = new SellerView();
                    sellerView.SellerViewPlot(vendingMachine);
                }
            }
        });


        container.add(panel);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        OwnerView ownerView = new OwnerView();
//        ownerView.OwnerViewPlot();
//    }
}
