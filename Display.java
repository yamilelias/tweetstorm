/**
 * Display interface, so we have a common display that the Queuer will be able to call to tweet its texts.
 * @author Yamil Elías <yamileliassoto@gmail.com>
 * @version 0.0.1
 */
public interface Display{
	/**
	 * Public method that will tweet out what it receives as a parameter with its index.
	 */
	public void tweet(int index, String text);
}