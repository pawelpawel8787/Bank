/**
 * Created by HP on 2017-09-11.
 */
public class BankAccount {

    private AccountOwner accountOwner;
    private int balance;

    public BankAccount(AccountOwner accountOwner, int balance) {
        this.accountOwner = accountOwner;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public AccountOwner getAccountOwner() {
        return accountOwner;
    }


    public void payIntoAccount(int howMuch) {

        balance += howMuch;
        System.out.println("Wplaciles " + howMuch + " PLN. Twój stan konta wynosi " + getBalance());
    }

    public void withdrawalFromAccount(int howMuch) {
        while (true)
            if (balance < howMuch) {
                System.out.println("Masz za mało pieniędzy na wypłatę " + howMuch + " PLN. Możesz wypłacić nie więcej niż " + balance + " PLN.");
                break;
            }
            else {
                setBalance(getBalance() - howMuch);
                System.out.println("Wyplaciles " + howMuch + " PLN z konta. Pozostało Ci " + balance + " PLN.");
            }
    }

    public void transfer(BankAccount bankAccount, int howMuch){


            if (balance < howMuch) {
                System.out.println("Masz za mało pieniędzy na transfer " + howMuch + " PLN. Możesz dokonac transferu na nie więcej niż " + balance + " PLN.");

            }
            else{
                setBalance(getBalance()-howMuch);
                bankAccount.setBalance(bankAccount.getBalance() + howMuch);
                System.out.println("Przelales na konto " + bankAccount.getAccountOwner().toString() + " " + howMuch + " PLN. Na koncie pozostało Ci " + balance + " PLN.");
                System.out.println("Na koncie " + bankAccount.getAccountOwner().toString() + " jest obecnie " + bankAccount.getBalance() + " PLN.");
            }
        }

    }

