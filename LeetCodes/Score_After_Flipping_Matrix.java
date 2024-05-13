/*
You are given an m x n binary matrix grid.
A move consists of choosing any row or column and toggling each value in that row or 
column (i.e., changing all 0's to 1's, and all 1's to 0's).

Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
Return the highest possible score after making any number of moves (including zero moves).

Example 1:
Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

Example 2:
Input: grid = [[0]]
Output: 1
 

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 20
grid[i][j] is either 0 or 1.
*/

// My solution : (beats 45%)
class Solution {
    public int matrixScore(int[][] grid) { 

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(j == 0 && grid[i][j] == 0){
                    toggleRow(i,grid);
                }
                else if(i ==0  && grid[i][j] == 0){
                    togglecoloum(j,grid);
                }
            }
        }

        for(int c=0; c<grid[0].length; c++){
            int count = 0;
            for(int i=0; i<grid.length; i++){ 
                if(grid[i][c] == 1){
                count++;
                }
            }
            if((double)count < (double)grid.length/2){
                togglecoloum(c,grid);
            }
        }

        int ans = 0;
        for(int i=0; i< grid.length; i++){
            int l = grid[i].length-1;
            int decimalNO = 0;
            for(int j=0; j<grid[i].length; j++){ 
                int bit = grid[i][l--];
                if(bit == 1){
                    decimalNO = decimalNO + (int)Math.pow(bit*2,j);
                }
            }
            ans = ans + decimalNO;
        }

        return ans;

    }
    private void toggleRow(int row, int[][] grid){
        for(int i=0; i<grid[row].length; i++){
            if(grid[row][i] == 0){
                grid[row][i] = 1;
            }
            else{
                grid[row][i] = 0;
            }
        }
    }
    private void togglecoloum(int coloum, int[][] grid){
        for(int i=0; i<grid.length; i++){
            if(grid[i][coloum] == 0){
                grid[i][coloum] = 1;
            }
            else{
                grid[i][coloum] = 0;
            }
        }
    }
}

// Optimized solution from solutions
class Solution {

    public int matrixScore(int[][] grid) {
        // We will be maximizing our left most column to gain max sum out of it
        // One function to toggle rows whenever we get 0 we will convert it to 1
        // One function to toggle columns whenever we get 0's count > 1's count will toggle the column
        // after flipping the values we will convert binary numbers into decimal and return the answer
       int ans = 0;
       int row = grid.length;
       int col = grid[0].length; 
       for(int i=0; i<row; i++){
           if(grid[i][0]==0){
               toggleRow(grid, i);
           }
       }
       for(int i=0; i<col; i++){
           int a=0, b=0;
           for(int j=0; j<row; j++){
               if(grid[j][i]==1){ // As we are checking for columns so 
                   a++;
               }
               else{
                   b++;
               }
           }
           if(a<b){
               toggleCol(grid, i);
           }
       }
       for(int i=0; i<grid.length; i++){
           ans+=bintodec(grid[i]);
       }
       return ans;
    }
    public void toggleRow(int[][] grid, int row){
        for(int i=0; i<grid[0].length; i++){
            if(grid[row][i] == 1){
                grid[row][i]=0;
            }
            else{
                grid[row][i] = 1;
            }
        }
    } 
    public void toggleCol(int[][] grid, int col){
        for(int i=0; i<grid.length; i++){
            if(grid[i][col] == 1){
                grid[i][col]=0;
            }
            else{
                grid[i][col] = 1;
            }
        }
    }
    public int bintodec(int[] arr){
        int dec = 0;
        for(int i=0; i<arr.length; i++){
            dec = dec*2+arr[i];
        }
        return dec; 
    }
    

}
