import java.util.*;

class week4 {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        HashMap<String, Integer> langValue = new HashMap<>();
        int maxJobIdx = 0;
        String[] jobs = new String[5];

        for(int i = 0; i < languages.length ; i++)
            langValue.put(languages[i], preference[i]);

        int sum = 0;
        for(int i = 0; i < table.length ; i++){
            String[] ret = table[i].split(" ");
            jobs[i] = ret[0];
            int temp = 0;
            for(int n = 1; n < ret.length ; n++){
                if( langValue.get(ret[n]) != null ){
                    temp += (5 - n + 1) * langValue.get(ret[n]);
                }
            } 
            if( temp > sum ){
                sum = temp;
                maxJobIdx = i;
            }
            else if( temp == sum && jobs[i].compareTo(jobs[maxJobIdx]) < 0 ){ 
                //사전순으로 더 앞선 것을 출력
                maxJobIdx = i;
            }
        }
        answer = jobs[maxJobIdx];
        return answer;

    }
}
