package RE08_Group3_A2.View;

import RE08_Group3_A2.CancelTransaction;
import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.WriteTXT;
import RE08_Group3_A2.Read_Json_file;
import RE08_Group3_A2.User.Cashier;
import RE08_Group3_A2.User.Owner;
import RE08_Group3_A2.User.Seller;
import RE08_Group3_A2.VendingMachine;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pay_CardView extends JFrame {
    VendingMachine vendingMachine;
    //panel
    SpringLayout springLayout = new SpringLayout();
    JPanel panel = new JPanel(springLayout);
    //BorderLayout borderLayout = new BorderLayout(50,50);
    //JPanel panel = new JPanel();

    //component

    JLabel userLable = new JLabel("cardholder name:");
    JLabel passwordLable = new JLabel("credit card number:");

    JTextField userText = new JTextField();
    JPasswordField passwordText = new JPasswordField();


    JButton payButton = new JButton("Pay now!");
    JButton exitButton = new JButton("Exit!");
    String username;

    int tt = 0;

    public Pay_CardView(VendingMachine vendingMachine,String username) {
        this.vendingMachine = vendingMachine;
        this.username = username;
    }

    public void Pay_CardViewPlot(BigDecimal totalPrice, List<Product> boughtProduct,String s,String account,int time){



        JLabel nameLable = new JLabel("You need to pay "+ totalPrice.toString(),JLabel.CENTER);
        Container container = getContentPane();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(800,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

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
                    dispose();
                    LoginView loginView = new LoginView(vendingMachine);
                    loginView.LoginViewPlot();
                }
            }
        });


        String[] ss = s.split("\n");
        String sss = "<html><body><p>product name, count, price</p><br><p>";
        String ssss = "</p><body></html>";
        for (int i = 0; i < ss.length; i++) {
            sss+=ss[i] + "<br>";
        }
        sss+=ssss;
        //System.out.println(sss);

        //JLabel list = new JLabel("<html><body><p>product name, count, price</p><br><p>"+s+"</p><body></html>");




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
        panel.add(payButton);
        panel.add(exitButton);

        springLayout.putConstraint(SpringLayout.WEST,userLable,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,userLable,100,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,userText,10,SpringLayout.EAST,userLable);
        springLayout.putConstraint(SpringLayout.NORTH,userText,95,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.NORTH,passwordLable,150,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,passwordLable,150,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.WEST,passwordText,10,SpringLayout.EAST,passwordLable);
        springLayout.putConstraint(SpringLayout.NORTH,passwordText,145,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,payButton,350,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,payButton,200,SpringLayout.NORTH,panel);
        springLayout.putConstraint(SpringLayout.WEST,exitButton,200,SpringLayout.WEST,panel);
        springLayout.putConstraint(SpringLayout.NORTH,exitButton,200,SpringLayout.NORTH,panel);

        JLabel list = new JLabel(sss);

        panel.add(list);
        springLayout.putConstraint(SpringLayout.NORTH,list,25,SpringLayout.SOUTH,nameLable);
        springLayout.putConstraint(SpringLayout.WEST,list,25,SpringLayout.EAST,passwordText);

        if(vendingMachine.getSavedCard().get(account)!=null){
            userText.setText(vendingMachine.getSavedCard().get(account).getName());
            passwordText.setText(vendingMachine.getSavedCard().get(account).getNumber());
        }

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==payButton){
                    //TODO:Check whether the user has saved the information

                    String name = userText.getText();
                    String psw = String.valueOf(passwordText.getPassword());
                    Read_Json_file read_json_file = new Read_Json_file("src/main/resources/credit_cards.json");
                    try {
                        read_json_file.ReadCCfile();
                    } catch (IOException | ParseException ioException) {
                        ioException.printStackTrace();
                    }
                    ArrayList<JSONObject> usercard = read_json_file.getUser_cards();
                    boolean pass = false;
                    for (int i = 0; i < usercard.size(); i++) {
                        if (name.equals( usercard.get(i).get("name")) && psw.equals(usercard.get(i).get("number")) ){
                            //no 1
                            //yes 0

                            if(vendingMachine.getSavedCard().get(account)==null){
                                int sl = JOptionPane.showOptionDialog(null, "Do you want to save your credit card information?", "Message!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,   null, new String[]{"Yes","no"}, "苹果");

                                if (sl==0){
                                    if(account.equals("-1")){
                                        JOptionPane.showMessageDialog(panel, "Temporary users cannot save this information", "Save failed",JOptionPane.WARNING_MESSAGE);
                                    }
                                    else {
                                        vendingMachine.saveCardInfo((String) usercard.get(i).get("name"), usercard.get(i).get("number").toString(),account);
                                    }
                                }
                            }


                            vendingMachine.subtractProductsAfterPayment(boughtProduct);
                            pass = true;
                            JOptionPane.showMessageDialog(panel, "Successful payment", "Successful payment",JOptionPane.WARNING_MESSAGE);
                            for (Product p : boughtProduct) {
                                vendingMachine.sellProducts(p);
                            }
                            vendingMachine.saveTransaction(account,boughtProduct,totalPrice,new BigDecimal(0),"Card");
                            new Cashier("",1,"").getReportOfTheTransaction(vendingMachine);
                            Seller seller = new Seller("",0,"");
                            seller.getReportASummary(vendingMachine);
                            seller.getReportAListOfTheCurrentAvailableItems(vendingMachine);
                            for (Product p :
                                    boughtProduct) {
                                vendingMachine.sellProducts(p);
                            }
                            WriteTXT writeTXT = new WriteTXT();
                            writeTXT.writeProductTXT(vendingMachine.getProducts());


                            timer.stop();
                            dispose();
                            LoginView loginView = new LoginView(vendingMachine);
                            loginView.LoginViewPlot();
                            break;
                        }
                    }
                    if (!pass){
                        JOptionPane.showMessageDialog(panel, "Payment Failed", "Payment Failed",JOptionPane.WARNING_MESSAGE);
                        Seller seller = new Seller("",0,"");
                        seller.getReportASummary(vendingMachine);
                        seller.getReportAListOfTheCurrentAvailableItems(vendingMachine);
                        Cashier cashier = new Cashier("",2,"");
                        cashier.getReportOfTheTransaction(vendingMachine);


                    }
                    else {
                        ;
                    }

                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource() == exitButton){
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

        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                tt = 0;
            }
        });

        container.add(nameLable,BorderLayout.NORTH);
        container.add(panel);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        Pay_CardView pay_cardView = new Pay_CardView(vendingMachine);
//        pay_cardView.Pay_CardViewPlot(3.6,null);
//    }
}
