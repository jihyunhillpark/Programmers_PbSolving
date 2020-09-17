
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
38
39
40
41
42
43
44
45
46
47
48
49
50
51
52
53
54
55
56
57
58
59
60
61
62
63
64
65
66
67
#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int solution(string numbers) {
    int answer = 0;
    int cnt[10] = {0,};

    sort(numbers.begin(), numbers.end(), greater<int>());
    int max = stoi(numbers);

    for(int i=0 ; i < numbers.size(); i++)
        cnt[numbers[i]-'0']++;

    for(int i=0 ; 6*i-1 <= max ; i++)
    {
        if(i==0)
        {
            if(cnt[2] > 0) answer++;
            if(cnt[3] > 0) answer++;
        }
        else 
        {
            int less_prime = 6*i - 1;
            int more_prime = 6*i + 1;
            int cnt_for_prime1[10] = {0,};
            int cnt_for_prime2[10] = {0,};
            int j;

            while(less_prime > 0){
                int number1 = less_prime%10;
                int number2 = more_prime%10;
                less_prime/=10;
                more_prime/=10;
                cnt_for_prime1[number1]++;
                cnt_for_prime2[number2]++;
            }


            for(j = 0; j < 10; j++)
            {
                int k = 2;
                for(k; k <= (int)sqrt(6*i - 1) ; k++){
                     if((6*i - 1)%k == 0) break;
                }
                if(k <= (int)sqrt(6*i - 1)|| cnt_for_prime1[j] > cnt[j]) break;
            }
            if(j == 10 )
                answer++;

            for(j = 0; j < 10; j++)
            {   int k = 2;
                for(k; k <= (int)sqrt(6*i + 1) ; k++){
                     if((6*i + 1)%k == 0) break;
                }
                if(k <= (int)sqrt(6*i + 1) || cnt_for_prime2[j] > cnt[j]) break;
            }
            if(j == 10)
                answer++;
        }
    }
    return answer;
}

