package threedimanimatedart;


import java.security.SecureRandom;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.AmbientLight;
import javafx.scene.ParallelCamera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public class ThreeDimAnimatedArtController {

    public double boxRatio = Math.sqrt(3); // This is the ratio needed to find the furthest possible distance
                                            // the cubes corner could be from its layOut coordinates when rotated.
    public double cylinderRatio; // Ratio needed to calculate the value of the cylinders center to
                                 // its furthest possible edge.
    
    @FXML
    private ParallelCamera paralellCamera;
    @FXML
    private PerspectiveCamera perspectiveCamera;
    @FXML
    private AmbientLight ambientLight;
    @FXML
    private PointLight pointLight;
    @FXML
    private Pane displayPane;
    @FXML
    private Box box;
    @FXML
    private Cylinder cylinder;
    @FXML
    private Sphere sphere;

       @FXML
    void ambientRadioButtonSelected(ActionEvent event) {
   
   }
    
   @FXML
    void parallelRadioButtonSelected(ActionEvent event) {
   
   }

   @FXML
    void perspectiveRadioButtonSelected(ActionEvent event) {
   
   }
    
   @FXML
    void pointRadioButtonSelected(ActionEvent event) {
   
   }
    
    @FXML
    void displayPaneClicked(ActionEvent event) {
        
    }
    
   public void initialize() {
      SecureRandom random = new SecureRandom();
      
      // Setting our shapes to random sizes
      double radius = 10.0 + random.nextInt(32);
      sphere.setRadius(radius);
      double boxWHL = 10.0 + random.nextInt(70);
      box.setDepth(boxWHL);
      box.setHeight(boxWHL);
      box.setWidth(boxWHL);
      radius = 5.0 + random.nextInt(25);
      cylinder.setRadius(radius);
      cylinder.setHeight(10.0 + random.nextInt(55));
      
      // These ratio's will help determine when the shapes hit the edge of the pane
      cylinderRatio = Math.ceil(Math.sqrt((Math.pow(radius, 2) + Math.pow(cylinder.getHeight()/2, 2))));
      boxRatio = Math.ceil(boxWHL / 2 * boxRatio);
     
      //Sets the spin of the shapes in random directions
      int boxTheta, cylinderTheta;
      if (random.nextInt(2) == 0)
          boxTheta = -1;
      else
          boxTheta = 1;
     
      if (random.nextInt(2) == 0)
          cylinderTheta = -1;
      else
          cylinderTheta = 1;
      
      
      // define a timeline animation
      AnimationTimer sphereTimer = 
         new AnimationTimer() {
            int dx = 1 + random.nextInt(5);
            int dy = 1 + random.nextInt(5);
            double z = 100;
            double dz = 1 + random.nextInt(3);
            int velocity = 60; // used to scale distance changes
            long previousTime = System.nanoTime(); // time since app launch
         
         // specify how to move Circle for current animation frame
            @Override
            public void handle(long now) {
               double elapsedTime = (now - previousTime) / 1000000000.0;
               previousTime = now;
               double scale = elapsedTime * velocity;
               
               // Used to give illusion of movement along z-axis
               // There is no layoutZ and I couldn't find another alternative
               // on the internet this is the best I could think up
                z += dz;
                if (z >= 300 || z<= 75)
                   dz *= -1;
                
              Bounds bounds = displayPane.getBoundsInLocal();
              
              //Sets new sphere location
               sphere.setLayoutX(sphere.getLayoutX() + dx * scale);
               sphere.setLayoutY(sphere.getLayoutY() + dy * scale);
               
               //Scale the sphere to where it is along the 'z-axis'
               sphere.scaleXProperty().setValue(z/100);
               sphere.scaleYProperty().setValue(z/100);
               sphere.scaleZProperty().setValue(z/100);
               
               
             
            
               if (hitRightOrLeftEdge(bounds, sphere.getScaleX() * sphere.getRadius())) {
                  dx *= -1;
               }
            
               if (hitTopOrBottom(bounds, sphere.getScaleY() * sphere.getRadius())) {
                  dy *= -1;
               }
             
            }
         };
      
      // define a timeline animation
      AnimationTimer boxTimer = 
         new AnimationTimer() {
            int dx = 1 + random.nextInt(5);
            int dy = 1 + random.nextInt(5);
            double boxXCoordinates = box.getLayoutX();
            double boxYCoordinates = box.getLayoutY();
            double z = 100;
            double dz = 1 + random.nextInt(3);
            int velocity = 60; // used to scale distance changes
            long previousTime = System.nanoTime(); // time since app launch
         
         // specify how to move Circle for current animation frame
            @Override
            public void handle(long now) {
               double elapsedTime = (now - previousTime) / 1000000000.0;
               previousTime = now;
               double scale = elapsedTime * velocity;
               
               //Rotate box with the random angle boxTheta (either 1 or -1)
               Transform boxRotate = new Rotate(boxTheta, new Point3D(1,1,1));
               box.getTransforms().add(boxRotate);
               
               // Again, used to give illusion of movement along z-axis
               z += dz;
                if (z >= 300 || z<= 75)
                   dz *= -1;
               
               
               
               Bounds bounds = displayPane.getBoundsInLocal();
               //Set box to new location
               boxXCoordinates = boxXCoordinates + dx * scale;
               box.setLayoutX(boxXCoordinates);
               boxYCoordinates = boxYCoordinates + dy * scale;
               box.setLayoutY(boxYCoordinates);
               
               //Scale to movement along z-axis
               box.scaleXProperty().setValue(z/100);
               box.scaleYProperty().setValue(z/100);
               box.scaleZProperty().setValue(z/100);
               
               if (boxHitRightOrLeftEdge(bounds, boxXCoordinates, boxRatio * box.getScaleX())) {
                  dx *= -1;
               }
               if (boxHitTopOrBottom(bounds, boxYCoordinates, boxRatio * box.getScaleY())){
                 
                   dy *= -1;
               }
               
            }
         };
      
      // define a timeline animation
      AnimationTimer cylinderTimer = 
         new AnimationTimer() {
            int dx = 1 + random.nextInt(5);
            int dy = 1 + random.nextInt(5);
            double z = 100;
            double dz = 1 + random.nextInt(3);
            double cylinderXCoordinates = cylinder.getLayoutX();
            double cylinderYCoordinates = cylinder.getLayoutY();
            int velocity = 60; // used to scale distance changes
            long previousTime = System.nanoTime(); // time since app launch
         
         // specify how to move Circle for current animation frame
            @Override
            public void handle(long now) {
               double elapsedTime = (now - previousTime) / 1000000000.0;
               previousTime = now;
               double scale = elapsedTime * velocity;
               Bounds bounds = displayPane.getBoundsInLocal();
               
               //Rotate cylinder
               Transform cylinderRotate = new Rotate(cylinderTheta, new Point3D(1,1,1));
               cylinder.getTransforms().add(cylinderRotate);
               
               //Track cylinder movement along z-axis
               z += dz;
               if (z >= 300 || z<= 75)
                   dz *= -1;
               
               //Set cylinder new location
               cylinderXCoordinates = cylinderXCoordinates + dx * scale;
               cylinder.setLayoutX(cylinderXCoordinates);
               cylinderYCoordinates = cylinderYCoordinates + dy * scale;
               cylinder.setLayoutY(cylinderYCoordinates);
               
               //Scale to movement along the z-axis
               cylinder.scaleXProperty().setValue(z/100);
               cylinder.scaleYProperty().setValue(z/100);
               cylinder.scaleZProperty().setValue(z/100);
            
               if (cylinderHitRightOrLeftEdge(bounds, cylinderXCoordinates, cylinderRatio * cylinder.getScaleX())) {
                  dx *= -1;
               }
               if (cylinderHitTopOrBottom(bounds, cylinderYCoordinates, cylinderRatio * cylinder.getScaleY())) {
                  dy *= -1;
               }
            }
         };
         
      boxTimer.start();
      sphereTimer.start();
      cylinderTimer.start();
   

      
   
   }
   
   /*
   * The rest are methods that check wether the object hits the edge of the pane or not
   */
   
   private boolean boxHitRightOrLeftEdge(Bounds bounds, double boxXCoordinates, double ratio) {
      return (boxXCoordinates <= (bounds.getMinX() + ratio) ||
              boxXCoordinates >= (bounds.getMaxX() - ratio));
   } 

   private boolean boxHitTopOrBottom(Bounds bounds, double boxYCoordinates, double ratio) {
      return (boxYCoordinates <= (bounds.getMinY() + ratio) ||
              boxYCoordinates >= (bounds.getMaxY() - ratio));
   }

   private boolean cylinderHitRightOrLeftEdge(Bounds bounds, double cylinderXCoordinates, double ratio) {
      return (cylinderXCoordinates <= (bounds.getMinX() + ratio) ||
               (cylinderXCoordinates >= (bounds.getMaxX() - ratio)));
   }

   private boolean cylinderHitTopOrBottom(Bounds bounds, double cylinderYCoordinates, double ratio) {
      return (cylinderYCoordinates <= (bounds.getMinY() + ratio) ||
               (cylinderYCoordinates >= (bounds.getMaxY() - ratio)));
   }
   
   // determines whether the sphere hit left/right of the window
   private boolean hitRightOrLeftEdge(Bounds bounds, double transRadius) {
      return (sphere.getLayoutX() <= (bounds.getMinX() + transRadius)) ||
         (sphere.getLayoutX() >= (bounds.getMaxX() - transRadius));
   }

   // determines whether the sphere hit top/bottom of the window
   private boolean hitTopOrBottom(Bounds bounds, double transRadius) {
      return (sphere.getLayoutY() <= (bounds.getMinY() + transRadius)) ||
         (sphere.getLayoutY() >= (bounds.getMaxY() - transRadius));
   }
   
}



