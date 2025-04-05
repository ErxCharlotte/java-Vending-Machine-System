package RE08_Group3_A2.View;

import RE08_Group3_A2.CancelTransaction;
import RE08_Group3_A2.Money;
import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.WriteTXT;
import RE08_Group3_A2.User.Cashier;
import RE08_Group3_A2.User.Owner;
import RE08_Group3_A2.User.Seller;
import RE08_Group3_A2.VendingMachine;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

public class Pay_CashView extends JFrame {
    VendingMachine vendingMachine;
    SpringLayout springLayout = new SpringLayout();
    JPanel panel = new JPanel(springLayout);
    String username;

    int tt = 0;
    JLabel nameLable = new JLabel("please put cash ",JLabel.CENTER);

    public Pay_CashView(VendingMachine vendingMachine,String username) {
        this.vendingMachine = vendingMachine;
        this.username = username;
    }

    public void Pay_CashViewPlot(BigDecimal totalPrice, List<Product> boughtProduct, String s, int time,String account){



        Container container = getContentPane();

        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        panel.add(nameLable);

        tt = time;

        JLabel t = new JLabel("You have "+Integer.toString(120-tt)+" seconds left");
        panel.add(t);

        springLayout.putConstraint(SpringLayout.WEST,t,300,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,t,25,SpringLayout.SOUTH,nameLable);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                t.setText("You have "+Integer.toString(120-tt)+" seconds left");
                tt++;
            }
        });
        timer.start();

        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (tt>=120){
                    //TODO:Time out & add it in report
                    JOptionPane.showMessageDialog(panel, "Sorry,time out!", "Failed!", JOptionPane.WARNING_MESSAGE);
                    tt = 0;
                    timer.stop();

                    CancelTransaction cancelTransaction = new CancelTransaction("timeout",vendingMachine.getUsers().get(Integer.parseInt(account)));
                    vendingMachine.getCancelTransactions().add(cancelTransaction);
                    Owner owner = new Owner("",999,"");
                    owner.getCancelTransactionReport(vendingMachine);

                    dispose();
                    LoginView loginView = new LoginView(vendingMachine);
                    loginView.LoginViewPlot();
                }
            }
        });


        setTitle("Re 08    Group 3    Project 2");
        nameLable.setFont(new Font("Arial",Font.PLAIN,30));

        JLabel price = new JLabel("total price: "+totalPrice.toString());
        price.setFont(new Font("Arial",Font.PLAIN,25));
        panel.add(price);
        springLayout.putConstraint(SpringLayout.NORTH,price,25,SpringLayout.SOUTH,nameLable);

        String[] ss = s.split("\n");
        String sss = "<html><body><p>product name, count, price</p><br><p>";
        String ssss = "</p><body></html>";
        for (int i = 0; i < ss.length; i++) {
            sss+=ss[i] + "<br>";
        }
        sss+=ssss;
        //System.out.println(sss);

        //JLabel list = new JLabel("<html><body><p>product name, count, price</p><br><p>"+s+"</p><body></html>");

        JLabel list = new JLabel(sss);

        panel.add(list);
        springLayout.putConstraint(SpringLayout.NORTH,list,25,SpringLayout.SOUTH,t);
        springLayout.putConstraint(SpringLayout.WEST,list,300,SpringLayout.WEST,panel);


        JButton cancel = new JButton("cancel order!");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==cancel){
                    timer.stop();
                    dispose();
                    LoginView loginView = new LoginView(vendingMachine);
                    loginView.LoginViewPlot();
                }
            }
        });




        JLabel m$50 = new JLabel("number of $50:");
        springLayout.putConstraint(SpringLayout.NORTH,m$50,25,SpringLayout.SOUTH,price);
        panel.add(m$50);
        SpinnerModel _50$ = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_50$= new JSpinner(_50$);
        JFormattedTextField tf_50$ =  ((JSpinner.DefaultEditor)num_50$.getEditor()).getTextField();
        tf_50$.setEditable(false);
        panel.add(num_50$);
        springLayout.putConstraint(SpringLayout.WEST,num_50$,50,SpringLayout.EAST,m$50);
        springLayout.putConstraint(SpringLayout.NORTH,num_50$,25,SpringLayout.SOUTH,price);


        JLabel m$20 = new JLabel("number of $20:");
        springLayout.putConstraint(SpringLayout.NORTH,m$20,25,SpringLayout.SOUTH,m$50);
        panel.add(m$20);
        SpinnerModel _20$ = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_20$= new JSpinner(_20$);
        JFormattedTextField tf_20$ =  ((JSpinner.DefaultEditor)num_20$.getEditor()).getTextField();
        tf_20$.setEditable(false);
        panel.add(num_20$);
        springLayout.putConstraint(SpringLayout.WEST,num_20$,50,SpringLayout.EAST,m$20);
        springLayout.putConstraint(SpringLayout.NORTH,num_20$,25,SpringLayout.SOUTH,m$50);

        JLabel m$10 = new JLabel("number of $10:");
        springLayout.putConstraint(SpringLayout.NORTH,m$10,25,SpringLayout.SOUTH,m$20);
        panel.add(m$10);
        SpinnerModel _10$ = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_10$= new JSpinner(_10$);
        JFormattedTextField tf_10$ =  ((JSpinner.DefaultEditor)num_10$.getEditor()).getTextField();
        tf_10$.setEditable(false);
        panel.add(num_10$);
        springLayout.putConstraint(SpringLayout.WEST,num_10$,50,SpringLayout.EAST,m$10);
        springLayout.putConstraint(SpringLayout.NORTH,num_10$,25,SpringLayout.SOUTH,m$20);


        JLabel m$5 = new JLabel("number of $5:");
        springLayout.putConstraint(SpringLayout.NORTH,m$5,25,SpringLayout.SOUTH,m$10);
        panel.add(m$5);
        SpinnerModel _5$ = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_5$= new JSpinner(_5$);
        JFormattedTextField tf_5$ =  ((JSpinner.DefaultEditor)num_5$.getEditor()).getTextField();
        tf_5$.setEditable(false);
        panel.add(num_5$);
        springLayout.putConstraint(SpringLayout.WEST,num_5$,50,SpringLayout.EAST,m$5);
        springLayout.putConstraint(SpringLayout.NORTH,num_5$,25,SpringLayout.SOUTH,m$10);

        JLabel mc200 = new JLabel("number of $2:");
        springLayout.putConstraint(SpringLayout.NORTH,mc200,25,SpringLayout.SOUTH,m$5);
        panel.add(mc200);
        SpinnerModel _200c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_200c= new JSpinner(_200c);
        JFormattedTextField tf_200c =  ((JSpinner.DefaultEditor)num_200c.getEditor()).getTextField();
        tf_200c.setEditable(false);
        panel.add(num_200c);
        springLayout.putConstraint(SpringLayout.WEST,num_200c,50,SpringLayout.EAST,mc200);
        springLayout.putConstraint(SpringLayout.NORTH,num_200c,25,SpringLayout.SOUTH,m$5);

        JLabel mc100 = new JLabel("number of $1:");
        springLayout.putConstraint(SpringLayout.NORTH,mc100,25,SpringLayout.SOUTH,mc200);
        panel.add(mc100);
        SpinnerModel _100c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_100c= new JSpinner(_100c);
        JFormattedTextField tf_100c =  ((JSpinner.DefaultEditor)num_100c.getEditor()).getTextField();
        tf_100c.setEditable(false);
        panel.add(num_100c);
        springLayout.putConstraint(SpringLayout.WEST,num_100c,50,SpringLayout.EAST,mc100);
        springLayout.putConstraint(SpringLayout.NORTH,num_100c,25,SpringLayout.SOUTH,mc200);

        JLabel mc50 = new JLabel("number of 50c:");
        springLayout.putConstraint(SpringLayout.NORTH,mc50,25,SpringLayout.SOUTH,mc100);
        panel.add(mc50);
        SpinnerModel _50c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_50c= new JSpinner(_50c);
        JFormattedTextField tf_50c =  ((JSpinner.DefaultEditor)num_50c.getEditor()).getTextField();
        tf_50c.setEditable(false);
        panel.add(num_50c);
        springLayout.putConstraint(SpringLayout.WEST,num_50c,50,SpringLayout.EAST,mc50);
        springLayout.putConstraint(SpringLayout.NORTH,num_50c,25,SpringLayout.SOUTH,mc100);


        JLabel mc20 = new JLabel("number of 20c:");
        springLayout.putConstraint(SpringLayout.NORTH,mc20,25,SpringLayout.SOUTH,mc50);
        panel.add(mc20);
        SpinnerModel _20c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_20c= new JSpinner(_20c);
        JFormattedTextField tf_20c =  ((JSpinner.DefaultEditor)num_20c.getEditor()).getTextField();
        tf_20c.setEditable(false);
        panel.add(num_20c);
        springLayout.putConstraint(SpringLayout.WEST,num_20c,50,SpringLayout.EAST,mc20);
        springLayout.putConstraint(SpringLayout.NORTH,num_20c,25,SpringLayout.SOUTH,mc50);


        JLabel mc10 = new JLabel("number of 10c:");
        springLayout.putConstraint(SpringLayout.NORTH,mc10,25,SpringLayout.SOUTH,mc20);
        panel.add(mc10);
        SpinnerModel _10c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_10c= new JSpinner(_10c);
        JFormattedTextField tf_10c =  ((JSpinner.DefaultEditor)num_10c.getEditor()).getTextField();
        tf_10c.setEditable(false);
        panel.add(num_10c);
        springLayout.putConstraint(SpringLayout.WEST,num_10c,50,SpringLayout.EAST,mc10);
        springLayout.putConstraint(SpringLayout.NORTH,num_10c,25,SpringLayout.SOUTH,mc20);


        JLabel mc5 = new JLabel("number of 5c:");
        springLayout.putConstraint(SpringLayout.NORTH,mc5,25,SpringLayout.SOUTH,mc10);
        panel.add(mc5);
        SpinnerModel _5c = new SpinnerNumberModel(0,0,99,1);
        JSpinner num_5c= new JSpinner(_5c);
        JFormattedTextField tf_5c =  ((JSpinner.DefaultEditor)num_5c.getEditor()).getTextField();
        tf_5c.setEditable(false);
        panel.add(num_5c);
        springLayout.putConstraint(SpringLayout.WEST,num_5c,50,SpringLayout.EAST,mc5);
        springLayout.putConstraint(SpringLayout.NORTH,num_5c,25,SpringLayout.SOUTH,mc10);








        JButton pay = new JButton("pay now!");
        springLayout.putConstraint(SpringLayout.WEST,pay,200,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,pay,500,SpringLayout.NORTH,panel);
        panel.add(pay);
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==pay){
                    //TODO: call the change function

                    List<Money> monies = new ArrayList<>();

                    monies.add(new Money("note",new BigDecimal(5),(int)num_5$.getValue()));
                    monies.add(new Money("note",new BigDecimal(10),(int)num_10$.getValue()));
                    monies.add(new Money("note",new BigDecimal(20),(int)num_20$.getValue()));
                    monies.add(new Money("note",new BigDecimal(50),(int)num_50$.getValue()));
                    monies.add(new Money("coin",new BigDecimal("0.05"),(int)num_5c.getValue()));
                    monies.add(new Money("coin",new BigDecimal("0.1"),(int)num_10c.getValue()));
                    monies.add(new Money("coin",new BigDecimal("0.2"),(int)num_20c.getValue()));
                    monies.add(new Money("coin",new BigDecimal("0.5"),(int)num_50c.getValue()));
                    monies.add(new Money("coin",new BigDecimal(2),(int)num_200c.getValue()));
                    monies.add(new Money("coin",new BigDecimal(1),(int)num_100c.getValue()));


                    BigDecimal change = vendingMachine.cashAmount(monies).subtract(vendingMachine.productAmount(boughtProduct));
                    Map<BigDecimal, Money> returnvalue = vendingMachine.returnedChange(change);
                    String  info = vendingMachine.cashPayment(boughtProduct,monies,username);
                    //TODO: Close the page after successful payment
                    if (returnvalue!= null && info.split(",")[0].equals("Successful Paid. Please get your product and changes!")){
                        //BigDecimal change = new BigDecimal(info.split(",")[1]);
                        //Map<BigDecimal, Money> returnvalue = vendingMachine.gettempMoneyMap();

                        Iterator< BigDecimal > iterator = returnvalue.keySet().iterator();
                        String s = "";
                        while (iterator.hasNext()){
                            BigDecimal key = iterator.next();
                            String type = returnvalue.get(key).getType();
                            int count = returnvalue.get(key).getCount();
                            s = s + "Type: " + type +", " + "Amount: " + key +"," + "Count: " + count + ",\n";
                            System.out.println(s);
                        }
                        JTextPane jtp = new JTextPane();
                        jtp.setText("Payment succeeded"+ info.split(",")[0] +",\n your change:\n" + s);
                        JScrollPane jsp = new JScrollPane(jtp);
                        jsp.setPreferredSize(new Dimension(480, 150));
                        jsp.setBorder(null);
                        JOptionPane.showMessageDialog(panel, jsp, "Payment succeeded!" , JOptionPane.INFORMATION_MESSAGE);

                        for (Product p : boughtProduct) {
                            vendingMachine.sellProducts(p);
                        }

                        Seller seller = new Seller("",0,"");
                        seller.getReportASummary(vendingMachine);
                        seller.getReportAListOfTheCurrentAvailableItems(vendingMachine);
                        Cashier cashier = new Cashier("",2,"");
                        cashier.getReportOfTheTransaction(vendingMachine);
                        WriteTXT writeTXT = new WriteTXT();
                        writeTXT.writeProductTXT(vendingMachine.getProducts());
                        writeTXT.writeMoneyTXT(vendingMachine.getMoneyMap());

                        timer.stop();
                        dispose();

                        LoginView loginView = new LoginView(vendingMachine);
                        loginView.LoginViewPlot();

                    }
                    else if(info.equals("There are no available changes, enter the different notes or coins, or you can cancel this order.")){
                        JOptionPane.showMessageDialog(panel, info, "Payment failed!" , JOptionPane.WARNING_MESSAGE);

                    }
                    else if(info.equals("The cash you paid is not enough, you need to input more cash, or you can cancel this order.")){
                        JOptionPane.showMessageDialog(panel, info, "Payment failed!" , JOptionPane.WARNING_MESSAGE);

                    }
                    else if(info.equals("Successful Paid. Please get your product!")){
                        JOptionPane.showMessageDialog(panel, info, "Payment succeeded!" , JOptionPane.INFORMATION_MESSAGE);
                        for (Product p : boughtProduct) {
                            vendingMachine.sellProducts(p);
                        }
                        WriteTXT writeTXT = new WriteTXT();
                        writeTXT.writeProductTXT(vendingMachine.getProducts());
                        writeTXT.writeMoneyTXT(vendingMachine.getMoneyMap());
                        Seller seller = new Seller("",0,"");
                        seller.getReportASummary(vendingMachine);
                        seller.getReportAListOfTheCurrentAvailableItems(vendingMachine);
                        Cashier cashier = new Cashier("",2,"");
                        cashier.getReportOfTheTransaction(vendingMachine);
                        timer.stop();
                        dispose();
                        LoginView loginView = new LoginView(vendingMachine);
                        loginView.LoginViewPlot();


                    }
                    else {
                        ;
                    }
                }
            }
        });

        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==exit){
                    CancelTransaction cancelTransaction = new CancelTransaction("user cancelled",vendingMachine.getUsers().get(Integer.parseInt(account)));
                    vendingMachine.getCancelTransactions().add(cancelTransaction);
                    Owner owner = new Owner("",999,"");
                    owner.getCancelTransactionReport(vendingMachine);

                    timer.stop();
                    dispose();
                    LoginView loginView = new LoginView(vendingMachine);
                    loginView.LoginViewPlot();
                }
            }

        });

        panel.add(exit);

        springLayout.putConstraint(SpringLayout.WEST,exit,200,SpringLayout.EAST,pay);
        springLayout.putConstraint(SpringLayout.NORTH,exit,500,SpringLayout.NORTH,panel);

        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                tt = 0;
            }
        });




        container.add(panel);
        setVisible(true);

    }




}
