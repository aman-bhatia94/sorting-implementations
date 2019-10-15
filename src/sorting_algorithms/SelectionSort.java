/**
 * Selection sort procedure to sort an unsorted list of words
 */
package sorting_algorithms;

import java.util.ArrayList;

public class SelectionSort implements SortInterface{

    ArrayList<String> words; //ArrayList to store the words to be sorted
    int size; //Number of words in the array list
    int capacity = 10000; // intitial capacity of the array list

    SelectionSort(){
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

    //The selection sort procedure works by repeatedly finding the smallest element in the list
    //and putting it in the correct place
    @Override
    public void sort() {
        int size = size();
        for(int i = 0; i < size - 1; i++){
            int minIndex = i; //set the minimum index to be i
            for(int j = i + 1; j < size; j++){
                //this loop finds the smallest element from i+1 to end
                if(words.get(j).compareTo(words.get(minIndex)) < 0){
                    minIndex = j;
                }
            }
            //swap the smallest element with the ith element
            String temp = words.get(minIndex);
            words.set(minIndex,words.get(i));
            words.set(i,temp);
        }
    }

    @Override
    public void display(){
        System.out.println(this.words.toString());
    }

}
