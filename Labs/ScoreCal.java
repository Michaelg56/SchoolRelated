import java.util.Scanner;
public class ScoreCal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNumber = sc.nextInt();
        double score = sc.nextInt();
        double weightedScore = 0;
        switch (testNumber) {
            case 1:
                weightedScore = score * 0.1;
                break;

            case 2:
                weightedScore = score * 0.15;
                break;

            case 3:
                weightedScore = score * 0.15;
                break;

            case 4:
                weightedScore = score * 0.1;
                break;

            case 5:
                weightedScore = score * 0.5;
                break;

            default:
                weightedScore = 0;
                break;
        }
        System.out.print("Your weighted Score: " + weightedScore);
    }
}