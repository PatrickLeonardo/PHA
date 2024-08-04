package pha.cli.repl;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import pha.algorithm.crypto.ProceduralHashAlgorithm;
import pha.algorithm.key.PHAKeyCipher;

public class Repl {

    /**
     * @param args
     * @throws IOException
     * @throws InvalidKeyException
     */
    public static void main(final String[] args) throws IOException, InvalidKeyException {
        
        File publicKeyHash, privateKeyHash;
        String command;

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
                    System.out.println("        decrypt -f        decrypt all content of a file\n");
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

                case ("pwd"):
                    command = RemoteShell.executeCommand("pwd", "linux");
                    System.out.println("\n" + command);
                    break;

                case("l"):
                case ("ls"):
                    command = RemoteShell.executeCommand("ls", "linux");
                    System.out.println("\n" + command);
                    break;
                
                case ("install"):
                    command = RemoteShell.executeCommand("mvn install", "linux");
                    System.out.println("\n" + command);
                    break;

                case ("test"):
                    command = RemoteShell.executeCommand("mvn test", "linux");
                    System.out.println("\n" + command);
                    break;
                
                case (":q"):
                case ("exit"):
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); 
                    break inputloop;
                
                default:
                    System.out.println("\n|  Incorrect command, try again!");
                    break;
                
            }
        }
        
    }

}

class RemoteShell {

    private static final Logger log = Logger.getLogger(RemoteShell.class.getName());

    public static String executeCommand(final String command, final String arg) throws IOException {

        final Vector<String> commands = new Vector<String>();        

        if (arg.contains("windows")) {
            commands.add("powershell");
            commands.add("-c");
        }
        else {
            commands.add("./src/main/java/pha/cli/repl/load.sh");
        }
        commands.add(command);

        BufferedReader bufferedReader = null;
        String logBuffer = "";

        try {
            
            final ProcessBuilder processBuilder = new ProcessBuilder(commands);
            final Process process = processBuilder.start();
            final InputStream inputStream = process.getInputStream();
            final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                logBuffer += line + "\n";
            }
              
        } catch (final IOException ioException){
            
            if(log.isLoggable(Level.FINEST)){
                log.finest("Erro ao executar o comando shell: " + ioException.getMessage()); 
            }
            ioException.printStackTrace();   
            
        } finally { secureClose(bufferedReader); }
         
        logBuffer = logBuffer.substring(0, logBuffer.length()-2);
        return logBuffer;
          
    }

    private static void secureClose(final Closeable source){
        try{
            if(source != null){
                source.close();
            }
        } catch (final IOException ioException){
            ioException.printStackTrace();
        }
    }
    
}

