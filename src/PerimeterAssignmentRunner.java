import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        for (Point p : s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double totalPerimeter = 0;
        Point prevPt = s.getLastPoint();
        for(Point p : s.getPoints()){
            double currentDistance = prevPt.distance(p);
            totalPerimeter = totalPerimeter + currentDistance;
            prevPt = p;
        }
        double average = totalPerimeter / getNumPoints(s);
        return average;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0;
        Point prevPt = s.getLastPoint();
        for(Point p : s.getPoints()){
            double currentSide = prevPt.distance(p);
            if(currentSide > largestSide){
                largestSide = currentSide;
            }
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double currentXPoint = 0;
        for(Point p : s.getPoints()){
            double x = p.getX();
            if(Math.abs(currentXPoint) < Math.abs(x)){
                currentXPoint = x;
            }
        }
        return currentXPoint;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerimeter = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentLargestPerimeter = getPerimeter(s);
            if(largestPerimeter < currentLargestPerimeter){
                largestPerimeter = currentLargestPerimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("Total points is: " + getNumPoints(s));
        System.out.println("Total Average length is: " + getAverageLength(s));
        System.out.println("The largest side is: " + getLargestSide(s));
        System.out.println("The Largest x is: " + getLargestX(s));
        System.out.println("The largest perimeter in multiple file is: " + getLargestPerimeterMultipleFiles());
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        String fileName = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            fileName = f.getName();
            double eachPerimeter = getPerimeter(s);
            System.out.println("The total Perimeter of " + fileName + ": " + eachPerimeter);
        }
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        double largestPrimeter = 0.0;
        String fileName = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currentPrimeter = getPerimeter(s);
            if (largestPrimeter < currentPrimeter){
                largestPrimeter = currentPrimeter;
                fileName = f.getName();
            }
        }
        System.out.println("The file with the largest Perimeter is: " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
