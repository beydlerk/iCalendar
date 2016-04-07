public class mergesort {
     
    private int[] array;
    private int[] tempMergArr;
    private int length;
    private String[] follow;
    private String[] tempfollow;
    
    
    public int[] getarray() {
    	return array;
    }
    public String[] getfollow() {
    	return follow;
    }
    public void sort(int inputArr[], String followArr[], int size) {
        this.array = inputArr;
        this.length = size;
        this.tempMergArr = new int[length];
        this.follow = followArr;
        this.tempfollow = new String[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
            tempfollow[i] = follow[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                follow[k] = tempfollow[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                follow[k] = tempfollow[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            follow[k] = tempfollow[i];
            k++;
            i++;
        }
    }
}
