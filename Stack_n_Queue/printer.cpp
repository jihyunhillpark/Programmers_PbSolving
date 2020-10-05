#include <string>
#include <vector>

using namespace std;

int solution(vector<int> priorities, int location) {
    vector<int> idx;
    int answer = 0;

    for(int i = 0 ; i < priorities.size() ; i++)
        idx.push_back(i);

    while(true)
    {
        int j = 0;
        int current = idx[0], current_p = priorities[0];
        idx.erase(idx.begin());
        priorities.erase(priorities.begin());

        for( ; j < priorities.size() ; j++)
            if( current_p < priorities[j]) break;


        if( j < priorities.size())
        {
            priorities.push_back(current_p);
            idx.push_back(current);
        }
        else
        {
            answer++;
            if( location == current) break;   
        }
    }
    return answer;
}
