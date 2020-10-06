#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    vector<int> order = {4,1,2};
    vector<int> nums;
    int div = 3;
    while(true)
    {
        int rem = n%div;
        if(div <= n){
            nums.push_back(order[rem/(div/3)]);
            if(rem == 0 ) n -= div;
            else n -= rem;
            div*=3;
        }
        else{
            if( n != 0) 
                nums.push_back(order[rem/(div/3)]);
            break;
        }
    }
    while(!nums.empty())
    {
        answer.append(to_string(nums.back()));
        nums.pop_back();
    }
    return answer;
}

