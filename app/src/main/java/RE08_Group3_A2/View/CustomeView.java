package RE08_Group3_A2.View;

import RE08_Group3_A2.CancelTransaction;
import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.User.Owner;
import RE08_Group3_A2.VendingMachine;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

public class CustomeView extends JFrame {
    VendingMachine vendingMachine;
    SpringLayout springLayout = new SpringLayout();


    JTabbedPane jTabbedpane = new JTabbedPane();
    String[] tabNames = { "Drinks", "Chocolates","Chips","Candies","Order" };
    JPanel panel0 = new JPanel(springLayout);
    JPanel panel1 = new JPanel(springLayout);
    JPanel panel2 = new JPanel(springLayout);
    JPanel panel3 = new JPanel(springLayout);
    JPanel panel4 = new JPanel(springLayout);
    JPanel panel5 = new JPanel(springLayout);

    int numDrinks = 0;
    int numChocolates = 0;
    int numChips = 0;
    int numCandies = 0;

    String s1 = "";
    String s2 = "";
    String s3 = "";
    String s4 = "";
    String s5 = "";
    BigDecimal p1 = new BigDecimal(0);
    BigDecimal p2= new BigDecimal(0);
    BigDecimal p3= new BigDecimal(0);
    BigDecimal p4= new BigDecimal(0);
    BigDecimal p_total = new BigDecimal(0);
    String account = "";

    List<Product> products = new ArrayList<>();

    int time = 0;
    String username;

    public CustomeView(VendingMachine vendingMachine,String username,String account) {
        this.vendingMachine = vendingMachine;
        this.username = username;
        this.account = account;
    }

    public void CustomeViewPlot(){



        JLabel t = new JLabel("You have "+Integer.toString(120-time)+" seconds left");
        panel5.add(t);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                t.setText("You have "+Integer.toString(120-time)+" seconds left");
                time++;

            }
        });
        timer.start();

        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (time>=120){
                    //TODO:Time out & add it in report
                    JOptionPane.showMessageDialog(panel5, "Sorry,time out!", "Failed!", JOptionPane.WARNING_MESSAGE);
                    time = 0;
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
        if(vendingMachine.recentlyProduct(username)==null){
            JLabel a = new JLabel("no any history");
            panel5.add(a);
            springLayout.putConstraint(SpringLayout.NORTH,a,25,SpringLayout.NORTH,panel5);
            springLayout.putConstraint(SpringLayout.WEST,a,50,SpringLayout.WEST,panel5);
        }
        else {

            JLabel b = new JLabel("You recently purchased:");
            panel5.add(b);
            springLayout.putConstraint(SpringLayout.NORTH,b,25,SpringLayout.NORTH,panel5);
            springLayout.putConstraint(SpringLayout.WEST,b,50,SpringLayout.WEST,panel5);
            for (int i = 0; i < vendingMachine.recentlyProduct(username).size(); i++) {
                if (i>4){
                    break;
                }
                JLabel a = new JLabel(vendingMachine.recentlyProduct(username).get(i).getName());
                panel5.add(a);
                springLayout.putConstraint(SpringLayout.NORTH,a,50+i*25,SpringLayout.NORTH,panel5);
                springLayout.putConstraint(SpringLayout.WEST,a,50,SpringLayout.WEST,panel5);
            }
        }




        ReadTXT product = new ReadTXT();
        HashMap<Integer, Product> productlist = product.readProductTXT();
        Container container = getContentPane();

        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Re 08    Group 3    Project 2");
        jTabbedpane.addTab("Home",new ImageIcon(), panel5, "Home");
        jTabbedpane.addTab(tabNames[0],new ImageIcon(), panel0, tabNames[0]);
        jTabbedpane.addTab(tabNames[1],new ImageIcon(), panel1, tabNames[1]);
        jTabbedpane.addTab(tabNames[2],new ImageIcon(), panel2, tabNames[2]);
        jTabbedpane.addTab(tabNames[3],new ImageIcon(), panel3, tabNames[3]);
        jTabbedpane.addTab(tabNames[4],new ImageIcon(), panel4, tabNames[4]);


        Iterator < Integer > iterator = productlist.keySet().iterator();

        while (iterator.hasNext()){
            Integer code = iterator.next();
            String type = productlist.get(code).getType();
            String name = productlist.get(code).getName();
            int maxNum = productlist.get(code).getCount();
//            double price = productlist.get(code).getPrice();

            //Drinks
            if(type.equals("Drinks")){
                numDrinks++;

                JCheckBox product_Drinks = new JCheckBox(name);
                //name: Drink1 Drink2 Drink3 ...Drinkn
                product_Drinks.setName(name);
                panel0.add(product_Drinks);
                int x = numDrinks*40+20;
                int y = 50;
                springLayout.putConstraint(SpringLayout.NORTH,product_Drinks,x,SpringLayout.NORTH,panel0);
                springLayout.putConstraint(SpringLayout.WEST,product_Drinks,y,SpringLayout.WEST,panel0);

                SpinnerModel model = new SpinnerNumberModel(0, 0, maxNum, 1);
                JSpinner num = new JSpinner(model);
                JFormattedTextField tf =  ((JSpinner.DefaultEditor)num.getEditor()).getTextField();
                tf.setEditable(false);
                // name:Drinknum1,Drinknum2,Drinknum3...Drinknumn
                num.setName(Integer.toString(numDrinks));
                panel0.add(num);
                springLayout.putConstraint(SpringLayout.NORTH,num,x,SpringLayout.NORTH,panel0);
                springLayout.putConstraint(SpringLayout.EAST,num,50,SpringLayout.EAST,product_Drinks);

                JLabel ID = new JLabel(code.toString());
                // name:Drinkid1,Drinkid2...
                ID.setName(Integer.toString(code));
                panel0.add(ID);
                springLayout.putConstraint(SpringLayout.NORTH,ID,x,SpringLayout.NORTH,panel0);
                springLayout.putConstraint(SpringLayout.EAST,ID,50,SpringLayout.EAST,num);

                num.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent changeEvent) {
                        if(changeEvent.getSource()==num){
                            if((int)num.getValue()>=maxNum){
                                JOptionPane.showMessageDialog(panel0,"only " +maxNum+ "!","MAX!",1);
                            }
                        }
                    }
                });

            }
            //Chocolates
            else if(type.equals("Chocolates")){
                numChocolates++;

                JCheckBox product_Chocolates = new JCheckBox(name);
                //name: Chocolates1 Chocolates2 Chocolates3 ...Chocolatesn
                product_Chocolates.setName(name);
                panel1.add(product_Chocolates);
                int x = numChocolates*40+20;
                int y = 50;
                springLayout.putConstraint(SpringLayout.NORTH,product_Chocolates,x,SpringLayout.NORTH,panel1);
                springLayout.putConstraint(SpringLayout.WEST,product_Chocolates,y,SpringLayout.WEST,panel1);

                SpinnerModel model = new SpinnerNumberModel(0, 0, maxNum, 1);
                JSpinner num = new JSpinner(model);
                JFormattedTextField tf =  ((JSpinner.DefaultEditor)num.getEditor()).getTextField();
                tf.setEditable(false);
                // name:Chocolatesnum1,Chocolatesnum2,Chocolatesnum3...Chocolatesnumn
                num.setName(Integer.toString(numChocolates));
                panel1.add(num);
                springLayout.putConstraint(SpringLayout.NORTH,num,x,SpringLayout.NORTH,panel1);
                springLayout.putConstraint(SpringLayout.EAST,num,50,SpringLayout.EAST,product_Chocolates);

                JLabel ID = new JLabel(code.toString());
                // name:Chocolatesid1,Chocolatesid2...
                ID.setName(Integer.toString(code));
                panel1.add(ID);
                springLayout.putConstraint(SpringLayout.NORTH,ID,x,SpringLayout.NORTH,panel1);
                springLayout.putConstraint(SpringLayout.EAST,ID,50,SpringLayout.EAST,num);
                num.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent changeEvent) {
                        if(changeEvent.getSource()==num){
                            if((int)num.getValue()>=maxNum){
                                JOptionPane.showMessageDialog(panel0,"only " +maxNum+ "!","MAX!",1);
                            }
                        }
                    }
                });
            }
            //Chips
            else if(type.equals("Chips")){
                numChips++;

                JCheckBox product_Chips = new JCheckBox(name);
                //name: Chips1 Chips2 Chips3 ...Chipsn
                product_Chips.setName(name);
                panel2.add(product_Chips);
                int x = numChips*40+20;
                int y = 50;
                springLayout.putConstraint(SpringLayout.NORTH,product_Chips,x,SpringLayout.NORTH,panel2);
                springLayout.putConstraint(SpringLayout.WEST,product_Chips,y,SpringLayout.WEST,panel2);

                SpinnerModel model = new SpinnerNumberModel(0, 0, maxNum, 1);
                JSpinner num = new JSpinner(model);
                JFormattedTextField tf =  ((JSpinner.DefaultEditor)num.getEditor()).getTextField();
                tf.setEditable(false);
                // name:Chipsnum1,Chipsnum2,Chipsnum3...Chipsnumn
                num.setName(Integer.toString(numChips));
                panel2.add(num);
                springLayout.putConstraint(SpringLayout.NORTH,num,x,SpringLayout.NORTH,panel2);
                springLayout.putConstraint(SpringLayout.EAST,num,50,SpringLayout.EAST,product_Chips);

                JLabel ID = new JLabel(code.toString());
                // name:Chipsid1,Chipsid2...
                ID.setName(Integer.toString(code));
                panel2.add(ID);
                springLayout.putConstraint(SpringLayout.NORTH,ID,x,SpringLayout.NORTH,panel2);
                springLayout.putConstraint(SpringLayout.EAST,ID,50,SpringLayout.EAST,num);
                num.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent changeEvent) {
                        if(changeEvent.getSource()==num){
                            if((int)num.getValue()>=maxNum){
                                JOptionPane.showMessageDialog(panel0,"only " +maxNum+ "!","MAX!",1);
                            }
                        }
                    }
                });
            }
            //Candies
            else if(type.equals("Candies")){
                numCandies++;

                JCheckBox product_Candies = new JCheckBox(name);
                //name: Candies1 Candies2 Candies3 ...Candiesn
                product_Candies.setName(name);
                panel3.add(product_Candies);
                int x = numCandies*40+20;
                int y = 50;
                springLayout.putConstraint(SpringLayout.NORTH,product_Candies,x,SpringLayout.NORTH,panel3);
                springLayout.putConstraint(SpringLayout.WEST,product_Candies,y,SpringLayout.WEST,panel3);

                SpinnerModel model = new SpinnerNumberModel(0, 0, maxNum, 1);
                JSpinner num = new JSpinner(model);
                JFormattedTextField tf =  ((JSpinner.DefaultEditor)num.getEditor()).getTextField();
                tf.setEditable(false);
                // name:Candiesnum1,Candiesnum2,Candiesnum3...Candiesnumn
                num.setName(Integer.toString(numCandies));
                panel3.add(num);
                springLayout.putConstraint(SpringLayout.NORTH,num,x,SpringLayout.NORTH,panel3);
                springLayout.putConstraint(SpringLayout.EAST,num,50,SpringLayout.EAST,product_Candies);

                JLabel ID = new JLabel(code.toString());
                // name:Candiesid1,Candiesid2...
                ID.setName(Integer.toString(code));
                panel3.add(ID);
                springLayout.putConstraint(SpringLayout.NORTH,ID,x,SpringLayout.NORTH,panel3);
                springLayout.putConstraint(SpringLayout.EAST,ID,50,SpringLayout.EAST,num);
                num.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent changeEvent) {
                        if(changeEvent.getSource()==num){
                            if((int)num.getValue()>=maxNum){
                                JOptionPane.showMessageDialog(panel0,"only " +maxNum+ "!","MAX!",1);
                            }
                        }
                    }
                });
            }
            else{
                ;
            }
        }

        //order
        JTextArea orderList = new JTextArea(20,70);
        orderList.setEditable(false);
        panel4.add(orderList);

        JButton panel5Button = new JButton("Payment (Cash)");
        panel4.add(panel5Button);
        springLayout.putConstraint(SpringLayout.NORTH,panel5Button,50,SpringLayout.SOUTH,orderList);

        JButton panel5Button2 = new JButton("Payment (Card)");
        panel4.add(panel5Button2);
        springLayout.putConstraint(SpringLayout.NORTH,panel5Button2,50,SpringLayout.NORTH,panel5Button);


        //panel0:
        JButton panel0Button = new JButton("Add the Drinks to the order");
        panel0.add(panel0Button);
        springLayout.putConstraint(SpringLayout.NORTH,panel0Button,350,SpringLayout.NORTH,panel0);

        panel0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==panel0Button){
                    s1 = "";
                    p1 = new BigDecimal(0);
                    Component[] components_panel0 = panel0.getComponents();
                    //-1 because one button
                    for (int i = 0; i < components_panel0.length-1; i+=3) {
                        //name num id, name num id... button
                        if(components_panel0[i] instanceof JCheckBox && components_panel0[i+1] instanceof JSpinner){
                            if (((JCheckBox) components_panel0[i]).isSelected() && (int)((JSpinner) components_panel0[i+1]).getValue()>0){
                                Product p = productlist.get(Integer.parseInt(components_panel0[i+2].getName()));


//                                for (int j = 0; j < (int) ((JSpinner) components_panel0[i + 1]).getValue(); j++) {
//                                    products.add(p);
//                                }
                                p.setCount(((int)((JSpinner) components_panel0[i+1]).getValue()));
                                products.add(p);
                                //double price = (int)((JSpinner) components_panel0[i+1]).getValue() * p.getPrice();
                                BigDecimal price = p.getPrice().multiply(BigDecimal.valueOf(((int)((JSpinner) components_panel0[i+1]).getValue())));
                                p1 = price.add(p1);
                                s1 = s1 + p.getName() + "," + (int)((JSpinner) components_panel0[i+1]).getValue() + "," + price + "\n";

                            }
                        }
                    }
                    if(s1.equals("")){
                        JOptionPane.showMessageDialog(panel0, "No product!", "Error!", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel0, "It has been added to the order!", "OK!", JOptionPane.INFORMATION_MESSAGE);

                    }


                    p_total = p1.add(p2.add(p3.add(p4)));
                    s5 = s1 + s2 + s3 +s4;
                    orderList.setText(s5);
                }
            }
        });


        //panel1:
        JButton panel1Button = new JButton("Add the Chocolates to the order");
        panel1.add(panel1Button);
        springLayout.putConstraint(SpringLayout.NORTH,panel1Button,350,SpringLayout.NORTH,panel1);

        panel1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==panel1Button){
                    s2 = "";
                    p2 = new BigDecimal(0);
                    Component[] components_panel0 = panel1.getComponents();
                    //-1 because one button
                    for (int i = 0; i < components_panel0.length-1; i+=3) {
                        //name num id, name num id... button
                        if(components_panel0[i] instanceof JCheckBox && components_panel0[i+1] instanceof JSpinner){
                            if (((JCheckBox) components_panel0[i]).isSelected() && (int)((JSpinner) components_panel0[i+1]).getValue()>0){
                                Product p = productlist.get(Integer.parseInt(components_panel0[i+2].getName()));

//                                for (int j = 0; j < (int) ((JSpinner) components_panel0[i + 1]).getValue(); j++) {
//                                    products.add(p);
//                                }
                                p.setCount(((int)((JSpinner) components_panel0[i+1]).getValue()));
                                products.add(p);
                                BigDecimal price = p.getPrice().multiply(BigDecimal.valueOf(((int)((JSpinner) components_panel0[i+1]).getValue())));
                                p2 = price.add(p2);
                                s2 = s2 + p.getName() + "," + (int)((JSpinner) components_panel0[i+1]).getValue() + "," + price + "\n";

                            }
                        }
                    }
                    if(s2.equals("")){
                        JOptionPane.showMessageDialog(panel1, "No product!", "Error!", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel1, "It has been added to the order!", "OK!", JOptionPane.INFORMATION_MESSAGE);

                    }
                    p_total = p1.add(p2.add(p3.add(p4)));
                    s5 = s1 + s2 + s3 +s4;
                    orderList.setText(s5);
                }
            }
        });

        //panel2:
        JButton panel2Button = new JButton("Add the Chips to the order");
        panel2.add(panel2Button);
        springLayout.putConstraint(SpringLayout.NORTH,panel2Button,350,SpringLayout.NORTH,panel2);

        panel2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==panel2Button){
                    s3 = "";
                    p3 = new BigDecimal(0);
                    Component[] components_panel0 = panel2.getComponents();
                    //-1 because one button
                    for (int i = 0; i < components_panel0.length-1; i+=3) {
                        //name num id, name num id... button
                        if(components_panel0[i] instanceof JCheckBox && components_panel0[i+1] instanceof JSpinner){
                            if (((JCheckBox) components_panel0[i]).isSelected() && (int)((JSpinner) components_panel0[i+1]).getValue()>0){
                                Product p = productlist.get(Integer.parseInt(components_panel0[i+2].getName()));

//                                for (int j = 0; j < (int) ((JSpinner) components_panel0[i + 1]).getValue(); j++) {
//                                    products.add(p);
//                                }
                                p.setCount(((int)((JSpinner) components_panel0[i+1]).getValue()));
                                products.add(p);
                                BigDecimal price = p.getPrice().multiply(BigDecimal.valueOf(((int)((JSpinner) components_panel0[i+1]).getValue())));
                                p3 = price.add(p3);
                                s3 = s3 + p.getName() + "," + (int)((JSpinner) components_panel0[i+1]).getValue() + "," + price + "\n";

                            }
                        }
                    }
                    if(s3.equals("")){
                        JOptionPane.showMessageDialog(panel2, "No product!", "Error!", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel2, "It has been added to the order!", "OK!", JOptionPane.INFORMATION_MESSAGE);

                    }
                    p_total = p1.add(p2.add(p3.add(p4)));
                    s5 = s1 + s2 + s3 +s4;
                    orderList.setText(s5);
                }
            }
        });

        //panel3:
        JButton panel3Button = new JButton("Add the Candies to the order");
        panel3.add(panel3Button);
        springLayout.putConstraint(SpringLayout.NORTH,panel3Button,350,SpringLayout.NORTH,panel3);

        panel3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==panel3Button){
                    s4 = "";
                    p4 = new BigDecimal(0);
                    Component[] components_panel0 = panel3.getComponents();
                    //-1 because one button
                    for (int i = 0; i < components_panel0.length-1; i+=3) {
                        //name num id, name num id... button
                        if(components_panel0[i] instanceof JCheckBox && components_panel0[i+1] instanceof JSpinner){
                            if (((JCheckBox) components_panel0[i]).isSelected() && (int)((JSpinner) components_panel0[i+1]).getValue()>0){
                                Product p = productlist.get(Integer.parseInt(components_panel0[i+2].getName()));

//                                for (int j = 0; j < (int) ((JSpinner) components_panel0[i + 1]).getValue(); j++) {
//                                    products.add(p);
//                                }
                                p.setCount(((int)((JSpinner) components_panel0[i+1]).getValue()));
                                products.add(p);
                                BigDecimal price = p.getPrice().multiply(BigDecimal.valueOf(((int)((JSpinner) components_panel0[i+1]).getValue())));
                                p4 = price.add(p4);
                                s4 = s4 + p.getName() + "," + (int)((JSpinner) components_panel0[i+1]).getValue() + "," + price + "\n";

                            }
                        }
                    }
                    if(s4.equals("")){
                        JOptionPane.showMessageDialog(panel3, "No product!", "Error!", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel3, "It has been added to the order!", "OK!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    p_total = p1.add(p2.add(p3.add(p4)));
                    s5 = s1 + s2 + s3 +s4;
                    orderList.setText(s5);
                }
            }
        });

        panel5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==panel5Button){
                    if ( products.size()>0){
                        timer.stop();
                        dispose();
                        Pay_CashView pay_cashView = new Pay_CashView(vendingMachine,username);
                        pay_cashView.Pay_CashViewPlot(p_total,products,s5,time,account);
                    }
                    else{
                        JOptionPane.showMessageDialog(panel4, "no product!", "Failed!", JOptionPane.WARNING_MESSAGE);
                    }


                }
            }
        });

        panel5Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==panel5Button2){
                    if ( products.size()>0){
                        timer.stop();
                        dispose();
                        Pay_CardView pay_cardView = new Pay_CardView(vendingMachine,username);
                        pay_cardView.Pay_CardViewPlot(p_total,products,s5,account,time);
                    }
                    else {
                        JOptionPane.showMessageDialog(panel4, "no product!", "Failed!", JOptionPane.WARNING_MESSAGE);
                    }


                }
            }
        });

        JButton panel5Button3 = new JButton("Exit");
        panel5Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==panel5Button3){

                    CancelTransaction cancelTransaction = new CancelTransaction("user cancelled",vendingMachine.getUsers().get(Integer.parseInt(account)));
                    vendingMachine.getCancelTransactions().add(cancelTransaction);
                    Owner owner = new Owner("",999,"");
                    owner.getCancelTransactionReport(vendingMachine);

                    dispose();
                    LoginView LV = new LoginView(vendingMachine);
                    LV.LoginViewPlot();
                }
            }
        });

        panel4.add(panel5Button3);
        springLayout.putConstraint(SpringLayout.NORTH,panel5Button3,500,SpringLayout.NORTH,panel3);

        panel0.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                time = 0;
            }
        });

        panel1.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                time = 0;
            }
        });

        panel2.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                time = 0;
            }
        });

        panel3.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                time = 0;
            }
        });

        panel4.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                time = 0;
            }
        });

        panel5.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                time = 0;
            }
        });





        container.add(jTabbedpane);
        setVisible(true);
    }


//    static class task extends java.util.TimerTask{
//        @Override
//        public void run(){
//
//        }
//    }
//    public static void main(String[] args) {
//        CustomeView customeView = new CustomeView();
//        customeView.CustomeViewPlot();
//    }
}
