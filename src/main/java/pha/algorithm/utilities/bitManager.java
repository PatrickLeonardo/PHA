package pha.algorithm.utilities;

/**
 * <p>The {@code bitManager} class is a class created to manage bit values and more.</p>
 */
public class bitManager {

    /**
     * <p>This method is used to transform the number (in the byte type) into the bit representation with the bitwise operation.</p>
     * @return String containing the bit representation of the byte.
     */
    public static String byteToBit(final byte suffixByte){
        StringBuilder bit = new StringBuilder();
        for (int index = 7; index > -1; index--){
            bit.append((byte)((suffixByte >> index) & 0x1));
        }
        return bit.toString();
    }

}

