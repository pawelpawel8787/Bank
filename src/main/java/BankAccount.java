/**
 * Created by HP on 2017-09-11.
 */
public class BankAccount extends Bank{

    private AccountOwner accountOwner;

    public BankAccount(int balance, AccountOwner accountOwner) {
        super(balance);
        this.accountOwner = accountOwner;
    }

    public AccountOwner getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(AccountOwner accountOwner) {
        this.accountOwner = accountOwner;
    }

    @Override
    public void payIntoAccount(int howMuch) {
        super.payIntoAccount(howMuch);
    }

    @Override
    public void withdrawalFromAccount(int howMuch) {
        super.withdrawalFromAccount(howMuch);
    }

    @Override
    public void transfer(Bank bank, int howMuch) {
        super.transfer(bank, howMuch);
    }
    }

