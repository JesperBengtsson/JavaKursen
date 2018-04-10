public class CommandHandler {

    public void countWords (String sentence) {
        int words = 0;
        for(int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            char prevChar = ' ';
            if(i - 1 >= 0) {
                prevChar = sentence.charAt(i - 1);
            }
            if(currentChar != ' ' && prevChar == ' ') {
                words += 1;
            }
        }
        System.out.println("words: " + words);
    }
    public void countCharacters (String sentence) {
    	int counter = 0;
    	for (int i = 0; i< sentence.length(); i++) {
            char c = sentence.charAt(i);
            	if (Character.isLetter(c)) {
            	counter++;
            	}
    	}
        System.out.println("Characters: " + counter);

    }

}