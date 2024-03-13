import java.util.Scanner;



import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;

public class Main {

    static LinkedList<Song> songList = new LinkedList<>();

    public static void ReadCSV(int MaxSongs) {
        /* Array de songs */
        String csvFile = "C:\\Users\\Xthen\\OneDrive\\Escritorio\\U\\estructura\\Lab2\\data.csv"; // Cambiar si se quiere probar con aleatorio descendente y ascendente
        String line = "";
        String cvsSplitBy = ",(?![^\\[]*\\])";
        int yearIndex = 1;
        int artistsIndex = 3;
        int nameIndex = 14;
        int count = 0;

        // Registra el tiempo de inicio
        long startTime = System.currentTimeMillis();

        // Medidores para uso de memoria y CPU
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        MemoryUsage heapMemoryUsage1 = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage1 = memoryMXBean.getNonHeapMemoryUsage();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (count == MaxSongs) {
                    break;
                }

                count++;
                String[] values = line.split(cvsSplitBy);
                String year = values[yearIndex];
                String artists = values[artistsIndex];
                String name = values[nameIndex];

                /* Así creo una canción! */
                Song song = new Song(name, artists, year);
                System.out.printf("Ingresando canción: %s\n", song.toString());

                /* Así accedo al controlador de canciones! */
                songList.add(song);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Registra el tiempo de finalización
        long endTime = System.currentTimeMillis();

        // Calcula el tiempo transcurrido en milisegundos
        long tiempoEjecucionMs1 = endTime - startTime;
        double cpuUsage1 = osBean.getSystemLoadAverage();

        System.out.println("Tiempo de ejecución de ReadCSV: " + tiempoEjecucionMs1 + " ms");
        System.out.println("Uso de memoria (heap): " + heapMemoryUsage1.getUsed() / (1024 * 1024) + " MB");
        System.out.println("Uso de memoria (non-heap): " + nonHeapMemoryUsage1.getUsed() / (1024 * 1024) + " MB");
        System.out.println("Uso de CPU (aproximado): " + cpuUsage1 + "%");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Medidores para uso de memoria y CPU
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

        do {
            System.out.println("\n--- Menú UDP Music ---");
            System.out.println("1. Agregar canciones!");
            System.out.println("2. Printear lista");
            System.out.println("3. burbuja sort");
            System.out.println("4. Ordenar canciones con Insertion Sort");
            System.out.println("5. Ordenar canciones con Selection Sort");
            System.out.println("6. Ordenar canciones con Merge Sort");
            System.out.println("7. Ordenar canciones con Counting Sort");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Agregar canciones a UDPMusic.");
                    long startTime1 = System.currentTimeMillis();
                    MemoryUsage heapMemoryUsage1 = memoryMXBean.getHeapMemoryUsage();
                    MemoryUsage nonHeapMemoryUsage1 = memoryMXBean.getNonHeapMemoryUsage();
                    OperatingSystemMXBean osBean1 = ManagementFactory.getOperatingSystemMXBean();
                    ReadCSV(100000); 
                    long endTime1 = System.currentTimeMillis();
                    long tiempoEjecucionMs1 = endTime1 - startTime1;
                    double cpuUsage1 = osBean1.getSystemLoadAverage();
                    System.out.println("Tiempo de ejecución de la carga de canciones: " + tiempoEjecucionMs1 + "ms");
                    System.out.println("Uso de memoria (heap): " + heapMemoryUsage1.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de memoria (non-heap): " + nonHeapMemoryUsage1.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de CPU (aproximado): " + cpuUsage1 + "%");
                    break;

                    case 2:
                    long startTime2 = System.currentTimeMillis();
                    for (int i = 0; i < songList.size(); i++) {
                        System.out.println(songList.get(i));
                    }
                    long endTime2 = System.currentTimeMillis();
                    long tiempoEjecucionMs2 = endTime2 - startTime2;
                    double cpuUsage2 = osBean.getSystemLoadAverage();
                    System.out.println("Tiempo de ejecución de listar canciones: " + tiempoEjecucionMs2 + "ms");
                    System.out.println("Uso de CPU (aproximado): " + cpuUsage2 + "%");
                    break;

                    case 3:
                    System.out.println("Ordenar canciones con Bubble Sort.");
                    // Medidores para uso de memoria y CPU
                    MemoryUsage heapMemoryUsage3 = memoryMXBean.getHeapMemoryUsage();
                    MemoryUsage nonHeapMemoryUsage3 = memoryMXBean.getNonHeapMemoryUsage();
                    OperatingSystemMXBean osBean3 = ManagementFactory.getOperatingSystemMXBean();

                    long startTime3 = System.currentTimeMillis();
                    if (songList.isEmpty()) {
                        System.out.println("La lista de canciones está vacía. Agrega canciones primero.");
                    } else {
                        Song[] song3Array = songList.toArray(new Song[songList.size()]);
                        Metodos.bubbleSort(song3Array, song3Array.length);
                        System.out.println("Lista de canciones ordenada con Bubble Sort:");
                        for (Song song : song3Array) {
                            System.out.println(song.toString());
                        }
                    }
                    long endTime3 = System.currentTimeMillis();
                    long tiempoEjecucionMs3 = endTime3 - startTime3;
                    double cpuUsage3 = osBean3.getSystemLoadAverage();
                    System.out.println("Tiempo de ejecución de Bubble Sort: " + tiempoEjecucionMs3 + "ms");
                    System.out.println("Uso de memoria (heap): " + heapMemoryUsage3.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de memoria (non-heap): " + nonHeapMemoryUsage3.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de CPU (aproximado): " + cpuUsage3 + "%");
                    break;


                    case 4:
                    System.out.println("Ordenar canciones con Insertion Sort.");
                    // Medidores para uso de memoria y CPU
                    MemoryUsage heapMemoryUsage4 = memoryMXBean.getHeapMemoryUsage();
                    MemoryUsage nonHeapMemoryUsage4 = memoryMXBean.getNonHeapMemoryUsage();
                    OperatingSystemMXBean osBean4 = ManagementFactory.getOperatingSystemMXBean();

                    long startTime4 = System.currentTimeMillis();
                    if (songList.isEmpty()) {
                        System.out.println("La lista de canciones está vacía. Agrega canciones primero.");
                    } else {
                        Song[] song1Array = songList.toArray(new Song[songList.size()]);
                        Metodos.insertionSort(song1Array, song1Array.length);
                        System.out.println("Lista de canciones ordenada con Insertion Sort:");
                        for (Song song : song1Array) {
                            System.out.println(song.toString());
                        }
                    }
                    long endTime4 = System.currentTimeMillis();
                    long tiempoEjecucionMs4 = endTime4 - startTime4;
                    double cpuUsage4 = osBean4.getSystemLoadAverage();
                    System.out.println("Tiempo de ejecución de Insertion Sort: " + tiempoEjecucionMs4 + "ms");
                    System.out.println("Uso de memoria (heap): " + heapMemoryUsage4.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de memoria (non-heap): " + nonHeapMemoryUsage4.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de CPU (aproximado): " + cpuUsage4 + "%");
                    break;

                    case 5:
                    System.out.println("Ordenar canciones con Selection Sort.");
                    // Medidores para uso de memoria y CPU
                    MemoryUsage heapMemoryUsage5 = memoryMXBean.getHeapMemoryUsage();
                    MemoryUsage nonHeapMemoryUsage5 = memoryMXBean.getNonHeapMemoryUsage();
                    OperatingSystemMXBean osBean5 = ManagementFactory.getOperatingSystemMXBean();

                    long startTime5 = System.currentTimeMillis();
                    if (songList.isEmpty()) {
                        System.out.println("La lista de canciones está vacía. Agrega canciones primero.");
                    } else {
                        Song[] song5Array = songList.toArray(new Song[songList.size()]);
                        Metodos.selectionSort(song5Array, song5Array.length);
                        System.out.println("Lista de canciones ordenada con Selection Sort:");
                        for (Song song : song5Array) {
                            System.out.println(song.toString());
                        }
                    }
                    long endTime5 = System.currentTimeMillis();
                    long tiempoEjecucionMs5 = endTime5 - startTime5;
                    double cpuUsage5 = osBean5.getSystemLoadAverage();
                    System.out.println("Tiempo de ejecución de Selection Sort: " + tiempoEjecucionMs5 + "ms");
                    System.out.println("Uso de memoria (heap): " + heapMemoryUsage5.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de memoria (non-heap): " + nonHeapMemoryUsage5.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de CPU (aproximado): " + cpuUsage5 + "%");
                    break;

                    case 6:
                    System.out.println("Ordenar canciones con Merge Sort.");
                    // Medidores para uso de memoria y CPU
                    MemoryUsage heapMemoryUsage6 = memoryMXBean.getHeapMemoryUsage();
                    MemoryUsage nonHeapMemoryUsage6 = memoryMXBean.getNonHeapMemoryUsage();
                    OperatingSystemMXBean osBean6 = ManagementFactory.getOperatingSystemMXBean();

                    long startTime6 = System.currentTimeMillis();
                    if (songList.isEmpty()) {
                        System.out.println("La lista de canciones está vacía. Agrega canciones primero.");
                    } else {
                        Song[] song6Array = songList.toArray(new Song[songList.size()]);
                        Metodos.mergeSort(song6Array, 0, song6Array.length - 1);
                        System.out.println("Lista de canciones ordenada con Merge Sort:");
                        for (Song song : song6Array) {
                            System.out.println(song.toString());
                        }
                    }
                    long endTime6 = System.currentTimeMillis();
                    long tiempoEjecucionMs6 = endTime6 - startTime6;
                    double cpuUsage6 = osBean6.getSystemLoadAverage();
                    System.out.println("Tiempo de ejecución de Merge Sort: " + tiempoEjecucionMs6 + "ms");
                    System.out.println("Uso de memoria (heap): " + heapMemoryUsage6.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de memoria (non-heap): " + nonHeapMemoryUsage6.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de CPU (aproximado): " + cpuUsage6 + "%");
                    break;

                    case 7:
                    System.out.println("Ordenar canciones con Counting Sort.");
                    // Medidores para uso de memoria y CPU
                    MemoryUsage heapMemoryUsage7 = memoryMXBean.getHeapMemoryUsage();
                    MemoryUsage nonHeapMemoryUsage7 = memoryMXBean.getNonHeapMemoryUsage();
                    OperatingSystemMXBean osBean7 = ManagementFactory.getOperatingSystemMXBean();

                    long startTime7 = System.currentTimeMillis();
                    if (songList.isEmpty()) {
                        System.out.println("La lista de canciones está vacía. Agrega canciones primero.");
                    } else {
                        Song[] song7Array = songList.toArray(new Song[songList.size()]);
                        Metodos.countingSort(song7Array, song7Array.length);
                        System.out.println("Lista de canciones ordenada con Counting Sort:");
                        for (Song song : song7Array) {
                            System.out.println(song.toString());
                        }
                    }
                    long endTime7 = System.currentTimeMillis();
                    long tiempoEjecucionMs7 = endTime7 - startTime7;
                    double cpuUsage7 = osBean7.getSystemLoadAverage();
                    System.out.println("Tiempo de ejecución de Counting Sort: " + tiempoEjecucionMs7 + "ms");
                    System.out.println("Uso de memoria (heap): " + heapMemoryUsage7.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de memoria (non-heap): " + nonHeapMemoryUsage7.getUsed() / (1024 * 1024) + " MB");
                    System.out.println("Uso de CPU (aproximado): " + cpuUsage7 + "%");
                    break;

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        } while (choice != 8);

        scanner.close();
    }
}