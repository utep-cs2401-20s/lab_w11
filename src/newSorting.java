public class newSorting {
    public void newSorting(int[] A, int size) {
        if ( A.length <= size )
            quicksort(A); //just do quicksort on A
        else {
            int[] LH = new int[A.length/2];
            int[] RH = new int[A.length-A.length/2];
            populate(A,LH,RH); //fill the left half and right half from A
            newSorting(LH,size); //run newSorting on the left half
            newSorting(RH,size); //run newSorting on the right half
            mergeSortedHalves(A,LH,RH); //merge the sorted halves appropriately into A
        }
    }

    /**
     * The starter method for the recursive quicksort algorithm.
     * @param arr the array we will sort using quicksort
     */
    private void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length-1);
    }
    /**
     * The recursive helper method that does the sorting using quicksort.
     * Overloads quicksort(int[]).
     * @param a the array to sort
     * @param s the starting index to start swapping
     * @param e the ending index to stop swapping
     */
    private void quicksort(int[] a, int s, int e) {
        //base case: avoid AOoB exception
        if ( s>=e ) return;
        int left=s+1, right=e;
        while ( left<=right ) {
            //keep moving up the list until it doesn't belong relative to the pivot: a[s]
            while ( left<=e && a[left]<=a[s] )
                left++;
            //keep moving down the list until it doesn't belong relative to the pivot: a[s]
            while ( right>=s && a[right]>a[s] )
                right--;
            //swap, if we can
            if ( left<right )
                swap(a,left,right);
        }
        swap(a,s,right);
        //recursively repeat the process until sorted
        quicksort(a,s,right-1);
        quicksort(a,right+1,e);
    }

    /**
     * Swaps elements from index p0 to index p1.
     * @param A the array to swap within
     * @param p0 the index to swap from
     * @param p1 the index to swap into
     */
    private void swap(int[] A, int p0, int p1) {
        int temp = A[p0];
        A[p0] = A[p1];
        A[p1] = temp;
    }

    /**
     * Fills two half-length arrays of the data in from.
     * @param from the original we copy the data from
     * @param first the array that contains the left half of data in from
     * @param second the array that contains the right half of data in from
     */
    private void populate(int[] from, int[] first, int[] second) {
        int l = 0, r = 0;
        for ( int i=0 ; i<from.length ; i++ )
            //do we copy into the left half?
            if ( i<from.length/2 ) first[l++] = from[i];
            //do we copy into the right half?
            else second[r++] = from[i];
    }

    /**
     * Merges two sorted lists into a larger list in sorted order.
     * @param into the array we are copying the sorted contents into
     * @param LH the sorted left half
     * @param RH the sorted right half
     */
    private void mergeSortedHalves(int[] into, int[] LH, int[] RH) {
        int l = 0, r = 0;
        for ( int i=0 ; i<into.length ; i++ ) {
            //either we're moving through both
            if ( l<LH.length && r<RH.length ) {
                //one or the other has to be placed in into
                if (LH[l] <= RH[r]) into[i] = LH[l++];
                else into[i] = RH[r++];
            } else {
                //or we move through one or the other
                if ( l<LH.length ) //does left have more to place in into?
                    into[i] = LH[l++];
                else //does right have more to place in into?
                    into[i] = RH[r++];
            }
        }
    }
}
