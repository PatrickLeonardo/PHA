package main.algorithm.utilities;

public class bitManager {

    public static void main(String[] args) {
        
        byte b = 9; // 00001001
        byteToBit(b);

        //System.out.println(byteToBits(b));
        System.out.println(58 >> 2); // (58) 00111010 -> (14) 00001110
        System.out.println(9 >> 7);  // (9) 00001001 -> (0) 00000000
        System.out.println(9 >> 3); // (3) 00000011 -> () 00000001
        System.out.println(9 >> 0 & 0x1);
    }

    public static String byteToBit(byte b){
        String bit = "";
        for (int index = 7; index > -1; index--){
            bit += (byte)((b >> index) & 0x1);
        }
        return bit;
    }

    public static String byteToBits(byte b) {
        String bits = Integer.toBinaryString(b & 0xFF);
        System.out.println(bits);
        while (bits.length() < 8) { bits = "0" + bits; }
        return bits;
    }

}