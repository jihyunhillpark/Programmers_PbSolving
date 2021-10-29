class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = sizes[0][0];
        int maxH = sizes[0][1];
        for(int i =1 ; i < sizes.length; i++){
            System.out.println(sizes.length);
            int w = sizes[i][0];
            int h = sizes[i][1];
            if( w <= maxW && h <= maxH) continue;
            if( h <= maxW && w <= maxH) continue;
            else {
                // 입력 그대로 비교
                int tempW = Math.max(maxW, w);
                int tempH = Math.max(maxH,h);
                // w, h 바꿔서 비교
                int tempW2 = Math.max(maxW, h);
                int tempH2 = Math.max(maxH, w);
                if( tempW + tempH > tempW2 + tempH2){
                    tempW = tempW2;
                    tempH = tempH2;
                }
                maxW = tempW;
                maxH = tempH;
            }
        }
        answer = maxW * maxH;
        return answer;
    }
}
