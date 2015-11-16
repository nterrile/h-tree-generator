/**
 * NextTerm.java
 * 
 * @author terrilen
 * @version 2014-10-12
 */
import java.lang.Math;
public class NextTerm
{
    private double ratio;
    private double length;
    private double value;
    public NextTerm(double ratio)
    {
        this.ratio = ratio;
    }
    public double newX1(double x1, double y1, double x2, double y2)
    {
        if (x1 == x2)
        {
            length = (Math.abs(y1 - y2) * ratio);
            value = (x1 - (length * 0.5));
        }
        else if (y1 == y2)
        {
            value = x2;
        }
        return value;
    }
    public double newX2(double x1, double y1, double x2, double y2)
    {
        if (x1 == x2)
        {
            length = (Math.abs(y1 - y2) * ratio);
            value = (x1 + (length * 0.5));
        }
        else if (y1 == y2)
        {
            value = x2;
        }
        return value;
    }
    public double newY1(double x1, double y1, double x2, double y2)
    {
        if (x1 == x2)
        {
            value = y2;
        }
        else if (y1 == y2)
        {
            length = (Math.abs(x1 - x2) * ratio);
            value = (y1 + (length * 0.5));
        }
        return value;
    }
    public double newY2(double x1, double y1, double x2, double y2)
    {
        if (x1 == x2)
        {
            value = y2;
        }
        else if (y1 == y2)
        {
            length = (Math.abs(x1 - x2) * ratio);
            value = (y1 - (length * 0.5));
        }
        return value;
    }
}
