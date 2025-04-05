package RE08_Group3_A2.View;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.ReadAndWriteTXT.WriteTXT;
import RE08_Group3_A2.User.Cashier;
import RE08_Group3_A2.User.Seller;
import RE08_Group3_A2.VendingMachine;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;

public class SellerView extends JFrame {
    Container container = getContentPane();
    SpringLayout springLayout = new SpringLayout();

    Product temp = null;
    ReadTXT txt = new ReadTXT();
    HashMap<Integer, Product> products = txt.readProductTXT();


    public void SellerViewPlot(VendingMachine vendingMachine){


        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Re 08    Group 3    Project 2");

        JPanel panel = new JPanel(springLayout);



        String detail = "";

        JComboBox<Integer> productBox = new JComboBox<>();

        Iterator< Integer > iterator = products.keySet().iterator();
        while (iterator.hasNext()){

            Integer code = iterator.next();
            detail+= code + ",  " + products.get(code).getName() +"<br/>";
            productBox.addItem(code);
        }
        //use html
        JLabel d = new JLabel("<html><body><p>Code,  Product name, Price<br/>" + detail+ "</p></body></html>");
        springLayout.putConstraint(SpringLayout.NORTH,d,50,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,d,0,SpringLayout.WEST,panel);
        panel.add(d);
        springLayout.putConstraint(SpringLayout.NORTH,productBox,50,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,productBox,50,SpringLayout.EAST,d);
        panel.add(productBox);

        JLabel itemCodeLabel = new JLabel("Code:");
        springLayout.putConstraint(SpringLayout.NORTH,itemCodeLabel,100,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemCodeLabel,50,SpringLayout.EAST,d);
        JTextField itemCode = new JTextField(25);
        springLayout.putConstraint(SpringLayout.NORTH,itemCode,100,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemCode,50,SpringLayout.EAST,itemCodeLabel);
        panel.add(itemCodeLabel);
        panel.add(itemCode);


        JLabel itemNameLabel = new JLabel("Name:");
        springLayout.putConstraint(SpringLayout.NORTH,itemNameLabel,150,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemNameLabel,50,SpringLayout.EAST,d);
        JTextField itemName = new JTextField(25);
        springLayout.putConstraint(SpringLayout.NORTH,itemName,150,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemName,50,SpringLayout.EAST,itemNameLabel);
        panel.add(itemNameLabel);
        panel.add(itemName);



        JLabel itemTypeLabel = new JLabel("Type:");
        springLayout.putConstraint(SpringLayout.NORTH,itemTypeLabel,200,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemTypeLabel,50,SpringLayout.EAST,d);
        //JTextField itemType = new JTextField(25);
        JComboBox<String> itemType = new JComboBox<>();
        itemType.addItem("Drinks");
        itemType.addItem("Chocolates");
        itemType.addItem("Chips");
        itemType.addItem("Candies");

        springLayout.putConstraint(SpringLayout.NORTH,itemType,200,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemType,50,SpringLayout.EAST,itemTypeLabel);
        panel.add(itemTypeLabel);
        panel.add(itemType);


        JLabel itemNumberLabel = new JLabel("Number:");
        springLayout.putConstraint(SpringLayout.NORTH,itemNumberLabel,250,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemNumberLabel,50,SpringLayout.EAST,d);
        JTextField itemNumber = new JTextField(25);
        springLayout.putConstraint(SpringLayout.NORTH,itemNumber,250,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemNumber,50,SpringLayout.EAST,itemNumberLabel);
        panel.add(itemNumberLabel);
        panel.add(itemNumber);

        JLabel itemPriceLabel = new JLabel("Price:");
        springLayout.putConstraint(SpringLayout.NORTH,itemPriceLabel,300,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemPriceLabel,50,SpringLayout.EAST,d);


        JFormattedTextField itemPrice = new JFormattedTextField();
        itemPrice.setColumns(5);
        springLayout.putConstraint(SpringLayout.NORTH,itemPrice,300,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,itemPrice,50,SpringLayout.EAST,itemPriceLabel);
        panel.add(itemPriceLabel);
        panel.add(itemPrice);





        JButton search = new JButton("search");
        springLayout.putConstraint(SpringLayout.NORTH,search,50,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,search,50,SpringLayout.EAST,productBox);
        panel.add(search);

        itemCode.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                int keyChar=keyEvent.getKeyChar();
                if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {

                } else {
                    keyEvent.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                //itemCode.setText(itemCode.getText().replaceAll("[^0-9|\\.]", ""));
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                //itemCode.setText(itemCode.getText().replaceAll("[^0-9|\\.]", ""));
            }
        });

        itemNumber.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                int keyChar=keyEvent.getKeyChar();
                if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {

                } else {
                    keyEvent.consume();
                }


            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                //itemCode.setText(itemCode.getText().replaceAll("[^0-9|\\.]", ""));
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                //itemCode.setText(itemCode.getText().replaceAll("[^0-9|\\.]", ""));
            }
        });



        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==search){
                    //TODO:show details
                    int code = (int)productBox.getSelectedItem();
                    temp = products.get(code);
                    itemName.setText(products.get(code).getName());
                    itemCode.setText(Integer.toString(code));
//                    itemType.setText(products.get(code).getType());
                    itemType.setSelectedItem(products.get(code).getType());
                    itemPrice.setText(products.get(code).getPrice().toString());
                    itemNumber.setText(Integer.toString(products.get(code).getCount()));

                }
            }
        });




        JButton update = new JButton("Update!");
        springLayout.putConstraint(SpringLayout.NORTH,update,350,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,update,50,SpringLayout.EAST,d);
        panel.add(update);


        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==update){
                    //TODO: Check whether the update is valid. If yes, update it. Otherwise, an error message is displayed
                    if(temp==null){
                        JOptionPane.showMessageDialog(panel, "Please search before updating!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(itemCode.getText().equals("")){
                        JOptionPane.showMessageDialog(panel, "Please enter the code!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(itemName.getText().equals("")){
                        JOptionPane.showMessageDialog(panel, "Please enter the name!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if (itemNumber.getText().equals("")) {

                        JOptionPane.showMessageDialog(panel, "Please enter the number of products!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(itemPrice.getText().equals("")){
                        JOptionPane.showMessageDialog(panel, "Please enter the price!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(Integer.parseInt(itemNumber.getText())>15){
                        JOptionPane.showMessageDialog(panel, "too much number of product number,number<=15!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(!checkprice(itemPrice.getText())){

                        JOptionPane.showMessageDialog(panel, "Please enter the correct price format e.g.: 1.0, 5.6!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(products.get(Integer.parseInt(itemCode.getText()))!=temp&&products.get(Integer.parseInt(itemCode.getText()))!=null){
                        JOptionPane.showMessageDialog(panel, "code already exists!", "Error!", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        Seller seller = new Seller(null,1,null);


//                        seller.modifyProductType(temp,itemType.getSelectedItem().toString());
//                        seller.modifyProductCount(temp,Integer.parseInt(itemNumber.getText()));
//                        seller.modifyProductPrice(temp,new BigDecimal(itemPrice.getText()));
//                        seller.modifyProductCount(temp,Integer.parseInt(itemNumber.getText()));
//                        seller.modifyProductName(temp,itemName.getText());
//                        seller.modifyProductCode(temp,Integer.parseInt(itemCode.getText()));


                        products.remove(Integer.parseInt(productBox.getSelectedItem().toString()));
                        Product newproduct = new Product();
                        newproduct.setCode(Integer.parseInt(itemCode.getText()));
                        newproduct.setName(itemName.getText());
                        newproduct.setCount(Integer.parseInt(itemNumber.getText()));
                        newproduct.setType(itemType.getSelectedItem().toString());
                        newproduct.setPrice(new BigDecimal(itemPrice.getText()));
                        products.put(newproduct.getCode(), newproduct);
                        WriteTXT writeTXT = new WriteTXT();
                        writeTXT.writeProductTXT(products);
                        Seller sellers = new Seller("",0,"");
                        sellers.getReportASummary(vendingMachine);
                        sellers.getReportAListOfTheCurrentAvailableItems(vendingMachine);
                        JOptionPane.showMessageDialog(panel, "Product has changed!", "OK!", 1);

                        dispose();
                        SellerView sellerView = new SellerView();
                        sellerView.SellerViewPlot(vendingMachine);
                    }
                }
            }
        });


        JButton del = new JButton("Remove!");

        springLayout.putConstraint(SpringLayout.NORTH,del,350,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,del,50,SpringLayout.EAST,update);
        panel.add(del);

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==del){
                    products.get(Integer.parseInt(productBox.getSelectedItem().toString())).setCount(0);
//                    products.remove(Integer.parseInt(productBox.getSelectedItem().toString()));
                    WriteTXT writeTXT = new WriteTXT();
                    writeTXT.writeProductTXT(products);
                    System.out.println("pass!");

                    Seller seller = new Seller("",0,"");
                    seller.getReportASummary(vendingMachine);
                    seller.getReportAListOfTheCurrentAvailableItems(vendingMachine);
                    JOptionPane.showMessageDialog(panel, "Product has removed!", "OK!",1);

                    dispose();
                    SellerView sellerView = new SellerView();
                    sellerView.SellerViewPlot(vendingMachine);
                }
            }
        });

        JButton add = new JButton("Add!");

        springLayout.putConstraint(SpringLayout.NORTH,add,350,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,add,50,SpringLayout.EAST,del);
        panel.add(add);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==add){
                    if(itemCode.getText().equals("")){
                        JOptionPane.showMessageDialog(panel, "Please enter the code!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(itemName.getText().equals("")){
                        JOptionPane.showMessageDialog(panel, "Please enter the name!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if (itemNumber.getText().equals("")) {

                        JOptionPane.showMessageDialog(panel, "Please enter the number of products!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(itemPrice.getText().equals("")){
                        JOptionPane.showMessageDialog(panel, "Please enter the price!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(Integer.parseInt(itemNumber.getText())>15){
                        JOptionPane.showMessageDialog(panel, "too much number of product number,number<=15!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(!checkprice(itemPrice.getText())){

                        JOptionPane.showMessageDialog(panel, "Please enter the correct price format e.g.: 1.0, 5.6!", "Error!", JOptionPane.WARNING_MESSAGE);

                    }
                    else if(products.get(Integer.parseInt(itemCode.getText()))!=null){
                        JOptionPane.showMessageDialog(panel, "code already exists!", "Error!", JOptionPane.WARNING_MESSAGE);
                    }else {
                        Product newproduct = new Product();

                        newproduct.setCode(Integer.parseInt(itemCode.getText()));
                        newproduct.setName(itemName.getText());
                        newproduct.setCount(Integer.parseInt(itemNumber.getText()));
                        newproduct.setType(itemType.getSelectedItem().toString());
                        newproduct.setPrice(new BigDecimal(itemPrice.getText()));
                        products.put(newproduct.getCode(), newproduct);

                        Seller seller = new Seller("",0,"");
                        seller.getReportASummary(vendingMachine);
                        seller.getReportAListOfTheCurrentAvailableItems(vendingMachine);
                        JOptionPane.showMessageDialog(panel, "Product has add!", "OK!", 1);

                        WriteTXT writeTXT = new WriteTXT();
                        writeTXT.writeProductTXT(products);
                        System.out.println("pass!");
                        dispose();
                        SellerView sellerView = new SellerView();
                        sellerView.SellerViewPlot(vendingMachine);
                    }
                }
            }
        });



        JButton Exit = new JButton("Exit!");

        springLayout.putConstraint(SpringLayout.NORTH,Exit,350,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,Exit,50,SpringLayout.EAST,add);
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












        setVisible(true);
        container.add(panel);
    }

    public boolean checkprice(String s){
        String[] priceofinput = s.split("\\.");
        if (priceofinput.length!=2){
            return false;
        }

        if(priceofinput[1].length()>2){
            return false;
        }
        if(!isNumeric(priceofinput[0])){
            return false;
        }
        if (!isNumeric(priceofinput[1])){
            return false;
        }

        return true;
    }

    public static boolean isNumeric(String str) {

        for (int i = 0; i < str.length(); i++) {

            if (!Character.isDigit(str.charAt(i))) {

                return false;

            }
        }

        return true;
    }

//    public static void main(String[] args) {
//        SellerView sellerView = new SellerView();
//        sellerView.SellerViewPlot();
//    }
}
