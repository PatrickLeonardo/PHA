package pha.cli.repl;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;

import pha.algorithm.crypto.ProceduralHashAlgorithm;
import pha.algorithm.key.PHAKeyCipher;

public class Repl {

    public static void main(final String[] args) throws IOException, InvalidKeyException {
        
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("|  Welcome to PHAShell -- Version 1.0 (" + System.getProperty("os.name") + ")");
        System.out.println("|  For an introduction type: /help intro");
        
        inputloop:
        while (true) {
            
            final String input = System.console().readLine("\nphashell> ");
            
            switch (input) {

                case ("/help intro"):
                    System.out.println("\nUsage:\n");
                    System.out.println("    *Key\n        keypair -c        create a Key Pair");
                    System.out.println("\n   *Encrypt\n        encrypt -t        encrypt a text");
                    break;    

                case ("ping"):
                    System.out.println("\n|  pong\n");
                    break; 
                
                case ("keypair -c"):
                    
                    final File publicKeyFile = new File("publicKeyFile.jks");
                    final File privateKeyFile = new File("privateKeyFile.jks");
                    
                    try {
                        publicKeyFile.createNewFile();
                        privateKeyFile.createNewFile();
                    } catch (final IOException ioException) {
                        ioException.printStackTrace();
                    }
                    
                    PHAKeyCipher.createKeyPair(publicKeyFile, privateKeyFile);
                    break;

                case ("encrypt -t"):
                    final String text = System.console().readLine("\n|  Text to encrypt: ");
                    final File publicKey = new File(System.console().readLine("|  Path to public key: "));
                    ProceduralHashAlgorithm.encryptData(publicKey, text);
                    break;
               
                case ("cls"):
                case ("clear"):
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;

                case ("exit"):
                    break inputloop;
                
                default:
                    System.out.println("\n|  Incorrect command, try again!\n");
                    break;
                
            }
        }
        
    }

}
