import java.util.Iterator;
import java.util.ArrayList;
public class ReviewIterator implements Iterator<String>{
    private boolean skipping;
    private String[] comment;
    private ArrayList<String> SuspiciousWords = new ArrayList<String>(){
        {add("veritas"); add("moribus"); add("inmaturitas"); add("malignus");}
    };
    private int CurrentLoc = 0;
    public ReviewIterator(boolean f, String r){
        skipping = f;
        comment = r.split(" ");
    }
    public boolean hasNext(){
        boolean hasNext = false;
        if(CurrentLoc < comment.length){
            hasNext = true;
        }
        return hasNext;
    }
    public String next(){
        String next;
        if(skipping == false) {
            next = comment[CurrentLoc];
            CurrentLoc++;
        }
        else{
            if(SuspiciousWords.contains(comment[CurrentLoc])){
                next = comment[CurrentLoc + 1];
                CurrentLoc += 2;
            }
            else{
                next = comment[CurrentLoc];
                CurrentLoc++;
            }
        }
        return next;
    }
    public void remove(){
        throw new UnsupportedOperationException();
    }
}