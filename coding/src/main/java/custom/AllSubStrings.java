package custom;

import java.util.ArrayList;
import java.util.HashMap;

public class AllSubStrings {

    static ArrayList<String> st = new ArrayList<>();

    public static void main(String[] args){
        String test = "abcd";
        int len = 1;
        for(;len<=test.length();){
           getAll(test,len);
           len++;
        }
        System.out.println(st.size());
    }

    public static void getAll(String test, int len){
        int i = 0;
        int j = i+len;
        for(;j<=test.length();){
            st.add(test.substring(i,j));
            i++;
            j++;
        }
    }

}
