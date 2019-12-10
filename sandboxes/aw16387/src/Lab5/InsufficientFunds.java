package Lab5;

public class InsufficientFunds extends Throwable {
    public InsufficientFunds(float availableFunds){
        super(Float.toString(availableFunds));
    }
}
