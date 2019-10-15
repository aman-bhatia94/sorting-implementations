/**
 * Heap sort procedure to sort an unsorted list of words
 */

package sorting_algorithms;

import java.util.ArrayList;

public class HeapSort implements SortInterface {

    ArrayList<String> words;
    int heapSize;
    int size; //size of arrayList words
    int capacity = 10000; // intitial capacity of the array list

    HeapSort(){
        words = new ArrayList<String>();
        size = words.size();
        heapSize = 0;
    }

    public int left(int i){
        return (2*i) + 1;
    }

    public int right(int i){
        return (2 * i)+2;
    }

    //return the number of words in the list
    public int size(){
        size = words.size();
        return size;
    }

    @Override
    public void addWordsToList(String word) {
        this.words.add(word);
        size++;
        heapSize++;

    }

    @Override
    public void sort() {
        heapSort(words);
    }

    //sort method
    private void heapSort(ArrayList<String> words) {
        buildMaxHeap(words); //build a max heap first
        for(int i = size - 1; i >=1; i--){
            String temp = words.get(0);
            words.set(0,words.get(i));
            words.set(i,temp);
            heapSize--;
            maxHeapify(words,0);
        }
    }
    //method to build a max heap(bottom up approach)
    private void buildMaxHeap(ArrayList<String> words) {
        heapSize = words.size();
        for(int i = (size - 1)/2; i >= 0; i--){
            maxHeapify(words,i);
        }
    }

    //method to heapify(used to set a heap  to max heap)
    private void maxHeapify(ArrayList<String> words, int i){
        int left = left(i);
        int right = right(i);
        int maximum = i;
        if(left < heapSize && words.get(left).compareTo(words.get(i)) > 0){
            maximum = left;
        }
        if(right < heapSize && words.get(right).compareTo(words.get(maximum)) > 0){
            maximum = right;
        }
        if(maximum != i){
            //swap maximum with i, and run max heapify on (words, maximum)
            String temp = words.get(i);
            words.set(i,words.get(maximum));
            words.set(maximum,temp);
            maxHeapify(words,maximum); //we recursively do this, because once its for for node i, one of its child nodes
            //might not satisfy heap property and thus we need to maintain it.
        }

    }

    @Override
    public void display() {
        System.out.println(words.toString());
    }

}
