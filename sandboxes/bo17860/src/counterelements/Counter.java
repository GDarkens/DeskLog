package counterelements;

public class Counter {
    Integer number;

    public Counter(int x){
       number=x;
    }

    public void increase_int(){
        number++;
    }

    public void decrease(){
        number--;
    }
    public void toString(Integer number){
        System.out.println("''" + number);
    }
}
