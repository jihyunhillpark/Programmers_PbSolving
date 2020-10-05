#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> days;
    int cnt = 0, basis = 0;
    for(int i = 0 ; i < progresses.size(); i++)
    {
        if((100-progresses[i])%speeds[i] != 0)
            days.push_back((100-progresses[i])/speeds[i]+1);
        else
            days.push_back((100-progresses[i])/speeds[i]);
    }

    for(int i = 1 ; i < progresses.size(); i++)
    {
        cnt++;
        if( days[i] > days[basis]) 
        {
            answer.push_back(cnt);
            cnt = 0;
            basis = i;
        }
        if( i == progresses.size()-1) 
            answer.push_back(cnt+1);
    }
    return answer;
}
