import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class lab12 extends JComponent{

    private int width;
    private int height;
    private JFrame aJFrame;

    public lab12(){
        this.width = 1200;
        this.height = 1200;
        // create JFrame where we (the main object in its JComponent identity) can paint:
        this.aJFrame = new JFrame();
        aJFrame.setTitle("HW03");
        aJFrame.add(this);
        aJFrame.setSize(width, height);
        aJFrame.setVisible( true );
        aJFrame.setLocationRelativeTo(null);
        aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public void drawPoint(int x, int height){
        Graphics pGraphics = this.getGraphics();
        Color c;

        c = new Color(255, 255, 255);

        pGraphics.setColor(c);
        //pGraphics.drawOval(x, y, 1, 1);
        pGraphics.fillRect( x, 1200 - height, 1, height);

        pGraphics.dispose();

    }
    public void drawBlackPoint(int x, int height){
        Graphics pGraphics = this.getGraphics();
        Color c;

        c = new Color(0, 0, 0);


        pGraphics.setColor(c);
        //pGraphics.drawOval(x, y, 1, 1);
        pGraphics.fillRect( x, 0, 1, 1200 - height);
        pGraphics.dispose();

    }

    public void clear(){

        Graphics g = this.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0 , width, height);
    }


    // we override the JComponent's paintComponent() method, to do some drawing:
    //  and we receive the currently active graphics for our JComponent:

    public static void main(String[] args) {
        lab12 view = new lab12();
        try{
            Thread.sleep(100);
        }
        catch (Exception e){}

        view.clear();
        //view.drawPoint(20, 30, 200);
        //view.drawPoint(50, 50, 10);
        //view.drawPoint(100, 500, 10);
        //view.drawPoint(50, 50, 10);
    }


}