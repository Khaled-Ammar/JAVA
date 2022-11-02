import java.util.*;
public class seconde {

    static int findSecondLargest(int a[], int n) {

        Arrays.sort(a);

        int secondlargest = 0;
        for (int i = n - 2; i >= 0; i--){
            if (a[i] != a[n - 1])
            {
                secondlargest = a[i];
                break;
            }
        }
        return secondlargest;
    }

    public static void main(String[] args) {
        int a[] = {3,4,5,6,100,200};
        int n = a.length;
        int answer = findSecondLargest(a, n);

        System.out.println("The second largest num in the array is: " + answer);

    }
}
