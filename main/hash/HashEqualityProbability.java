package main.hash;

public class HashEqualityProbability {

    public double getProbability(int numberOfProbability){
        
        double p = Math.pow((1.0/365), numberOfProbability);
        for(int i = (366 - numberOfProbability); i < 366; i++) p *= i;
        return 1 - p;

    }

}