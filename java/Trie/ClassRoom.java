public class ClassRoom {

    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26]; // from a to z

            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }

            eow = false;
        }

    }

    static Node root = new Node(); // Main root

    public static void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                // Add new node
                curr.children[idx] = new Node();
            }

            if (i == word.length() - 1) {
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    public static boolean search(String key) {
        Node curr = root;

        for (int i = 0; i < key.length(); i++) { // O(L) L = key length
            int idx = key.charAt(i) - 'a';

            Node node = curr.children[idx];

            if (node == null) {
                return false;
            }
            if (i == key.length() - 1 && node.eow == false) {
                return false;
            }
            curr = node;
        }
        return true;
    }

    // public static void main(String[] args) {
    // String words[] = {"the","a","ther","their","any"};
    // for(int i=0;i < words.length; i++){
    // insert(words[i]);
    // }

    // System.out.println(search("their")); // true
    // System.out.println(search("thor")); //false
    // System.out.println(search("an")); // false

    // }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secPart = key.substring(i);

            if (search(firstPart) && wordBreak(secPart)) {
                return true;
            }
        }
        return false;
    }

    // public static void main(String[] args) {

    //     String words[] = { "i", "like", "sam", "samsung", "phone" };
    //     String key = "ilikephonesam";


    //     for (int i = 0; i < words.length; i++) {
    //         insert(words[i]);
    //     }

    //     System.out.println(wordBreak(key));
    // }


    public static boolean startWith(String prefix){
        Node curr = root;

        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }

    //  public static void main(String[] args) {

    //     String words[] = { "apple", "app", "mango", "man", "woman" };
    //     String preFix = "go";


    //     for (int i = 0; i < words.length; i++) {
    //         insert(words[i]);
    //     }
       
    //     System.out.println(startWith(preFix));
    // }


    public static int countNode(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;

        for(int i=0; i< 26; i++){
            if(root.children[i] != null){
                count += countNode(root.children[i]);
            }
        }

        return count+1;
    }


    //  public static void main(String[] args) {
    //     String str = "apple";

    //     for(int i=0; i< str.length(); i++){
    //         String suffix = str.substring(i);
    //         System.out.println(suffix);
    //         insert(suffix);
    //     }

    //     System.out.println(countNode(root));
    // }

    // Longest word with all prefix


    public static String ans = "";

    public static void longestWord(Node root,StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i=0;i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()){
                    ans  = temp.toString();
                }
                longestWord(root.children[i], temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }


    }

     public static void main(String[] args) {
        String[] words = {"a","banana","app","ap", "appl","apple","apply"};

        for(int i=0; i< words.length; i++){
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));

        System.out.println(ans);
    }


}
