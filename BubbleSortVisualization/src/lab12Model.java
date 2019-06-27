import java.util.Observable;
import java.util.*;

public class lab12Model extends Observable {

    Int2DArray twoD;
    bubbleSort tool;
    int[] array;

    public lab12Model(){
        twoD = new Int2DArray(1200, 1200);
        tool = new bubbleSort();
        array = tool.createRandomArray(1200);
    }

    public int[] arrayToSort(){
        return tool.createRandomArray(1200);
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public int[] bubbleSort(){



            int n = array.length;
            boolean swapped;
            do {
                swapped = false;
                for(int i = 0; i < n - 1; i++){
                    if(array[i] > array[i + 1]){
                        //System.out.println("Switching: " + array[i] + " and " + array[i + 1]);
                        swap(array, i, i+1);
                        setChanged();
                        notifyObservers(i);
                        swapped = true;
                    }
                }
                //System.out.println("Updated array: " + Arrays.toString(array));
            }while(swapped);
            return array;
        }


    public int[][] getArray(){
        return this.twoD.getArray();
    }

    public int getRows(){
        return this.twoD.getRowSize();
    }

    public int getCols(){
        return this.twoD.getColSize();
    }

    public void randomize(){
        twoD.randomArray();
        setChanged();
        notifyObservers();
    }

   /* public void sortRows(){
        twoD.sortrow();
        //setChanged();
        //notifyObservers();
    }


    public void sortCols(){
        twoD.sortCol();
        //setChanged();
        //notifyObservers();
    }*/

    /*public void sortArray1(){
        // your method's declaration {
        long lTimeBefore = System.nanoTime();
        // your method's body

        sortCols();
        sortRows();

        long lTimeAfter = System.nanoTime();

        // print out duration:
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println(lElapsedNanoSeconds);
    }
    public void sortArray2(){
        long lTimeBefore = System.nanoTime();
        sortRows();
        sortCols();
        long lTimeAfter = System.nanoTime();

        // print out duration:
        long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
        System.out.println(lElapsedNanoSeconds);
    }*/


    public static void main(String[] args){
        lab12Model test = new lab12Model();
        System.out.println(Arrays.toString(test.bubbleSort()));
    }
}