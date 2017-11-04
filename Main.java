import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Task 1 - define int array of 1s and 0s and change 1 by 0 and 0 by 1
        int[] ar = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        displayAr("Task 1.\nDefined array:", ar);
        for (int i = 0; i < ar.length; i++) ar[i] = (ar[i]==0) ? 1 : 0;
        displayAr("Modified array:", ar);

        //Task 2 - define empty array of 8 elements and change its items to progression 0 3 6 9 12..
        int empty_ar_len = 8; //length of empty array
        int progression_step = 3;
        int[] empty_ar = new int[empty_ar_len];
        displayAr("\nTask 2.\nDefined array:", empty_ar);
        for (int i=0; i<empty_ar_len; i++) empty_ar[i] = i * progression_step;
        displayAr("Modified array:", empty_ar);

        //Task 3 - define array [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]. Multiply by 2 every number less than 6
        int[] test_ar = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        displayAr("\nTask 3.\nDefined array:", test_ar);
        for (int i = 0; i < test_ar.length; i++) {
            if (test_ar[i]<6) test_ar[i]*=2;
        }
        displayAr("Modified array:", test_ar);

        //Task 4 - create square 2-dimensional int array and fill its diagonals by 1
        int square_ar_len = 5;
        int[][] square_ar = new int[square_ar_len][square_ar_len];
        for (int i = 0; i < square_ar_len; i++) {
            int opposite_i = square_ar_len-1-i;
            square_ar[i][i]=1;
            square_ar[i][opposite_i]=1;
        }
        displayDeepAr("\nTask 4.\nMethod 1, modified array:", square_ar);
        square_ar = new int[square_ar_len][square_ar_len];
        for (int i = 0; i < square_ar_len; i++) {
            for (int j = 0; j < square_ar_len; j++) {
                if (i==j || i==square_ar_len-1-j){
                    square_ar[i][j] = 1;
                }
            }
        }
        displayDeepAr("Method 2, modified array:", square_ar);

        //Task 5 - define 1-dimensional array (will be used already defined test_ar) and find min and max items
        int min_v = test_ar[0], max_v = test_ar[0], min_i = 0, max_i = 0;
        for (int i=1; i<test_ar.length; i++){
            if (test_ar[i]<min_v) {min_v=test_ar[i]; min_i=i;}
            if (test_ar[i]>max_v) {max_v=test_ar[i]; max_i=i;}
        }
        displayAr("\nTask 5.\nDefined array:", test_ar);
        System.out.println("Max value: "+max_v+" at position "+max_i);
        System.out.println("Min value: "+min_v+" at position "+min_i);

        //Task 6 - write a method returning true if there is a place in array where sum left items = sum right items
        int[] ar2={1, 1, 1, 2, 5};
        System.out.println("\nTask 6. Method - 'equals'.");
        equals(ar2);

        //Task 7 - write a method which receives 1-dimensional array and number N which can be positive or negative
        //Method should shift elements of one-dimensional array by N steps right or left (+N or -N)
        int[] ar3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n=-2;
        displayAr("\nTask 7. Method - 'shiftAr'.\nDefined array:", ar3);
        shiftAr(ar3, n);
        displayAr("Steps to shift: "+n+"\nModified array:", ar3);
    }

    public static void displayAr(String caption, int[] array){
        System.out.println(caption);
        System.out.println(Arrays.toString(array));
    }
    public static void displayDeepAr(String caption, int[][] array){
        System.out.println(caption);
        System.out.println(Arrays.deepToString(array));
    }
    public static boolean equals(int array[]){
        int sum_l=0, sum_r=0, i=0;
        for (i = 0; i < array.length; i++) sum_r += array[i];
        i=0;
        while(sum_l<sum_r){
            sum_l+=array[i];
            sum_r-=array[i];
            i++;
        }
        System.out.println("In the array "+Arrays.toString(array));
        if (sum_l==sum_r) {
            System.out.println("sum of left "+i+" elements (is "+sum_l+") is equal to sum of "+(array.length-i)+" right elements (is "+sum_r+").");
        } else {
            System.out.println("is no place where sum of left part equals to sum of righr parts.");
        }
        return sum_l==sum_r;
    }
    public static void shiftAr(int array[], int n){
        int l=array.length;
        int m=n%l; //skip overlaps
        if (l>1 && m!=0){ //if arrays is zero length or is 1-item array or n = array.length will return same array
            int pos=0, i=l, mem, p0, p1; //defining position of memory, memory variable and pointers
            do {
                mem=array[pos];
                p0=pos; p1=p0-m; //here p1 initialized to be different from p0
                while (i>0 && p1!=pos) {
                    p1=p0-m;
                    if (p1 < 0) p1 += l;
                    else if (p1 >= l) p1 -= l;
                    array[p0] = (p1==pos)?mem:array[p1];
                    p0=p1; i--;
                }
                pos++;
            } while (i>0);
        }
    }
}
