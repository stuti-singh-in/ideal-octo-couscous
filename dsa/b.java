//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        
        int start = 0, end = 0;
        int currSum = arr[0]; // Initialize the current sum with the first element
        
        for (int i = 1; i <= n; i++) { // Iterate over the array
            // Remove elements from the start if the current sum exceeds s
            while (currSum > s && start < i - 1) {
                currSum -= arr[start]; // Subtract the element at start index
                start++; // Move the start index
            }
            
            if (currSum == s) {
                end = i - 1; // Update the end index
                break; // Exit the loop
            }
            
            // Add the current element to the current sum
            if (i < n) {
                currSum += arr[i];
            }
        }
        
        if (currSum != s) {
            result.add(-1); // If no subarray found, add -1 to the result
        } else {
            result.add(start + 1); // Add start index + 1 (for 1-based indexing)
            result.add(end + 1); // Add end index + 1 (for 1-based indexing)
        }
        
        return result; // Return the result ArrayList
    }
    
}
