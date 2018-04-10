
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        CommandHandler ch = new CommandHandler();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
        String WORDS, CHARS, EXIT, BACK, BOTH;
        EXIT = "EXIT";
        WORDS = "A";
        CHARS = "B";
        BACK = "BACK";
        BOTH = "C";

        String command = "";

        while(!command.equals(EXIT)) {
            System.out.println("Count words or chars? A for words, B for chars or C for both.\nTYPE EXIT TO EXIT");
            command = reader.readLine();
            if(command.equals(WORDS)) {
                System.out.println("Type a sentence to count words.\nTYPE BACK TO GO BACK");
                command = reader.readLine();
                if(command.equals(BACK)) {
                    continue;
                }
                ch.countWords(command);
            }
            else if (command.equals(CHARS)) {
                System.out.println("Type a sentence to count characters.\nTYPE BACK TO GO BACK");
                command = reader.readLine();
                if(command.equals(BACK)) {
                    continue;
                }
                ch.countCharacters(command);
            }
            else if (command.equals(BOTH)) {
                System.out.println("Type a sentence to count words and characters.\nTYPE BACK TO GO BACK");
                command = reader.readLine();
                if (command.equals(BACK)) {
                    continue;
                }
                ch.countWords(command);
                ch.countCharacters(command);
            }
        }
	}
}
