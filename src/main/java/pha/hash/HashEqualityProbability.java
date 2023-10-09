package pha.hash;

/**
 * <p>This class is used for the calculate the hash equality probability.
 * It is used to avoid collisions between hashes and to avoid security flaws like validations and more.
 * If modified, this class may show malfunctions, with constant errors and failures.
 * Only used for checks, not for key and encoding calculations.
 */
public class HashEqualityProbability {

    /**
     * This is the method used to get the hash equality probability number based on the birthday paradox.
     * In which a calculation is made with the distributions and hash variation compared to the days of the year
     * @return double Probability number.
     */
    public double getProbability(int numberOfProbability){
        
        double p = Math.pow((1.0/365), numberOfProbability);
        for(int i = (366 - numberOfProbability); i < 366; i++) p *= i;
        return 1 - p;

    }

}
