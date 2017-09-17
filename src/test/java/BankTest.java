import org.junit.Test;


import static org.junit.Assert.assertTrue;

/**
 * Created by HP on 2017-09-11.
 */
public class BankTest {

    @Test
    public void shouldPayIntoAccount() {
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankAccount = new BankAccount(10000,accountOwner);
        //when
        bankAccount.payIntoAccount(3000);
        //then
        assertTrue(bankAccount.getBalance() == 13000);
    }

    @Test
    public void shouldPayIntoPremiumAccount() {
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        PremiumAccount premiumAccount = new PremiumAccount(21000,accountOwner,-7000);
        //when
        premiumAccount.payIntoAccount(3000);
        //then
        assertTrue(premiumAccount.getBalance() == 24000);
    }

    @Test
    public void shouldWithdrawalFromAccount() {
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankkAccount = new BankAccount(10000, accountOwner);
        //when
        bankkAccount.withdrawalFromAccount(9000);
        //then
        assertTrue(bankkAccount.getBalance() == 1000);
    }

    @Test
    public void shouldTransferBetweenAccounts() {
        //given
        AccountOwner accountOwner1 = new AccountOwner("Jan", "Kowalski", "1234");
        AccountOwner accountOwner2 = new AccountOwner("Zenon", "Nowak", "5678");
        BankAccount bankAccount = new BankAccount(12000, accountOwner1);
        PremiumAccount premiumAccount = new PremiumAccount(20000, accountOwner2,-5000);
        //when
        bankAccount.transfer(premiumAccount, 5000);
        //then
        assertTrue(bankAccount.getBalance() == 7000 && premiumAccount.getBalance() == 25000);
    }

    @Test
    public void shouldTransferBetweenAccounts2() {
        //given
        AccountOwner accountOwner1 = new AccountOwner("Jan", "Kowalski", "1234");
        AccountOwner accountOwner2 = new AccountOwner("Zenon", "Nowak", "5678");
        BankAccount bankAccount1 = new BankAccount(12000, accountOwner1);
        BankAccount bankAccount2 = new BankAccount(3000, accountOwner2);

        //when
        bankAccount1.transfer(bankAccount2, 9000);
        //then
        assertTrue(bankAccount1.getBalance() == 3000 && bankAccount2.getBalance() == 12000);
    }

    @Test
    public void shouldTakeCredit(){
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankAccount = new BankAccount(10000, accountOwner);
        BankCredit bankCredit = new BankCredit(bankAccount, 5000,3,48);
        //when
        bankCredit.repaymentBankCredit();
        //then
        assertTrue(bankAccount.getBalance() == 4850);

    }

    @Test
    public void shouldNoTakeMoreCreditThanAccountBalance(){
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankAccount = new BankAccount(10000, accountOwner);
        BankCredit bankCredit = new BankCredit(bankAccount, 15000,3,48);
        //when
        bankCredit.repaymentBankCredit();
        //then
        assertTrue(bankAccount.getBalance() == 10000);

    }

    @Test
    public void shouldTakeDebet(){
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        PremiumAccount premiumAccount = new PremiumAccount(10000, accountOwner, -5000);
        //when
        premiumAccount.takeDebet(14000);
        //then
        assertTrue(premiumAccount.getBalance() == -4000);
    }
    @Test
    public void shouldTakeNoMoreThanMaxDebet(){
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        PremiumAccount premiumAccount = new PremiumAccount(10000, accountOwner, -5000);
        //when
        premiumAccount.takeDebet(16000);
        //then
        assertTrue(premiumAccount.getBalance() == 10000);
    }

}

