public class RefactoredTests {
    public static void main(String[] args) {
        test_creation();
        //bankAccount.depositOrWithdraw();
        test_deposit();
        test_withdraw();
        test_credit_interest();
        System.out.println("Success!");
    }

    private static void test_creation() {
        bankAccount a = new bankAccount(100.0f, 31, 0.0001f);
        assert a.balance == 100.0f : "Incorrect balance!";
        assert a.interestEarned == 0.0f : "Incorrect interest!";
        assert a.dayLastOp == 31 : "Incorrect day last operation!";
        assert a.interestRate == 0.0001f : "Incorrect interest rate!";
    }

    private static void test_deposit(){
        bankAccount a = new bankAccount(100.0f,31,0.0001f);
        a.depositOrWithdraw(50f, 61, false);
        assert a.balance==150f;
        assert a.interestEarned>0.299999f && a.interestEarned<0.3000001f;
        assert a.dayLastOp == 61;
    }

    private static void test_withdraw(){
        bankAccount a = new bankAccount(100.0f,31,0.0001f);
        a.depositOrWithdraw(50f, 61, true);
        assert a.balance==50f;
        assert a.interestEarned>0.299999f && a.interestEarned<0.3000001f;
        assert a.dayLastOp == 61;
    }

    private static void test_credit_interest() {
        bankAccount a = new bankAccount(100.0f,31,0.0001f);
        a.depositOrWithdraw(50f, 61, false);
        a.credit_interest();
        assert a.balance==150.3f;
        assert a.interestEarned==0.0f;
    }

}
