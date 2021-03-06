/**
 * Merge sort procedure to sort an unsorted list of words
 */
package sorting_algorithms;
import java.util.ArrayList;

public class MergeSort implements SortInterface {

    ArrayList<String> words; //ArrayList to store the words to be sorted
    int size; //Number of words in the array list
    int capacity = 10000; // intitial capacity of the array list

    MergeSort(){
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
        mergeSort(words,0,this.size() - 1);
    }

    private void mergeSort(ArrayList<String> words, int beg, int end){
        if(beg < end){
            //beg < end because if beg = end, recursion will bottom out, since one element is always sorted
            int mid = (beg + end) / 2;
            mergeSort(words, beg, mid);
            mergeSort(words, mid + 1, end);
            merge(words, beg, mid, end);
        }
    }

    //the merge procedures assumes that the two temporary lists it operates on, are sorted
    //it then merges the two into the original one
    private void merge(ArrayList<String> words, int beg, int mid, int end){

        //creating the left and right temporary sublists
        ArrayList<String> leftList = new ArrayList<>(words.subList(beg,mid + 1));
        ArrayList<String> rightList = new ArrayList<>(words.subList(mid + 1,end + 1));

        int i = 0; //counter to keep track of leftList
        int j = 0; //counter to keep track of rightList
        int k = beg; //counter to run from beg to end for the original ArrayList words
        int leftSize = leftList.size();
        int rightSize = rightList.size();

        while( (i < leftSize) && (j < rightSize) ){
            if(leftList.get(i).compareTo(rightList.get(j)) <= 0){
                words.set(k,leftList.get(i));
                i++;
                k++;
            }
            else{
                words.set(k,rightList.get(j));
                j++;
                k++;
            }
        }

        //now we check if any of of leftList or rightList has elements pending to be inserted into words
        if( j >= rightSize){
            //rightList exhausted, leftList has pending elements
            while(i < leftSize){
                words.set(k,leftList.get(i));
                i++;
                k++;
            }
        }
        else if( i >= leftSize){
            //leftList exhausted, rightList has pending elements
            while(j < rightSize){
                words.set(k,rightList.get(j));
                j++;
                k++;
            }
        }


    }

    @Override
    public void display() {
        System.out.println(words.toString());
    }

}
