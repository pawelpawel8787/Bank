package model;

import java.math.BigDecimal;

public class PremiumAccount implements BankTransactions {


    private BigDecimal balance;
    private AccountOwner accountOwner;
    private BigDecimal maxDebet;

    public PremiumAccount(BigDecimal balance, AccountOwner accountOwner, BigDecimal maxDebet) {
        this.balance = balance;
        this.accountOwner = accountOwner;
        this.maxDebet = maxDebet;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void takeDebet(BigDecimal howMuch) {
        if (((getBalance().subtract(howMuch)).compareTo(maxDebet)) < 0) {
            System.out.println("Nie możesz pożyczyć więcej niż wynosi limit debetu: " + maxDebet + " PLN.");
        } else {
            setBalance(getBalance().subtract(howMuch));
            System.out.println("Wybrales " + howMuch + " PLN. Twoje saldo na koncie wynosi obecnie " + getBalance() + " PLN.");
        }
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
            System.out.println("Przelales na konto " + howMuch + " PLN. Na koncie pozostało Ci " + getBalance() + " PLN.");
        }
    }

    public void transferIntoPremiumAccount(PremiumAccount premiumAccount, BigDecimal howMuch) {
        if (getBalance().compareTo(howMuch) < 0) {
            System.out.println("Masz za mało pieniędzy na transfer " + howMuch + " PLN. Możesz dokonac transferu na nie więcej niż " + balance + " PLN.");

        } else {
            balance = getBalance().subtract(howMuch);
            premiumAccount.setBalance(premiumAccount.getBalance().add(howMuch));
            System.out.println("Przelales na konto " + howMuch + " PLN. Na koncie pozostało Ci " + getBalance() + " PLN.");
        }
    }
}
