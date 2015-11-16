/**
  * FrameViewer.java
  * @author terrilen
  * @version 2014-10-11
*/

import javax.swing.JFrame;
import java.util.Scanner;

public class FrameViewer
{
    public static void main(String[] args)
    {
        JFrame myFrame = new JFrame();  // constructing a Frame
        myFrame.setSize(1200,700);       // (pixels across, pixels down)
        myFrame.setTitle("Fractal");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Scanner inputs:
        Scanner in = new Scanner(System.in);
        System.out.println("Initial length (suggested: 100-450):");
        double initialLength = in.nextDouble();
        double ratio = Math.sqrt(2) / 2;
        System.out.println("Use Math.sqrt(2)/2 for the ratio? (y/n)");
        String useRatio = in.next();
        useRatio = useRatio.toLowerCase();
        if (useRatio.equals("n") || useRatio.equals("no"))
        {
            System.out.println("Custom Ratio (suggested: 0.5-0.8):");
            ratio = in.nextDouble();
        }
        System.out.println("Number of terms (suggested: 1-16):");
        int numTerms = in.nextInt();
        System.out.println();
        
        // We'll construct something to be viewed here in a minute
        Fractal myComponent = new Fractal(initialLength, ratio, numTerms);
    
        // We'll add the thing that we've constructed to the frame here
        myFrame.add(myComponent);
    
        // Now we need to show the frame
        myFrame.setVisible(true);
    }
}
