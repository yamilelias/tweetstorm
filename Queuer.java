import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Queuer class. This will handle all the queue logic that is needed in order to print the tweets for a tweetstorm.
 * @author Yamil Elías <yamileliassoto@gmail.com>
 * @version 0.0.1
 */
public class Queuer{

	/**
	 * Index of the tweetstorm.
	 */
	int index = 1;

	/**
	 * Display each one of the comments of the tweetstorm in console.
	 * @return void
	 * @see tokenizeInvalid()
	 */
	public void tweetQueue(Queue queue){

        String text = "";
        Display display = new ConsoleDisplayer(); // Select a display

        while (!queue.isEmpty()){
        	text = queue.remove().toString(); // Take out from queue

        	if(text.length() <= 140){
        		display.tweet(index, text); // Tweet! (if is equal or less of 140 characters, obviously)
        		index++;
        	}
        	else{
        		String[] tokenizer = tokenizeInvalid(text);

        		// Recursive method to print all tokens made from text
        		tweetQueue(arrayToQueue(tokenizer));
        	}
        }
	}

	/**
	 * Transform a string array into a valid queue.
	 * @return java.util.Queue;
	 */
	public Queue arrayToQueue(String[] array){
		Queue<String> queue = new LinkedList<String>();

		for(int i=0; i<array.length; i++){
			queue.add(array[i]);
		}

		return queue;
	}

	/**
	 * If a string is invalid (is bigger than 140 characters), then tokenize it into smaller
	 * strings so they can be used later.
	 * @param String
	 * @return String[]
	 */
	private String[] tokenizeInvalid(String text){
		StringTokenizer st = new StringTokenizer(text, ".");
		String[] tokenizedText = new String[st.countTokens()];

		int i = 0;
		while(st.hasMoreElements()){
			tokenizedText[i] = st.nextElement().toString();
			i++;
		}

		return tokenizedText;
	}
}