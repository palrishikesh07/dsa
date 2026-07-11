//https://leetcode.com/problems/sort-colors/description/
public class Sort_colors {
 
    public static void main(String[] args) {
        
    }

    public static void sortColors(int[] nums) {

        int zero = 0, one = 0, two = 0;

        for(int num:nums){
            if(num == 0 ) zero++;
            else if(num == 1) one++;
            else two++;
        }
        int i=0;
        while (zero >0) {
            nums[i]= 0;
            zero--;
            i++;
        }
        while (one >0) {
            nums[i]= 1;
            one--;
            i++;
        }
        while (two >0) {
            nums[i]= 2;
            two--;
            i++;
        }
        
    }
}




class Solution {
    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;

            } else if (nums[mid] == 1) {

                mid++;

            } else {

                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }
}

/*

Memory Trick

Remember:

0 → Left
1 → Middle
2 → Right
Three Pointer Rule
low  -> where next 0 goes

mid  -> current element

high -> where next 2 goes
What to do?
If current is 0
Swap(low, mid)

low++
mid++
If current is 1
Just move

mid++
If current is 2
Swap(mid, high)

high--

❌ Don't increment mid.

Because after swapping, a new number comes to mid and needs to be checked.

Dry Run

Input

2 0 2 1 1 0

L
M
          H
Step 1

Current = 2

Swap with High

0 0 2 1 1 2

H--

Current = 0

Swap with Low

0 0 2 1 1 2

L++
M++

Current = 0

Swap

0 0 2 1 1 2

L++
M++

Current = 2

Swap with High

0 0 1 1 2 2

H--

Current = 1

M++

Done.

Interview Trick (10 Seconds)

Just remember:

0 -> swap with low

1 -> move mid

2 -> swap with high

That's the entire algorithm.

Interview Answer

If the interviewer asks "Which algorithm is this?"

Answer:

Dutch National Flag Algorithm, using three pointers (low, mid, high) to partition the array into three regions (0s, 1s, and 2s) in one pass.

Complexity
Time: O(n) (single pass)
Space: O(1)

*/