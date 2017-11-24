import model.AccountOwner;
import model.BankAccount;
import model.BankCredit;
import model.PremiumAccount;
import org.junit.Test;


import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

/**
 * Created by HP on 2017-09-11.
 */
public class BankTest {

    @Test
    public void shouldPayIntoAccount() {
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankAccount = new BankAccount(new BigDecimal(10000),accountOwner);
        //when
        bankAccount.payIntoAccount(new BigDecimal(3000));
        //then
        assertTrue(bankAccount.getBalance().equals(new BigDecimal(13000)));
    }

    @Test
    public void shouldPayIntoPremiumAccount() {
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        PremiumAccount premiumAccount = new PremiumAccount(new BigDecimal(21000),accountOwner,new BigDecimal(-7000));
        //when
        premiumAccount.payIntoAccount(new BigDecimal(3000));
        //then
        assertTrue(premiumAccount.getBalance().equals(new BigDecimal(24000)));
    }

    @Test
    public void shouldWithdrawalFromAccount() {
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankAccount = new BankAccount(new BigDecimal(10000), accountOwner);
        //when
        bankAccount.withdrawalFromAccount(new BigDecimal(9000));
        //then
        assertTrue(bankAccount.getBalance().equals(new BigDecimal(1000)));
    }

    @Test
    public void shouldTransferFromBasicAccToBasicAcc() {
        //given
        AccountOwner accountOwner1 = new AccountOwner("Jan", "Kowalski", "1234");
        AccountOwner accountOwner2 = new AccountOwner("Zenon", "Nowak", "5678");
        BankAccount bankAccount1 = new BankAccount(new BigDecimal(12000), accountOwner1);
        BankAccount bankAccount2 = new BankAccount(new BigDecimal(450000), accountOwner2);
        //when
        bankAccount1.transferIntoBasicAccount(bankAccount2, new BigDecimal(5000));
        //then
        assertTrue(bankAccount1.getBalance().equals(new BigDecimal(7000)) && bankAccount2.getBalance().equals(new BigDecimal(455000)));
    }
    @Test
    public void shouldTransferFromBasicAccToPremiumAcc() {
        //given
        AccountOwner accountOwner1 = new AccountOwner("Jan", "Kowalski", "1234");
        AccountOwner accountOwner2 = new AccountOwner("Zenon", "Nowak", "5678");
        BankAccount bankAccount = new BankAccount(new BigDecimal(12000), accountOwner1);
        PremiumAccount premiumAccount = new PremiumAccount(new BigDecimal(120000), accountOwner2, new BigDecimal(-5000));
        //when
        bankAccount.transferIntoPremiumAccount(premiumAccount, new BigDecimal(5000));
        //then
        assertTrue(bankAccount.getBalance().equals(new BigDecimal(7000)) && premiumAccount.getBalance().equals(new BigDecimal(125000)));
    }

    @Test
    public void shouldTransferBetweenAccounts2() {
        //given
        AccountOwner accountOwner1 = new AccountOwner("Jan", "Kowalski", "1234");
        AccountOwner accountOwner2 = new AccountOwner("Zenon", "Nowak", "5678");
        BankAccount bankAccount1 = new BankAccount(new BigDecimal(12000), accountOwner1);
        BankAccount bankAccount2 = new BankAccount(new BigDecimal(3000), accountOwner2);
        //when
        bankAccount1.transfer(bankAccount2, new BigDecimal(9000));
        //then
        assertTrue(bankAccount1.getBalance().equals(new BigDecimal(3000)) && bankAccount2.getBalance().equals(new BigDecimal(12000)));
    }

    @Test
    public void shouldTakeCredit(){
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankAccount = new BankAccount(new BigDecimal(10000), accountOwner);
        BankCredit bankCredit = new BankCredit(bankAccount, new BigDecimal(5000),new BigDecimal(3),48);
        //when
        bankCredit.repaymentBankCredit();
        //then
        assertTrue(bankAccount.getBalance().equals(new BigDecimal("4850.08")));

    }

    @Test
    public void shouldNoTakeMoreCreditThanAccountBalance(){
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        BankAccount bankAccount = new BankAccount(new BigDecimal(10000), accountOwner);
        BankCredit bankCredit = new BankCredit(bankAccount, new BigDecimal(15000),new BigDecimal(3),48);
        //when
        bankCredit.repaymentBankCredit();
        //then
        assertTrue(bankAccount.getBalance().equals(new BigDecimal("10000")));

    }

    @Test
    public void shouldTakeDebet(){
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        PremiumAccount premiumAccount = new PremiumAccount(new BigDecimal(10000), accountOwner, new BigDecimal(-5000));
        //when
        premiumAccount.takeDebet(new BigDecimal(14000));
        //then
        assertTrue(premiumAccount.getBalance().equals(new BigDecimal(-4000)));
    }

    @Test
    public void shouldTakeNoMoreThanMaxDebet(){
        //given
        AccountOwner accountOwner = new AccountOwner("Jan", "Kowalski", "1234");
        PremiumAccount premiumAccount = new PremiumAccount(new BigDecimal(10000), accountOwner, new BigDecimal(-5000));
        //when
        premiumAccount.takeDebet(new BigDecimal(16000));
        //then
        assertTrue(premiumAccount.getBalance().equals(new BigDecimal("10000")));
    }

}

