package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by HP on 2017-09-12.
 */
public class BankCredit {

    private BankAccount bankAccount;
    private BigDecimal amountOfCredit;
    private BigDecimal loanInterestRate;
    private int repaymentPeriod;


    public BankCredit(BankAccount bankAccount, BigDecimal amountOfCredit, BigDecimal loanInterestRate, int repaymentPeriod) {
        this.bankAccount = bankAccount;
        this.amountOfCredit = amountOfCredit;
        this.loanInterestRate = loanInterestRate;
        this.repaymentPeriod = repaymentPeriod;
    }

    public BigDecimal getAmountOfCredit() {
        return amountOfCredit;
    }

    public BigDecimal getLoanInterestRate() {
        return loanInterestRate;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void repaymentBankCredit() {

        BigDecimal bankAccountBalance = bankAccount.getBalance();

        //wysokosc jednej raty np. (x+(x*(3/100)))/48
        BigDecimal valueOfMonthlyRate = (amountOfCredit.add(amountOfCredit.multiply(loanInterestRate.divide(new BigDecimal(100))))).divide(new BigDecimal(repaymentPeriod), 2, RoundingMode.HALF_EVEN);

        BigDecimal sumToRepayment = valueOfMonthlyRate.multiply(new BigDecimal(repaymentPeriod));

        if (amountOfCredit.compareTo(bankAccountBalance) > 0) {
            System.out.println("Chcesz za duzo pozyczyc");
        } else {
            System.out.println("Pozyczyles " + getAmountOfCredit() + " PLN z oprocentowaniem " + getLoanInterestRate() + "% na okres " + getRepaymentPeriod() + " miesięcy.");

            System.out.println("Wysokość pojedynczej raty wyniesie " + valueOfMonthlyRate + " PLN.");

            bankAccount.setBalance(bankAccountBalance.subtract(sumToRepayment));
            System.out.println("Kwota na koncie po splacie kredytu wynosi " + bankAccount.getBalance() + " PLN.");

        }
    }
}
