package RE08_Group3_A2;

import RE08_Group3_A2.Product.Product;
import RE08_Group3_A2.ReadAndWriteTXT.ReadTXT;
import RE08_Group3_A2.User.Owner;
import RE08_Group3_A2.User.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

public class OwnerReportTest {

    @Test
    void reportTest() {

        ReadTXT rd = new ReadTXT();
        Owner owner = new Owner("Jack", 123, "111");
        HashMap<Integer, User> users = rd.readUserTXT();
        HashMap<Integer, Product> products = rd.readProductTXT();
        HashMap<BigDecimal, Money> moneys = rd.readMoneyTXT();
        VendingMachine vm = new VendingMachine(products, users, moneys);
        vm.initializeNumberOfCategory();

        vm.getCancelTransactions().add(new CancelTransaction("User cancel",owner));

        Assertions.assertTrue(owner.getUsersReport(vm));
        Assertions.assertTrue(owner.getCancelTransactionReport(vm));
        Assertions.assertFalse(owner.getUsersReport(new VendingMachine(null,null,null)));
        Assertions.assertFalse(owner.generateTransactionReports("dsadasd", vm.getCancelTransactions()));
        Assertions.assertFalse(owner.generateUsersReports("dsadasd", vm.getUsers()));
        Assertions.assertFalse(owner.getUsersReport(null));
        Assertions.assertFalse(owner.getCancelTransactionReport(null));
    }
}
