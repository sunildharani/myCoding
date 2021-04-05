package leetcode.arrays;

public class TwoNumbersTarget {

	public static void main(String[] args) {
		int[] numbers = new int[] {2,7,11,15};
		int target = 9;
		int i =0;
        int j = numbers.length-1;
        int sum = numbers[i]+numbers[j];
        while(sum != target){
            if(sum > target){
                j--;
            }else{
                i++;
            }
            if(i ==j) {
            	break;
            }
            sum = numbers[i]+numbers[j];
        }
        System.out.println(i);
        System.out.println(j);

	}

}
