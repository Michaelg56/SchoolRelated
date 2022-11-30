import java.io.File;
import java.util.Iterator;
public class RateMyTeacher{
	private static File input_file;
	public static void main(String[] args){
		// validation needs to be completed 
		File input_file = new File("reviews.File");
		ReviewList list = new ReviewList(input_file);
		// prints all reviews and all their words without skipping anything
		System.out.println("all reviews with out skipping with a for Loop");
		for (Review r : list) {
			for (String s : r) {
				System.out.println(s);
			}
		}
		System.out.println("**********************");
		// prints all reviews and all their words without skipping anything. Same as above.
		System.out.println("all reviews with out skipping with a while Loop");
		for (Review r : list){
			Iterator it = r.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
		System.out.println("**********************");
		// skips the suspicious reviews and prints all the words in the non-suspicious reviews
		System.out.println("all reviews with skipping with a for Loop");
		Iterator it = list.iterator(true);
		while(it.hasNext()){
			Review r = (Review) it.next();
			for(String s : r){
				System.out.println(s);
			}
		}
		System.out.println("**********************");
		// skips the suspicious reviews and the suspicious words in the non-suspicious reviews
		System.out.println("all reviews with skipping with a while Loop");
		Iterator it1 = list.iterator(true);
		while(it1.hasNext()) {
			Review r = (Review) it1.next();
			Iterator it2 = r.iterator(true);
			while(it2.hasNext()) {
				System.out.println(it2.next());
			}
		}
		System.out.println("**********************");
	}
}