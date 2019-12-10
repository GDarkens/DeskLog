public class BankAccount {
    float balance, interestEarned, interestRate;
    int dayLastOp;

    public BankAccount(float initialBalance, int dayCreated, float rate) {
        balance = initialBalance;
        dayLastOp = dayCreated;
        interestEarned = 0.0f;
        interestRate = rate;
    }
    public void deposit(float amount, int dayDeposited){
        int daysInterest = dayDeposited - dayLastOp;
        interestEarned += calcInterest(daysInterest);
        balance += amount;
        dayLastOp = dayDeposited;
    }
    public void withdraw(float amount, int dayWithdrawn){
        int daysInterest = dayWithdrawn - dayLastOp;
        interestEarned += calcInterest(daysInterest);
        balance -= amount;
        dayLastOp = dayWithdrawn;
    }
    public void credit_interest() {
        balance += interestEarned;
        interestEarned = 0.0f;
    }
    private float calcInterest(int daysInterest){
        return daysInterest * interestRate * balance;
    }



}
