
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Testing {
	public static void main(String[] args) {
		if(args.length > 0) {
			File file = new File(args[0]);

			try{
				fileReader(file);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		else{
			tokenizer();
		}
	}

	public static void tokenizer(){
		String str = "This is String , split by StringTokenizer, created by mkyong";
		StringTokenizer st = new StringTokenizer(str);

		System.out.println("---- Split by space ------");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}

		System.out.println("---- Split by comma ',' ------");
		StringTokenizer st2 = new StringTokenizer(str, ",");

		while (st2.hasMoreElements()) {
			System.out.println(st2.nextElement());
		}
	}

	public static void fileReader(File file) throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		int lines = readLines(file);

		String[] textData = new String[lines];

		for(int i=0; i < lines; i++){
			textData[i] = br.readLine();
			System.out.println(textData[i]);
		}

		br.close();
	}

	public static int readLines(File file) throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		int lines = 0;
		String line = "";
		while ((line = reader.readLine()) != null) lines++;
		reader.close();

		return lines;
	}
}