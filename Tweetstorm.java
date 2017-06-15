import java.io.File;
import java.io.IOException;
import java.util.Queue;

/**
 * Tweetstorm class. Main class to implement a tweetstorm.
 * @author Yamil Elías <yamileliassoto@gmail.com>
 * @version 0.0.1
 */
public class Tweetstorm {

	/**
	 * Main method.
	 * @see Reader
	 * @return void
	 */
	public static void main(String args[]){
		// Check for files passed
		if(args.length > 0) {
			// Read files
            File file = new File(args[0]);
            Reader reader = new Reader(file);
            Queuer queuer = new Queuer();

            try{
            	// Try to read it, if is not possible, throw Exception
				reader.readFile();

				// Get information ready
				String[] textData = reader.getTextData();
				Queue textDataQueue = queuer.arrayToQueue(textData);

				//Start tweeting!
				queuer.tweetQueue(textDataQueue);
			}
			catch(IOException e){
				System.out.println("You have an error in your file or it wasn't found. Check the error: \n");
				e.printStackTrace();
			}
        }
        else{
        	System.out.println("You forgot to provide a file, don't you? \nDon't worry, here is something better: \n\n"); // Notice the user of the missing input file
        	       	
        	File file = new File(".easter");
        	Reader reader = new Reader(file);

        	try{
            	// Try to read it, if is not possible, throw Exception
				reader.readFile();

				// Get information ready
				String[] textData = reader.getTextData();

				for(int i=0; i<textData.length;i++){
					System.out.println(textData[i]);
				}

				System.out.println("Enjoy it :)");
			}
			catch(IOException e){
				System.out.println("Wait... you did something to the .easter file, don't you? :(");
			}
        }
	}
}