#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue< int, vector<int>, greater<int> > pq;

    for(int sco : scoville)
        pq.push(sco);

    for(int i= 0 ; i < scoville.size() ; i++)
    {
        int lowest = pq.top();
        if(lowest < K ) 
        {
            if(i == scoville.size() - 1) return -1;
            pq.pop();
            int lower = pq.top();
            pq.pop();
            pq.push(lowest + lower*2);
            answer++;
        }
        else 
            return answer;
    }
    answer = -1;
    return answer;
}

