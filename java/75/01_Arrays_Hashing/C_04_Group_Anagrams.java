import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class C_04_Group_Anagrams {
    
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        BruteForceApproach bruteForceApproach = new BruteForceApproach();
        List<List<String>> result = bruteForceApproach.groupAnagrams(strs);
        System.out.println(result);

        // HashMapApproach hashMapApproach = new HashMapApproach();
        // List<List<String>> result = hashMapApproach.groupAnagrams(strs);
        // System.out.println(result);
    }

    
}

//  Character Counting 
class BruteForceApproach{
    
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>(); // List of strings for each unique character count key

        for(String str : strs){
            int[] count = new int[26]; // Get the count of each character in the string 

            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }

            System.out.println("Count array for string \"" + str + "\": " + Arrays.toString(count));

            StringBuilder sb = new StringBuilder(); // Generate a unique key based on the character counts
            for(int i = 0; i < 26; i++){
                sb.append('#');
                sb.append(count[i]);
            }

            System.out.println("Key for string \"" + str + "\": " + sb.toString());
            String key = sb.toString(); // Convert the StringBuilder to a String to use as a key in the map, east or tea will have same key from alphabet wiese
            
            System.out.println("key: " + key);
            // System.out.println("Current map: " + map);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>()); // Create a new list for this key if it doesn't exist
            }
            map.get(key).add(str); // Add the original string to the list corresponding to this key
        }
        System.out.println("Final map: " + map);
        return new ArrayList<>(map.values());   
    }
}



class HashMapApproach{
    
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>(); // List of strings for each unique character count key

        for(String str : strs){
            char[] charArray = str.toCharArray();
            System.out.println("Char array for string \"" + str + "\": " + Arrays.toString(charArray));

            Arrays.sort(charArray); // Sort the characters in the string
            String key = new String(charArray); // Use the sorted string as a key

            System.out.println("Key for string \"" + str + "\": " + key);
            System.out.println("Current map: " + map);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>()); // Create a new list for this key if it doesn't exist
            }
            map.get(key).add(str); // Add the original string to the list corresponding to this key
        }
        return new ArrayList<>(map.values());   
    }
}