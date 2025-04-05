package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.User.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class VendingMachine {
    private HashMap<Integer,Product> products;

    private HashMap<Integer, User> users;

    private HashMap<Integer, Product> soldProducts;

    private HashMap<BigDecimal, Money> moneyMap;

    private HashMap<String, Card> savedCard = new HashMap<>();

    private HashMap<String, List<Product>> paidProduct = new HashMap<>();

    private List<Transaction> transactions = new ArrayList<>();

    private List<CancelTransaction> cancelTransactions = new CopyOnWriteArrayList<>();

    public List<CancelTransaction> getCancelTransactions() {
        return cancelTransactions;
    }

    public void setCancelTransactions(List<CancelTransaction> cancelTransactions) {
        this.cancelTransactions = cancelTransactions;
    }

    private int NumberOfDrinks;
    private int NumberOfChoc;
    private int NumberOfChips;
    private int NumberOfCandies;
    private HashMap<BigDecimal, Money> tempMoneyMap;



    public VendingMachine(HashMap<Integer, Product> products, HashMap<Integer, User> users, HashMap<BigDecimal, Money> moneyMap) {
        this.products = products;
        this.users = users;
        this.soldProducts = new HashMap<>();
        this.moneyMap = moneyMap;
        this.NumberOfChips = 0;
        this.NumberOfChoc = 0;
        this.NumberOfDrinks = 0;
        this.NumberOfCandies = 0;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public HashMap<String, List<Product>> getPaidProduct() {
        return paidProduct;
    }

    public void setPaidProduct(HashMap<String, List<Product>> paidProduct) {
        this.paidProduct = paidProduct;
    }

    public HashMap<String, Card> getSavedCard() {
        return savedCard;
    }

    public void setSavedCard(HashMap<String, Card> savedCard) {
        this.savedCard = savedCard;
    }

    public HashMap<BigDecimal, Money> getMoneyMap() {
        return moneyMap;
    }

    public void setMoneyMap(HashMap<BigDecimal, Money> moneyMap) {
        this.moneyMap = moneyMap;
    }

    public HashMap<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Product> products) {
        this.products = products;
    }

    public HashMap<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<Integer, User> users) {
        this.users = users;
    }

    public HashMap<Integer, Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(HashMap<Integer, Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public List<Product> recentlyProduct(String account){
        List<Product> products1 = paidProduct.get(account);
        List<Product> sortedProducts = new ArrayList<>();
        if (products1 == null){
            return null;
        }
        if (products1.size() < 5){
            for (int i = products1.size() - 1; i >= 0; i--){
                sortedProducts.add(products1.get(i));
            }
            return sortedProducts;
        }
        for (int j = products1.size() - 1; j >= products1.size() - 5; j--){
            sortedProducts.add(products1.get(j));
        }
        return sortedProducts;
    }


    public void modifyMoneyCount(BigDecimal amount, int count, String type){
        Money money = moneyMap.get(amount);
        if (money == null){
            moneyMap.put(amount, new Money(type,amount,count));
        }else {
            money.setCount(money.getCount() + count);
        }
    }


    public BigDecimal productAmount(List<Product> boughtProduct){
        BigDecimal sumAmount = new BigDecimal(0);
        for (int i = 0; i < boughtProduct.size(); i++){
            Product product = boughtProduct.get(i);
            BigDecimal count = new BigDecimal(product.getCount());
            sumAmount = sumAmount.add((product.getPrice().multiply(count)));
            //sumAmount = sumAmount.add((product.getPrice()));
        }
        return sumAmount;
    }

    public BigDecimal cashAmount(List<Money> cashPaid){
        BigDecimal sumCash = new BigDecimal(0);
        for (int i = 0; i < cashPaid.size(); i++){
            Money money = cashPaid.get(i);
            BigDecimal count = new BigDecimal(money.getCount());
            sumCash = sumCash.add(money.getAmount().multiply(count));
        }
        return sumCash;
    }


    public void subtractProductsAfterPayment(List<Product> boughtProduct){
        for (int i = 0; i < boughtProduct.size(); i++){
            Product product = boughtProduct.get(i);
            for (Integer key : products.keySet()) {
                if (product.getCode() == products.get(key).getCode()){
                    products.get(key).setCount(products.get(key).getCount() - product.getCount());
//                    if (products.get(key).getCount() == 0){
//                        products.remove(key);
//                    }
                    break;
                }
            }
        }

    }

    public void saveCardInfo(String name, String number, String account){
        if (savedCard.containsKey(account)){
            return;
        }
        savedCard.put(account, new Card(name, number, account));
    }

    public void saveTransaction(String account, List<Product> boughtProduct, BigDecimal amount, BigDecimal change, String paymentWay){
        if (paidProduct.containsKey(account)){
            paidProduct.get(account).addAll(boughtProduct);
        }else {
            paidProduct.put(account, new ArrayList<>(boughtProduct));
        }
        transactions.add(new Transaction(LocalDateTime.now(), boughtProduct, amount, change, paymentWay));
    }



    public String cashPayment(List<Product> boughtProduct, List<Money> cashPaid, String account) {
        if (productAmount(boughtProduct).compareTo(cashAmount(cashPaid)) <= 0) {
            BigDecimal change = cashAmount(cashPaid).subtract(productAmount(boughtProduct));
            if (change.compareTo(new BigDecimal(0)) == 0) {
                subtractProductsAfterPayment(boughtProduct);
                saveTransaction(account, boughtProduct, cashAmount(cashPaid), change, "Cash");
                return "Successful Paid. Please get your product!";
            } else {
                tempMoneyMap = returnedChange(change);
                if (tempMoneyMap == null) {
                    return "There are no available changes, enter the different notes or coins, or you can cancel this order.";
                } else {
                    for (int j = 0; j < cashPaid.size(); j++) {
                        Money money = cashPaid.get(j);
                        if (moneyMap.get(money.getAmount()).getAmount().compareTo(money.getAmount()) == 0) {
                            moneyMap.get(money.getAmount()).setCount(moneyMap.get(money.getAmount()).getCount() + money.getCount());
                        }
                    }
                    subtractProductsAfterPayment(boughtProduct);
                    saveTransaction(account, boughtProduct, cashAmount(cashPaid), change, "Cash");
                    return "Successful Paid. Please get your product and changes!" + "," + change;
                }
            }
        } else {
            return "The cash you paid is not enough, you need to input more cash, or you can cancel this order.";
        }
    }


    public HashMap<BigDecimal, Money> returnedChange(BigDecimal change){
        HashMap<BigDecimal, Money> map = new HashMap<>();
        if (change.compareTo(BigDecimal.valueOf(0)) < 0 || change.compareTo(BigDecimal.valueOf(0)) == 0){
            return null;
        }
        List<Money> sortedMoney = moneyMap.values().stream().sorted(Comparator.comparing(Money::getAmount).reversed()).toList();
        int i = 0;
        while (i < sortedMoney.size() && change.compareTo(BigDecimal.valueOf(0)) > 0){
            Money money = sortedMoney.get(i);
            if ((this.getMoneyMap().get(money.getAmount()).getCount() < 0) || (money.getAmount().compareTo(change) > 0) || ((map.get(money.getAmount()) != null) && (map.get(money.getAmount()).getCount() >= money.getCount()))){
                //***
                i++;
                continue;
            }
            change = change.subtract(money.getAmount());
            if (map.containsKey(money.getAmount())){
                Money money1 = map.get(money.getAmount());
                money1.setCount(money1.getCount() + 1);
            }else {
                map.put(money.getAmount(), new Money(money.getType(), money.getAmount(), 1));
            }
//            if (change.compareTo(money.getAmount()) < 0){
//                i = i + 1;
//            }
        }

        if (change.compareTo(BigDecimal.valueOf(0)) > 0){
            return null;
        }

        for (BigDecimal key : map.keySet()) {
            Money money = moneyMap.get(key);
            money.setCount(money.getCount() - map.get(key).getCount());
        }

        return map;
    }
    

    public HashMap<BigDecimal, Money> gettempMoneyMap(){
        return this.tempMoneyMap;
    }

    // initialize the number of products in each category.
    public void initializeNumberOfCategory(){
        for(Product product : this.products.values()){
            switch (product.getType()) {
                case "Drinks":
                    this.NumberOfDrinks = this.NumberOfDrinks + product.getCount();
                    break;
                case "Chocolates":
                    this.NumberOfChoc = this.NumberOfChoc + product.getCount();
                    break;
                case "Chips":
                    this.NumberOfChips = this.NumberOfChips + product.getCount();
                    break;
                case "Candies":
                    this.NumberOfCandies = this.NumberOfCandies + product.getCount();
                    break;
            }
        }
    }

    public void updateNumberOfCategory(Product product, int quantity){
        switch (product.getType()) {
            case "Drinks" :
                this.NumberOfDrinks = this.NumberOfDrinks + quantity;
                break;
            case "Chocolates" :
                this.NumberOfChoc = this.NumberOfChoc + quantity;
                break;
            case "Chips" :
                this.NumberOfChips = this.NumberOfChips + quantity;
                break;
            case "Candies" :
                this.NumberOfCandies = this.NumberOfCandies + quantity;
                break;
        }
    }

    public void sellProducts(Product product){
        Product productNew = null;
        int quantity = product.getCount();
        int code = product.getCode();
        if(!this.soldProducts.containsKey(product.getCode())){
            productNew = new Product();
            productNew.setCount(product.getCount());
            productNew.setCode(product.getCode());
            productNew.setType(product.getType());
            productNew.setName(product.getName());
            this.soldProducts.put(productNew.getCode(), productNew);
        }else {
            this.soldProducts.get(code).setCount(this.soldProducts.get(code).getCount() + quantity);
        }
    }

    public int getNumberOfDrinks() {
        return NumberOfDrinks;
    }
    public int getNumberOfChoc() {
        return NumberOfChoc;
    }

    public int getNumberOfChips() {
        return NumberOfChips;
    }


    public int getNumberOfCandies() {
        return NumberOfCandies;
    }
}
