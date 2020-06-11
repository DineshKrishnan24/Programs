/*

Two City Scheduling
Question:

There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

Note:

1) 1 <= costs.length <= 100
2) It is guaranteed that costs.length is even.
3) 1 <= costs[i][0], costs[i][1] <= 1000

*/

class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs,(cost1,cost2)->{if(cost1[0]-cost1[1] > cost2[0]-cost2[1])
                                                return 1;
                                         else 
                                            return -1;});
        int len = costs.length,sum=0;
        for(int i=0;i<len;i++)
        {
            
            if(i<len/2)
                sum += costs[i][0];
            else
                sum += costs[i][1];
        }   
        return sum;
    }
}