package hackerrank.algo.strings;

public class CommonChild {
    public static void main(String[] args){
        String s1 = "AB";
        String s2 = "B";
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int[][] ans = new int[s1.length()][s2.length()];
        char loc = a1[0];
        int k =0;
        while(k < a2.length && loc != a2[k]){
            ans[0][k] = 0;
            k++;
        }
        while(k < a2.length){
            ans[0][k] = 1;
            k++;
        }

        for(int i=1; i< a1.length;i++){
            char local = a1[i];
            int j =0;
            while(j < a2.length && local != a2[j]){
                ans[i][j] = ans[i - 1][j];
                j++;
            }
            while(j < a2.length) {
                if (j > 0) {
                    ans[i][j] = ans[i - 1][j - 1] + 1;
                } else {
                    ans[i][j] = 1;
                }
                j++;
                while (j < a2.length && local != a2[j]) {
                    ans[i][j] = Math.max(ans[i][j - 1],ans[i - 1][j]);
                    j++;
                }
            }
        }
        System.out.println(ans[a1.length-1][a2.length-1]);
    }

}
