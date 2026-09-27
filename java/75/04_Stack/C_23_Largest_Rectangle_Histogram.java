//https://leetcode.com/problems/largest-rectangle-in-histogram/description/

import java.util.Stack;

class C_23_Largest_Rectangle_Histogram {
    public static void main(String[] args) {
        
        int[] heights = {2, 1, 5, 6, 2, 3};

        BruteForceSolution bruteForceSolution = new BruteForceSolution();
        int maxAreaBruteForce = bruteForceSolution.largestRectangleArea(heights);
        System.out.println("Max Area (Brute Force): " + maxAreaBruteForce);

        MonotonicStack monotonicStack = new MonotonicStack();
        int maxAreaMonotonicStack = monotonicStack.largestRectangleArea(heights);
        System.out.println("Max Area (Monotonic Stack): " + maxAreaMonotonicStack);

    }
}

/*
 * Start with height = heights[i]
 * Move right
 * Keep updating the minimum height
 * Calculate area
 * 
 */

class BruteForceSolution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int minHeight = heights[i];

            for (int j = i; j < n; j++) {

                minHeight = Math.min(minHeight, heights[j]);

                int width = j - i + 1;

                int area = minHeight * width;

                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}

/*
 * Nearest Smaller Element on Left
 * Nearest Smaller Element on Right
 * 
 * 
 * Remember this sentence:
 * "For every bar, find how far it can extend left and right."
 * 
 * And to find that:
 * "Use an increasing Monotonic Stack."
 */

class MonotonicStack {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }
        return maxArea;

    }
}
