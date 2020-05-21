
package mastermindgame;

import java.security.SecureRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/*----------------------------------------------------------\
|                   -----COLORS-----                        |
| Colors: 0=Red ; 1=White ; 2=Yellow; 3=Blue ; 4=Orange     |
|                                                           |
\*---------------------------------------------------------*/

public class MastermindGameController {

    private final int[] codeColors = new int[4];
    private final int[] guessColors = new int[4];
    private int chosenCircle = -1;
    final int[] correctGuesses = new int[4];
    int whites = 0;
    int gridPaneRowPosition = 1;
    
    @FXML
    private GridPane colorSelectorGrid;

    @FXML
    private Circle Circle1;

    @FXML
    private Circle Circle2;

    @FXML
    private Circle Circle3;

    @FXML
    private Circle Circle4;
    
    @FXML
    private SplitPane gameSplitPane;
    
    @FXML
    private GridPane guessesResultsGridPane;
    
    @FXML
    private Pane winLosePane;
    
    @FXML
    private Label winLoseLabel;
    
    @FXML
    private Pane rootPane;

    @FXML
    private void MouseClickedCircle1(MouseEvent event) {
       colorSelectorGrid.setVisible(true);
       gameSplitPane.setVisible(false);
       event.consume();
       chosenCircle = 1;
    }

    @FXML
    private void MouseClickedCircle2(MouseEvent event) {
        colorSelectorGrid.setVisible(true);
       gameSplitPane.setVisible(false);
       event.consume();
       chosenCircle = 2;
    }

    @FXML
    private void MouseClickedCircle3(MouseEvent event) {
        colorSelectorGrid.setVisible(true);
       gameSplitPane.setVisible(false);
       event.consume();
       chosenCircle = 3;
    }

    @FXML
    private void MouseClickedCircle4(MouseEvent event) {
        colorSelectorGrid.setVisible(true);
       gameSplitPane.setVisible(false);
       event.consume();
       chosenCircle = 4;
    }

    @FXML
    private void checkButtonSelected(ActionEvent event) {
        checkReds();
        checkWhites();
        System.out.println("Red: " + (correctGuesses[0] + correctGuesses[1] + correctGuesses[2] + correctGuesses[3]));
        System.out.println("White: " + whites);
        System.out.println("Guess: " + guessColors[0] + guessColors[1] + guessColors[2] + guessColors[3]);
        setResults();
        setPreviousGuesses();
        gridPaneRowPosition++;
        event.consume();
            
    }
    
     @FXML
    void blueColorSelected(ActionEvent event) {
        setColorSelected(Color.BLUE, chosenCircle);
    }

    @FXML
    void cancelButtonPressed(ActionEvent event) {
        colorSelectorGrid.setVisible(false);
       gameSplitPane.setVisible(true);
       event.consume();
    }

    @FXML
    void orangeColorSelected(ActionEvent event) {
        setColorSelected(Color.ORANGE, chosenCircle);
    }

    @FXML
    void redColorSelected(ActionEvent event) {
        setColorSelected(Color.RED, chosenCircle);
    }

    @FXML
    void whiteColorSelected(ActionEvent event) {
        setColorSelected(Color.WHITE, chosenCircle);
    }

    @FXML
    void yellowColorSelected(ActionEvent event) {
        setColorSelected(Color.YELLOW, chosenCircle);
    }
    
    private void setColorSelected(Color color, int circle){
        if (color.equals(Color.RED)){
            guessColors[circle-1] = 0;
            setCircleColor(color, circle);
        }
        if (color.equals(Color.WHITE)){
            guessColors[circle-1] = 1;
            setCircleColor(color, circle);
        }
        if (color.equals(Color.YELLOW)){
            guessColors[circle-1] = 2;
            setCircleColor(color, circle);
        }
        if (color.equals(Color.BLUE)){
            guessColors[circle-1] = 3;
            setCircleColor(color, circle);
        }
        if (color.equals(Color.ORANGE)){
            guessColors[circle-1] = 4;
            setCircleColor(color, circle);
        }    
        colorSelectorGrid.setVisible(false);
       gameSplitPane.setVisible(true);
    }
    
    private void setCircleColor(Color color, int circle){
        if (circle == 1)
            Circle1.fillProperty().set(Paint.valueOf(color.toString()));
        if (circle == 2)
            Circle2.fillProperty().set(Paint.valueOf(color.toString()));
        if (circle == 3)
            Circle3.fillProperty().set(Paint.valueOf(color.toString()));
        if (circle == 4)
            Circle4.fillProperty().set(Paint.valueOf(color.toString()));
    }
    
    public void checkReds(){
        setAll(correctGuesses,0);
        for (int a = 0; a < 4; a++){
            if (codeColors[a] == guessColors[a])
                correctGuesses[a] = 1;
        }
        
        if (correctGuesses[0] == 1 && correctGuesses[1] == 1 && correctGuesses[2] ==1 && correctGuesses[3] == 1)
            userWins();
    }
    
    public void checkWhites(){
        int[] codeNumbers = new int[5];
        int[] guessNumbers = new int[5];
        whites = 0;
        for (int a=0; a < 4; a++){
            if (correctGuesses[a]==0)
            codeNumbers[codeColors[a]]++;
        }
        for (int a=0; a < 4; a++){
            if (correctGuesses[a]==0)
            guessNumbers[guessColors[a]]++;
        }
        for (int a=0; a<5; a++){
            if ((codeNumbers[a] > 0) && (guessNumbers[a] >= codeNumbers[a])){
                if (guessNumbers[a] > 1 && codeNumbers[a] > 1){
                    whites++;
                }
                whites++;
            }
            if (((codeNumbers[a] > 0) && guessNumbers[a] > 0) && (codeNumbers[a]-1 == guessNumbers[a])){
                whites++;
            }
        }
    }
    
    public void setResults(){
        
        int columnIndex = 0;
        GridPane addGridPane = new GridPane();
        //Setting red results
        for (int a = 0; a < (correctGuesses[0] + correctGuesses[1] + correctGuesses[2] + correctGuesses[3]); a++){
            addGridPane.addColumn(columnIndex, new Circle(0.0, 0.0, 5.0, javafx.scene.paint.Color.RED));
            columnIndex++;
        }
         //setting whites
        for (int a = 0; a < whites; a++){
            addGridPane.addColumn(columnIndex, new Circle(0.0, 0.0, 5.0, javafx.scene.paint.Color.WHITE));
            columnIndex++;
        }
        guessesResultsGridPane.add(addGridPane, 1, gridPaneRowPosition);
        
    }
    
    public void setPreviousGuesses(){
        Circle pgCircle1 = new Circle(0.0, 0.0, 5.0, Circle1.getFill());
        Circle pgCircle2 = new Circle(0.0, 0.0, 5.0, Circle2.getFill());
        Circle pgCircle3 = new Circle(0.0, 0.0, 5.0, Circle3.getFill());
        Circle pgCircle4 = new Circle(0.0, 0.0, 5.0, Circle4.getFill());
        GridPane addGridPane = new GridPane();
        addGridPane.addColumn(0, pgCircle1);
        addGridPane.addColumn(1, pgCircle2);
        addGridPane.addColumn(2, pgCircle3);
        addGridPane.addColumn(3, pgCircle4);
        guessesResultsGridPane.add(addGridPane, 0, gridPaneRowPosition);
        
    }
    
    public void userWins(){
        System.out.println("You win!");
        System.out.println("Code: " + codeColors[0] + ", " + codeColors[1] + ", " + codeColors[2] + ", " + codeColors[3]);
        System.out.println("Guess: " + guessColors[0] + ", " + guessColors[1] + ", " + guessColors[2] + ", " + guessColors[3]);
        winLoseLabel.setText("     YOU WIN!!!!    ");
        winLosePane.setVisible(true);
        gameSplitPane.setVisible(false);
        colorSelectorGrid.setVisible(false);
        infiniteLoop();
        
    }
    
    public void initialize()
    {
        SecureRandom random = new SecureRandom();
        codeColors[0] = random.nextInt(4) + 1;
        codeColors[1] = random.nextInt(4) + 1;
        codeColors[2] = random.nextInt(4) + 1;
        codeColors[3] = random.nextInt(4) + 1;
        codeColors[0] = 3;
        codeColors[1] = 1;
        codeColors[2] = 4;
        codeColors[3] = 3;
    }
    
    public int[] setAll(int[] intArray, int value){
        for (int a = 0; a < intArray.length; a++){
            intArray[a] = value;
        }
        return intArray;
    }
    
    public void infiniteLoop(){
        while (true){
            
        }
    }

}

