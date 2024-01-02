package pha.cli.repl;

public class Repl {

    public static void main(final String[] args) {
    
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("|  Welcome to PHAShell -- Version 1.0 (" + System.getProperty("os.name") + ")");
        System.out.println("|  For an introduction type: /help intro\n");
        
        while (true) {
            
            final String input = System.console().readLine("phashell> ");
            
            if (input.equals("ping")) {
                System.out.println("pong");
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println(input);
            }
            
        }

    }

}
