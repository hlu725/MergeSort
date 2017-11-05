import java.util.Random;

public class MergeSortTest {
    public static void main(String[] args) {        
        MergeSortTest s = new MergeSortTest();
        
        int array[] = {48, 7, 53, 52 ,23 ,48, 63, 77, 45 ,49 };
        //int size = 10; //数组大小
    	// int array[] =  s.generateArray(size);
        int splitedArray[] = new int[array.length];
        System.out.println("Before sorting");
        
        // display random array
        s.displaySort(array);
        System.out.println("Start sorting");
        s.mergeSort(array, splitedArray, 0, array.length-1);
    }
    
    // generate array with random number
    public int[] generateArray(int size) {
        int temp[]= new int[size];
        Random random = new Random();

        for(int i = 0; i < size; i++) {
            temp[i] = Math.abs(random.nextInt()%100);
            if(temp[i] == 0) {
                temp[i] += 1;
            }
        }
        return temp;
    }
    
   // display random array
    public static void displaySort(int array[]) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println(" ");
    }
    
    public int[] mergeSort(int array[], int splitedArray[], int first, int last) {        
        int mid;
        int unitArray[] = new int[last+1];
        if(first == last) {
        	splitedArray[first] = array[first];
        } else {
        	// divide and conquer
            mid = (first+last)/2;            
            // split array left side
            mergeSort(array, unitArray, first, mid);         
            // split array right side
            mergeSort(array, unitArray, mid+1, last);
            // merge
            merge(unitArray, splitedArray, first, mid, last);
        }
        return splitedArray;
    }
    public void merge(int unitArray[], int splitedArray[], int first, int mid, int last) {
        int begin1 = first;
        int end1 = mid;
        int begin2 = mid+1;
        int end2 = last;
       
        int index = first;
        //System.out.println("first = " + first + ", mid = " + mid + ", last = " + last);
        while((begin1 <= end1) && (begin2 <= end2)) {
            if(unitArray[begin1] < unitArray[begin2]) {
            	splitedArray[index] = unitArray[begin1];
                begin1++;
            } else {
            	splitedArray[index] = unitArray[begin2];
                begin2++;
            }
            index++;
        }
     
        while(begin1 <= end1) {
        	splitedArray[index] = unitArray[begin1];
            begin1++;
            index++;
        }
      
        while(begin2 <= end2) {
        	splitedArray[index] = unitArray[begin2];
            begin2++;
            index++;
        }
    
        MergeSortTest.displaySort(splitedArray);
    }
}