
//HashSet

import java.util.HashSet;

public class C_02_Contains_Duplicate {

    public static void main(String[] args) {

        int nums[] = {1,2,3,1};
        // BruteForceApproach bruteForceApproach = new BruteForceApproach();
        // boolean isDuplicate = bruteForceApproach.containDuplicate(nums);
        // System.out.println(isDuplicate ? "Duplicate found" : "No duplicate found");

        HashSetApproach hashSetApproach= new HashSetApproach();
        boolean isDuplicate = hashSetApproach.containDuplicate(nums);
        System.out.println(isDuplicate ? "Duplicate found" : "No duplicate found");


        
    }
}


class BruteForceApproach{


    public boolean containDuplicate(int[] nums){
        int n = nums.length;

        for(int i=0;i <n; i++){
            
            for(int j=i+1; j<n;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return  false;

    }
}


class HashSetApproach{
    public boolean containDuplicate(int[] nums){
        int n= nums.length;

        HashSet<Integer> set= new HashSet<>();

        for(int i=0;i<n;i++){
            if(set.contains(nums[i])){
                return  true;
            }
            set.add(nums[i]);
        }

        return  false;
    }
}

