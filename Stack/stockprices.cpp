#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    answer.resize(prices.size(),0);

    for(int i = 0; i < prices.size() ; i++)
    {
        int basis = prices[i];
        for(int j = i+1  ; j < prices.size(); j++)
        {
            if( basis <= prices[j] ) answer[i]++;
            else{
                answer[i]++;
                break;
            }
        }
    }

    return answer;
}
