import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class ReviewList implements Iterable<Review>{
    private ArrayList<Review> Reviews = new ArrayList<>();
    public ReviewList(File f){
        try{
            Scanner sc = new Scanner(f);
            while(sc.hasNext()) {
                String username = sc.nextLine();
                int rating = sc.nextInt();
                String comment = sc.nextLine();
                Review tmp = new Review(username, rating, comment);
                Reviews.add(tmp);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Iterator iterator(){
        Iterator<Review> tmp = new Iterator<Review>(){
            private int CurrentLoc = 0;
            public boolean hasNext(){
                boolean hasIt = false;
                if(Reviews.size() > CurrentLoc){
                    hasIt = true;
                }
                return hasIt;
            }
            public Review next(){
                Review myR = Reviews.get(CurrentLoc);
                CurrentLoc++;
                return myR;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
        return tmp;
    }
    public Iterator iterator(boolean SSR){
        Iterator<Review> tmp;
        if(SSR == false){
            tmp = iterator();
        }
        else{
            tmp = new Iterator<Review>(){
                private int CurrentLoc = 0;
                private boolean SuS(Review r){
                    boolean isIt = false;
                    String comment = "";
                    if(r.getRating() == 5){
                        ReviewIterator myIt = r.iterator(true);
                        while(myIt.hasNext()){
                            comment += myIt.next() + " ";
                        }
                        if(comment.length() <= 10){
                            isIt = true;
                        }
                    }
                    return isIt;
                }
                public boolean hasNext(){
                    boolean hasIt = false;
                    if(Reviews.size() > CurrentLoc){
                        hasIt = true;
                    }
                    return hasIt;
                }
                public Review next(){
                    Review tmp = Reviews.get(CurrentLoc);
                    while(SuS(tmp)){
                        tmp = Reviews.get(CurrentLoc);
                        CurrentLoc++;
                    }
                    CurrentLoc++;
                    return tmp;
                }
                public void remove(){
                    throw new UnsupportedOperationException();
                }
            };
        }
        return tmp;
    }
}