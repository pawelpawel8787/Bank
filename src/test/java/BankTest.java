import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by HP on 2017-09-11.
 */
public class BankTest {

    @Test
    public void shouldPayIntoAccount() {
        //given
        AccountOwner accountOwner1 = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankkAccount1 = new BankAccount(accountOwner1, 10000);
        //when
        bankkAccount1.payIntoAccount(1000);
        //then
        assertTrue(bankkAccount1.getBalance() == 11000);
    }

    @Test
    public void shouldHaveCorrectPinNmber() {
        //given
        AccountOwner accountOwner1 = new AccountOwner("Jan", "Kowalski", "1234");
        //when

        //then
        assertTrue(accountOwner1.getPIN().equals("1234"));
    }

    @Test
    public void shouldWithdrawalFromAccount() {
        //given
        AccountOwner accountOwner1 = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankkAccount1 = new BankAccount(accountOwner1, 10000);
        //when
        bankkAccount1.withdrawalFromAccount(19000);
        //then
        assertTrue(bankkAccount1.getBalance() > 0);
    }

    @Test
    public void shouldTransferBetweenAccounts1() {
        //given
        AccountOwner accountOwner2 = new AccountOwner("Jan", "Kowalski", "1234");
        AccountOwner accountOwner3 = new AccountOwner("Zenon", "Nowak", "5678");
        BankAccount bankAccount2 = new BankAccount(accountOwner2, 10000);
        BankAccount bankAccount3 = new BankAccount(accountOwner3, 10000);
        //when
        bankAccount2.transfer(bankAccount3, 5000);
        //then
        assertTrue(bankAccount2.getBalance() < bankAccount3.getBalance());
    }

    @Test
    public void shouldTransferBetweenAccounts2() {
        //given
        AccountOwner accountOwner2 = new AccountOwner("Jan", "Kowalski", "1234");
        AccountOwner accountOwner3 = new AccountOwner("Zenon", "Nowak", "5678");
        BankAccount bankAccount2 = new BankAccount(accountOwner2, 10000);
        BankAccount bankAccount3 = new BankAccount(accountOwner3, 10000);
        //when
        bankAccount2.transfer(bankAccount3, 15000);
        //then
        assertTrue(bankAccount2.getBalance() == bankAccount3.getBalance());
    }

    @Test
    public void shouldTakeCredit1(){
        //given
        AccountOwner accountOwner4 = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankAccount4 = new BankAccount(accountOwner4, 10000);
        BankCredit bankCredit = new BankCredit(bankAccount4, 5000,3,48);
        //when
        bankCredit.repaymentBankCredit();
        //then
        assertTrue(bankAccount4.getBalance()>bankCredit.getAmountOfCredit());

    }

    @Test
    public void shouldTakeCredit2(){
        //given
        AccountOwner accountOwner4 = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankAccount4 = new BankAccount(accountOwner4, 10000);
        BankCredit bankCredit = new BankCredit(bankAccount4, 15000,3,48);
        //when
        bankCredit.repaymentBankCredit();
        //then
        assertTrue(bankAccount4.getBalance()<bankCredit.getAmountOfCredit());

    }

    @Test
    public void shouldTakeNoMoreThanMaxDebet1(){
        //given
        AccountOwner accountOwner5 = new AccountOwner("Jan", "Kowalski", "1234");
        PremiumAccount premiumAccount = new PremiumAccount(accountOwner5,10000,-5000);
        //when
        premiumAccount.takeDebet(14000);
        //then
        assertTrue(premiumAccount.getBalance()>premiumAccount.getMaxDebet());
    }
    @Test
    public void shouldTakeNoMoreThanMaxDebet2(){
        //given
        AccountOwner accountOwner5 = new AccountOwner("Jan", "Kowalski", "1234");
        PremiumAccount premiumAccount = new PremiumAccount(accountOwner5,10000,-5000);
        //when
        premiumAccount.takeDebet(16000);
        //then
        assertTrue(premiumAccount.getBalance()>premiumAccount.getMaxDebet());
    }
}

