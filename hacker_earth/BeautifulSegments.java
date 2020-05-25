import java.io.*;
import java.util.*;

/* 

Question :

You are given an array A of length N. 
You have to output the total number of beautiful segments in the given array .
Beautiful segment  is a contiguous subarray of odd length L (L >= 3) of an array,
such that the sequence of numbers from first element(inclusive) 
to middle element(inclusive) is non decreasing and the sequence of numbers from middle element(inclusive)
 to last element (inclusive) is strictly decreasing.

e.g. "1 2 3 3 0 -1 -2", "1 2 3 2 1" are beautiful segments but "1 2 3 3 5", "1 2 3 3 3" are not.

Note that beautiful segments can overlap. Also one beautiful segment can lie completely inside other one.

Input Format:
First line of input will contain a number T denoting number of test cases.Each test case will consist of 
two lines. First line of each test case will contain a number N denoting number of elements in the array.
Second line will contain N space seperated integers denoting the elements of the array.

Output Format:
Output T lines, one for each test case, denoting the total number of beautiful segments in the array of
 the corresponding testcase.

Constraints:
1 <= T <= 20
0 <= n <= 500
-1000000 <= A[i] <= 1000000
 

SAMPLE INPUT 
4
4
1 2 1 4
3
1 1 1
5
1 2 1 2 1
5
1 2 3 2 1
SAMPLE OUTPUT 
1
0
2
2


*/

class TestClass {
    public static void main(String args[] ) throws Exception {

        Reader reader = new Reader();
        int t = reader.nextInt();
        while(t-->0) {
            int n = reader.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = reader.nextInt();
            }
            int subSize = 3,count=0;
            while(subSize <= arr.length) {
                for(int i=0;i+subSize<=n;i++) {
                    if(check(Arrays.copyOfRange(arr,i,i+subSize))) {
                        count++;
                    } 
                }
                subSize += 2;
            }
            System.out.println(count);
        }
    }

    static boolean check(int[] arr) {
        int len = arr.length;
        for(int i=0;i<len;i++) {
            if(i==len/2)
                continue;
            if(i<len/2) {
                if(arr[i] > arr[i+1])
                    return false;
            } else {
                if(arr[i-1] <= arr[i])
                    return false;
            }
        }
        return true;
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;
        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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
