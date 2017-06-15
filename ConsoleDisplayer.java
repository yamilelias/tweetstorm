/**
 * ConsoleDisplayer class. Implements Display to show the tweets, in this case, on console.
 * @author Yamil Elías <yamileliassoto@gmail.com>
 * @version 0.0.1
 * @see Display
 */
public class ConsoleDisplayer implements Display{

	/**
	 * Implements Display method tweet
	 */
	public void tweet(int index, String text){
		// Avoid unwanted spaces
		if(text.startsWith(" ")){
			text = text.substring(1);
		}

		// If it doesn't end with a dot
		if(!text.endsWith(".")){
			text += ".";
		}

		System.out.println(index + "/ " + text);
	}
}