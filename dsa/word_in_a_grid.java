//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; //offset values for the 8 directions in x-axis
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; //offset values for the 8 directions in y-axis
    
    public int[][] searchWord(char[][] grid, String word) {
        int rows = grid.length; //Number of rows in the grid
        
        int cols = grid[0].length; //Number of columns in the grid
        
        List<int[]> result = new ArrayList<>(); //List to store the result coordinates
        
        for (int i = 0; i < rows; i++) { //Loop through each row of the grid
        
            for (int j = 0; j < cols; j++) { // Loop through each column of the grid
            
                if (grid[i][j] == word.charAt(0)) { //if the current character matches the first character of the word
                
                    for (int dir = 0; dir < 8; dir++) { //looop through the 8 possible directions
                    
                        int x = i + dx[dir]; //calculate the new x-coordinate
                        
                        int y = j + dy[dir]; // calculate the new y-coordinate
                        
                        if (isValid(x, y, rows, cols) && searchDirection(grid, i, j, word, dir)) {
                            // If the new coordinates are valid and the word is found in the current direction
                            
                            result.add(new int[]{i, j}); // Add the starting coordinates to the result
                            
                            break;  // Break out of direction loop if found
                        }
                    }
                }
            }
        }
        
        int[][] ans = new int[result.size()][2]; // Convert the result list to a 2D array
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i)[0]; //Store the row coordinates in the answer array
            ans[i][1] = result.get(i)[1]; //Store the column coordinates in the answer array
        }
        
        return ans; // Return the final array - answer
    }
    
    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;//check if the given coordiates are withiin the grid boundaries
    }
    //{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; //offset values for the 8 directions in x-axis
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; //offset values for the 8 directions in y-axis
    
    public int[][] searchWord(char[][] grid, String word) {
        int rows = grid.length; //Number of rows in the grid
        
        int cols = grid[0].length; //Number of columns in the grid
        
        List<int[]> result = new ArrayList<>(); //List to store the result coordinates
        
        for (int i = 0; i < rows; i++) { //Loop through each row of the grid
        
            for (int j = 0; j < cols; j++) { // Loop through each column of the grid
            
                if (grid[i][j] == word.charAt(0)) { //if the current character matches the first character of the word
                
                    for (int dir = 0; dir < 8; dir++) { //looop through the 8 possible directions
                    
                        int x = i + dx[dir]; //calculate the new x-coordinate
                        
                        int y = j + dy[dir]; // calculate the new y-coordinate
                        
                        if (isValid(x, y, rows, cols) && searchDirection(grid, i, j, word, dir)) {
                            // If the new coordinates are valid and the word is found in the current direction
                            
                            result.add(new int[]{i, j}); // Add the starting coordinates to the result
                            
                            break;  // Break out of direction loop if found
                        }
                    }
                }
            }
        }
        
        int[][] ans = new int[result.size()][2]; // Convert the result list to a 2D array
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i)[0]; //Store the row coordinates in the answer array
            ans[i][1] = result.get(i)[1]; //Store the column coordinates in the answer array
        }
        
        return ans; // Return the final array - answer
    }
    
    private boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;//check if the given coordiates are withiin the grid boundaries
    }
    
    private boolean searchDirection(char[][] grid, int row, int col, String word, int dir) {
        int len = word.length();
        
        for (int k = 0; k < len; k++) {
            int x = row + k * dx[dir];
            int y = col + k * dy[dir];
            
            if (!isValid(x, y, grid.length, grid[0].length) || grid[x][y] != word.charAt(k)) {
                return false;
            }
        }
        
        return true;
    }
}

    private boolean searchDirection(char[][] grid, int row, int col, String word, int dir) {
        int len = word.length();
        
        for (int k = 0; k < len; k++) {
            int x = row + k * dx[dir];
            int y = col + k * dy[dir];
            
            if (!isValid(x, y, grid.length, grid[0].length) || grid[x][y] != word.charAt(k)) {
                return false;
            }
        }
        
        return true;
    }
}
