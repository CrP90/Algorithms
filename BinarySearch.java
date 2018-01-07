public class BinarySearch {

    public static void main(String[] args) {
        int[] A = {-14, 0, 12, 195, 15, -12, 90, 4, 100, 203, 90, 1,
                12, 15, 90, -14, 100, 18, 90, 4, 18, 0, 100, 18, 90, 1, 18, 90};
        QuickSort.quickSort(A, 0, A.length - 1);
        int firstIndex = binarySearch(A, 90, true);
        if(firstIndex != -1)
            System.out.println(firstIndex);
        else
            System.out.println("niet");
    }

    static int binarySearch(int[] A, int x, boolean flag)
    {
        int low = 0;
        int high = A.length - 1;
        int result = -1;
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if(A[mid] == x)
            {
                result = mid;
                if(flag)
                    high = mid -1;
                else
                    low = mid + 1;
            }
            else if(x < A[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return (result);
    }
}
