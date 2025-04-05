package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.User.Owner;
import RE08_Group3_A2.User.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import java.util.HashMap;


public class OwnerTest {
    @Test
    void ownerAdd(){
        ReadTXT rd = new ReadTXT();
        Owner owner = new Owner("Jack",123,"111");
        HashMap<Integer, User> users = rd.readUserTXT();
        HashMap<Integer, Product> products = rd.readProductTXT();
        HashMap<BigDecimal, Money> moneys = rd.readMoneyTXT();
        VendingMachine vm = new VendingMachine(products, users, moneys);
        vm.initializeNumberOfCategory();
        //String format: account,type,name,password
        Assertions.assertEquals(9, vm.getUsers().size());
        owner.addUser("123321123,1,Dark,qwe123", vm);
        Assertions.assertEquals(10, vm.getUsers().size());
        owner.addUser("19,2,DDD,123321",vm);
        Assertions.assertEquals(11, vm.getUsers().size());
        owner.addUser("27,3,DDD,123321",vm);
        Assertions.assertEquals(12, vm.getUsers().size());
        owner.addUser("0,3,DDD,123321",vm);
        Assertions.assertEquals(12, vm.getUsers().size());
    }
    @Test
    void ownerRemove(){
        ReadTXT rd = new ReadTXT();
        Owner owner = new Owner("Jack",123,"111");
        HashMap<Integer, User> users = rd.readUserTXT();
        HashMap<Integer, Product> products = rd.readProductTXT();
        HashMap<BigDecimal, Money> moneys = rd.readMoneyTXT();
        VendingMachine vm = new VendingMachine(products, users, moneys);
        vm.initializeNumberOfCategory();
        //String format: account,type,name,password
        Assertions.assertEquals(9, vm.getUsers().size());
        owner.removeUser(0, vm);
        Assertions.assertEquals(8, vm.getUsers().size());
        owner.removeUser(1, vm);
        Assertions.assertEquals(7, vm.getUsers().size());
        owner.removeUser(0, vm);
        Assertions.assertEquals(7, vm.getUsers().size());
    }
}