package model;

import java.math.BigDecimal;

public interface BankTransactions {

    void payIntoAccount(BigDecimal howMuch);

    void withdrawalFromAccount(BigDecimal howMuch);

    void transferIntoBasicAccount(BankAccount bankAccount, BigDecimal howMuch);

    void transferIntoPremiumAccount(PremiumAccount premiumAccount, BigDecimal howMuch);


}
