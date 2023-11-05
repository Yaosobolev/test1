package task1;

public class Calculator {
    public double calculateDiscount(double sum, int percent){
        if(percent>100){
            throw new IllegalArgumentException("Percent of discount can not be > 100");
        }
        return sum-percent*sum/100;
    }
}
