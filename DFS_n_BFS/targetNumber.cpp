#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<int> numbers, int target) {
    int answer = 0;
	int level = 0;
    int value = 0;
    int size = numbers.size();

    //vector<int> groups(0, size); 
    stack< pair<int,int> > s; 


    s.push(make_pair(value,level));

    while(!s.empty()){

        int value = s.top().first;
        int level = s.top().second;


        s.pop();
        if(level < numbers.size())
        {
            //cout << "TEST valus:" << value << endl;
            s.push(make_pair(value-numbers[level], level+1));
            s.push(make_pair(value+numbers[level], level+1));
        }
        else{
            if(value == target) answer++;
        }
    }
    return answer;
}
