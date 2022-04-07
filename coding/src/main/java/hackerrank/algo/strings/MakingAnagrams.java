package hackerrank.algo.strings;

public class MakingAnagrams {

    public static void main(String[] args){
        String s1 ="cde";
        String s2 = "abc";
        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for(int i =0;i < first.length;i++){
            a1[first[i]-'a'] = a1[first[i]-'a']+1;
        }
        for(int i =0;i < second.length;i++){
            a2[second[i]-'a'] = a2[second[i]-'a']+1;
        }
        int count = 0;
        for(int i= 0;i<26;i++){
            count += Math.abs(a1[i]-a2[i]);
        }
        System.out.println(count);
    }

}
