import java.util.*;

public class SortowanieAlgorytmy {

    // ===================== Bubble Sort =====================
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // jeśli w tej iteracji nic się nie zamieniło — tablica już posortowana
            if (!swapped) break;
        }
    }

    // ===================== Selection Sort =====================
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    // ===================== Insertion Sort =====================
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // ===================== Quick Sort =====================
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // wybieramy ostatni element jako pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // ===================== Merge Sort =====================
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // ===================== Pomocnicza metoda =====================
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // ===================== Main =====================
    public static void main(String[] args) {
        int[] tab = {5, 3, 8, 4, 2};

        System.out.println("Oryginalna tablica: " + Arrays.toString(tab));

        int[] copy1 = tab.clone();
        bubbleSort(copy1);
        System.out.print("Bubble Sort:     ");
        printArray(copy1);

        int[] copy2 = tab.clone();
        selectionSort(copy2);
        System.out.print("Selection Sort:  ");
        printArray(copy2);

        int[] copy3 = tab.clone();
        insertionSort(copy3);
        System.out.print("Insertion Sort:  ");
        printArray(copy3);

        int[] copy4 = tab.clone();
        quickSort(copy4, 0, copy4.length - 1);
        System.out.print("Quick Sort:      ");
        printArray(copy4);

        int[] copy5 = tab.clone();
        mergeSort(copy5);
        System.out.print("Merge Sort:      ");
        printArray(copy5);
    }
}
