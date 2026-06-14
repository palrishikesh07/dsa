public class circular_rotation {
    public static void main(String[] args) {
     
        System.out.println(isCircularRotation("abcdefg", "fgabcde")); // true
        System.out.println(isCircularRotation("abcdefg", "fgabced")); // false
    }

    public static  boolean isCircularRotation(String s1,String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        return (s1+s1).contains(s2);
    }

}
