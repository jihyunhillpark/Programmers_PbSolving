#include <string>
#include <vector>
#include <math>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int yellow_sqrt = (int)sqrt((float)yellow);

    for(int i =  yellow_sqrt; 0 < i ; i--)
    {
        if((yellow%i) == 0)
        {  
            int y_width = yellow/i;
            int y_height = i;
            if(((y_width + 2)*2 + y_height*2) == brown){
                answer.push_back(y_width + 2);
                answer.push_back(y_height+ 2);
            }
        }
    }
    return answer;
}
