import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //BubbleSort con su matriz
        int[] values = CreateValues();
        long bubbleTime = BubbleSort(values);
        System.out.println("Tiempo de ejecución de Bubble Sort en ms: " + bubbleTime);

        //MergeSort con su matriz
        values = CreateValues();
        long firstTime = System.currentTimeMillis();
        MergeSort(values, 0, values.length - 1);
        long lastTime = System.currentTimeMillis();

        long mergeTime = lastTime - firstTime;
        System.out.println("Tiempo de ejecución de Merge Sort en ms: " + mergeTime);

        //SelectionSort con su matriz
        values = CreateValues();
        long selectionTime = SelectionSort(values);
        System.out.println("Tiempo de ejecución de Selection Sort en ms: " + selectionTime);

    }
    private static int[] CreateValues(){
        Random random = new Random();
        int[] valores = new int[1000];

        for (int i = 0; i < 1000; i++){
            valores[i] = random.nextInt(101);
        }

        return valores;
    }

    private static long BubbleSort (int[] values){
        int n = values.length;
        long firstTime = System.currentTimeMillis();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (values[j] > values[j+1]) {
                    //intercambio
                    int temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }
        long lastTime = System.currentTimeMillis();

        return lastTime - firstTime;
    }

    private static void MergeSort (int[] values, int left, int right){
        if (left < right) {
            int middle = (left + right) / 2;

            // Dividir la mitad izquierda y derecha
            MergeSort(values, left, middle);
            MergeSort(values, middle + 1, right);

            // Combinar las mitades ordenadas
            merge(values, left, middle, right);
        }
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

    private static long SelectionSort(int[] values){
        int n = values.length;
        long firstTime = System.currentTimeMillis();
        for (int i = 0; i < n - 1; i++){

            int minIndex = i;

            for (int j = i + 1; j < n; j++){
                if (values[j] < values[minIndex]){
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