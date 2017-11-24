import model.AccountOwner;
import model.BankAccount;
import model.PremiumAccount;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by HP on 2017-09-17.
 */
public class Bank{
//
//
//    public Bank(BigDecimal balance, AccountOwner accountOwner) {
//        super(balance, accountOwner);
//    }
//
//    public void payIntoAccount(BankAccount bankAccount, BigDecimal howMuch) {
//
//        BigDecimal bankAccountBalance = bankAccount.getBalance();
//        bankAccountBalance = bankAccountBalance.add(howMuch);
//        System.out.println("Wplaciles " + howMuch + " PLN. Twój stan konta wynosi " + bankAccountBalance);
//    }
//
//    public void withdrawalFromAccount(BankAccount bankAccount, BigDecimal howMuch) {
//
//        BigDecimal bankAccountBalance = bankAccount.getBalance();
//        if (bankAccountBalance.compareTo(howMuch) < 0) {
//            System.out.println("Masz za mało pieniędzy na wypłatę " + howMuch + " PLN. Możesz wypłacić nie więcej niż " + bankAccountBalance + " PLN.");
//
//        } else {
//            bankAccount.setBalance(bankAccountBalance.subtract(howMuch));
//            System.out.println("Wyplaciles " + howMuch + " PLN z konta. Pozostało Ci " + bankAccountBalance + " PLN.");
//        }
//    }
//
//    public void transfer(BankAccount bankAccount, BigDecimal howMuch) {
//
//        BigDecimal bankAccountBalance = bankAccount.getBalance();
//        if (bankAccountBalance.compareTo(howMuch) < 0) {
//            System.out.println("Masz za mało pieniędzy na transfer " + howMuch + " PLN. Możesz dokonac transferu na nie więcej niż " + bankAccountBalance                                   + " PLN.");
//
//        } else {
//            bankAccount.setBalance(bankAccountBalance.subtract(howMuch));
//            bankAccount.setBalance(bankAccountBalance.add(howMuch));
//            System.out.println("Przelales na konto " + howMuch + " PLN. Na koncie pozostało Ci " + bankAccountBalance + " PLN.");
//
//        }
//    }


}
