package RE08_Group3_A2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaveCardInfoTest {

    @Test
    void addInfo(){
        VendingMachine vm = new VendingMachine(null, null, null);
        vm.saveCardInfo("James", "123456", "aaa");
        assertEquals(vm.getSavedCard().get("aaa").getName(), "James");
        assertEquals(vm.getSavedCard().get("aaa").getNumber(), "123456");
        assertEquals(vm.getSavedCard().get("aaa").getAccount(), "aaa");

        //add exist card Info
        vm.saveCardInfo("Jim", "654321", "aaa");
        assertEquals(vm.getSavedCard().get("aaa").getName(), "James");
        assertEquals(vm.getSavedCard().get("aaa").getNumber(), "123456");
        assertEquals(vm.getSavedCard().get("aaa").getAccount(), "aaa");
    }
}
