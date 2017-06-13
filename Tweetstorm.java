import java.util.List;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.Stack;
import java.io.File;
import java.io.IOException;

public class Tweetstorm {

	/**
	 * The object that will save all the lines of the input file in the main class.
	 */
	static List<String> textData;

	/**
	 * Index of the tweetstorm.
	 */
	static int index = 1;

	/**
	 * Main method.
	 * @see Reader
	 * @return void
	 */
	public static void main(String args[]){
		if(args.length > 0) {
            File file = new File(args[0]);
            Reader reader = new Reader(file);

            try{
				reader.readFile();
				textData = Arrays.asList(reader.getTextData());
				display();
			}
			catch(IOException e){
				e.printStackTrace();
			}
        }
        else{
        	System.out.println("You forgot to provide a file, don't you?"); // Notice the user of the missing input file
        	// TODO: Add an easter egg after the message
        }
	}

	/**
	 * If a string is invalid (is bigger than 140 characters), then tokenize it into smaller
	 * strings so they can be used later.
	 * @param String
	 * @return String[]
	 */
	public static String[] tokenizeInvalid(String text){
		StringTokenizer st = new StringTokenizer(text, ".");
		String[] tokenizedText = new String[st.countTokens()];

		int i = 0;
		while(st.hasMoreElements()){
			tokenizedText[i] = st.nextElement().toString();
			i++;
		}

		return tokenizedText;
	}

	/**
	 * Display each one of the comments of the tweetstorm in console.
	 * @return void
	 * @see tokenizeInvalid()
	 */
	public static void display(){
        Stack<String> stack = new Stack<String>(); 
        stack.addAll(textData);

        // Extra String Array if a sentence is too large
        String[] auxTextData = null;

        String text = "";

        while(!stack.empty()){

        	text = stack.pop(); // Save what it was taken from the stack into a variable

        	if(text.length() <= 140){
        		// Avoid unwanted spaces
        		if(text.startsWith(" ")){
        			text = text.substring(1);
        		}
				// Print if is equal or less of 140 characters
				System.out.println(index + "/ " + text);
				index++;
			}
			else{
				auxTextData = tokenizeInvalid(text);

				// Save everything to the stack to show it later
				for(int i=0;i<auxTextData.length;i++){
					stack.push(auxTextData[i] + ".");
				}
			}
        }
	}
}