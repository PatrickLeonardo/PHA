package main.hash;

public class HashEqualityProbability {

        public static void main(String[] args) {
        
        HashEqualityProbability hashEqualityProbability = new HashEqualityProbability();        
        
        int numberOfProbability = 10;
        for (int i = 8; i > 0; i--) numberOfProbability *= 10;
        int prefix = 2;
        for (double i = 10; i > 0; i--) prefix *= 2;
        
        numberOfProbability += prefix;
        double probability = hashEqualityProbability.getProbability(numberOfProbability);
        System.out.println(probability);

    }

    public double getProbability(int number){
        
        System.out.println("\n" + (1.0/365));
        double p = Math.pow((1.0/365), number);
        for(int i = (366 - number); i < 366; i++) p *= i;
        return 1 - p;

    }

}