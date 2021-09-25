import java.util.*;

class week5 {
    static char vowels[] = {'A','E','I','O','U'};
    static int ret;
    static boolean flag = true;
    public int solution(String word) {
        int answer = 0;
        
        answer = dfs("",word,0);
    
        return answer;
    }
    static int dfs(String now, String word, int order){
        if(now.equals(word)) {
            flag = false;
            return order;
        }
        if(5 <= now.length()) return order;
        for(int i = 0; i < 5 && flag ; i++){
            // System.out.println(now+vowels[i] + " " + order + flag);
            order = dfs(now + vowels[i], word, order+1);
        }
        return order;
    }
}
