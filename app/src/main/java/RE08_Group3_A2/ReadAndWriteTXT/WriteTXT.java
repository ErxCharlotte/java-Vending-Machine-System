package RE08_Group3_A2.ReadAndWriteTXT;

import RE08_Group3_A2.Money;
import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.User.User;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;

public class WriteTXT {
    public void writeUserTXT(HashMap<Integer, User> userMap) {
        String path = "src/main/resources/users.txt";
        //String path = "src\\main\\resources\\users.txt";
        File file = new File(path);
        String firstLine = "account,type,name,password";

        try {
            //for First line
            FileWriter fwFirstLine = new FileWriter(file);
            BufferedWriter bwFirstLine = new BufferedWriter(fwFirstLine);
            bwFirstLine.write(firstLine);
            bwFirstLine.close();

            //for User data
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Integer account : userMap.keySet()){
                String data = "\n" + String.valueOf(account) + "," +
                        userMap.get(account).getType() + "," +
                        userMap.get(account).getName() + "," +
                        userMap.get(account).getPassword();
                bw.write(data);
            }
            bw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeProductTXT(HashMap<Integer, Product> productMap) {
        String path = "src/main/resources/products.txt";
        //String path = "src\\main\\resources\\products.txt";
        File file = new File(path);
        String firstLine = "category,name,quantity,code,price";

        try {
            //for First line
            FileWriter fwFirstLine = new FileWriter(file);
            BufferedWriter bwFirstLine = new BufferedWriter(fwFirstLine);
            bwFirstLine.write(firstLine);
            bwFirstLine.close();

            //for Product data
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Integer code : productMap.keySet()) {
                System.out.println(productMap.get(code).getName());
                String data = "\n" + productMap.get(code).getType() + "," +
                        productMap.get(code).getName() + "," +
                        String.valueOf(productMap.get(code).getCount()) + "," +
                        String.valueOf(productMap.get(code).getCode()) + "," +
                        String.valueOf(productMap.get(code).getPrice());
                bw.write(data);
            }
            bw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeMoneyTXT(HashMap<BigDecimal, Money> moneyMap) {
        String path = "src/main/resources/money_in_VendingMachine.txt";
        //String path = "src\\main\\resources\\money_in_VendingMachine.txt";
        File file = new File(path);
        String firstLine = "type,amount,count";

        try {
            //for First line
            FileWriter fwFirstLine = new FileWriter(file);
            BufferedWriter bwFirstLine = new BufferedWriter(fwFirstLine);
            bwFirstLine.write(firstLine);
            bwFirstLine.close();

            //for Product data
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (BigDecimal amount : moneyMap.keySet()) {
                String data = "\n" + moneyMap.get(amount).getType() + "," +
                        String.valueOf(moneyMap.get(amount).getAmount()) + "," +
                        String.valueOf(moneyMap.get(amount).getCount());
                bw.write(data);
            }
            bw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
