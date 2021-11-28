import java.util.*;
class Solution {
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,1,0,-1};
    public int[] solution(String[][] places) {
        Queue<int[]> people = new LinkedList<>();
        int[] answer = new int[5];
        boolean visit[][] = new boolean[5][5];

        for(int i = 0 ; i < 5 ; i++){
            // 전처리
            people.clear();
            int result = 1;
            for(int j = 0 ; j < 5 ; j++){
                for(int k = 0 ; k < 5 ; k++){
                    if(places[i][j].charAt(k) == 'P'){
                        people.add(new int[]{j,k});
                    }
                }
            }
            // 처리
            while(!people.isEmpty()){
                for(int ct = 0 ; ct < 5 ; ct++) Arrays.fill(visit[ct], false);
                int person[] = people.poll();
                visit[person[0]][person[1]] = true;
                if( !dfs(visit, places[i], person[0], person[1], 1)){
                    result = 0;
                    break;
                }
            }
            answer[i] = result;
        }
        return answer;
    }
    static boolean dfs(boolean[][] visit, String[] place, int i, int j, int dist){
        if( 2 < dist ) return true;
        boolean check = true;
        for(int ct = 0 ; ct < 4 ; ct ++){
            int newR = dr[ct] + i;
            int newC = dc[ct] + j;
            if( 0 <= newR && newR < 5 && 0 <= newC && newC < 5 && !visit[newR][newC]){
                visit[newR][newC] = true;
                if( place[newR].charAt(newC) == 'O') {
                    check = dfs(visit, place, newR, newC, dist + 1);
                }
                else if( place[newR].charAt(newC) == 'P'){
                    return false; 
                }
            }
            if(!check) return false;
        }
        return true;
    }
}
