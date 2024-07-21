package pha.cli.repl;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;

import pha.algorithm.crypto.ProceduralHashAlgorithm;
import pha.algorithm.key.PHAKeyCipher;

public class Repl {

    public static void main(final String[] args) throws IOException, InvalidKeyException {
        
        File publicKeyHash, privateKeyHash;


        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("|  Welcome to PHAShell -- Version 1.0 (" + System.getProperty("os.name") + ")");
        System.out.println("|  For an introduction type: /help intro");
        
        inputloop:
        while (true) {
            
            final String input = System.console().readLine("\nphashell> ");
            
            switch (input) {

                case ("/help intro"):
                    System.out.println("\nUsage:");
                    System.out.println("\n    *Key\n\n        keypair -c        create a Key Pair");
                    System.out.println("\n\n    *Encrypt\n\n        encrypt -t        encrypt a text");
                    System.out.println("        encrypt -f        encrypt all content of a file");
                    System.out.println("\n\n    *Decrypt\n\n        decrypt -t        decrypt a text");
                    System.out.println("        decrypt -f        decrypt all content of a file");
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
                    final String textToEncrypt = System.console().readLine("\n|  Text to encrypt: ");
                    publicKeyHash = new File(System.console().readLine("|  Path to public key: "));
                    ProceduralHashAlgorithm.encryptData(publicKeyHash, textToEncrypt);
                    break;

                case ("encrypt -f"):
                    final String fileUriToEncrypt = System.console().readLine("\n|  Path to file: ");
                    publicKeyHash = new File(System.console().readLine("\n|  Path to public key: "));
                    ProceduralHashAlgorithm.encryptData(publicKeyHash, fileUriToEncrypt);

                case ("decrypt -f"):
                    final String fileUriToDecrypt = System.console().readLine("\n|  Path to file: ");
                    privateKeyHash = new File(System.console().readLine("\n|  Path to private key: "));
                    ProceduralHashAlgorithm.decryptData(privateKeyHash, fileUriToDecrypt);

                case ("decrypt -t"):
                    final String textToDecrypt = System.console().readLine("\n|  Text to decrypt: ");
                    privateKeyHash = new File(System.console().readLine("|  Path to private key: "));
                    ProceduralHashAlgorithm.decryptData(privateKeyHash, textToDecrypt);
                
                case ("cls"):
                case ("clear"):
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                
                case (":q"):
                case ("exit"):
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    break inputloop;
                
                default:
                    System.out.println("\n|  Incorrect command, try again!\n");
                    break;
                
            }
        }
        
    }

}
