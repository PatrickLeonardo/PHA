package pha.cli.repl;

import java.io.IOException;
import java.io.File;
import pha.algorithm.key.PHAKeyCipher;

public class Repl {

    public static void main(final String[] args) throws IOException {
    
        System.out.print("\033[H\033[2J");
        System.out.flush(); 
        System.out.println("|  Welcome to PHAShell -- Version 1.0 (" + System.getProperty("os.name") + ")");
        System.out.println("|  For an introduction type: /help intro\n");
        
        while (true) {
            
            final String input = System.console().readLine("phashell> ");
            
            if (input.equals("/help intro")) {
                System.out.println("\nUsage:\n");
                System.out.println("    *Key\n        keypair -c        create a Key Pair\n");
            }

            else if (input.equals("ping")) {
                System.out.println("\n| pong\n");
            }

            else if (input.equals("exit")) {
                break;
            } 
            
            else if (input.equals("keypair -c")) {
                
                final File publicKeyFile = new File("publicKeyFile.jks");
                final File privateKeyFile = new File("privateKeyFile.jks");

                try {
                    publicKeyFile.createNewFile();
                    privateKeyFile.createNewFile();
                } catch (final IOException ioException) {
                    ioException.printStackTrace();
                }

                PHAKeyCipher.createKeyPair(publicKeyFile, privateKeyFile);

            } else {
                System.out.println("\n| " + input + "\n");
            }
            
        }

    }

}
