import java.util.*;

class Solution {
    static boolean visit[];
    static HashSet<Integer> edges[];
    public int solution(int n, int[][] wires) {
        int answer = 100;
        visit = new boolean[n+1];
        edges = new HashSet[n+1];  
        
        // 트리 만들기
        for(int i = 0 ; i <= n ; i++) edges[i] = new HashSet<>();
        for(int[] wire : wires){
            edges[wire[0]].add(wire[1]);
            edges[wire[1]].add(wire[0]);
        }
        // 처리
        for(int i = 0 ; i < n-1 ; i++){
            int abs = 100, ct1 = 0, ct2 = 0;
            // 기지국 트리 순회 - 와이어 제거 반영
            edges[wires[i][0]].remove(wires[i][1]);
            edges[wires[i][1]].remove(wires[i][0]);
            int temp = 0;
            boolean hit = false;
            for(int node = 1; node <= n ; node++){
                if( !visit[node] ){ // 처음 방문하는 기지국이라면
                    visit[node] = true;
                    temp = dfs(node, 1); // 방문하기 (기지국 갯수)
                    if(!hit) {
                        ct1 = temp;
                        hit = true;
                    }
                    else ct2 = temp;
                }
            }
            Arrays.fill(visit,false);
            edges[wires[i][0]].add(wires[i][1]);
            edges[wires[i][1]].add(wires[i][0]);
            abs = Math.abs(ct1 - ct2); 
            answer = ( abs < answer )? abs : answer;
        }
        return answer;
    }
    static int dfs(int nodeNum, int count){
        for(int num : edges[nodeNum] ){
            if( !visit[num]){
                visit[num] = true;
                count = dfs(num, count+1);
            }
        }
        return count;
    }
}
