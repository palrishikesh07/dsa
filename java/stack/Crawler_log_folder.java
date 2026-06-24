import java.util.Stack;

//https://leetcode.com/problems/crawler-log-folder/
public class Crawler_log_folder {
    public static void main(String[] args) {
        int result = minOperations(new String[] { "d1/", "d2/", "../", "d21/", "./" });
        // int result = minOperations(new String[] { "d1/", "d2/", "./", "d3/", "../",
        // "d31/" });
        System.out.println(result);

    }

    public static int minOperations(String[] logs) {

        Stack<String> st = new Stack<>();

        for (int index = 0; index < logs.length; index++) {
            if (logs[index].equals("./"))
                continue;
            else if (logs[index].equals("../")) {

                if (!st.isEmpty()) {
                    st.pop();
                }

            } else {
                st.add(logs[index]);
            }
        }

        return st.size();
    }
}
