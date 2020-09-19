#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    int i, j,k;
    stack<int> s;
    // bool *visited = new bool[n];
    vector<bool> visited(n,false);
    int num = i = j = k = 0;

    for(k ; k < n ;) 
    {
        for(j = 0 ; j < n; j++)
        {
            if(computers[i][j] == 1 && !visited[j])
            {
                visited[j] = true;
                s.push(j);
            }
        }
        if(!s.empty())
        {
            i = s.top();
            s.pop();
            if(s.empty())
                answer++;
        }
        else
        {
            k++;
            i = k;
        } 
    }
    return answer;
}
