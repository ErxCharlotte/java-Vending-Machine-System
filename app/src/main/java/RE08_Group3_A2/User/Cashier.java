package RE08_Group3_A2.User;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.Transaction;
import RE08_Group3_A2.VendingMachine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Cashier extends User{

    private VendingMachine vm;
    public Cashier(String name, int account, String password) {
        super(name, account, 2, password);
    }

    public void modifyMoney(BigDecimal amount, int count, String type){
        vm.modifyMoneyCount(amount, count, type);
    }

    public void getReportOfTheTransaction(VendingMachine vendingMachine){
        //generateTransactionReport("src\\main\\resources\\transactionReport.txt", vendingMachine);
        generateTransactionReport("src/main/resources/transactionReport.txt", vendingMachine);
    }

    public void generateTransactionReport(String path, VendingMachine vendingMachine){
        File report = new File(path);
        ArrayList<Transaction> transactions = (ArrayList<Transaction>) vendingMachine.getTransactions();
        try{
            if(!report.exists()){
                System.out.println("We had to make a new file for the report of the Transactions.");
                return;
            }
            PrintWriter pw = new PrintWriter(report);
            pw.print("Time;Products;Amount;Changes;PaymentWay" + "\n");
            for (Transaction transaction : transactions){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(transaction.getTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))).append(";");
                for (int i = 0; i < transaction.getProducts().size(); i++){
                    Product pd = transaction.getProducts().get(i);
//                    if (i == 0){
//                        stringBuilder.append(pd.getName()).append("[");
//                    }
                    if (i == transaction.getProducts().size() - 1){
                        stringBuilder.append(pd.getName()).append(";");
                    }else {
                        stringBuilder.append(pd.getName()).append(",");
                    }
                }
                stringBuilder.append(transaction.getAmount()).append(";");
                stringBuilder.append(transaction.getChanges()).append(";");
                stringBuilder.append(transaction.getPaymentWay()).append("\n");
                pw.append(stringBuilder);
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            pw.append("\n");
            pw.append("This report updated at: ").append(dtf.format(now));
            pw.close();
        }catch(IOException e){
            System.out.println("COULD NOT LOG!!");
        }
    }

}

 