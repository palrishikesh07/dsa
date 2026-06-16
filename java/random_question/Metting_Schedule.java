import java.util.Arrays;

public class Metting_Schedule {
    public static void main(String[] args) {
        int[][] metting1 = {{1,3},{4,6},{7,8}};
        int[][] metting2 = {{1,4},{2,5},{6,8}};
        boolean everythingFine = isMettingOk(metting2);
        System.out.println("everythingFine: "+everythingFine);
    }


    public static boolean isMettingOk(int[][] meeting){

        Arrays.sort(meeting, (a,b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < meeting.length; i++) {
            if(meeting[i][0] < meeting[i-1][1]){
                return false;
            }
        }
        return true;
    }
}
