import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Reader{

	private File file;
	private String[] textData = null;

	public Reader(File file){
		this.file = file;
	}

	public void setFile(File file){
		this.file = file;
	}

	public File getFile(){
		return file;
	}

	public String[] getTextData(){
		return textData;
	}

	public void readFile() throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		int lines = readLines(file);

		String[] textData = new String[lines];

		for(int i=0; i < lines; i++){
			textData[i] = br.readLine();
			//System.out.println(textData[i]);
		}
	}

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