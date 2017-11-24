package model;

import java.math.BigDecimal;

/**
 * Created by HP on 2017-09-11.
 */
public class BankAccount implements BankTransactions {

    private BigDecimal balance;
    private AccountOwner accountOwner;

    public BankAccount(BigDecimal balance, AccountOwner accountOwner) {
        this.balance = balance;
        this.accountOwner = accountOwner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void payIntoAccount(BigDecimal howMuch) {
        balance = getBalance().add(howMuch);
        System.out.println("Wplaciles " + howMuch + " PLN. Twój stan konta wynosi " + getBalance());
    }

    public void withdrawalFromAccount(BigDecimal howMuch) {
        if (getBalance().compareTo(howMuch) < 0) {
            System.out.println("Masz za mało pieniędzy na wypłatę " + howMuch + " PLN. Możesz wypłacić nie więcej niż " + getBalance() + " PLN.");

        } else {
            balance = getBalance().subtract(howMuch);
            System.out.println("Wyplaciles " + howMuch + " PLN z konta. Pozostało Ci " + getBalance() + " PLN.");
        }

    }

    public void transferIntoBasicAccount(BankAccount bankAccount, BigDecimal howMuch) {
        if (getBalance().compareTo(howMuch) < 0) {
            System.out.println("Masz za mało pieniędzy na transfer " + howMuch + " PLN. Możesz dokonac transferu na nie więcej niż " + balance + " PLN.");

        } else {
            balance = getBalance().subtract(howMuch);
            bankAccount.setBalance(bankAccount.getBalance().add(howMuch));
            System.out.println("Przelales na konto " + howMuch + " PLN. Na koncie pozostało Ci " + balance + " PLN.");
            System.out.println("Przelales na drugie konto " + howMuch + " PLN. Na drugim koncie jest obecnie " + bankAccount.getBalance() + " PLN.");
        }
    }

    public void transferIntoPremiumAccount(PremiumAccount premiumAccount, BigDecimal howMuch) {
        if (getBalance().compareTo(howMuch) < 0) {
            System.out.println("Masz za mało pieniędzy na transfer " + howMuch + " PLN. Możesz dokonac transferu na nie więcej niż " + balance + " PLN.");

        } else {
            balance = getBalance().subtract(howMuch);
            premiumAccount.setBalance(premiumAccount.getBalance().add(howMuch));
            System.out.println("Przelales na konto " + howMuch + " PLN. Na koncie pozostało Ci " + balance + " PLN.");
            System.out.println("Przelales na konto premium " + howMuch + " PLN. Na koncie premium masz " + premiumAccount.getBalance() + " PLN.");
        }
    }


    public void transfer(BankAccount bankAccount, BigDecimal howMuch) {
        if (getBalance().compareTo(howMuch) < 0) {
            System.out.println("Masz za mało pieniędzy na transfer " + howMuch + " PLN. Możesz dokonac transferu na nie więcej niż " + balance + " PLN.");

        } else {
            balance = getBalance().subtract(howMuch);
            bankAccount.setBalance(bankAccount.getBalance().add(howMuch));
            System.out.println("Przelales na konto " + howMuch + " PLN. Na koncie pozostało Ci " + getBalance() + " PLN.");

        }
    }
}