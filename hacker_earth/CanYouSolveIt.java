
import java.util.*;
import java.io.*;

/*

Question:

Raman loves Mathematics a lot. One day his maths teacher gave him an interesting problem.

He was given an array 'A' consisting of 'n' integers, he was needed to find the maximum value of the following expression:

|Ai - Aj| + |i - j|

where, 0<= i,j <n and Ai, Aj are the Array elements.

Input:

First line of input contains an integer T denoting number of test cases.
Each test case contains two lines, first line contains integer n where n is the number of elements in array
Second line contains n space separated integers Ai.
Output:

Print the maximum value of the above give expression, for each test case separated in a new line.

Constraints:

1<=T<=100
1<=n<=105
0<=Ai<=105
Note: Use Fast I/O (scanf/printf or any other ways) to handle large test files.

SAMPLE INPUT 
2
3
1 1 1
4
1 2 3 1
SAMPLE OUTPUT 
2
4
Explanation
For the first sample case, if we choose i=0 and j=2; then we get the maximum value as 2.

In the second test case, if we choose i=0 and j=2, the we get the maximum value as 4.

*/


class CanYouSolveIt {
    public static void main(String args[] ) throws Exception {

        Reader s = new Reader(); // for faster reading Input operation
        int t = s.nextInt();
        while(t>0) {
            int n = s.nextInt();
            int min = Integer.MAX_VALUE ; int max = Integer.MIN_VALUE;
            int min1= Integer.MAX_VALUE ; int max1 = Integer.MIN_VALUE;
   	        for(int i=0;i<n;i++) {
   		        int x=s.nextInt();
   	            if((x+i)<min){
   	                min= x+i;
   	            }
                if((x+i)>max){
                    max= x+i;
                }
                if((x-i) > max1){
                    max1 = x-i;
                    
                }
                if((x-i)<min1){
                    min1 = x-i;
                }
   	        }
    
            System.out.println(Math.max((max-min),(max1-min1)));
            t--;
        }

    }

    static class Reader { 

        StringTokenizer st;
        BufferedReader bf;

        Reader() {
            this.bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
        while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(bf.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
}

}

