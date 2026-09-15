//Unique paths and Manuvering a cave

//Mathematical or combinaorics solution
class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;
        int totalSteps = m + n - 2;
        int downSteps = m - 1;
        
        for (int i = 1; i <= downSteps; i++) {
            res = res * (totalSteps - downSteps + i) / i;
        }
        
        return (int) res;
    }
}


//Optimized Space Approach
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}

//Dynamic Programming Approach
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Fill the first row and first column with 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

//BackTracking Soluton (Not Optimal)
class Solution {
    private int count = 0;

    public int uniquePaths(int m, int n) {
        backtrack(0, 0, m, n);
        return count;
    }

    private void backtrack(int i, int j, int m, int n) {
        // Base case: reached bottom-right corner
        if (i == m - 1 && j == n - 1) {
            count++;
            return;
        }

        // Move Down
        if (i + 1 < m) {
            backtrack(i + 1, j, m, n);
        }

        // Move Right
        if (j + 1 < n) {
            backtrack(i, j + 1, m, n);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(3, 3)); // Output: 6
    }
}
