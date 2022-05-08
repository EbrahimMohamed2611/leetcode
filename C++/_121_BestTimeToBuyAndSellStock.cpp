#include <iostream>
#include <vector>
#include <cstdlib>
using namespace std;

// Using bruteForce
/*
Input: prices = [7,1,5,3,6,4]
Output: 5
*/
int maxProfit(vector<int> &prices)
{
    int maxProfit = 0;

    for (int i = 0; i < prices.size(); i++)
    {
        int currentMaxProfit = 0;
        /* code */
        for (int j = i + 1; j < prices.size(); j++)
        {
            /* code */
            if (prices[j] > prices[i])
            {
                currentMaxProfit = (prices[j] - prices[i]);
                if (currentMaxProfit > maxProfit)
                    maxProfit = currentMaxProfit;
            }
        }
    }

    return maxProfit;
}

// Using Two Pointers ( Flixble Sliding window) ==> O(N)
/*
Input: prices = [7,1,5,3,6,4]
Output: 5
*/
int maxProfit2(vector<int> &prices)
{
    int maxProfit = 0, currentMaxProfit = 0;
    int sellPointer = 0, buyPointer = 0;
    // should sellPointer > buyPointer
    //  sell =====> then buy
    while (buyPointer < prices.size())
    {
        /* code */
        if (prices[sellPointer] > prices[buyPointer])
        {
            sellPointer = buyPointer;
        }
        else
        {
            currentMaxProfit = prices[buyPointer] - prices[sellPointer];
            if (currentMaxProfit > maxProfit)
                maxProfit = currentMaxProfit;
        }
        buyPointer++;
    }

    return maxProfit;
}

int main()
{
    cout << "121. Best Time to Buy and Sell Stock" << endl;
    vector<int> vect1{7, 1, 5, 3, 6, 4};
    cout << maxProfit(vect1) << endl;
    vector<int> vect2{7, 6, 4, 3, 1};
    cout << maxProfit(vect2) << endl;

    cout << "121. Best Time to Buy and Sell Stock" << endl;
    cout << maxProfit2(vect1) << endl;
    cout << maxProfit2(vect2) << endl;
    return 1;
}