package java_Revision;
public class AverageOfArray {
	public static void main(String[] args) {  
        
        int [] arr = {1, 2, 3, 4, 5};  
        int sum = 0;  
        float avg=0;
       
        for (int i = 0; i < arr.length; i++) {  
           sum = sum + arr[i];  
           avg=sum/(arr.length);
        }  
        System.out.println("Sum of all the elements of an array: " + sum);  
        System.out.println("Average of Array:"+avg);
	}  
}