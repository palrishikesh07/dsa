//https://www.geeksforgeeks.org/problems/power-set4302/1
public class PowerSet_Lexicographical {
    public static void main(String[] args) {
        
    }
}



class Solution1 {
    public List<String> AllPossibleStrings(String s) {

        int n = s.length();
        List<String> ans = new ArrayList<>();

        // Generate all non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            StringBuilder str = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    str.append(s.charAt(j));
                }
            }

            ans.add(str.toString());
        }

        Collections.sort(ans);
        return ans;
    }
}



import java.util.*;

class Solution {

    public List<String> AllPossibleStrings(String s) {

        List<String> ans = new ArrayList<>();

        solve(0, s, new StringBuilder(), ans);

        Collections.sort(ans);

        return ans;
    }

    private void solve(int index, String s, StringBuilder curr, List<String> ans) {

        if (index == s.length()) {
            if (curr.length() > 0)
                ans.add(curr.toString());
            return;
        }

        // Include current character
        curr.append(s.charAt(index));
        solve(index + 1, s, curr, ans);

        // Backtrack
        curr.deleteCharAt(curr.length() - 1);

        // Exclude current character
        solve(index + 1, s, curr, ans);
    }
}