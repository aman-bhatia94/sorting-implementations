/**
 * Insertion sort procedure to sort an unsorted list of words
 */
package sorting_algorithms;

import java.util.ArrayList;

public class InsertionSort implements SortInterface {

    ArrayList<String> words; //ArrayList to store the words to be sorted
    int size; //Number of words in the array list
    int capacity = 10000; // intitial capacity of the array list

    InsertionSort(){
        words = new ArrayList<String>(capacity);
        size = words.size();
    }

    //return the number of words in the list
    public int size(){
        size = words.size();
        return size;
    }

    @Override
    public void addWordsToList(String[] words) {
        for(String word: words){
            this.words.add(word);
        }
    }

    //key is the string that needs to be put into its correct position
    //The while loop keeps on comparing all the strings before the key to the key
    //If a string is lexicographically bigger than key then we move it one position forward
    //We repeat this procedure until we encounter the beginning of the list or until we find
    //a string that is smaller than key, and insert the key after it.
    @Override
    public void sort() {
        int size = size();
        for(int i = 1; i < size; i++){
            int j = i - 1;
            String key = words.get(i);
            while(j >= 0 && words.get(j).compareTo(key) > 0){
                words.set(j+1,words.get(j));
                j--;
            }
            words.set(j+1,key);
        }
    }
    @Override
    public void display(){
        System.out.println(this.words.toString());
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        String[] check = {"dc","b","dca","xxx","a","aa"};
        sort.addWordsToList(check);
        sort.sort();
        sort.display();

    }
}
