package de.hegmanns.training.junit5.managing.parallel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomerAccountService {
    private Map<String, Account> accounts;
    private WithdrawCommand withdrawCommand = new WithdrawCommand();
    private Set<Thread> withdrawThreads = new HashSet<>();
    private boolean withSynchronizedTheWithdrawcommand = false;

    public CustomerAccountService(boolean withSynchronizedTheWithdrawcommand) {
        this();
        this.withSynchronizedTheWithdrawcommand = withSynchronizedTheWithdrawcommand;
    }

    public CustomerAccountService(){
        accounts = new HashMap<String, Account>(){
            {
                put("1234", new Account("1234", 10));
                put("5678", new Account("5678", 10));
                put("9101", new Account("9101", 10));
            }
        };
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public boolean isNotOpenWithdraw(){
        boolean oneOpenThreadAtLeast = withdrawThreads.stream().filter(Thread::isAlive).findAny().isPresent();

        return !oneOpenThreadAtLeast;
    }

    public int getCountWithdrawProcesses(){
        return withdrawThreads.size();
    }

    public void doWithdraw(String accountNumber, int withdraw) {
        Account account = accounts.get(accountNumber);

        Runnable commandInThread = () -> {
            withdrawCommand.doWith(account, withdraw);
        };

        Thread thread = new Thread(commandInThread);
        withdrawThreads.add(thread);
        thread.start();

        if (withSynchronizedTheWithdrawcommand) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // nothing to do
            }
        }
    }
}
