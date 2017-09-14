/**
 * Created by HP on 2017-09-13.
 */
public class PremiumAccount {

    private AccountOwner accountOwner;
    private int balance;
    private int maxDebet;

    public PremiumAccount(AccountOwner accountOwner, int balance, int maxDebet) {
        this.accountOwner = accountOwner;
        this.balance = balance;
        this.maxDebet = maxDebet;
    }

    public AccountOwner getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(AccountOwner accountOwner) {
        this.accountOwner = accountOwner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMaxDebet() {
        return maxDebet;
    }

    public void takeDebet(int howMuch){
        if ((getBalance()-howMuch)<maxDebet){
            System.out.println("Nie możesz wybrać więcej niż wynosi kwota debetu: " + maxDebet + " PLN.");
        }
        else{
            setBalance(getBalance()-howMuch);
            System.out.println("Wybrales " + howMuch + " PLN. Twoje saldo na koncie wynosi obecnie " + getBalance() + " PLN.");
        }
    }
}
