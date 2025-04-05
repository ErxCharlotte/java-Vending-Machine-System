package RE08_Group3_A2.User;

import RE08_Group3_A2.Product.*;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name;
    private int account;
    private String password;

    //0 for Customer, 1 for Seller, 2 for Cashier, 3 for Owner.
    private int type;
    private ArrayList<Product> purchasedList = new ArrayList<>();

    //get product hashmap
    public ReadTXT rd = new ReadTXT();

    public User(){
    }

    public User(String name, int account, int type, String password){
        this.name = name;
        this.account = account;
        this.type = type;
        this.password = password;
    }

    public void addPurchasedProduct(Product product) {
        this.purchasedList.add(product);
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPurchasedList(ArrayList<Product> purchasedList) {
        this.purchasedList = purchasedList;
    }

    public String getName() {
        return name;
    }

    public int getAccount() {
        return account;
    }

    public int getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Product> getPurchasedList() {
        return purchasedList;
    }

    public HashMap<Integer, Product> getProductMap() {
        HashMap<Integer, Product> productMap = rd.readProductTXT();
        return productMap;
    }
}
