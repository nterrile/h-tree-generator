/** 
 * Fractal.java
 * 
 * @author terrilen
 * @version 2014-09-11
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.lang.Math;
import javax.swing.JComponent;

public class Fractal extends JComponent
{
    private double initialLength;
    private double ratio;
    private int numTerms;
    public Fractal(double initialLength, double ratio, int numTerms)
    {
        this.initialLength = initialLength;
        this.ratio = ratio;
        this.numTerms = numTerms;
    }
    public void paintComponent(Graphics g) //, double initialLength, double ratio, int numTerms)
    {
        //variables:
        double seq = 0;
        int p = 0;
        double newX1 = (600 - (initialLength / 2));
        double newY1 = 350;
        double newX2 = (600 + (initialLength / 2));
        double newY2 = 350;

        //create graphics:
        Graphics2D g2 = (Graphics2D) g;

        //create line object:
        Line2D.Double line = new Line2D.Double();

        //create RootTwo object:
        NextTerm r = new NextTerm(ratio);

        //begin drawing the fractal:
        for (int n = 0; n < numTerms; n ++)
        {
            seq = Math.pow(2, n); //seq is the number of lines in the next term
            for (int x = 0; x < seq; x ++)
            {
                line.setLine(newX1, newY1, newX2, newY2);
                g2.draw(line);
                if (x < seq - 1)
                {
                    if (n % 2 == 0) //if n is even (horizontal line)
                    {
                        if (x % 2 == 0) //if x is even, horizontal translation
                        {
                            newX1 = newX1 + (initialLength * Math.pow(ratio, n - 2));
                            newX2 = newX2 + (initialLength * Math.pow(ratio, n - 2));
                        }
                        else //if x is odd, diagonal translation
                        {
                            for (int k = (((x - 1) / 2) + 1); k % 2 == 0; k /= 2)
                            {
                                p ++;
                            }
                            if (p % 2 == 0) //if p is even, translate down/left
                            {
                                newX1 = newX1 - (initialLength * Math.pow(ratio, n - (p + 2)));
                                newY1 = newY1 + (initialLength * Math.pow(ratio, n - (p + 1)));
                                newX2 = newX2 - (initialLength * Math.pow(ratio, n - (p + 2)));
                                newY2 = newY2 + (initialLength * Math.pow(ratio, n - (p + 1)));
                                for (int j = 1; j <= p / 2; j ++)
                                {
                                    newX1 = newX1 - (initialLength * Math.pow(ratio, n - (j * 2)));
                                    newY1 = newY1 - (initialLength * Math.pow(ratio, n - ((j * 2) - 1)));
                                    newX2 = newX2 - (initialLength * Math.pow(ratio, n - (j * 2)));
                                    newY2 = newY2 - (initialLength * Math.pow(ratio, n - ((j * 2) - 1)));
                                }
                            }
                            else //else translate up/right
                            {
                                newX1 = newX1 + (initialLength * Math.pow(ratio, n - (p + 3)));
                                newX2 = newX2 + (initialLength * Math.pow(ratio, n - (p + 3)));
                                for (int i = 1; i <= ((p - 1) / 2) + 1; i ++)
                                {
                                    newX1 = newX1 - (initialLength * Math.pow(ratio, n - (i * 2)));
                                    newY1 = newY1 - (initialLength * Math.pow(ratio, n - ((i * 2) - 1)));
                                    newX2 = newX2 - (initialLength * Math.pow(ratio, n - (i * 2)));
                                    newY2 = newY2 - (initialLength * Math.pow(ratio, n - ((i * 2) - 1)));
                                }
                            }
                            p = 0;
                        }
                    }

                    else //if n is odd (vertical line)
                    {
                        if (x % 2 == 0) //if x is even, horizontal translation
                        {
                            newX1 = newX1 - (initialLength * Math.pow(ratio, n - 1));
                            newX2 = newX2 - (initialLength * Math.pow(ratio, n - 1));
                        }
                        else //if x is odd, diagonal translation
                        {
                            for (int k = (((x - 1) / 2) + 1); k % 2 == 0; k /= 2)
                            {
                                p ++;
                            }
                            if (p % 2 == 0) //if p is even, translate up/right
                            {
                                newX1 = newX1 + (initialLength * Math.pow(ratio, n - (p + 1)));
                                newY1 = newY1 - (initialLength * Math.pow(ratio, n - (p + 2)));
                                newX2 = newX2 + (initialLength * Math.pow(ratio, n - (p + 1)));
                                newY2 = newY2 - (initialLength * Math.pow(ratio, n - (p + 2)));
                                for (int j = 1; j <= p / 2; j ++)
                                {
                                    newX1 = newX1 + (initialLength * Math.pow(ratio, n - ((j * 2) - 1)));
                                    newY1 = newY1 + (initialLength * Math.pow(ratio, n - (j * 2)));
                                    newX2 = newX2 + (initialLength * Math.pow(ratio, n - ((j * 2) - 1)));
                                    newY2 = newY2 + (initialLength * Math.pow(ratio, n - (j * 2)));
                                }
                            }
                            else //else translate down/left
                            {
                                newX1 = newX1 - (initialLength * Math.pow(ratio, n - (p + 2)));
                                newX2 = newX2 - (initialLength * Math.pow(ratio, n - (p + 2)));
                                for (int i = 1; i <= ((p - 1) / 2) + 1; i ++)
                                {
                                    newX1 = newX1 + (initialLength * Math.pow(ratio, n - ((i * 2) - 1)));
                                    newY1 = newY1 + (initialLength * Math.pow(ratio, n - (i * 2)));
                                    newX2 = newX2 + (initialLength * Math.pow(ratio, n - ((i * 2) - 1)));
                                    newY2 = newY2 + (initialLength * Math.pow(ratio, n - (i * 2)));
                                }
                            }
                            p = 0;
                        }
                    }
                }
            }
            newX1 = r.newX1(line.getX1(), line.getY1(), line.getX2(), line.getY2());
            newY1 = r.newY1(line.getX1(), line.getY1(), line.getX2(), line.getY2());
            newX2 = r.newX2(line.getX1(), line.getY1(), line.getX2(), line.getY2());
            newY2 = r.newY2(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        }
    }
}
