/**
 * Created by HP on 2017-09-13.
 */
public class PremiumAccount extends BankAccount{


    private int maxDebet;

    public PremiumAccount(int balance, AccountOwner accountOwner, int maxDebet) {
        super(balance, accountOwner);
        this.maxDebet = maxDebet;
    }


    public int getMaxDebet() {
        return maxDebet;
    }


    public void takeDebet(int howMuch) {
        if ((getBalance() - howMuch) < maxDebet) {
            System.out.println("Nie możesz wybrać więcej niż wynosi kwota debetu: " + maxDebet + " PLN.");
        } else {
            setBalance(getBalance() - howMuch);
            System.out.println("Wybrales " + howMuch + " PLN. Twoje saldo na koncie wynosi obecnie " + getBalance() + " PLN.");
        }
    }
}
