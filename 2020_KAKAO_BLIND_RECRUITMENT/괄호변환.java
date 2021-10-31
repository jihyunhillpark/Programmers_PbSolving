import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        answer = fix(p);
        return answer;
    }
    static String fix(String input) {
        // System.out.println(input + " " + input.length());
        if(input.length() == 0) return input; //빈 문자열이면 반환
        int leftCnt = 0, rightCnt = 0, idx = 0;
        while(idx < input.length()){
            if(input.charAt(idx) == '(') leftCnt++;
            else rightCnt++;
            if( leftCnt == rightCnt) break; 
            idx++;
        }
        String u = (idx < input.length())? input.substring(0,idx+1) : input.substring(0,idx) ;
        String v = (idx < input.length())? input.substring(idx+1) : "";

        if(isAllright(u)) return u + fix(v);
        // 올바른 문자열이 아닌 경우
        String temp = "(" + fix(v) + ")";
        String latter = (2 < u.length())? upsideDown(u.substring(1,u.length()-1)) : "";
        return temp + latter;
    }
    static String upsideDown(String u) {
        String temp = "";
        int idx = 0, size = u.length();
        while(idx < size) {
            if( u.charAt(idx) == '(') temp+=")";
            else temp += "(";
            idx++;
        }
        return temp;
    }
    static boolean isAllright(String u){
        Stack stack = new Stack<Character>();
        int idx = 0, size = u.length();
        while(idx < size){
            if( u.charAt(idx) == '(') stack.push('(');
            else if( !stack.isEmpty()){
                stack.pop();
            }
            idx++;
        }
        if( stack.isEmpty()) return true;
        return false;
    }
}
