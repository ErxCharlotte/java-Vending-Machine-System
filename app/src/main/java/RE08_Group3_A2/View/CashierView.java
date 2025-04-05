package RE08_Group3_A2.View;

import RE08_Group3_A2.Money;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.ReadAndWriteTXT.WriteTXT;
import RE08_Group3_A2.User.Cashier;
import RE08_Group3_A2.User.Seller;
import RE08_Group3_A2.VendingMachine;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.HashMap;

public class CashierView extends JFrame {
    Container container = getContentPane();
    SpringLayout springLayout = new SpringLayout();
    JPanel panel = new JPanel(springLayout);

    public void CashierViewPlot(VendingMachine vendingMachine){
        setSize(400,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Re 08    Group 3    Project 2");

        HashMap<BigDecimal, Money> money = (new ReadTXT()).readMoneyTXT();



        JLabel m$50 = new JLabel("number of $50:");
        springLayout.putConstraint(SpringLayout.NORTH,m$50,25,SpringLayout.NORTH,panel);
        panel.add(m$50);
        SpinnerModel _50$ = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_50$= new JSpinner(_50$);
        JFormattedTextField tf_50$ =  ((JSpinner.DefaultEditor)num_50$.getEditor()).getTextField();
        tf_50$.setEditable(false);
        num_50$.setValue(money.get(new BigDecimal(50)).getCount());
        panel.add(num_50$);
        springLayout.putConstraint(SpringLayout.WEST,num_50$,50,SpringLayout.EAST,m$50);
        springLayout.putConstraint(SpringLayout.NORTH,num_50$,25,SpringLayout.NORTH,panel);

        num_50$.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_50$){
                    if((int)num_50$.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });


        JLabel m$20 = new JLabel("number of $20:");
        springLayout.putConstraint(SpringLayout.NORTH,m$20,25,SpringLayout.SOUTH,m$50);
        panel.add(m$20);
        SpinnerModel _20$ = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_20$= new JSpinner(_20$);
        JFormattedTextField tf_20$ =  ((JSpinner.DefaultEditor)num_20$.getEditor()).getTextField();
        tf_20$.setEditable(false);
        num_20$.setValue(money.get(new BigDecimal(20)).getCount());
        panel.add(num_20$);
        springLayout.putConstraint(SpringLayout.WEST,num_20$,50,SpringLayout.EAST,m$20);
        springLayout.putConstraint(SpringLayout.NORTH,num_20$,25,SpringLayout.SOUTH,m$50);

        num_20$.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_20$){
                    if((int)num_20$.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });

        JLabel m$10 = new JLabel("number of $10:");
        springLayout.putConstraint(SpringLayout.NORTH,m$10,25,SpringLayout.SOUTH,m$20);
        panel.add(m$10);
        SpinnerModel _10$ = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_10$= new JSpinner(_10$);
        JFormattedTextField tf_10$ =  ((JSpinner.DefaultEditor)num_10$.getEditor()).getTextField();
        tf_10$.setEditable(false);
        num_10$.setValue(money.get(new BigDecimal(10)).getCount());
        panel.add(num_10$);
        springLayout.putConstraint(SpringLayout.WEST,num_10$,50,SpringLayout.EAST,m$10);
        springLayout.putConstraint(SpringLayout.NORTH,num_10$,25,SpringLayout.SOUTH,m$20);

        num_10$.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_10$){
                    if((int)num_10$.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });


        JLabel m$5 = new JLabel("number of $5:");
        springLayout.putConstraint(SpringLayout.NORTH,m$5,25,SpringLayout.SOUTH,m$10);
        panel.add(m$5);
        SpinnerModel _5$ = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_5$= new JSpinner(_5$);
        JFormattedTextField tf_5$ =  ((JSpinner.DefaultEditor)num_5$.getEditor()).getTextField();
        tf_5$.setEditable(false);
        num_5$.setValue(money.get(new BigDecimal(5)).getCount());
        panel.add(num_5$);
        springLayout.putConstraint(SpringLayout.WEST,num_5$,50,SpringLayout.EAST,m$5);
        springLayout.putConstraint(SpringLayout.NORTH,num_5$,25,SpringLayout.SOUTH,m$10);

        num_5$.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_5$){
                    if((int)num_5$.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });

        JLabel mc200 = new JLabel("number of $2:");
        springLayout.putConstraint(SpringLayout.NORTH,mc200,25,SpringLayout.SOUTH,m$5);
        panel.add(mc200);
        SpinnerModel _200c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_200c= new JSpinner(_200c);
        JFormattedTextField tf_200c =  ((JSpinner.DefaultEditor)num_200c.getEditor()).getTextField();
        tf_200c.setEditable(false);
        num_200c.setValue(money.get(new BigDecimal(2)).getCount());
        panel.add(num_200c);
        springLayout.putConstraint(SpringLayout.WEST,num_200c,50,SpringLayout.EAST,mc200);
        springLayout.putConstraint(SpringLayout.NORTH,num_200c,25,SpringLayout.SOUTH,m$5);
        num_200c.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_200c){
                    if((int)num_200c.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });

        JLabel mc100 = new JLabel("number of $1:");
        springLayout.putConstraint(SpringLayout.NORTH,mc100,25,SpringLayout.SOUTH,mc200);
        panel.add(mc100);
        SpinnerModel _100c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_100c= new JSpinner(_100c);
        JFormattedTextField tf_100c =  ((JSpinner.DefaultEditor)num_100c.getEditor()).getTextField();
        tf_100c.setEditable(false);
        num_100c.setValue(money.get(new BigDecimal(1)).getCount());
        panel.add(num_100c);
        springLayout.putConstraint(SpringLayout.WEST,num_100c,50,SpringLayout.EAST,mc100);
        springLayout.putConstraint(SpringLayout.NORTH,num_100c,25,SpringLayout.SOUTH,mc200);

        num_100c.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_100c){
                    if((int)num_100c.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });


        JLabel mc50 = new JLabel("number of 50c:");
        springLayout.putConstraint(SpringLayout.NORTH,mc50,25,SpringLayout.SOUTH,mc100);
        panel.add(mc50);
        SpinnerModel _50c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_50c= new JSpinner(_50c);
        JFormattedTextField tf_50c =  ((JSpinner.DefaultEditor)num_50c.getEditor()).getTextField();
        tf_50c.setEditable(false);
        num_50c.setValue(money.get(new BigDecimal("0.5")).getCount());
        panel.add(num_50c);
        springLayout.putConstraint(SpringLayout.WEST,num_50c,50,SpringLayout.EAST,mc50);
        springLayout.putConstraint(SpringLayout.NORTH,num_50c,25,SpringLayout.SOUTH,mc100);
        num_50c.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_50c){
                    if((int)num_50c.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });


        JLabel mc20 = new JLabel("number of 20c:");
        springLayout.putConstraint(SpringLayout.NORTH,mc20,25,SpringLayout.SOUTH,mc50);
        panel.add(mc20);
        SpinnerModel _20c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_20c= new JSpinner(_20c);
        JFormattedTextField tf_20c =  ((JSpinner.DefaultEditor)num_20c.getEditor()).getTextField();
        tf_20c.setEditable(false);
        num_20c.setValue(money.get(new BigDecimal("0.2")).getCount());
        panel.add(num_20c);
        springLayout.putConstraint(SpringLayout.WEST,num_20c,50,SpringLayout.EAST,mc20);
        springLayout.putConstraint(SpringLayout.NORTH,num_20c,25,SpringLayout.SOUTH,mc50);

        num_20c.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_20c){
                    if((int)num_20c.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });


        JLabel mc10 = new JLabel("number of 10c:");
        springLayout.putConstraint(SpringLayout.NORTH,mc10,25,SpringLayout.SOUTH,mc20);
        panel.add(mc10);
        SpinnerModel _10c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_10c= new JSpinner(_10c);
        JFormattedTextField tf_10c =  ((JSpinner.DefaultEditor)num_10c.getEditor()).getTextField();
        tf_10c.setEditable(false);
        num_10c.setValue(money.get(new BigDecimal("0.1")).getCount());
        panel.add(num_10c);
        springLayout.putConstraint(SpringLayout.WEST,num_10c,50,SpringLayout.EAST,mc10);
        springLayout.putConstraint(SpringLayout.NORTH,num_10c,25,SpringLayout.SOUTH,mc20);

        num_10c.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_10c){
                    if((int)num_10c.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });


        JLabel mc5 = new JLabel("number of 5c:");
        springLayout.putConstraint(SpringLayout.NORTH,mc5,25,SpringLayout.SOUTH,mc10);
        panel.add(mc5);
        SpinnerModel _5c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_5c= new JSpinner(_5c);
        JFormattedTextField tf_5c =  ((JSpinner.DefaultEditor)num_5c.getEditor()).getTextField();
        tf_5c.setEditable(false);
        num_5c.setValue(money.get(new BigDecimal("0.05")).getCount());
        panel.add(num_5c);
        springLayout.putConstraint(SpringLayout.WEST,num_5c,50,SpringLayout.EAST,mc5);
        springLayout.putConstraint(SpringLayout.NORTH,num_5c,25,SpringLayout.SOUTH,mc10);

        num_50c.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if(changeEvent.getSource()==num_50c){
                    if((int)num_50c.getValue()>=99){
                        JOptionPane.showMessageDialog(panel,"MAX!","MAX!",1);
                    }
                }
            }
        });

        JButton update = new JButton("update now!");
        springLayout.putConstraint(SpringLayout.WEST,update,50,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,update,500,SpringLayout.NORTH,panel);
        panel.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==update){
                    //TODO:update
                    money.get(new BigDecimal(50)).setCount((int)num_50$.getValue());
                    money.get(new BigDecimal(20)).setCount((int)num_20$.getValue());
                    money.get(new BigDecimal(10)).setCount((int)num_10$.getValue());
                    money.get(new BigDecimal(5)).setCount((int)num_5$.getValue());
                    money.get(new BigDecimal(2)).setCount((int)num_200c.getValue());
                    money.get(new BigDecimal(1)).setCount((int)num_100c.getValue());
                    money.get(new BigDecimal("0.5")).setCount((int)num_50c.getValue());
                    money.get(new BigDecimal("0.2")).setCount((int)num_20c.getValue());
                    money.get(new BigDecimal("0.1")).setCount((int)num_10c.getValue());
                    money.get(new BigDecimal("0.05")).setCount((int)num_5c.getValue());

                    Cashier cashier = new Cashier("",2,"");
                    cashier.getReportOfTheTransaction(vendingMachine);
                    JOptionPane.showMessageDialog(panel,"OK!","OK!",1);

                    WriteTXT writeTXT = new WriteTXT();
                    writeTXT.writeMoneyTXT(money);

                    dispose();
                    CashierView cashierView = new CashierView();
                    cashierView.CashierViewPlot(vendingMachine);



                }
            }
        });

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
        springLayout.putConstraint(SpringLayout.WEST,exit,200,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,exit,500,SpringLayout.NORTH,panel);
        panel.add(exit);

        



        container.add(panel);
        setVisible(true);

    }


}

