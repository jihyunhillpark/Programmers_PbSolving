import java.io.BufferedReader;

public class Solution {

    public static void main(String[] args) {
        testSolution("...!@BaT#*..y.abcdefghijklm");
        testSolution("z-+.^.");
        testSolution("=.=");
        testSolution("123_.def");
        testSolution("abcdefghijklmn.p");
    }
    public static String testSolution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase(); //1단계
        new_id = new_id.replaceAll("[^0-9a-z.\\-_]",""); //2단계
        new_id = new_id.replaceAll("[.]+",".");//3단계
        if(0 < new_id.length() && new_id.charAt(0) == '.'){
            new_id = new_id.substring(1,new_id.length());// 4-1 단계
        }
        if(0 < new_id.length() && new_id.charAt(new_id.length()-1) == '.')
            new_id = new_id.substring(0,new_id.length()-1);
        if(new_id.length() == 0) new_id+='a';//5단계

        if(16 <= new_id.length()) new_id = new_id.substring(0,15);//6단계
        if(0 < new_id.length() && new_id.charAt(new_id.length()-1) == '.')
            new_id = new_id.substring(0,new_id.length()-1);

        if(new_id.length() <= 2){ //7단계
            char ad = new_id.charAt(new_id.length()-1);
            while(new_id.length()<3)  new_id+=ad;
        }

        System.out.println(new_id);
        return answer;
    }
}
