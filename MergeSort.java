public class MergeSort {

    public int[] mergeSort(int[] arr)
    {
        //inductive step, continue breaking array into smaller sub arrays
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2); //exclusive
        int [] right = Arrays.copyOfRange(arr,arr.length / 2, arr.length);
        //while we have a left and right sub array that add up to at least 3 --
        //--meaning last call to method will result in array sizes of 1:1 or 1:2
        if(arr.length > 2) {
            //continue split left sub array until we have reached a size of 1 or >
            mergeSort(left);
            //complete split right sub array until we have reached a size of 1 or >
            mergeSort(right);
        }
        //unwrap call, sorting arr reference location by merging every sub array pair created --
        // --until we reach our original left and right sub array in the front of our stack
        merge(arr, left,right);
        return arr;
    }

    public void merge(int[] arr, int[] left, int[] right) {

//        System.out.println(Arrays.toString(arr));
//        System.out.println("Merge " + Arrays.toString(left) +":" + Arrays.toString(right));

        for (int i = 0, l = 0, r = 0 ; i < arr.length; i++)
        {
            //case we have exhausted an array
            if(l == left.length || r == right.length)
                //if we have exhausted left array, right array must hold larger value -> :
                arr[i] = l == left.length ? right[r++] : left[l++];
            //if left is smaller add to temp and move to next loc in left array
            else if(left[l] < right[r])
                arr[i] = left[l++];
            else
                arr[i] = right[r++];
        }
    }

    public static void main (String[] args)
    {
        int[] i = {7,3,101,90,12,9,4,5,1,20,40,23,-1};
        System.out.println(i.length);
        System.out.println(Arrays.toString(i));
        MergeSort m = new MergeSort();
        System.out.println(Arrays.toString(m.mergeSort(i)));
    }
