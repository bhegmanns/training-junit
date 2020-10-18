package de.hegmanns.training.junit5.managing.parallel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TooSimpleAccountTest {

    @Test
    @Disabled("the test don't wait of ending thread ...")
    public void makeOneWithdraw() {
        Account anyAccount = new Account("007", 10000);

        CustomerAccountService customerAccountService = new CustomerAccountService();
        customerAccountService.addAccount(anyAccount);

        customerAccountService.doWithdraw(anyAccount.getAccountNumber(), 1);

        Assertions.assertEquals(9999, anyAccount.getBalance());
    }

    @Test
    @DisplayName("hope you have a second ...")
    public void makeOneWithdrawWithWaiting() {
        Account anyAccount = new Account("007", 10000);

        CustomerAccountService customerAccountService = new CustomerAccountService();
        customerAccountService.addAccount(anyAccount);

        customerAccountService.doWithdraw(anyAccount.getAccountNumber(), 1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(9999, anyAccount.getBalance());
    }
}
