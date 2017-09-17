/**
 * Created by HP on 2017-09-17.
 */
public class Bank {

    private int balance;

    public Bank(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void payIntoAccount(int howMuch) {

        balance += howMuch;
        System.out.println("Wplaciles " + howMuch + " PLN. Twój stan konta wynosi " + getBalance());
    }

    public void withdrawalFromAccount(int howMuch) {

        if (balance < howMuch) {
            System.out.println("Masz za mało pieniędzy na wypłatę " + howMuch + " PLN. Możesz wypłacić nie więcej niż " + balance + " PLN.");

        } else {
            setBalance(getBalance() - howMuch);
            System.out.println("Wyplaciles " + howMuch + " PLN z konta. Pozostało Ci " + balance + " PLN.");
        }
    }

    public void transfer(Bank bank, int howMuch) {


        if (balance < howMuch) {
            System.out.println("Masz za mało pieniędzy na transfer " + howMuch + " PLN. Możesz dokonac transferu na nie więcej niż " + balance + " PLN.");

        } else {
            setBalance(getBalance() - howMuch);
            bank.setBalance(bank.getBalance() + howMuch);
            System.out.println("Przelales na konto " + howMuch + " PLN. Na koncie pozostało Ci " + getBalance() + " PLN.");

        }
    }


}
