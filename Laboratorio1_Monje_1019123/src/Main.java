import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Crear la matriz original
        int[] originalValues = createValues();

        // BubbleSort con su matriz
        int[] bubbleValues = Arrays.copyOf(originalValues, originalValues.length);
        long bubbleTime = bubbleSort(bubbleValues);
        System.out.println("Tiempo de ejecución de Bubble Sort en ms: " + bubbleTime);

        // MergeSort con su matriz
        int[] mergeValues = Arrays.copyOf(originalValues, originalValues.length);
        long mergeTime = mergeSort(mergeValues, 0, mergeValues.length - 1);
        System.out.println("Tiempo de ejecución de Merge Sort en ms: " + mergeTime);

        // SelectionSort con su matriz
        int[] selectionValues = Arrays.copyOf(originalValues, originalValues.length);
        long selectionTime = selectionSort(selectionValues);
        System.out.println("Tiempo de ejecución de Selection Sort en ms: " + selectionTime);
    }

    private static int[] createValues() {
        Random random = new Random();
        int[] valores = new int[1000];

        for (int i = 0; i < 1000; i++) {
            valores[i] = random.nextInt(101);
        }

        return valores;
    }

    private static long bubbleSort(int[] values) {
        int n = values.length;
        long firstTime = System.currentTimeMillis();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    // Intercambio
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
        long lastTime = System.currentTimeMillis();

        return lastTime - firstTime;
    }

    private static long mergeSort(int[] values, int left, int right) {
        long firstTime = System.currentTimeMillis();
        if (left < right) {
            int middle = (left + right) / 2;

            // Dividir la mitad izquierda y derecha
            mergeSort(values, left, middle);
            mergeSort(values, middle + 1, right);

            // Combinar las mitades ordenadas
            merge(values, left, middle, right);
        }
        long lastTime = System.currentTimeMillis();

        return lastTime - firstTime;
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Crear arreglos temporales
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copiar datos a los arreglos temporales
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; ++j){
            rightArray[j] = arr[middle + 1 + j];
        }

        // Combinar los arreglos temporales
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de leftArray (si hay alguno)
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de rightArray (si hay alguno)
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static long selectionSort(int[] values) {
        int n = values.length;
        long firstTime = System.currentTimeMillis();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = values[i];
            values[i] = values[minIndex];
            values[minIndex] = temp;
        }
        long lastTime = System.currentTimeMillis();

        return lastTime - firstTime;
    }
}
