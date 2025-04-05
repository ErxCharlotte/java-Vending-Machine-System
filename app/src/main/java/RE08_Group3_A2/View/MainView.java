//package RE08_Group3_A2.View;
//
//import RE08_Group3_A2.Product.Product;
//import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//
//public class MainView extends JFrame {
//
//    SpringLayout springLayout = new SpringLayout();
//
//    JTabbedPane jTabbedpane = new JTabbedPane();
//    String[] tabNames = { "Drinks", "Chocolates","Chips","Candies","Order" };
//    JPanel panel1 = new JPanel(springLayout);
//    JPanel panel2 = new JPanel(springLayout);
//    JPanel panel3 = new JPanel(springLayout);
//    JPanel panel4 = new JPanel(springLayout);
//    JPanel panel5 = new JPanel(springLayout);
//    String s1 = "";
//    String s2 = "";
//    String s3 = "";
//    String s4 = "";
//    String s5 = "";
//    double p1;
//    double p2;
//    double p3;
//    double p4;
//    double p_total = 0;
//    List<Product> products = new ArrayList<>();
//
//
//
//
//    public void MainViewPlot(){
//        //get quantity of products
//        ReadTXT product = new ReadTXT();
//        HashMap<Integer, Product> productlist = product.readProductTXT();
////        System.out.println(productlist.get(1000).getCount());
//
//
//
//        Container container = getContentPane();
//
//        setSize(800,600);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setResizable(false);
//        setTitle("Re 08    Group 3    Project 2");
//
//
//        //panel1
//        //Mineral Water
//        jTabbedpane.addTab(tabNames[0],new ImageIcon(), panel1, "1");
//        JCheckBox Mineral_Water = new JCheckBox("Mineral Water");
//        panel1.add(Mineral_Water);
//        springLayout.putConstraint(SpringLayout.WEST,Mineral_Water,20,SpringLayout.WEST,panel1);
//        springLayout.putConstraint(SpringLayout.NORTH,Mineral_Water,50,SpringLayout.NORTH,panel1);
//
//        SpinnerModel model_Mineral_Water = new SpinnerNumberModel(0, 0, productlist.get(1000).getCount(), 1);
//        JSpinner num_Mineral_Water = new JSpinner(model_Mineral_Water);
//        JFormattedTextField tf_Mineral_Water =  ((JSpinner.DefaultEditor)num_Mineral_Water.getEditor()).getTextField();
//        tf_Mineral_Water.setEditable(false);
//        panel1.add(num_Mineral_Water);
//        springLayout.putConstraint(SpringLayout.EAST,num_Mineral_Water,50,SpringLayout.EAST,Mineral_Water);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Mineral_Water,50,SpringLayout.NORTH,panel1);
//
//
//        //Sprite
//        JCheckBox Sprite = new JCheckBox("Sprite");
//        panel1.add(Sprite);
//        springLayout.putConstraint(SpringLayout.WEST,Sprite,20,SpringLayout.WEST,panel1);
//        springLayout.putConstraint(SpringLayout.NORTH,Sprite,50,SpringLayout.NORTH,Mineral_Water);
//
//        SpinnerModel model_Sprite = new SpinnerNumberModel(0, 0, productlist.get(1001).getCount(), 1);
//        JSpinner num_Sprite = new JSpinner(model_Sprite);
//        JFormattedTextField tf_Sprite =  ((JSpinner.DefaultEditor)num_Sprite.getEditor()).getTextField();
//        tf_Sprite.setEditable(false);
//        panel1.add(num_Sprite);
//        springLayout.putConstraint(SpringLayout.EAST,num_Sprite,50,SpringLayout.EAST,Sprite);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Sprite,50,SpringLayout.NORTH,num_Mineral_Water);
//
//
//        //Coca_cola
//        JCheckBox Coca_cola = new JCheckBox("Coca cola");
//        panel1.add(Coca_cola);
//        springLayout.putConstraint(SpringLayout.WEST,Coca_cola,20,SpringLayout.WEST,panel1);
//        springLayout.putConstraint(SpringLayout.NORTH,Coca_cola,50,SpringLayout.NORTH,Sprite);
//
//        SpinnerModel model_Coca_cola = new SpinnerNumberModel(0, 0, productlist.get(1002).getCount(), 1);
//        JSpinner num_Coca_cola = new JSpinner(model_Coca_cola);
//        JFormattedTextField tf_Coca_cola =  ((JSpinner.DefaultEditor)num_Coca_cola.getEditor()).getTextField();
//        tf_Coca_cola.setEditable(false);
//        panel1.add(num_Coca_cola);
//        springLayout.putConstraint(SpringLayout.EAST,num_Coca_cola,50,SpringLayout.EAST,Coca_cola);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Coca_cola,50,SpringLayout.NORTH,num_Sprite);
//
//
//
//        //Pepsi
//        JCheckBox Pepsi = new JCheckBox("Pepsi");
//        panel1.add(Pepsi);
//        springLayout.putConstraint(SpringLayout.WEST,Pepsi,20,SpringLayout.WEST,panel1);
//        springLayout.putConstraint(SpringLayout.NORTH,Pepsi,50,SpringLayout.NORTH,Coca_cola);
//
//        SpinnerModel model_Pepsi = new SpinnerNumberModel(0, 0, productlist.get(1003).getCount(), 1);
//        JSpinner num_Pepsi = new JSpinner(model_Pepsi);
//        JFormattedTextField tf_Pepsi =  ((JSpinner.DefaultEditor)num_Pepsi.getEditor()).getTextField();
//        tf_Pepsi.setEditable(false);
//        panel1.add(num_Pepsi);
//        springLayout.putConstraint(SpringLayout.EAST,num_Pepsi,50,SpringLayout.EAST,Pepsi);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Pepsi,50,SpringLayout.NORTH,num_Coca_cola);
//
//
//        //Juice
//        JCheckBox  Juice = new JCheckBox(" Juice");
//        panel1.add(Juice);
//        springLayout.putConstraint(SpringLayout.WEST,Juice,20,SpringLayout.WEST,panel1);
//        springLayout.putConstraint(SpringLayout.NORTH,Juice,50,SpringLayout.NORTH,Pepsi);
//
//        SpinnerModel model_Juice = new SpinnerNumberModel(0, 0, productlist.get(1004).getCount(), 1);
//        JSpinner num_Juice = new JSpinner(model_Juice);
//        JFormattedTextField tf_Juice =  ((JSpinner.DefaultEditor)num_Juice.getEditor()).getTextField();
//        tf_Juice.setEditable(false);
//        panel1.add(num_Juice);
//        springLayout.putConstraint(SpringLayout.EAST,num_Juice,50,SpringLayout.EAST,Juice);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Juice,50,SpringLayout.NORTH,num_Pepsi);
//
//
//        //panel2
//        //Mars
//        jTabbedpane.addTab(tabNames[1],new ImageIcon(), panel2, "2");
//        JCheckBox Mars = new JCheckBox("Mars");
//        panel2.add(Mars);
//        springLayout.putConstraint(SpringLayout.WEST,Mars,20,SpringLayout.WEST,panel2);
//        springLayout.putConstraint(SpringLayout.NORTH,Mars,50,SpringLayout.NORTH,panel2);
//
//        SpinnerModel model_Mars = new SpinnerNumberModel(0, 0, productlist.get(1005).getCount(), 1);
//        JSpinner num_Mars= new JSpinner(model_Mars);
//        JFormattedTextField tf_Mars =  ((JSpinner.DefaultEditor)num_Mars.getEditor()).getTextField();
//        tf_Mars.setEditable(false);
//        panel2.add(num_Mars);
//        springLayout.putConstraint(SpringLayout.EAST,num_Mars,50,SpringLayout.EAST,Mars);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Mars,50,SpringLayout.NORTH,panel2);
//
//
//        //M&M
//        JCheckBox MM = new JCheckBox("M&M");
//        panel2.add(MM);
//        springLayout.putConstraint(SpringLayout.WEST,MM,20,SpringLayout.WEST,panel2);
//        springLayout.putConstraint(SpringLayout.NORTH,MM,50,SpringLayout.NORTH,Mars);
//
//        SpinnerModel model_MM = new SpinnerNumberModel(0, 0, productlist.get(1006).getCount(), 1);
//        JSpinner num_MM= new JSpinner(model_MM);
//        JFormattedTextField tf_MM =  ((JSpinner.DefaultEditor)num_MM.getEditor()).getTextField();
//        tf_MM.setEditable(false);
//        panel2.add(num_MM);
//        springLayout.putConstraint(SpringLayout.EAST,num_MM,50,SpringLayout.EAST,MM);
//        springLayout.putConstraint(SpringLayout.NORTH,num_MM,50,SpringLayout.NORTH,num_Mars);
//
//
//        //Bounty
//        JCheckBox Bounty = new JCheckBox("Bounty");
//        panel2.add(Bounty);
//        springLayout.putConstraint(SpringLayout.WEST,Bounty,20,SpringLayout.WEST,panel2);
//        springLayout.putConstraint(SpringLayout.NORTH,Bounty,50,SpringLayout.NORTH,MM);
//
//        SpinnerModel model_Bounty = new SpinnerNumberModel(0, 0, productlist.get(1007).getCount(), 1);
//        JSpinner num_Bounty= new JSpinner(model_Bounty);
//        JFormattedTextField tf_Bounty =  ((JSpinner.DefaultEditor)num_Bounty.getEditor()).getTextField();
//        tf_Bounty.setEditable(false);
//        panel2.add(num_Bounty);
//        springLayout.putConstraint(SpringLayout.EAST,num_Bounty,50,SpringLayout.EAST,Bounty);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Bounty,50,SpringLayout.NORTH,num_MM);
//
//
//        //Snickers
//        JCheckBox Snickers = new JCheckBox("Snickers");
//        panel2.add(Snickers);
//        springLayout.putConstraint(SpringLayout.WEST,Snickers,20,SpringLayout.WEST,panel2);
//        springLayout.putConstraint(SpringLayout.NORTH,Snickers,50,SpringLayout.NORTH,Bounty);
//
//        SpinnerModel model_Snickers = new SpinnerNumberModel(0, 0, productlist.get(1008).getCount(), 1);
//        JSpinner num_Snickers= new JSpinner(model_Snickers);
//        JFormattedTextField tf_Snickers =  ((JSpinner.DefaultEditor)num_Snickers.getEditor()).getTextField();
//        tf_Snickers.setEditable(false);
//        panel2.add(num_Snickers);
//        springLayout.putConstraint(SpringLayout.EAST,num_Snickers,50,SpringLayout.EAST,Snickers);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Snickers,50,SpringLayout.NORTH,num_Bounty);
//
//
//        //panel3
//        //Smiths
//        jTabbedpane.addTab(tabNames[2],new ImageIcon(), panel3, "3");
//        JCheckBox Smiths = new JCheckBox("Smiths");
//        panel3.add(Smiths);
//        springLayout.putConstraint(SpringLayout.WEST,Smiths,20,SpringLayout.WEST,panel3);
//        springLayout.putConstraint(SpringLayout.NORTH,Smiths,50,SpringLayout.NORTH,panel3);
//
//        SpinnerModel model_Smiths = new SpinnerNumberModel(0, 0, productlist.get(1009).getCount(), 1);
//        JSpinner num_Smiths= new JSpinner(model_Smiths);
//        JFormattedTextField tf_Smiths =  ((JSpinner.DefaultEditor)num_Smiths.getEditor()).getTextField();
//        tf_Smiths.setEditable(false);
//        panel3.add(num_Smiths);
//        springLayout.putConstraint(SpringLayout.EAST,num_Smiths,50,SpringLayout.EAST,Smiths);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Smiths,50,SpringLayout.NORTH,panel3);
//
//        //Pringles
//        JCheckBox Pringles = new JCheckBox("Pringles");
//        panel3.add(Pringles);
//        springLayout.putConstraint(SpringLayout.WEST,Pringles,20,SpringLayout.WEST,panel3);
//        springLayout.putConstraint(SpringLayout.NORTH,Pringles,50,SpringLayout.NORTH,Smiths);
//
//        SpinnerModel model_Pringles = new SpinnerNumberModel(0, 0, productlist.get(1010).getCount(), 1);
//        JSpinner num_Pringles= new JSpinner(model_Pringles);
//        JFormattedTextField tf_Pringles =  ((JSpinner.DefaultEditor)num_Pringles.getEditor()).getTextField();
//        tf_Pringles.setEditable(false);
//        panel3.add(num_Pringles);
//        springLayout.putConstraint(SpringLayout.EAST,num_Pringles,50,SpringLayout.EAST,Pringles);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Pringles,50,SpringLayout.NORTH,num_Smiths);
//
//        //Kettle
//        JCheckBox Kettle = new JCheckBox("Kettle");
//        panel3.add(Kettle);
//        springLayout.putConstraint(SpringLayout.WEST,Kettle,20,SpringLayout.WEST,panel3);
//        springLayout.putConstraint(SpringLayout.NORTH,Kettle,50,SpringLayout.NORTH,Pringles);
//
//        SpinnerModel model_Kettle = new SpinnerNumberModel(0, 0, productlist.get(1011).getCount(), 1);
//        JSpinner num_Kettle= new JSpinner(model_Kettle);
//        JFormattedTextField tf_Kettle =  ((JSpinner.DefaultEditor)num_Kettle.getEditor()).getTextField();
//        tf_Kettle.setEditable(false);
//        panel3.add(num_Kettle);
//        springLayout.putConstraint(SpringLayout.EAST,num_Kettle,50,SpringLayout.EAST,Kettle);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Kettle,50,SpringLayout.NORTH,num_Pringles);
//
//
//        //Thins
//        JCheckBox Thins = new JCheckBox("Thins");
//        panel3.add(Thins);
//        springLayout.putConstraint(SpringLayout.WEST,Thins,20,SpringLayout.WEST,panel3);
//        springLayout.putConstraint(SpringLayout.NORTH,Thins,50,SpringLayout.NORTH,Kettle);
//
//        SpinnerModel model_Thins = new SpinnerNumberModel(0, 0, productlist.get(1012).getCount(), 1);
//        JSpinner num_Thins= new JSpinner(model_Thins);
//        JFormattedTextField tf_Thins =  ((JSpinner.DefaultEditor)num_Thins.getEditor()).getTextField();
//        tf_Thins.setEditable(false);
//        panel3.add(num_Thins);
//        springLayout.putConstraint(SpringLayout.EAST,num_Thins,50,SpringLayout.EAST,Thins);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Thins,50,SpringLayout.NORTH,num_Kettle);
//
//
//        //panel4
//        jTabbedpane.addTab(tabNames[3],new ImageIcon(), panel4, "4");
//
//        //Mentos
//        JCheckBox Mentos = new JCheckBox("Mentos");
//        panel4.add(Mentos);
//        springLayout.putConstraint(SpringLayout.WEST,Mentos,20,SpringLayout.WEST,panel4);
//        springLayout.putConstraint(SpringLayout.NORTH,Mentos,50,SpringLayout.NORTH,panel4);
//
//        SpinnerModel model_Mentos = new SpinnerNumberModel(0, 0, productlist.get(1013).getCount(), 1);
//        JSpinner num_Mentos= new JSpinner(model_Mentos);
//        JFormattedTextField tf_Mentos =  ((JSpinner.DefaultEditor)num_Mentos.getEditor()).getTextField();
//        tf_Mentos.setEditable(false);
//        panel4.add(num_Mentos);
//        springLayout.putConstraint(SpringLayout.EAST,num_Mentos,50,SpringLayout.EAST,Mentos);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Mentos,50,SpringLayout.NORTH,panel4);
//
//
//        //Sour Patch
//        JCheckBox Sour_Patch = new JCheckBox("Sour Patch");
//        panel4.add(Sour_Patch);
//        springLayout.putConstraint(SpringLayout.WEST,Sour_Patch,20,SpringLayout.WEST,panel4);
//        springLayout.putConstraint(SpringLayout.NORTH,Sour_Patch,50,SpringLayout.NORTH,Mentos);
//
//        SpinnerModel model_Sour_Patch = new SpinnerNumberModel(0, 0, productlist.get(1014).getCount(), 1);
//        JSpinner num_Sour_Patch= new JSpinner(model_Sour_Patch);
//        JFormattedTextField tf_Sour_Patch =  ((JSpinner.DefaultEditor)num_Sour_Patch.getEditor()).getTextField();
//        tf_Sour_Patch.setEditable(false);
//        panel4.add(num_Sour_Patch);
//        springLayout.putConstraint(SpringLayout.EAST,num_Sour_Patch,50,SpringLayout.EAST,Sour_Patch);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Sour_Patch,50,SpringLayout.NORTH,num_Mentos);
//
//
//        //Skittles
//        JCheckBox Skittles = new JCheckBox("Skittles");
//        panel4.add(Skittles);
//        springLayout.putConstraint(SpringLayout.WEST,Skittles,20,SpringLayout.WEST,panel4);
//        springLayout.putConstraint(SpringLayout.NORTH,Skittles,50,SpringLayout.NORTH,Sour_Patch);
//
//        SpinnerModel model_Skittles = new SpinnerNumberModel(0, 0, productlist.get(1015).getCount(), 1);
//        JSpinner num_Skittles= new JSpinner(model_Skittles);
//        JFormattedTextField tf_Skittles =  ((JSpinner.DefaultEditor)num_Skittles.getEditor()).getTextField();
//        tf_Skittles.setEditable(false);
//        panel4.add(num_Skittles);
//        springLayout.putConstraint(SpringLayout.EAST,num_Skittles,50,SpringLayout.EAST,Skittles);
//        springLayout.putConstraint(SpringLayout.NORTH,num_Skittles,50,SpringLayout.NORTH,num_Sour_Patch);
//
//
//        jTabbedpane.addTab(tabNames[4],new ImageIcon(), panel5, "5");
//        //panel5
//        JTextArea orderList = new JTextArea(20,70);
//        orderList.setEditable(false);
//        panel5.add(orderList);
//
//        JButton panel5Button = new JButton("Payment (Cash)");
//        panel5.add(panel5Button);
//        springLayout.putConstraint(SpringLayout.NORTH,panel5Button,50,SpringLayout.SOUTH,orderList);
//
//        JButton panel5Button2 = new JButton("Payment (Card)");
//        panel5.add(panel5Button2);
//        springLayout.putConstraint(SpringLayout.NORTH,panel5Button2,50,SpringLayout.NORTH,panel5Button);
//
//
//
//
//
//        JButton panel1Button = new JButton("Add the Drinks to the order");
//        panel1.add(panel1Button);
//        springLayout.putConstraint(SpringLayout.NORTH,panel1Button,100,SpringLayout.NORTH,Juice);
//        panel1Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource()==panel1Button){
//                    s1 = "";
//                    if (Mineral_Water.isSelected()&&((int)num_Mineral_Water.getValue())>0){
//                        double p1000 = productlist.get(1000).getPrice()*(int)num_Mineral_Water.getValue();
//                        p1 += p1000;
//                        s1+= "1000,Mineral Water,"+num_Mineral_Water.getValue().toString() + ", price:" + p1000+"\n";
//                    }
//
//                    if (Sprite.isSelected()&&((int)num_Sprite.getValue())>0){
//                        double p1001 = productlist.get(1001).getPrice()*(int)num_Sprite.getValue();
//                        p1 += p1001;
//                        s1+= "1001,Sprite,"+num_Sprite.getValue().toString()+ ", price:" + p1001+"\n";
//                    }
//
//                    if (Coca_cola.isSelected()&&((int)num_Coca_cola.getValue())>0){
//                        double p1002 = productlist.get(1002).getPrice()*(int)num_Coca_cola.getValue();
//                        p1 += p1002;
//                        s1+= "1002,Coca cola,"+num_Coca_cola.getValue().toString() + ", price:" + p1002+"\n";
//                    }
//
//                    if (Pepsi.isSelected()&&((int)num_Pepsi.getValue())>0){
//                        double p1003 = productlist.get(1003).getPrice()*(int)num_Pepsi.getValue();
//                        p1 += p1003;
//                        s1+= "1003,Pepsi,"+num_Pepsi.getValue().toString() + ", price:" + p1003+"\n";
//                    }
//
//                    if (Juice.isSelected()&&((int)num_Juice.getValue())>0){
//                        double p1004 = productlist.get(1004).getPrice()*(int)num_Juice.getValue();
//                        p1 += p1004;
//                        s1+= "1004,Juice,"+num_Juice.getValue().toString() + ", price:" + p1004+"\n";
//                    }
//                    p_total = p1+p2+p3+p4;
//                    s5 = s1+s2+s3+s4+"total price: " + p_total + "\n";
//                    orderList.setText(s5);
//                }
//            }
//        });
//
//        JButton panel2Button = new JButton("Add the Chocolates to the order");
//        panel2.add(panel2Button);
//        springLayout.putConstraint(SpringLayout.NORTH,panel2Button,100,SpringLayout.NORTH,Snickers);
//        panel2Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource()==panel2Button){
//                    s2 = "";
//                    if (Mars.isSelected()&&((int)num_Mars.getValue())>0){
//                        double p1005 = productlist.get(1005).getPrice()*(int)num_Mars.getValue();
//                        p2 += p1005;
//                        s2+= "1005,Mars,"+num_Mars.getValue().toString() + ", price:" + p1005+"\n";
//                    }
//                    if (MM.isSelected()&&((int)num_MM.getValue())>0){
//                        double p1006 = productlist.get(1006).getPrice()*(int)num_MM.getValue();
//                        p2 += p1006;
//                        s2+= "1006,M&M,"+num_MM.getValue().toString() + ", price:" + p1006+"\n";
//                    }
//                    if (Bounty.isSelected()&&((int)num_Bounty.getValue())>0){
//                        double p1007 = productlist.get(1007).getPrice()*(int)num_Bounty.getValue();
//                        p2 += p1007;
//                        s2+= "1007,Bounty,"+num_Bounty.getValue().toString() + ", price:" + p1007+"\n";
//                    }
//                    if (Snickers.isSelected()&&((int)num_Snickers.getValue())>0){
//                        double p1008 = productlist.get(1008).getPrice()*(int)num_Snickers.getValue();
//                        p2 += p1008;
//                        s2+= "1008,Snickers,"+num_Snickers.getValue().toString() + ", price:" + p1008+"\n";
//                    }
//                    p_total = p1+p2+p3+p4;
//                    s5 = s1+s2+s3+s4+"total price: " + p_total + "\n";
//                    orderList.setText(s5);
//                }
//            }
//        });
//
//        JButton panel3Button = new JButton("Add the Chips to the order");
//        panel3.add(panel3Button);
//        springLayout.putConstraint(SpringLayout.NORTH,panel3Button,100,SpringLayout.NORTH,Thins);
//        panel3Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource()==panel3Button){
//                    s3 = "";
//                    if (Smiths.isSelected()&&((int)num_Smiths.getValue())>0){
//                        double p1009 = productlist.get(1009).getPrice()*(int)num_Smiths.getValue();
//                        p3 += p1009;
//                        s3+= "1009,Smiths,"+num_Smiths.getValue().toString() + ", price:" + p1009+"\n";
//                    }
//                    if (Pringles.isSelected()&&((int)num_Pringles.getValue())>0){
//                        double p1010 = productlist.get(1010).getPrice()*(int)num_Pringles.getValue();
//                        p3 += p1010;
//                        s3+= "1010,Pringles,"+num_Pringles.getValue().toString() + ", price:" + p1010+"\n";
//                    }
//                    if (Kettle.isSelected()&&((int)num_Kettle.getValue())>0){
//                        double p1011 = productlist.get(1011).getPrice()*(int)num_Kettle.getValue();
//                        p3 += p1011;
//                        s3+= "1011,Kettle,"+num_Kettle.getValue().toString() + ", price:" + p1011+"\n";
//                    }
//                    if (Thins.isSelected()&&((int)num_Thins.getValue())>0){
//                        double p1012 = productlist.get(1012).getPrice()*(int)num_Thins.getValue();
//                        p3 += p1012;
//                        s3+= "1012,Thins,"+num_Thins.getValue().toString() + ", price:" + p1012+"\n";
//                    }
//                    p_total = p1+p2+p3+p4;
//                    s5 = s1+s2+s3+s4+"total price: " + p_total + "\n";
//                    orderList.setText(s5);
//
//                }
//            }
//        });
//
//        JButton panel4Button = new JButton("Add the Candies to the order");
//        panel4.add(panel4Button);
//        springLayout.putConstraint(SpringLayout.NORTH,panel4Button,100,SpringLayout.NORTH,Skittles);
//        panel4Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource()==panel4Button){
//                    s4 = "";
//                    if (Mentos.isSelected()&&((int)num_Mentos.getValue())>0){
//                        double p1013 = productlist.get(1013).getPrice()*(int)num_Mentos.getValue();
//                        p4 += p1013;
//                        s4+= "1013,Mentos,"+num_Mentos.getValue().toString() + ", price:" + p1013+"\n";
//
//                    }
//                    if (Sour_Patch.isSelected()&&((int)num_Sour_Patch.getValue())>0){
//                        double p1014 = productlist.get(1014).getPrice()*(int)num_Sour_Patch.getValue();
//                        p4 += p1014;
//                        s4+= "1014,Sour Patch,"+num_Sour_Patch.getValue().toString() + ", price:" + p1014+"\n";
//                    }
//                    if (Skittles.isSelected()&&((int)num_Skittles.getValue())>0){
//                        double p1015 = productlist.get(1015).getPrice()*(int)num_Skittles.getValue();
//                        p4 += p1015;
//                        s4+= "1015,Skittles,"+num_Skittles.getValue().toString() + ", price:" + p1015+"\n";
//                    }
//                    p_total = p1+p2+p3+p4;
//                    s5 = s1+s2+s3+s4+"total price: " + p_total + "\n";
//                    orderList.setText(s5);
//                }
//            }
//        });
//
//        panel5Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource()==panel5Button){
//                    if(!s1.equals("")) {
//                        String[] page1 = s1.split("\n");
//                        for (int i = 0; i < page1.length; i++) {
//                            int code = Integer.parseInt(page1[i].split(",")[0]);
//                            int num = Integer.parseInt(page1[i].split(",")[2]);
//                            for (int j = 0; j < num; j++) {
//                                System.out.println(productlist.get(code).getName());
//                                products.add((Product) productlist.get(code));
//                            }
//                        }
//                    }
//                    if(!s2.equals("")) {
//                        String[] page2 = s2.split("\n");
//                        for (int i = 0; i < page2.length; i++) {
//                            int code = Integer.parseInt(page2[i].split(",")[0]);
//                            int num = Integer.parseInt(page2[i].split(",")[2]);
//                            for (int j = 0; j < num; j++) {
//                                System.out.println(productlist.get(code).getName());
//                                products.add((Product) productlist.get(code));
//                            }
//                        }
//                    }
//                    if(!s3.equals("")) {
//                        String[] page3 = s3.split("\n");
//                        for (int i = 0; i < page3.length; i++) {
//                            int code = Integer.parseInt(page3[i].split(",")[0]);
//                            int num = Integer.parseInt(page3[i].split(",")[2]);
//                            for (int j = 0; j < num; j++) {
//                                System.out.println(productlist.get(code).getName());
//                                products.add((Product) productlist.get(code));
//                            }
//                        }
//                    }
//                    if(!s4.equals("")) {
//                        String[] page4 = s4.split("\n");
//                        for (int i = 0; i < page4.length; i++) {
//                            int code = Integer.parseInt(page4[i].split(",")[0]);
//                            int num = Integer.parseInt(page4[i].split(",")[2]);
//                            for (int j = 0; j < num; j++) {
//                                System.out.println(productlist.get(code).getName());
//                                products.add((Product) productlist.get(code));
//                            }
//                        }
//                    }
//
//
//                    Pay_CashView pay_cashView = new Pay_CashView();
//                    pay_cashView.Pay_CashViewPlot(p_total,products);
//
//
//                }
//            }
//        });
//
//        panel5Button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource()==panel5Button2){
//                    if(!s1.equals("")) {
//                        String[] page1 = s1.split("\n");
//                        for (int i = 0; i < page1.length; i++) {
//                            int code = Integer.parseInt(page1[i].split(",")[0]);
//                            int num = Integer.parseInt(page1[i].split(",")[2]);
//                            for (int j = 0; j < num; j++) {
//                                System.out.println(productlist.get(code).getName());
//                                products.add((Product) productlist.get(code));
//                            }
//                        }
//                    }
//                    if(!s2.equals("")) {
//                        String[] page2 = s2.split("\n");
//                        for (int i = 0; i < page2.length; i++) {
//                            int code = Integer.parseInt(page2[i].split(",")[0]);
//                            int num = Integer.parseInt(page2[i].split(",")[2]);
//                            for (int j = 0; j < num; j++) {
//                                System.out.println(productlist.get(code).getName());
//                                products.add((Product) productlist.get(code));
//                            }
//                        }
//                    }
//                    if(!s3.equals("")) {
//                        String[] page3 = s3.split("\n");
//                        for (int i = 0; i < page3.length; i++) {
//                            int code = Integer.parseInt(page3[i].split(",")[0]);
//                            int num = Integer.parseInt(page3[i].split(",")[2]);
//                            for (int j = 0; j < num; j++) {
//                                System.out.println(productlist.get(code).getName());
//                                products.add((Product) productlist.get(code));
//                            }
//                        }
//                    }
//                    if(!s4.equals("")) {
//                        String[] page4 = s4.split("\n");
//                        for (int i = 0; i < page4.length; i++) {
//                            int code = Integer.parseInt(page4[i].split(",")[0]);
//                            int num = Integer.parseInt(page4[i].split(",")[2]);
//                            for (int j = 0; j < num; j++) {
//                                System.out.println(productlist.get(code).getName());
//                                products.add((Product) productlist.get(code));
//                            }
//                        }
//                    }
//
//                    Pay_CardView pay_cardView = new Pay_CardView();
//                    pay_cardView.Pay_CardViewPlot(p_total,products);
//
//
//                }
//            }
//        });
//
//
//
//        container.add(jTabbedpane);
//        setVisible(true);
//    }
//
////    public static void main(String[] args) {
////        MainView mainView = new MainView();
////        mainView.MainViewPlot();
////    }
//}
