package RE08_Group3_A2.User;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.WriteTXT;
import RE08_Group3_A2.VendingMachine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Seller extends User{

    //WriteTXT wt = new WriteTXT();

    public Seller(String name, int account, String password) {
        super(name, account, 1, password);
    }

    public void modifyProductName(Product product, String name){
        HashMap<Integer, Product> productMap = this.getProductMap();
        /***edge case: product does not exist, code is negative or already exists*/
        int code = product.getCode();
        productMap.get(code).setName(name);
        //wt.writeProductTXT(productMap);
    }

    public void modifyProductCode(Product product, int changeCode){
        HashMap<Integer, Product> productMap = this.getProductMap();

        /***edge case: product does not exist, code is negative or already exists*/
        int initCode = product.getCode();
        productMap.remove(initCode);
        product.setCode(changeCode);
        productMap.put(changeCode, product);
        //wt.writeProductTXT(productMap);

    }

    public void modifyProductType(Product product, String type){
        HashMap<Integer, Product> productMap = this.getProductMap();

        /***edge case: product does not exist, type is illegal*/
        int code = product.getCode();
        productMap.get(code).setType(type);
        //wt.writeProductTXT(productMap);

    }

    public void modifyProductCount(Product product, int count){
        HashMap<Integer, Product> productMap = this.getProductMap();


        /***edge case: product does not exist, count is negative*/
        int code = product.getCode();
        productMap.get(code).setCount(count);
        //wt.writeProductTXT(productMap);

    }

    public void modifyProductPrice(Product product, BigDecimal price){
        HashMap<Integer, Product> productMap = this.getProductMap();

        /***edge case: product does not exist, price is negative*/
        int code = product.getCode();
        productMap.get(code).setPrice(price);
        //wt.writeProductTXT(productMap);

    }

    /*** Error message:
     *  1 :  successfully added products.
     *  -1:  no such product.
     * -2 :  invalid quantity.
     * -3 :  Drinks will be > 15 after adding.
     */

    public int addProduct(String message, VendingMachine vm){
        String[] str = message.split(",");
        Product product = vm.getProducts().get(Integer.parseInt(str[0]));
        int quantity = Integer.parseInt(str[1]);
        if (product == null){
            System.out.println("This product is not acceptable!");
            return -1;
        }

        if (quantity <= 0){
            System.out.println("Cannot add 0 or negative number of product!");
            return -1;
        }
        if(product.getCount() + quantity > 15){
            System.out.println(product.getName() + " cannot have more than 15 products here!");
            return -2;
        }
        product.setCount(product.getCount() + quantity);
        vm.updateNumberOfCategory(product, quantity);
        return 1;
    }

    /*** Error message:
     * -1 :  product does not exist
     * -2 :  invalid quantity
     * -3 :  There are no that many products exist
     * 1 :   Successfully removed
     */
    public int removeProduct(String message, VendingMachine vm){
        String[] str = message.split(",");
        Product product = vm.getProducts().get(Integer.parseInt(str[0]));
        int quantity = Integer.parseInt(str[1]);
        if (product == null){
            System.out.println("This product is not acceptable!");
            return -1;
        }

        if (quantity <= 0){
            System.out.println("Cannot remove 0 or negative number of product!");
            return -2;
        }
        if(product.getCount() - quantity < 0){
            System.out.println("No sufficient products here.");
            return -3;
        }
        product.setCount(product.getCount() - quantity);
        if (product.getCount() == 0){
            vm.getProducts().remove(product.getCode());
        }
        vm.updateNumberOfCategory(product, -quantity);
        return 1;
    }


    public boolean getReportAListOfTheCurrentAvailableItems(VendingMachine vendingMachine){
       //return generateCurrentItemReport("src\\main\\resources\\sellerCurrentItemsReport.txt", vendingMachine.getProducts());
        return generateCurrentItemReport("src/main/resources/sellerCurrentItemsReport.txt", vendingMachine.getProducts());
    }
    public boolean getReportASummary(VendingMachine vendingMachine){
       //return generateSoldReport("src\\main\\resources\\sellerSoldReport.txt", vendingMachine.getSoldProducts());
        return generateSoldReport("src/main/resources/sellerSoldReport.txt", vendingMachine.getSoldProducts());
    }

    public boolean generateCurrentItemReport(String path, HashMap<Integer,Product> products){
        File log = new File(path);
        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                return false;
            }
            if (products == null){
                return false;
            }
            PrintWriter pw = new PrintWriter(log);
            pw.print("Code;Type;Name;Quantity;Price" + "\n");
            for (Product product : products.values()){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(product.getCode()).append(";");
                stringBuilder.append(product.getType()).append(";");
                stringBuilder.append(product.getName()).append(";");
                stringBuilder.append(product.getCount()).append(";");
                stringBuilder.append(product.getPrice()).append("\n");
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
    public boolean generateSoldReport(String path, HashMap<Integer,Product> products){
        File log = new File(path);
        try{
            if(!log.exists()){
                System.out.println("We had to make a new file.");
                return false;
            }
            if (products == null){
                return false;
            }
            PrintWriter pw = new PrintWriter(log);
            pw.print("Code;Name;Quantity" + "\n");
            for (Product product : products.values()){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(product.getCode()).append(";");
                stringBuilder.append(product.getName()).append(";");
                stringBuilder.append(product.getCount()).append("\n");
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