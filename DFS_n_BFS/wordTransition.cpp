#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> path;
int compare(string a, string b)
{
    int count = 0;
    for( int i= 0; i < a.size() ; i++)
        if(a[i] != b[i]) count++;
    return count;
}
void dfs(string target, string word, vector<string> words, int depth, vector<int> visited){
    for( int i= 0; i < words.size(); i++)
    {   
        if(visited[i] == 0 && (compare(word, words[i]) == 1))
        {   
            //여기서 depth increase하면 안 된다.
            if(!words[i].compare(target))
            {
                path.push_back(depth+1);
                return ;  
            }
            else{
                visited[i] = 1;
                dfs(target,words[i], words, depth+1, visited);
            } 
        }
    }
}
int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    int depth = 0;
    vector<int> visited(words.size(),0);
    dfs(target, begin, words, depth, visited);
    if(path.size() > 0 ) 
        answer = *min_element(path.begin(),path.end());
    return answer;
}
