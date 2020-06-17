import edu.duke.*;
import java.io.File;

public class test {
    public static void main(String[] args){
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentLargestPerimeter = getPerimeter(s);
            if(largestPerimeter < currentLargestPerimeter){
                largestPerimeter = currentLargestPerimeter;
            }
        }
        System.out.println(largestPerimeter);
    }

    public static double getPerimeter(Shape s){
        double totalPerimeter = 0.0;
        Point prevPt = s.getLastPoint();
        for(Point p : s.getPoints()){
            double currentPerimeter = prevPt.distance(p);
            totalPerimeter = totalPerimeter + currentPerimeter;
            prevPt = p;
        }
        return totalPerimeter;
    }

    public static double getLargestPerimeterMultipleFile(Shape s){
        double largestPerimeter = 0.0;
        double currentLargestPerimeter = getPerimeter(s);
        if(largestPerimeter < currentLargestPerimeter){
            largestPerimeter = currentLargestPerimeter;
        }
        return largestPerimeter;
    }

}
