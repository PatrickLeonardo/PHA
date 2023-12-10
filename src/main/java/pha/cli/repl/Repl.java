package pha.cli.repl;

public class Repl {

    public static void main(final String[] args) {
         
        System.out.println("|  Welcome to PHAShell -- Version 1.0");
        System.out.println("|  For an introduction type: /help intro\n");

        while(true) {

            final String input = System.console().readLine("phashell> ");
            
            if(input.equals("ping")) {
                System.out.println("pong");
            } else {
                System.out.println(input);
            }

        }

    }

}
