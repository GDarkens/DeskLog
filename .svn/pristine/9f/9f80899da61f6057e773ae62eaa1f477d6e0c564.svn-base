public class testBankAccount {
    private static void test_creation() {
        BankAccount a = new BankAccount(100.0f, 31, 0.0001f);
        assert a.balance == 100.0f : "Incorrect balance!";
        assert a.interestEarned == 0.0f : "Incorrect interest!";
        assert a.dayLastOp == 31 : "Incorrect day last operation!";
        assert a.interestRate == 0.0001f : "Incorrect interest rate!";
    }
    private static void test_deposit(){
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        a.deposit(50f, 61);
        assertAccount(a, 150f, 0.299999f, 0.3000001f, 61);
    }
    private static void test_withdraw(){
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        a.withdraw(50f, 61);
        assertAccount(a, 50f, 0.299999f, 0.3000001f, 61);
    }
    private static void test_credit_interest() {
        BankAccount a = new BankAccount(100.0f,31,0.0001f);
        a.deposit(50f, 61);
        a.credit_interest();
        assert a.balance==150.3f;
        assert a.interestEarned==0.0f;
    }
    private static void assertAccount(BankAccount a, float balance, float interestEarnedmin, float interestEarnedmax, int dayLastop){
        assert a.balance==balance;
        assert a.interestEarned>interestEarnedmin && a.interestEarned<interestEarnedmax;
        assert a.dayLastOp == dayLastop;
    }
    public static void main(String[] args) {
        test_creation();
        test_deposit();
        test_withdraw();
        test_credit_interest();
        System.out.println("Success!");
    }

}
