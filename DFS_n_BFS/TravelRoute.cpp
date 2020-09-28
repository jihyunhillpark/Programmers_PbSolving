#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<vector<string> > paths;

bool compare(const vector<string> a, const vector<string> b){
    if(a[0] == b[0]) return a[1] < b[1];
    else return a[0] < b[0];
}

void dfs(string begin,vector<vector<string>> tickets, vector<int> visit,vector<string> path, int depth)
{
    for(int i = 0; i < tickets.size() ; i++)
    {
        if(visit[i] == 0 && begin.compare(tickets[i].at(0)) == 0)
        {
            visit[i] = 1;
            path.push_back(tickets[i].at(0));
            if(depth == tickets.size()-1 ){
                path.push_back(tickets[i][1]);
                paths.push_back(path);
                return;
            }
            else{
                dfs(tickets[i][1], tickets, visit, path, depth+1);
            }
            visit[i] = 0;
            path.pop_back();
        }
    }
}    
vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    vector<string> path;
    vector<int> visit(tickets.size(), 0);
    sort(tickets.begin(), tickets.end(), compare);
    int depth = 0;

    // for(vector<string> a: tickets)
    //     cout << "\[" + a[0] + " " + a[1] +"\]" << endl;
    dfs("ICN", tickets, visit, path, depth);
    cout << paths.size() << endl;
    return answer=paths[0];
}
