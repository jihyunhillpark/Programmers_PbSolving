class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE, limit = s.length();
        for(int num = 1; num <= limit/2 + 1 ; num++){
            String pre = s.substring(0,num);
            String cur = "";
            String zipped = ""; 
            int count = 1, to = 0;
            for(int start = num; start < limit ; start+= num){
                to = (start + num < limit)? start + num : limit;
                cur = s.substring(start, to);
                if(cur.equals(pre)) count++;
                else{
                    if( 1 < count ) {
                        zipped += count + pre;
                    }
                    else zipped += pre;
                    count = 1;
                    pre = cur;
                }
            }
            if( 1 < count ) {
                zipped += count + pre;
            }
            else zipped += pre;
            if( zipped.length() < answer ) answer = zipped.length(); 
        }
        return answer;
    }
}
