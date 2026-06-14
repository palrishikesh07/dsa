
public class Vowel {
    public static void main(String[] args) {
        String str = "OpenAI1234@!";
        checkValidVowel(str);
    }
    public static void checkValidVowel(String str){
        String vowel = new String("aeiouAEIOS");
        String specialChar = "!@#$%^&*()";
        String digit = "1234567890";
        int vowelCount = 0;
        int spcialCharCount = 0;
        int digitCount = 0;
        int constantCount = 0;
        
        char[] arr = str.toCharArray();
        for(int i=0; i< arr.length; i++){
            if(vowel.contains(String.valueOf(arr[i]))){
                vowelCount++;
            }
            else if(specialChar.contains(String.valueOf(arr[i]))){
                spcialCharCount++;
            }
            else if(digit.contains(String.valueOf(arr[i]))){
                digitCount++;
            }
            else{
                constantCount++;
            }
        }

        System.out.println("VowelCount: "+vowelCount);
        System.out.println("spcialCharCount: "+spcialCharCount);
        System.out.println("digitCount: "+digitCount);
        System.out.println("constantCount: "+constantCount);
    }


    public static void checkValidVowel(String str) {

    Set<Character> vowels = Set.of(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
    );

    int vowelCount = 0;
    int consonantCount = 0;
    int digitCount = 0;
    int specialCharCount = 0;

    for (char ch : str.toCharArray()) {

        if (Character.isWhitespace(ch)) {
            continue;
        }

        if (vowels.contains(ch)) {
            vowelCount++;
        } else if (Character.isDigit(ch)) {
            digitCount++;
        } else if (Character.isLetter(ch)) {
            consonantCount++;
        } else {
            specialCharCount++;
        }
    }

    System.out.println("Vowel Count      : " + vowelCount);
    System.out.println("Consonant Count  : " + consonantCount);
    System.out.println("Digit Count      : " + digitCount);
    System.out.println("Special Count    : " + specialCharCount);
}
}
