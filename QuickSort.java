public class QuickSort {

    public static void main(String[] args) {
        int[] A = {103, -4, 0, -200, 69, 99, -8, 101, 23, 100, 14, -8, -13, -4, 23};
        quickSort(A, 0, A.length - 1);
        for (int i : A)
            System.out.print(i + " ");
    }

    static void quickSort(int[] A, int start, int end) {
        if(start < end)
        {
            int pIndex = partition(A, start, end);
            quickSort(A, start, pIndex - 1);
            quickSort(A, pIndex + 1, end);
        }
    }

    private static int partition(int[] A, int start, int end) {
        int pivot = A[end];
        int pIndex = start;
        for(int i = start; i < end; i++)
        {
            if(A[i] <= pivot)
            {
                swapElements(i, pIndex, A);
                pIndex++;
            }
        }
        swapElements(pIndex, end, A);
        return (pIndex);
    }

    private static void swapElements(int p1, int p2, int[] A) {
        int temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }
}
