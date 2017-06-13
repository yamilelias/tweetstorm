import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

/**
 * A class that read files.
 *
 * @author Yamil Elías
 * @see java.io.FileReader
 * @see java.io.BufferedReader
 * @see java.io.File
 */
public class Reader{

	/**
	 * File being read.
	 */
	private File file;

	/**
	 * String array that will save what is read.
	 */
	private String[] textData = null;

	/**
	 * @param File
	 */
	public Reader(File file){
		this.file = file;
	}

	/**
	 * @param File
	 * @return void
	 */
	public void setFile(File file){
		this.file = file;
	}

	/**
	 * @return File
	 */
	public File getFile(){
		return this.file;
	}

	/**
	 * @return String[]
	 */
	public String[] getTextData(){
		return this.textData;
	}

	/**
	 * This method reads the file only and save the content to its private textData.
	 * @throws IOException
	 * @return void
	 */
	public void readFile() throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		int lines = readLines(file);

		textData = new String[lines];

		for(int i=0; i < lines; i++){
			textData[i] = br.readLine();
		}
	}

	/**
	 * Private method to read the lines in the file and then returns the total of them.
	 * @throws IOException
	 * @return int
	 */
	private int readLines(File file) throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		int lines = 0;
		String line = "";
		while ((line = reader.readLine()) != null) lines++;
		reader.close();

		return lines;
	}
}