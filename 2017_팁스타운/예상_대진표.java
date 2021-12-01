class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int num = (int)baseLog(n,2); //로그로 지수 구하기
        int start = 1, gap = n/2, start2 = 1 + n/2;
        int end = start2 - 1 , end2 = n;
        while( 1 < num ){ // 서로 다른 구간 속할 때까지 끝이 나지 않는다면
            if( start <= a && a <= end
              && start <= b && b <= end){ //a, b가 앞 구간에 속한다면
                end2 = end;
                start2 = start + gap/2;
                end = start2 - 1;
            } else if(start2 <= a && a <= end2 
              && start2 <= b && b <= end2){ // a, b가 뒷구간에 속한다면
                start = start2;
                start2 = start2 + gap/2;
                end = start2 - 1;
            } else { //a, b가 서로 다른 구간일 때
                answer = num;   
                break;
            }
            gap /= 2;
            num--;
        }
        return answer;
    }
    static double baseLog(double x, double base) {

        return Math.log(x) / Math.log(base);

    }

}
