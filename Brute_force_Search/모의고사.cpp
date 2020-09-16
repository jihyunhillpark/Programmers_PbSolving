#include <string>
#include <vector>
#include <algorithm>
// #include <utility>

using namespace std;

bool compare(pair<int, int> a,pair<int, int> b){
    if(a.second == b.second){
        return a.first < b.first;
    }else{
        return a.second > b.second;
    }
}
vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> std1{1,2,3,4,5};
    vector<int> std2{2,1,2,3,2,4,2,5};
    vector<int> std3{3,3,1,1,2,2,4,4,5,5};
    vector<pair<int, int>> score(3);
    
    for(int i = 0; i<3; i++){
        score[i] = make_pair(i,0);
    }
    
    for(int i = 0; i < answers.size(); i++){
        if(std1[i%5] == answers[i]) score[0].second++;
        if(std2[i%8] == answers[i]) score[1].second++;
        if(std3[i%10] == answers[i]) score[2].second++;
    }
    sort(score.begin(),score.end(),compare);
    
    if(score[0].second > score[1].second)
    {
        answer.push_back(score[0].first + 1);
    }
    else if(score[0].second == score[1].second)
    {
        answer.push_back(score[0].first + 1);
        answer.push_back(score[1].first + 1);
        if(score[1].second == score[2].second)
            answer.push_back(score[2].first + 1);
    }
    
    
    return answer;
}
