class Quick extends Sorter {

    void sort() {
        _iter(0, n -1 );
    }
    //definerer den rekursive delen av algoritmen
    void _iter(int low, int high){
        if(leq(low, high)) {
            int p = part(low, high);
            _iter(low, p - 1);
            _iter(p + 1, high);
        }
    }
    //Definerer partition delen av algoritmen
    int part(int low, int high){
        int pivot = A[high];
        int left = low;
        int right = high - 1;

        while(leq(left, right)) {
            while (leq(left, right) && leq(A[left], pivot)) {
                left++;
            }
            while (geq(right, left) && geq(A[right], pivot)) {
                right--;
            }
            if (lt(left, right)) {
                swap(left, right);
            }
        }
        swap(left, high);
        return left;
    }

    String algorithmName() {
        return "quick";
    }
}
