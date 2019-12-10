import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class JtestBankAccount {
    public  void main(String[] args) {
        runAllTests();
        System.out.println("Success!");
    }
    private  void runAllTests(){
        test_creation();
        //test_desposit();
       // test_withdraw();
       // test_credit_interest();
    }

    public void test_creation(){
        BankAccountRefactored a = standardTestAccount();
        assertBankAccount(a, 100.0f, 0.0f, 31);

    }
    @Test
    @RunWith(Parameterized.class)
    public void assertBankAccount(BankAccountRefactored a, float expectedBalance, float expectedInterestEarned, int expectedDayLastOp) {
        Assert.assertTrue( Math.abs(a.balance - expectedBalance) < 0.001);
        Assert.assertTrue( Math.abs(a.interestEarned - expectedInterestEarned) < 0.001);
        Assert.assertTrue( a.dayLastOp == expectedDayLastOp);
        Assert.assertEquals(0.0001f,a.interestEarned,0);
    }
    public BankAccountRefactored standardTestAccount(){
        return new BankAccountRefactored(100.0f,31,0.0001f);
    }
}
