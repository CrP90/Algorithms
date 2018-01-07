/** The mode of a set of data values is the value that appears most often. */

public class Mode {

    public static void main(String[] args) {

        int[] A = {200, -14, 90, 0, 12, 195, 15, -12, 90, 4, 100, 203,
                90, 1, 12, 15, 90, -14, 100, 18, 90, 4, 18, 0, 100, 18, 90, 1, 18, 90};
        System.out.println(Mode(A));
    }

    static int Mode(int[] A)
    {
        int mode = A[0];
        int count = 1;
        for(int i = 0; i < (A.length - 1); i++)
        {
            int temp = A[i];
            int tempCount = 1;
            for(int j = 1; j < A.length; j++)
            {
                if(temp == A[j])
                    tempCount++;
            }
            if(tempCount > count)
            {
                mode = temp;
                count = tempCount;
            }
        }
        return (mode);
    }
}
