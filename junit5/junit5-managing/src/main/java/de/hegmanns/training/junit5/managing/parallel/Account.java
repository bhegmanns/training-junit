package de.hegmanns.training.junit5.managing.parallel;

public class Account {
    private String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(int money) {
        if (balance > money) {
            /*
            this code seems to be very complex.
            And: indeed, this code is very complex due to show some problems ;)
             */
            System.out.println("start setting");
            int savedBalance = balance;
            makeSomeImportantChecksAndCalculation(250);
            savedBalance -= money;
            makeSomeImportantChecksAndCalculation(50);
            balance = savedBalance;
            System.out.println("balance is set");
        }else{
            throw new RuntimeException("not enough money");
        }
    }

    /**
     * Here should be realized some background-operations, like
     * <ol>
     *     <li>send some change-balance-events to other systems</li>
     *     <li>make some fraud-checks</li>
     *     <li>make some business-checks</li>
     *     <li>sending/checking tan/push-tan etc</li>
     *     <li>...</li>
     * </ol>
     * @param millis duration for the work in millisecond
     */
    private void makeSomeImportantChecksAndCalculation(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance(){
        return balance;
    }
}
