package threedimanimatedart;

import java.security.SecureRandom;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.ParallelCamera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

public class ThreeDimAnimatedArtController {

    public double boxRatio = Math.sqrt(3); // This is the ratio needed to find the furthest possible distance
                                            // the cubes corner could be from its layOut coordinates when rotated.
    public double cylinderRatio; // Ratio needed to calculate the value of the cylinders center to
                                 // its furthest possible edge.
    
    SecureRandom random = new SecureRandom();
    
    Translate translateX, translateY, translateZ;
    float r, g, b;
    int xAxis, yAxis, zAxis = 0;
    Rotate xRotate, yRotate, zRotate;
    
    @FXML
    private ParallelCamera paralellCamera;
    @FXML
    private final PerspectiveCamera perspectiveCamera = new PerspectiveCamera(true);
    @FXML
    private final AmbientLight ambientLight = new AmbientLight();
    @FXML
    private final PointLight pointLight = new PointLight();
    @FXML
    private Pane displayPane;
    @FXML
    private Box box;
    @FXML
    private Cylinder cylinder;
    @FXML
    private Sphere sphere;
    
    private final Group lightGroup = new Group();
    

       @FXML //Sets our ambient light to yellow, lightPane visible , camera Pane is not
    void ambientRadioButtonSelected(ActionEvent event) {
        lightPane.toFront();
        lightPane.setOpacity(1);
        cameraPane.setOpacity(0);
        ambientLight.setLightOn(true);
        pointLight.setLightOn(false);
        ambientLight.setColor(/*new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(),1)*/Color.YELLOW);
   }
    
    @FXML // Removes all light from the displayPane when selected
    void noneLightRadioButtonSelected(ActionEvent e) {
        displayPane.getChildren().removeAll(lightGroup);
        ambientLight.setLightOn(false);
        pointLight.setLightOn(false);
        lightPane.setOpacity(0);
        cameraPane.setOpacity(0);
        lightPane.toFront();
    }
    
   @FXML    //Set what happens when parallel radio button selected
    void parallelRadioButtonSelected(ActionEvent event) {
        displayPane.getChildren().removeAll(lightGroup);
        displayPane.getScene().setCamera(paralellCamera);
   }
    

    @FXML
    private TextField cameraRotationAngleTextField;
    
    @FXML
    private TextField lightRotationAngleTextField;

    @FXML   //X-axis for our rotate object to move the lights and cameras around
    void selectedXAxis(ActionEvent event) {
        if (xAxis == 0)
            xAxis = 1;
        else if (xAxis == 1)
            xAxis = 0;
    }

    @FXML   //Y-axis for our rotate object to move the lights and cameras around
    void selectedYAxis(ActionEvent event) {
        if (yAxis == 0)
            yAxis = 1;
        else if (yAxis == 1)
            yAxis = 0;
    }

    @FXML   //Z-axis for our rotate object to move the lights and cameras around
    void selectedZAxis(ActionEvent event) {
        if (zAxis == 0)
            zAxis = 1;
        else if (zAxis == 1)
            zAxis = 0;
    }
    
    @FXML 
    private Pane cameraPane;
    
    @FXML 
    private Pane lightPane;
    
    @FXML   //Sets the point radio color to yellow / lightPane is visible, cameraPane is not
    void pointRadioButtonSelected(ActionEvent event) {
        
        lightPane.setOpacity(1);
        cameraPane.setOpacity(0);
        lightPane.toFront();
        pointLight.setLightOn(true);
        ambientLight.setLightOn(false);
        pointLight.setColor(Color.YELLOW);
    }
    
    @FXML // Removes light from scene, sets perspective camera and makes cameraPane visible
    void perspectiveRadioButtonSelected(ActionEvent event) {
        displayPane.getChildren().removeAll(lightGroup);
        lightPane.setOpacity(0);
        cameraPane.setOpacity(1);
        cameraPane.toFront();
        
    }
    
    @FXML   //Adds the transforms to the camera node 
    void cameraViewButtonClicked(ActionEvent event) {
        displayPane.requestFocus();
        Bounds bounds = displayPane.getBoundsInLocal();
         displayPane.getScene().setCamera(perspectiveCamera);
        perspectiveCamera.setLayoutX((bounds.getMaxX()-bounds.getMinX())/2);
        perspectiveCamera.setLayoutY((bounds.getMaxY()-bounds.getMinY())/2);
        perspectiveCamera.setFieldOfView(90);
        perspectiveCamera.setNearClip(0);
        perspectiveCamera.setFarClip(1000);
        
        if (xAxis == 1) {
           try{
               xRotate = new Rotate(Integer.parseInt(cameraRotationAngleTextField.getText()), Rotate.X_AXIS);
           }catch (NumberFormatException e) {
               System.out.println("Please enter a rotation field.");
           }
            translateX = new Translate(bounds.getMaxX()*4,0,0);
        }else{
            xRotate = new Rotate(0, Rotate.X_AXIS);
            translateX = new Translate(-100,0,0);
        }
        if (yAxis == 1) {
           try{
               yRotate = new Rotate(Integer.parseInt(cameraRotationAngleTextField.getText()), Rotate.Y_AXIS);
           }catch (NumberFormatException e) {
               System.out.println("Pease enter a rotation field.");
           }
            translateY = new Translate(0,bounds.getMaxY()*4,0);
        }else{
            yRotate = new Rotate(0, Rotate.Y_AXIS);
            translateY = new Translate(0,-100,0);
        }
        if (zAxis == 1) {
            try{
                zRotate = new Rotate(Integer.parseInt(cameraRotationAngleTextField.getText()), Rotate.Z_AXIS);
            }catch (NumberFormatException e) {
                System.out.println("Please enter a rotation field.");
            }
            translateZ = new Translate(0,0, -bounds.getMaxZ()*4);
        }else{
            zRotate = new Rotate(0, Rotate.Z_AXIS);
            translateZ = new Translate(0,0,-100);
        }
        perspectiveCamera.getTransforms().addAll(xRotate, yRotate, zRotate, translateZ);
        
    }
    
    @FXML   //Adds all transforms to lightGroup
    void lightViewButtonClicked(ActionEvent event) {
        displayPane.requestFocus();
        Bounds bounds = displayPane.getBoundsInLocal();
        displayPane.getChildren().add(lightGroup);
        lightGroup.getChildren().add(ambientLight);
        lightGroup.getChildren().add(pointLight);
        lightGroup.setLayoutX((bounds.getMaxX()-bounds.getMinX())/2);
        lightGroup.setLayoutY((bounds.getMaxY()-bounds.getMinY())/2);
        
        if (xAxis == 1) {
           try{
               xRotate = new Rotate(Integer.parseInt(lightRotationAngleTextField.getText()), Rotate.X_AXIS);
           }catch (NumberFormatException e) {
               System.out.println("Please enter a rotation field.");
           }
            translateX = new Translate(bounds.getMaxX()*4,0,0);
        }else{
            xRotate = new Rotate(0, Rotate.X_AXIS);
            translateX = new Translate(-100,0,0);
        }
        if (yAxis == 1) {
           try{
               yRotate = new Rotate(Integer.parseInt(lightRotationAngleTextField.getText()), Rotate.Y_AXIS);
           }catch (NumberFormatException e) {
               System.out.println("Pease enter a rotation field.");
           }
            translateY = new Translate(0,bounds.getMaxY()*4,0);
        }else{
            yRotate = new Rotate(0, Rotate.Y_AXIS);
            translateY = new Translate(0,-100,0);
        }
        if (zAxis == 1) {
            try{
                zRotate = new Rotate(Integer.parseInt(lightRotationAngleTextField.getText()), Rotate.Z_AXIS);
            }catch (NumberFormatException e) {
                System.out.println("Please enter a rotation field.");
            }
            translateZ = new Translate(0,0, -bounds.getMaxZ()*4);
        }else{
            zRotate = new Rotate(0, Rotate.Z_AXIS);
            translateZ = new Translate(0,0,-100);
        }
        lightGroup.getTransforms().addAll(xRotate, yRotate, zRotate, translateZ);
        
    }
    
    @FXML   //If displayPane clicked set camera to parallel
    void displayPaneClicked() {
        displayPane.getScene().setCamera(paralellCamera);
    }
    
    @FXML       

    void keyPressed() {
        displayPane.getScene().setCamera(paralellCamera);
    }
    
    @FXML
    void mouseClicked() {
        displayPane.getScene().setCamera(paralellCamera);
    }
       
    
   public void initialize() {
  
      // Setting our shapes to random sizes and colors
      double radius = 15.0 + random.nextInt(35);
      sphere.setRadius(radius);
      double boxWHL = 15.0 + random.nextInt(75);
      box.setDepth(boxWHL);
      box.setHeight(boxWHL);
      box.setWidth(boxWHL);
      radius = 7.5 + random.nextInt(35);
      cylinder.setRadius(radius);
      cylinder.setHeight(10.0 + random.nextInt(55));
      sphere.setMaterial(randomMaterial());
      box.setMaterial(randomMaterial());
      cylinder.setMaterial(randomMaterial());
      sphere.toFront();
      box.toFront();
      cylinder.toFront();
      
      
      // These ratio's will help determine when the shapes hit the edge of the pane
      cylinderRatio = Math.ceil(Math.sqrt((Math.pow(radius, 2) + Math.pow(cylinder.getHeight()/2, 2))));
      boxRatio = Math.ceil(boxWHL / 2 * boxRatio);
     
      //Sets the spin of the shapes in random directions
      int boxTheta, cylinderTheta, sphereTheta;
      
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
            int dz = 1 + random.nextInt(5);
            int z = 0;
            int velocity = 60; // used to scale distance changes
            long previousTime = System.nanoTime(); // time since app launch
            
            
         
         // specify how to move Circle for current animation frame
            @Override
            public void handle(long now) {
                
               double elapsedTime = (now - previousTime) / 1000000000.0;
               previousTime = now;
               double scale = elapsedTime * velocity;
               
                
              Bounds bounds = displayPane.getBoundsInLocal();
              sphere.setTranslateZ(z);
              z += dz;
              if (z > 300 || z < 0)
                  dz *= -1;
              
              //Sets new sphere location
               sphere.setLayoutX(sphere.getLayoutX() + dx * scale);
               sphere.setLayoutY(sphere.getLayoutY() + dy * scale);
               
               
            
               
               if (hitRightOrLeftEdge(bounds, sphere.getRadius())) {
                  dx *= -1;
               }
               
               if (hitTopOrBottom(bounds, sphere.getRadius())) {
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
            int dz = 1 + random.nextInt(5);
            int z = 0;
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
               Bounds bounds = displayPane.getBoundsInLocal();
               box.setTranslateZ(z);
              z += dz;
              if (z > 300 || z < 0)
                  dz *= -1;
               
               //Set box to new location
               boxXCoordinates = boxXCoordinates + dx * scale;
               box.setLayoutX(boxXCoordinates);
               boxYCoordinates = boxYCoordinates + dy * scale;
               box.setLayoutY(boxYCoordinates);
               
               if (boxHitRightOrLeftEdge(bounds, boxXCoordinates, boxRatio)) {
                  dx *= -1;
               }
               if (boxHitTopOrBottom(bounds, boxYCoordinates, boxRatio)){
                 
                   dy *= -1;
               }
               
            }
         };
      
      // define a timeline animation
      AnimationTimer cylinderTimer = 
         new AnimationTimer() {
            int dx = 1 + random.nextInt(5);
            int dy = 1 + random.nextInt(5);
            double cylinderXCoordinates = cylinder.getLayoutX();
            double cylinderYCoordinates = cylinder.getLayoutY();
            int dz = 1 + random.nextInt(5);
            int z = 0;
            int velocity = 60; // used to scale distance changes
            long previousTime = System.nanoTime(); // time since app launch
         
         // specify how to move Circle for current animation frame
            @Override
            public void handle(long now) {
               double elapsedTime = (now - previousTime) / 1000000000.0;
               previousTime = now;
               double scale = elapsedTime * velocity;
               
               //Rotate cylinder
               Transform cylinderRotate = new Rotate(cylinderTheta, new Point3D(1,1,1));
               cylinder.getTransforms().add(cylinderRotate);
               
                Bounds bounds = displayPane.getBoundsInLocal();
                
                cylinder.setTranslateZ(z);
              z += dz;
              if (z > 300 || z < 0)
                  dz *= -1;
               
               //Set cylinder new location
               cylinderXCoordinates = cylinderXCoordinates + dx * scale;
               cylinder.setLayoutX(cylinderXCoordinates);
               cylinderYCoordinates = cylinderYCoordinates + dy * scale;
               cylinder.setLayoutY(cylinderYCoordinates);
               
               if (cylinderHitRightOrLeftEdge(bounds, cylinderXCoordinates, cylinderRatio)) {
                  dx *= -1;
               }
               if (cylinderHitTopOrBottom(bounds, cylinderYCoordinates, cylinderRatio)) {
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
   
   private boolean hitTopOrBottom(Bounds bounds, double transRadius) {
      return (sphere.getLayoutY() <= (bounds.getMinY() + transRadius)) ||
         (sphere.getLayoutY() >= (bounds.getMaxY() - transRadius));
   }

    private Material randomMaterial() {
        PhongMaterial material = new PhongMaterial();
      material.setDiffuseColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(),1));
      material.setSpecularColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(),1));
      return material;
    }
   
   
}

   




