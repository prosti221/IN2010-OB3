import java.util.Arrays;

public class Merge extends Sorter{
    @Override
    void sort() {
        A = MergeSort(A, n);
    }
    //rekursiv funksjon
    int[] MergeSort(int[] A, int n){
        if (lt(n, 2)) {
            return A;
        }
        int half = n / 2;
        int[] a1 = new int[half];
        int[] a2 = new int[n - half];

        System.arraycopy(A, 0, a1, 0, half);
        if (geq(n - half, 0)) System.arraycopy(A, half, a2, 0, n - half);
        MergeSort(a1, half);
        MergeSort(a2, n - half);
        return _Merge(a1, a2, A);
    }
    //setter sammen arrays fra MergeSort og returnerer den ferdig sorterte arrayen.
    int[] _Merge(int[] a1, int[] a2, int[] A){
        int i = 0;
        int j = 0;
        while(lt(i, a1.length) && lt(j, a2.length)) {
            if (lt(a1[i], a2[j])) {
                A[i + j] = a1[i];
                swaps++;
                i++;
            } else {
                A[i + j] = a2[j];
                swaps++;
                j++;
            }
        }
        while (lt(i, a1.length)) {
            A[i + j] = a1[i];
            swaps++;
            i++;
        }
        while (lt(j, a2.length)) {
            A[i + j] = a2[j];
            swaps++;
            j++;
        }
        return A;
    }
    String algorithmName() {
        return "Merge";
    }
}
