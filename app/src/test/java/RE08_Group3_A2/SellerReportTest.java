package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.User.Seller;
import RE08_Group3_A2.User.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;


public class SellerReportTest {

    @Test
    void reportTest(){
        ReadTXT rd = new ReadTXT();
        Seller seller = new Seller("Jack",123,"111");
        HashMap<Integer, User> users = rd.readUserTXT();
        HashMap<Integer, Product> products = rd.readProductTXT();
        HashMap<BigDecimal, Money> moneys = rd.readMoneyTXT();
        VendingMachine vm = new VendingMachine(products, users, moneys);
        vm.initializeNumberOfCategory();

        Assertions.assertTrue(seller.getReportAListOfTheCurrentAvailableItems(vm));

        seller.removeProduct("1000,2",vm);

        Assertions.assertTrue(seller.getReportASummary(vm));
        Assertions.assertFalse(seller.generateCurrentItemReport("fasdjkl", products));
        Assertions.assertFalse(seller.generateSoldReport("12ye", products));
        Assertions.assertFalse(seller.generateCurrentItemReport("src\\main\\resources\\sellerCurrentItemsReport.txt",null));
        Assertions.assertFalse(seller.generateSoldReport("src\\main\\resources\\sellerSoldIReport.txt", null));

        //Assertions.assertTrue(seller.generateSoldReport("src\\main\\resources\\sellerSoldReport.txt", vm.getSoldProducts()));
    }

}
