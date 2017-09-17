/**
 * Created by HP on 2017-09-12.
 */
public class BankCredit{

    private BankAccount bankAccount;
    private int amountOfCredit;
    private int loanInterestRate;
    private int repaymentPeriod;


    public BankCredit(BankAccount bankAccount, int amountOfCredit, int loanInterestRate, int repaymentPeriod) {
        this.bankAccount = bankAccount;
        this.amountOfCredit = amountOfCredit;
        this.loanInterestRate = loanInterestRate;
        this.repaymentPeriod = repaymentPeriod;
    }

    public int getAmountOfCredit() {
        return amountOfCredit;
    }

    public int getLoanInterestRate() {
        return loanInterestRate;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void repaymentBankCredit() {

        if (amountOfCredit > bankAccount.getBalance()) {
            System.out.println("Chcesz za duzo pozyczyc");
        } else {
            System.out.println("Pozyczyles " + getAmountOfCredit() + " PLN z oprocentowaniem " + getLoanInterestRate() + "% na okres " + getRepaymentPeriod() + " miesięcy.");
            //wysokosc jednej raty = (x+(x*(3/100)))/48
            double valueOfMonthlyRate = (amountOfCredit + (amountOfCredit * ((double) loanInterestRate / 100))) / repaymentPeriod;
            System.out.println("Wysokość pojedynczej raty wyniesie " + valueOfMonthlyRate + " PLN.");

            double sumToRepayment = valueOfMonthlyRate * repaymentPeriod;

            bankAccount.setBalance(bankAccount.getBalance() - (int) sumToRepayment);
            System.out.println("Kwota na koncie po splacie kredytu wynosi " + bankAccount.getBalance() + " PLN.");

        }
    }
}
