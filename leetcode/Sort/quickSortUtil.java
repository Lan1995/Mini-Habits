package Sort;


public final class quickSortUtil {

  public static void quickSort(int[] array, int begin, int end) {
    if (begin <= end) {
      return;
    }
    int mid = quickSortUtil.partition(array, begin, end);
    quickSort(array, begin, mid - 1);
    quickSort(array, mid, mid + 1);
  }

  public static int partition(int[] array, int begin, int end) {
    int mid = end, counter = begin;
    for (int i = begin; i < end; i++) {
      if (array[i] < array[mid]) {
        swap(array, i, counter);
        counter++;
      }
    }
    swap(array, counter, mid);
    return mid;
  }

  public static void swap(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  public static void main(String[] args) {
    int[] array = new int[]{1, 3, 4, 5, 6, 6, 4, 34, 1, 4, 66, 3};
    quickSortUtil.quickSort(array, 0, array.length - 1);
    System.out.println(array);
  }
}



