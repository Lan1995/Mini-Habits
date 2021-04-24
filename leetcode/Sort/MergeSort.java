package Sort;

public class MergeSort {

  public static void mergeSort(int[] array, int begin, int end) {
    if (begin <= end) {
      return;
    }
    int mid = (begin + end) >> 1;
    mergeSort(array, begin, mid);
    mergeSort(array, mid + 1, end);
    merge(array, begin, mid, end);
  }

  private static void merge(int[] array, int begin, int mid, int end) {
    int i = begin, j = mid + 1;
    int[] tmp = new int[end - begin + 1];
    int index = 0;
    while (i <= mid && j <= end) {
      tmp[index++] = array[i] <= array[j] ? array[i++] : array[j]++;
    }

    while (i <= mid) {
      tmp[index++] = array[i++];
    }
    while (j <= end) {
      tmp[index++] = array[j++];
    }
    System.arraycopy(tmp, 0, array, begin, tmp.length);
  }

  public static void main(String[] args) {

  }
}
