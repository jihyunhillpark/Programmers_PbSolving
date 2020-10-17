#include <string>
#include <vector>

#define DOWN 0
#define RIGHT 1
#define UP 2
using namespace std;

vector<vector<int>> temp;
int bottom_line;
int up_line = 0;
int state = DOWN;
int unit = 0;
int sum = 0;

void fill(int depth, int num){
    int round = unit/3;
    if(num == sum+1 ) return;
    if(state == DOWN){ //내려가는 길일 경우
        temp[depth].insert(temp[depth].begin()+round, num);  
        if(depth == bottom_line){
            unit++;
            state = RIGHT;
        } 
        else depth++; //한 층 더 내려간다
        num++;
    }
    else if(state == RIGHT) //옆으로 가기
    {   
        int size = temp[depth].size();
        for(int i = 0 ; i <= depth - size ; i++, num++)
            temp[depth].insert(temp[depth].begin()+(round+1)+i, num);  
        unit++;
        state = UP;
        bottom_line--;
        depth--;
    }
    else{   //올라가는 길일 경우 - 문제가 많았던...
        temp[depth].insert(temp[depth].end()-round, num);  //뒤에서부터 넣기 
        if( temp[depth].size()-1 == depth){ // 다채워진 경우
            state = DOWN;
            up_line++;
            depth++;
            unit++;
        } 
        else{
            depth--; 
        }
        num++;
    }

    fill(depth, num); 
}
int total_sum(int n){
    int sum = 0;
    for(int i = 1 ; i<=n ; i++) sum += i;
    return sum;
}
vector<int> solution(int n) {
    vector<int> answer;
    temp.resize(n);
    bottom_line = n-1;
    sum = total_sum(n);

    fill(0,1);

    for(int i=0 ; i < temp.size(); i++) 
        answer.insert(answer.end(),temp[i].begin(), temp[i].end());
    return answer;
}
