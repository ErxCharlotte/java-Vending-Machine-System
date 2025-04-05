package RE08_Group3_A2.User;

import RE08_Group3_A2.CancelTransaction;
import RE08_Group3_A2.VendingMachine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

public class Owner extends User{
    public Owner(String name, int account, String password) {
        super(name, account, 3, password);
    }

    //String format: account,type,name,password
    public boolean addUser(String info, VendingMachine vendingMachine){
        String[] strings = info.split(",");
        int account = Integer.parseInt(strings[0]);
        if (vendingMachine.getUsers().get(account) != null){
            return false;
        }
        int type = Integer.parseInt(strings[1]);
        String name = strings[2];
        String password = strings[3];
        User user = null;
        if(type == 1){
            user = new Seller(name, account, password);
        } else if (type == 2) {
            user = new Cashier(name, account, password);
        } else if (type == 3) {
            user = new Owner(name, account, password);
        }
        vendingMachine.getUsers().put(account, user);
        return true;

    }
    public boolean removeUser(int account, VendingMachine vendingMachine){
        return vendingMachine.getUsers().remove(account) != null;
    }

    public boolean getUsersReport(VendingMachine vendingMachine){
        if(vendingMachine == null){
            return false;
        }
        //String path = "src\\main\\resources\\ownerUsersReport.txt";
        String path = "src/main/resources/ownerUsersReport.txt";
        return generateUsersReports(path, vendingMachine.getUsers());
    }

    public boolean getCancelTransactionReport(VendingMachine vendingMachine){
        if(vendingMachine == null){
            return false;
        }
        //String path = "src\\main\\resources\\ownerCancelTransactionReport.txt";
        String path = "src/main/resources/ownerCancelTransactionReport.txt";
        return generateTransactionReports(path,vendingMachine.getCancelTransactions());
    }



    public boolean generateTransactionReports(String path, List<CancelTransaction> cancelTransactions){
        File log = new File(path);
        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                return false;
            }
            if (cancelTransactions == null){
                return false;
            }
            PrintWriter pw = new PrintWriter(log);
            pw.print("Date;Type;User" + "\n");
            for (CancelTransaction cancelTransaction : cancelTransactions){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cancelTransaction.getDtf()).append(";");
                stringBuilder.append(cancelTransaction.getType()).append(";");
                stringBuilder.append(cancelTransaction.getUser().getAccount()).append("\n");
                pw.append(stringBuilder);
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            pw.append("\n");
            pw.append("This report updated at: ").append(dtf.format(now));
            pw.close();
            return true;
        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
            return false;
        }
    }

    public boolean generateUsersReports(String path, HashMap<Integer, User> users){
        File log = new File(path);
        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                return false;
            }
            if (users == null){
                return false;
            }
            PrintWriter pw = new PrintWriter(log);
            pw.print("Name;Type" + "\n");
            for (User user : users.values()){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(user.getName()).append(";");
                //0 for Customer, 1 for Seller, 2 for Cashier, 3 for Owner.
                if(user.getType() == 0){
                    stringBuilder.append("Customer").append("\n");
                } else if (user.getType() == 1) {
                    stringBuilder.append("Seller").append("\n");
                } else if (user.getType() == 2) {
                    stringBuilder.append("Cashier").append("\n");
                } else if (user.getType() == 3) {
                    stringBuilder.append("Owner").append("\n");
                }
                pw.append(stringBuilder);
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            pw.append("\n");
            pw.append("This report updated at: ").append(dtf.format(now));
            pw.close();
            return true;
        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
            return false;
        }
    }
}

