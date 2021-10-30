import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> jewels = new HashSet<String>();
        for(String jewel : gems) jewels.add(jewel);
        
        // 처리
        int size = jewels.size(); // 보석의 갯수
        int length = gems.length; // 진열장 길이
        int start = 0 , end = 0, minStart = 0, minEnd=0; //투 포인터 사용
        boolean firstHit = false; // 보석을 모든 포함하는 경우가 처음 등장했는가?
        boolean visit[] = new boolean[length]; // 구간 끝을 가르키는 포인터의 방문 여부 - 중복 저장을 막기 위함
        Map temp = new HashMap<String, Integer>(); // 현재 구간에서 각 보석들이 얼만큼씩 있는지 관리
        
        while( end < length){ //모든 범위를 다 볼 때까지 - 그런데 start < length가 만족 안하면 틀려야 하는거 아닌가..? 
            if(!visit[end]) { // end 위치를 처음 방문할 때만 보석 갯수 기록 start <= end 뺀다면?
                int val = 1;
                if(temp.containsKey(gems[end])) val = (int)temp.get(gems[end])+1; //기록이 있다면 갯수를 올려줌 
                temp.put(gems[end], val);
                visit[end] = true;
            }
            if( temp.size() == size) { // start ~ end 구간이 모든 보석을 포함할 때
                //System.out.println(start + " " + end + " " + temp.size());
                if( !firstHit ){ // 보석을 모두 포함하는게 처음인 경우 아묻따 갱신
                    minEnd = end;
                    minStart =start;
                    firstHit = true;
                } 
                else if(end - start < minEnd - minStart){ // 보석을 모두 포함하는게 처음이 아니면서 기존 구간보다 짧은 구간일 경우 갱신
                  //  System.out.println(start + " " + end + " " + (end-start));
                    minEnd = end;
                    minStart = start;
                }
                // 앞에 포인터를 한 칸 뒤로 옮겨 구간을 줄임 -> 보석도 다시 내려놔야 함 -> 갯수 줄이기
                int val = (int)temp.get(gems[start]);
                if(val == 1 ) temp.remove(gems[start]);
                else temp.put(gems[start], val-1);
              // System.out.println(gems[start] + " "+ val + " " + temp.size());
                start++;
            }
            // 구간 내에 모든 보석을 포함할 수 없을 때 뒤에 있는 포인터를 뒤로 옮긴다.
            else end++;
        }
        int[] answer = new int[2]; //정답 담기
        answer[0] = minStart+1;
        answer[1] = minEnd+1;
        return answer;
    }
}
