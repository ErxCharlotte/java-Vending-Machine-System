package RE08_Group3_A2.ReadAndWriteTXT;

import RE08_Group3_A2.Money;
import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.User.User;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;


public class ReadTXT {
    //Make sure there are no empty lines in the txt.

    public HashMap<Integer, User> readUserTXT(){
        HashMap<Integer, User> userMap = new HashMap<Integer, User>();
        String path = "src/main/resources/users.txt";
        //String path = "src\\main\\resources\\users.txt";
        File file = new File(path);
        String lineOfTXT = "";
        boolean isFirstLine = true;

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((lineOfTXT = br.readLine()) != null) {
                String[] data = lineOfTXT.split(",");
                //First line
                if (isFirstLine == true) {
                    isFirstLine = false;
                    continue;
                }else {
                    User user = new User(data[2], Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[3]);
                    userMap.put(Integer.parseInt(data[0]), user);
                }
            }
            br.close();
            return userMap;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<Integer, Product> readProductTXT(){
        HashMap<Integer, Product> productMap = new HashMap<Integer, Product>();
        String path = "src/main/resources/products.txt";
        //String path = "src\\main\\resources\\products.txt";
        //String path = "C:\\Users\\ASUS\\Desktop\\SOFT2412\\Homework\\ASM2\\test3\\RE08_Group3_A2\\app\\src\\main\\resources\\products.txt";
        File file = new File(path);
        String lineOfTXT = "";
        boolean isFirstLine = true;

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((lineOfTXT = br.readLine()) != null) {
                String[] data = lineOfTXT.split(",");
                //First line
                if (isFirstLine == true) {
                    isFirstLine = false;
                }else {
                    Product product = new Product(data[1], data[0], new BigDecimal(data[4]), Integer.parseInt(data[3]), Integer.parseInt(data[2]));
                    productMap.put(Integer.parseInt(data[3]), product);
                }
            }
            br.close();
            return productMap;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public HashMap<BigDecimal, Money> readMoneyTXT(){
        HashMap<BigDecimal, Money> moneyMap = new HashMap<BigDecimal, Money>();
        String path = "src/main/resources/money_in_VendingMachine.txt";
        //String path = "src\\main\\resources\\money_in_VendingMachine.txt";
        //String path = "C:\\Users\\HP\\Desktop\\SOFT2412-A2\\RE08_Group3_A2\\app\\src\\main\\resources\\money_in_VendingMachine.txt";

        File file = new File(path);
        String lineOfTXT = "";
        boolean isFirstLine = true;

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((lineOfTXT = br.readLine()) != null) {
                String[] data = lineOfTXT.split(",");
                //First line
                if (isFirstLine == true) {
                    isFirstLine = false;
                }else {
                    Money money = new Money(data[0], new BigDecimal(data[1]), Integer.parseInt(data[2]));
                    moneyMap.put(new BigDecimal(data[1]), money);
                }
            }
            br.close();
            return moneyMap;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
