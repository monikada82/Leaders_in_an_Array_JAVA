import java.util.*;
/*Identify "leader" elements in an array, where a leader is an element greater than or equal to all elements to its right*/
public class Leaders_in_an_Array {

    public static List<Integer> nextLeader(int[]arr, int n){
       List<Integer>ans=new ArrayList<>();
       int rightmost=arr[n-1];
       ans.add(rightmost);
       for(int i=n-2;i>=0;i--){
           if(arr[i]>rightmost){
               ans.add(arr[i]);
               rightmost=arr[i];

           }
       }
       Collections.reverse(ans);
       return ans;

    }
    public static void main(String args[]){

        int n=6;//size of array
        int arr[]={16,17,4,3,5,2};

        List<Integer>ans=nextLeader(arr,n);
        System.out.print(ans);

    }
}
