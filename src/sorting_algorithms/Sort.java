package sorting_algorithms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sort {
    int counter = 1;

    //method that calculates sort time for algo
    public void sortTime(String sortAlgo, SortInterface sortInterface){
        File file = new File("src/input_files/pride-and-prejudice.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/output_files/sorts.csv", true);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split("[^a-zA-Z0-9]+");
                for (String token : tokens) {
                    if (!token.equals("")) {
                        sortInterface.addWordsToList(token);
                    }
                }
            }
            Long startTime = System.currentTimeMillis();
            sortInterface.sort();
            Long estimatedTime = System.currentTimeMillis() - startTime;
            fileWriter.append(sortAlgo+counter+","+estimatedTime);
            fileWriter.append("\n");
            counter++;
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //Experiments run 10 times. For simplicity i run it once, the reports however have been made by running them 10 times
        //The results of the experiments are directly appended to the file, and not displayed on the console.
        Sort sort = new Sort();
        InsertionSort is;
        SelectionSort ss;
        MergeSort ms;
        QuickSort qs;
        HeapSort hs;
        for(int i = 1; i <=1; i++) {
            is = new InsertionSort();
            System.out.println("insertion begin");
            sort.sortTime("insertion_sort", is);
            System.out.println("insertion end");
        }
        sort.counter = 1;
        for(int i = 1; i <=1; i++) {
            ss = new SelectionSort();
            System.out.println("selection begin");
            sort.sortTime("selection_sort", ss);
            System.out.println("selection end");
        }
        sort.counter = 1;
        for(int i = 1; i <=1; i++) {
            ms = new MergeSort();
            System.out.println("merge begin");
            sort.sortTime("merge_sort",ms);
            System.out.println("merge end");
        }
        sort.counter = 1;
        for(int i = 1; i <=1; i++) {
            qs = new QuickSort();
            System.out.println("quick sort begin");
            sort.sortTime("quick_sort", qs);
            System.out.println("quick_sort end");
        }
        sort.counter = 1;
        for(int i = 1; i <=1; i++) {
            hs = new HeapSort();
            System.out.println("heap begin");
            sort.sortTime("heap_sort", hs);
            System.out.println("heap end");
        }

    }
}
