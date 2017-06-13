
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Testing {

	static List<String> textData;
	static int index = 1;

	public static void main(String[] args) {
		if(args.length > 0) {
			File file = new File(args[0]);
            Reader reader = new Reader(file);

			try{
				reader.readFile();
				textData = Arrays.asList(reader.getTextData());
				//Stack<String> stack = reader.getTextData();
				stacker();
				//appender();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		else{
			//tokenizeInvalid();
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

	public static void appender(){
		// Used if needed to divide a sentence.
		String[] auxTextData = null;

		Iterator<String> iterator = textData.iterator();

		while (iterator.hasNext()) {

			String text = iterator.next();

			if(auxTextData != null){
				// Save the rest for the other line
				// TODO: Check what happens with more than 2 tokens...
				text = auxTextData[1] + ". " + text;
				auxTextData = null;
			}

			if(text.length() <= 140){
				// Print if is equal or less of 140 characters
				System.out.println(index + "/ " + text);
				index++;
			}
			else{
				//System.out.println("Not valid...");
				auxTextData = tokenizeInvalid(text);

				// Print the first element (leave the rest for the other index)
				System.out.println(index + "/ " + auxTextData[0] + ".");
				index++;
			}
		}
	}

	public static void stacker(){
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