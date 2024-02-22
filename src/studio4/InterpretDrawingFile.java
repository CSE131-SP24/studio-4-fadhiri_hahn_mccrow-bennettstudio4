package studio4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

import edu.princeton.cs.introcs.StdDraw;

public class InterpretDrawingFile {

    public static void main(String[] args) throws FileNotFoundException {
        // Set up the file chooser and select a file
        JFileChooser chooser = new JFileChooser("resources");
        chooser.showOpenDialog(null);
        File f = new File(chooser.getSelectedFile().getPath());
        
        // Set up the scanner to read from the file
        Scanner in = new Scanner(f);
        
        while (in.hasNext()) {
            // Read the shape type
            String shapeType = in.next();
            
            // Read the color components and set the pen color
            int redComponent = in.nextInt();
            int greenComponent = in.nextInt();
            int blueComponent = in.nextInt();
            Color color = new Color(redComponent, greenComponent, blueComponent);
            StdDraw.setPenColor(color);
            
            // Read whether the shape is filled
            boolean isFilled = in.nextBoolean();
            
            if ("rectangle".equalsIgnoreCase(shapeType)) {
                // Read rectangle parameters
                double x = in.nextDouble();
                double y = in.nextDouble();
                double halfWidth = in.nextDouble();
                double halfHeight = in.nextDouble();
                
                if (isFilled) {
                    StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
                } else {
                    StdDraw.rectangle(x, y, halfWidth, halfHeight);
                }
            } else if ("ellipse".equalsIgnoreCase(shapeType)) {
                // Read ellipse parameters
                double x = in.nextDouble();
                double y = in.nextDouble();
                double halfWidth = in.nextDouble();
                double halfHeight = in.nextDouble();
                
                if (isFilled) {
                    StdDraw.filledEllipse(x, y, halfWidth, halfHeight);
                } else {
                    StdDraw.ellipse(x, y, halfWidth, halfHeight);
                }
            } else if ("triangle".equalsIgnoreCase(shapeType)) {
                // Read triangle parameters 
                double[] x = {in.nextDouble(), in.nextDouble(), in.nextDouble()};
                double[] y = {in.nextDouble(), in.nextDouble(), in.nextDouble()};
                
                if (isFilled) {
                    StdDraw.filledPolygon(x, y);
                } else {
                    StdDraw.polygon(x, y);
                }
            }
        }
        
        in.close();
    }
}

