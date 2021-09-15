import java.util.*;
class Solution {
    static char[] target;
    static Map<String, Integer> newMenu;
    static int max=0;
    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> result = new PriorityQueue<>();
        for(int i = 0 ; i < course.length ; i++){ // 최대 10
            newMenu = new HashMap<>(); // 메뉴이름, 조합 가능한 회원수
            max=0;
            for(int j = 0 ; j < orders.length ; j++){ //최대 20
                int ret[] = new int[course[i]];
                target = orders[j].toCharArray();
                Arrays.sort(target);
                comb(ret, orders[j].length(), course[i], 0 , 0);
            } 
            Iterator<String> keys = newMenu.keySet().iterator();
            while(keys.hasNext()){
                String key = keys.next();
                if(newMenu.get(key) == max) result.add(key);
            }
            newMenu.clear();
        }
        String[] answer = new String[result.size()];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = result.poll();
        }
        return answer;
    }
    public static void comb(int[] ret, int n, int r, int index, int pos){
        if(r == 0){
            String newM = "";
            int temp = 0;
            for(int i : ret)
                newM += target[i];
            if( !newMenu.containsKey(newM)) {
                newMenu.put(newM, 0);
                temp++;
            }
            else {
                temp =newMenu.get(newM)+1;
                newMenu.put(newM, temp);
            }
            if(max< temp) max = temp;
            return ;
        }else if( n <= index) return;
        ret[pos] = index; //어차피 선택 안하면 덮여 쓰여짐
        comb(ret, n, r-1, index + 1, pos+1); //선택한 경우
        comb(ret, n, r, index + 1, pos); //선택하지 않은 경우 
    }
}
