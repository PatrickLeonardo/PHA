package main;

public class GeneralTest {

    public static void main(String[] args) {
        
        GeneralTest test = new GeneralTest();
        double n = test.getProbability(1000002020);
        System.out.println(n);
        
    }

    public double getProbability(int n){
        
        double p = Math.pow((1.0/365), n);
        System.out.println(1.0/365);
        for(int i = (366 - n); i < 366; i++){
            p *= i;
        }
        
        return 1 - p;
    }

}