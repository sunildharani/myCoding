package sorting;

public class MergeSort {

    public static void main(String[] args){
        int[] arr = new int[]{4,1,3,9,7};
        mergeSort(arr,0,arr.length-1);
        for(int i =0; i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    static void merge(int arr[], int l, int m, int r)
    {
        int[] a = new int[m-l+1];
        int[] b = new int[r-m];
        for(int i= l,j=0;i<=m;i++,j++){
            a[j] = arr[i];
        }
        for(int i= m+1,j=0;i<=r;i++,j++){
            b[j] = arr[i];
        }
        int j = l;
        int k = 0;
        int i = 0;
        while(i< a.length && k < b.length){
            if(a[i] < b[k]){
                arr[j] = a[i];
                i++;
            }else{
                arr[j] = b[k];
                k++;
            }
            j++;
        }
        while(i< a.length){
            arr[j] = a[i];
            i++;
            j++;
        }
        while(k< b.length){
            arr[j] = b[k];
            k++;
            j++;
        }

    }
    static void mergeSort(int arr[], int l, int r)
    {
        if(l >= r){
            return;
        }

        int mid = l+(r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
}
