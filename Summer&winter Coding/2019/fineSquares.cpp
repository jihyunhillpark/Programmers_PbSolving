using namespace std;

long long euclideanGCD(long long a, long long b)
{
    long long ret;
    while(b)
    {
        ret = a%b;
        a = b;
        b = ret;
    } 
    return a;
}

long long solution(int w,int h) {
    long long answer = 1;
    long long rec = (long)w*h;
    long long gcd = euclideanGCD(w,h);
    answer = rec - (w+h-gcd);
    return answer;
}
