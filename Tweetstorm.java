import java.util.List;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.Stack;
import java.io.File;
import java.io.IOException;

public class Tweetstorm {

	static List<String> textData;
	static int index = 1;

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
        	System.out.println("You forgot to provide a file, don't you?");
        }
	}

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

	public static void display(){
        Stack<String> stack = new Stack<String>(); 
        stack.addAll(textData);
        String[] auxTextData = null;

        String text = "";

        while(!stack.empty()){

        	text = stack.pop();

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