public class bankAccount {
    float balance, interestEarned, interestRate;
    int dayLastOp;

    public bankAccount(float initialBalance, int dayCreated, float rate) {
        balance = initialBalance;
        dayLastOp = dayCreated;
        interestEarned = 0.0f;
        interestRate = rate;
    }

    public void depositOrWithdraw(float amount, int dayDeposited, boolean withdrawl){
        int daysInterest = dayDeposited - dayLastOp;
        interestEarned += daysInterest * interestRate * balance;
        if(withdrawl){
            balance -= amount;
            dayLastOp = dayDeposited;
        } else{
            balance += amount;
            dayLastOp = dayDeposited;
        }
    }

    public void credit_interest() {
        balance += interestEarned;
        interestEarned = 0.0f;
    }
}