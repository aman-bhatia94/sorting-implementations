/**
 * Quick sort procedure to sort an unsorted list of words
 */
package sorting_algorithms;

import java.util.ArrayList;

public class QuickSort implements SortInterface {

    ArrayList<String> words; //ArrayList to store the words to be sorted
    int size; //Number of words in the array list
    int capacity = 10000; // intitial capacity of the array list

    QuickSort(){
        words = new ArrayList<String>(capacity);
        size = words.size();
    }

    //return the number of words in the list
    public int size(){
        size = words.size();
        return size;
    }

    @Override
    public void addWordsToList(String word) {
        this.words.add(word);

    }

    @Override
    public void sort() {
        quickSort(this.words,0,this.size() - 1);
    }

    private void quickSort(ArrayList<String> words, int beg, int end){
        if(beg < end) {
            int partitionIndex = partition(words, beg, end);
            quickSort(words,beg,partitionIndex - 1);
            quickSort(words,partitionIndex + 1, end);
        }
    }

    private int partition(ArrayList<String> words, int beg, int end){
        //choose the pivot to be the last element
        int pivot = end;
        //we start with an empty left part, as we go along, we keep on adding elements that are less than pivot to left of it
        //and those tht are greater than pivot to its right
        int i = beg - 1;
        for(int j = beg; j <= end - 1; j++){
            if(words.get(j).compareTo(words.get(pivot)) <= 0){
                i = i + 1;
                String temp = words.get(i);
                words.set(i,words.get(j));
                words.set(j,temp);
            }
        }
        //swap i + 1th and pivot because we want our pivot to be where the partition is
        //swapping with i + 1 will maintain the left and right properties around the pivot
        String temp = words.get(i + 1);
        words.set(i + 1,words.get(pivot));
        words.set(pivot,temp);

        return i + 1;

    }
    @Override
    public void display() {
        System.out.println(this.words.toString());
    }

}
