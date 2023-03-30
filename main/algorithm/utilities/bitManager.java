package main.algorithm.utilities;

public class bitManager {

    public static String byteToBit(final byte sufixByte){
        String bit = "";
        for (int index = 7; index > -1; index--){
            bit += (byte)((sufixByte >> index) & 0x1);
        }
        return bit;
    }

}