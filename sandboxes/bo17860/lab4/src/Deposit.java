public class Deposit {
    float amount;
    int deposit;
    public Deposit(float current_amount, int dayDeposited){
        amount=current_amount;
        deposit=dayDeposited;

    }

   /* public int do_deposit(float amount, int deposit, BankAccount b, int dayLastOp, float interestEarned, int interestRate){
        int daysInterest = deposit - b.dayLastOp;
        b.interestEarned += daysInterest * interestRate * b.balance;
        b.balance += amount;
        dayLastOp = deposit;
    }*/
}
