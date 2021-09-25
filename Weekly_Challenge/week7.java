class week7 {
    public int[] solution(int[] enter, int[] leave) {
        int answer[] = new int[leave.length];
        int leaveIdx[] = new int[leave.length];
        for(int i = 0; i < leave.length; i++){ //enter[i] 에 해당하는 애가 몇번째로 떠나는지 leaveIdx[i]에 기록
            for(int j= 0 ; j < leave.length;j++){
                if(leave[j] == enter[i]) leaveIdx[i] = j;
            }
        }

        for(int i = 0 ; i < enter.length; i++){
            for(int j = i+1 ; j < leave.length; j++){
                if(leaveIdx[i] > leaveIdx[j]){ // 나중에 들어온 비교 대상이 먼저 나가는 경우
                    answer[enter[i]-1]++;
                    answer[enter[j]-1]++;
                }
                else{ // 비교 대상이 나중에 나가는 경우
                    for(int k = enter.length-1; j < k; k--){
                        if(leaveIdx[i] > leaveIdx[k]){
                            answer[enter[i]-1]++;
                            answer[enter[j]-1]++;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}