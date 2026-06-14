public class DefangingIp {
    public static void main(String[] args) {
        
    }

    public String defangIPaddr(String address) {
        char[] ch = address.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i=0; i < ch.length; i++){
            if(ch[i] == '.'){
                result = result.append("[.]");
            }
            else{
                result = result.append(ch[i]);
            }
        }
        return result.toString();
    }
}
