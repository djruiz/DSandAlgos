import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class lab12Controller implements Observer {

    lab12Model model;
    lab12 view1;

    public lab12Controller(lab12 view, lab12Model model){
        this.model = model;
        this.model.addObserver(this);
        this.view1 = view;

        try{
            Thread.sleep(100);
        }
        catch (Exception e){}
        view.clear();
        System.out.println(Arrays.toString(model.array));
        for(int i = 0; i < model.array.length; i++){
            view1.drawPoint(i, model.array[i]);
            /*for(int j = 0; j <= model.array[i]; j++) {
                view.drawPoint(i, 1200 - j);
            }*/
        }

    }

    @Override
    public void update(Observable o, Object arg) {

        //System.out.println("update");

        int positionSwapped = (int) arg;


        int value1 = model.array[positionSwapped];
        int value2 = model.array[positionSwapped + 1];




        view1.drawPoint(positionSwapped, value1);

        view1.drawBlackPoint(positionSwapped, value1);
        view1.drawPoint(positionSwapped + 1, value2);

        view1.drawBlackPoint(positionSwapped + 1, value2);


        }

        /*System.out.println("update runs");
        int[][] modelArray = model.getArray();
        //use method I havent written in view yet
        for(int i = 0; i < model.getRows(); i++){
            for(int j = 0; j < model.getCols(); j++){
                view1.drawPoint(i, j, modelArray[i][j]);
            }
        }*/

    public static void main(String[] args){
        lab12Model model = new lab12Model();
        lab12 view = new lab12();
        lab12Controller cont = new lab12Controller(view, model);

        cont.model.bubbleSort();

        //model.randomize();
        /*model.sortArray1();
        model.sortArray2();*/
        //System.out.println(Arrays.deepToString(model.getArray()));
        //for(int i = 0; i < model.getRows(); i++){
        //    System.out.println(Arrays.toString(model.getArray()[i]));
        //}

        //model.sortArray1();

    }
}