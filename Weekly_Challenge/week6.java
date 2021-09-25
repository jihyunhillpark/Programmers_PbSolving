import java.util.*;
class week6 {
    class Boxer implements Comparable<Boxer> {
        float winRate;
        int winCount;
        int weight;
        int index;
        
        public Boxer(float winRate, int winCount, int weight, int index){
            this.winRate = winRate;
            this.winCount = winCount;
            this.weight = weight;
            this.index = index;
        }
        @Override
        public int compareTo(Boxer boxer){
            if( boxer.winRate == this.winRate){
                if( boxer.winCount == this.winCount){
                    if( boxer.weight == this.weight){
                        return this.index - boxer.index;
                    }
                    return boxer.weight - this.weight;
                }
                return boxer.winCount - this.winCount;
            }
            return (boxer.winRate - this.winRate < 0)? -1:1;
        }
        
    }
    public int[] solution(int[] weights, String[] head2head) {
        Boxer boxers[] = new Boxer[head2head.length];
        for(int i = 0 ; i < head2head.length ; i++){
            int win = 0, lose = 0, winGreater = 0;
            float rate = 0;
            for(int j = 0; j < head2head[i].length() ; j++){
                if(head2head[i].charAt(j) == 'W'){
                    win++;
                    if( weights[i] < weights[j] ) winGreater++;
                } 
                else if(head2head[i].charAt(j) == 'L') lose++;
            }
            if((win+lose) != 0) rate = (float)win/(win+lose);
            boxers[i] = new Boxer(rate, winGreater, weights[i], i); 
        }
        Arrays.sort(boxers);
        int[] answer = new int[boxers.length];
        for(int i = 0 ; i < boxers.length ; i++){
            answer[i] = boxers[i].index+1;
        }
        return answer;
    }
}
