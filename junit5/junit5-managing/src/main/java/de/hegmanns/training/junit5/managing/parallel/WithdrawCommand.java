package de.hegmanns.training.junit5.managing.parallel;

public class WithdrawCommand {
    private Account account;
    private int moneyToWithdraw;

    public WithdrawCommand() {
    }

    public void doWith(Account account, int moneyToWithdraw) {
        this.account = account;
        this.moneyToWithdraw = moneyToWithdraw;
        makeWithdraw();
    }

    public void makeWithdraw() {
        doHardWork();
        doHardWork();
        account.withdraw(moneyToWithdraw);
        doHardWork();
    }

    /**
     * Should be places some (unspecified) work.
     */
    private void doHardWork() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // nothing to do
        }
    }
}
