public class Metodos {
    public static void bubbleSort(Song[] A, int N) {
        Song temp;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (A[j].getYear().compareTo(A[j + 1].getYear()) > 0) {
                    temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(Song[] A, int N) {
        for (int i = 1; i < N; i++) {
            Song key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j].getYear().compareTo(key.getYear()) > 0) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }

    public static void selectionSort(Song[] A, int N) {
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (A[j].getYear().compareTo(A[minIndex].getYear()) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Song temp = A[i];
                A[i] = A[minIndex];
                A[minIndex] = temp;
            }
        }
    }

    // Aquí debes agregar el código para Merge Sort y Counting Sort

    public static void mergeSort(Song[] A, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(A, left, middle);
            mergeSort(A, middle + 1, right);
            merge(A, left, middle, right);
        }
    }

    private static void merge(Song[] A, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Song[] L = new Song[n1];
        Song[] R = new Song[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = A[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i].getYear().compareTo(R[j].getYear()) <= 0) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void countingSort(Song[] A, int N) {
        int maxYear = Integer.MIN_VALUE;
        int minYear = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int year = Integer.parseInt(A[i].getYear());
            if (year > maxYear) {
                maxYear = year;
            }
            if (year < minYear) {
                minYear = year;
            }
        }

        int range = maxYear - minYear + 1;
        int[] count = new int[range];
        Song[] output = new Song[N];

        for (int i = 0; i < N; i++) {
            int year = Integer.parseInt(A[i].getYear());
            count[year - minYear]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            int year = Integer.parseInt(A[i].getYear());
            output[count[year - minYear] - 1] = A[i];
            count[year - minYear]--;
        }

        for (int i = 0; i < N; i++) {
            A[i] = output[i];
        }
    }
}