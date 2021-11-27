import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 초기화 및 전처리
        int[] answer = new int[enroll.length];
        Map<String, Integer> nameMap = new HashMap<>();
        for(int i = 0 ; i < enroll.length ; i++)
            nameMap.put(enroll[i], i );

        // 처리
        for(int i = 0 ; i < seller.length ; i++){
            int q = 100 * amount[i];
            String name = seller[i];
            int idx = 0;
            do{
                idx = nameMap.get(name);
                int next = (int)Math.floor(q/10);
                answer[idx] += q - next;
                name = referral[idx];
                q = next;
            }while(!name.equals("-") && 0 < q);
        }

        return answer;
    }
}
