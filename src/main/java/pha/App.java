package pha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.SecureRandom;

public class App {

    public static void main( final String[] args ) throws IOException {

        final String msg = "Test";
        String msgcifrada = null;
        String msgdecifrada = null;
        System.out.println(msgdecifrada);
        BigInteger n, d, e;
        final int bitlen = 2048;

        final SecureRandom r = new SecureRandom();
        final BigInteger p = new BigInteger(bitlen / 2, 100, r);
        final BigInteger q = new BigInteger(bitlen / 2, 100, r);

        // Compute n = p * q  
        n = p.multiply(q);
        
        // phi(n) = p -1 * q -1
        final BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        
        //Escolha um inteiro  "e"  , 1 < "e" < phi(n) ,  "e" e phi(n) sejam primos entre si.
        e = new BigInteger("3");
        while(m.gcd(e).intValue() > 1) e = e.add(new BigInteger("2"));

        // d seja inverso multiplicativo de "e"
        d = e.modInverse(m);
        
        //System.out.println("p:"+p);
        //System.out.println("q:"+q);
        //System.out.println("n:"+n);
        //System.out.println("e:"+e);
        //System.out.println("d:"+d);

        //mensagem cifrada - RSA_encrypt()
        msgcifrada = new BigInteger(msg.getBytes()).modPow(e, n).toString();
        //System.out.println("msg cifrada: "+ msgcifrada);

        //mensagem decifrada - RSA_decrypt()
        msgdecifrada = new String(new BigInteger(msgcifrada).modPow(d, n).toByteArray());
        //System.out.println("msg decifrada: " +msgdecifrada);
         
        final File publicKeyFile = new File("./publicKeyFile.jks");
        final File privateKeyFile = new File("./privateKeyFile.jks");

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(publicKeyFile)));
        final BufferedReader bufferedReaderPrivate = new BufferedReader(new InputStreamReader(new FileInputStream(privateKeyFile)));

        String key = bufferedReader.readLine().replace("0x", "");
        String key2 = bufferedReaderPrivate.readLine().replace("0x", "");

        bufferedReader.close();
        bufferedReaderPrivate.close();

        final byte[] keyBytes = hexStringToByteArray(key);
        final byte[] keyBytes2 = hexStringToByteArray(key2);

        // Obtém o tamanho da chave em bytes
        final int keySizeInBytes = keyBytes.length;
        final int keySizeInBytes2 = keyBytes2.length;
        
        // Converte o tamanho para bits
        final int keySizeInBits = keySizeInBytes * 8;
        final int keySizeInBits2 = keySizeInBytes2 * 8;

        System.out.println("\nTamanho da chave publica em bytes: " + keySizeInBytes);
        System.out.println("Tamanho da chave publica em bits: " + keySizeInBits);
        
        System.out.println("\nTamanho da chave privada em bytes: " + keySizeInBytes2);
        System.out.println("Tamanho da chave privada em bits: " + keySizeInBits2);
        
    }

    public static byte[] hexStringToByteArray(final String s) {
        final int len = s.length();
        final byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}
