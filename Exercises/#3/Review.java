
public class Review implements Iterable<String>{
	private String username;
	private int rating;
	private String comment;
	
	Review(String u, int r, String c){
		username = u;
		rating = r;
		comment = c;
	}
	
	public String getUsername(){
		return username;
	}
	public int getRating(){
		return rating;
	}
	public int getCommentSize(){
		String[] tmp = comment.split(" ");
		return tmp.length;
	}
	public String getCommentWord(int N){
		String[] tmp = comment.split(" ");
		return tmp[N];
	}
	public ReviewIterator iterator(){
		ReviewIterator tmp = new ReviewIterator(false, comment);
		return tmp;
	}
	public ReviewIterator iterator(boolean SSW){
		ReviewIterator tmp = new ReviewIterator(SSW, comment);
		return tmp;
	}
}