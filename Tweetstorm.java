import java.util.StringTokenizer;

public class Tweetstorm {
	public static void main(String args[]){
		if(args.length > 0) {
            File file = new File(args[0]);
            Reader reader = new Reader(file);
        }
        else{
        	System.out.println("You forgot to provide a file, don't you?");
        }
	}
}