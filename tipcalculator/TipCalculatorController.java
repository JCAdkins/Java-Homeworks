package tipcalculator;

import javafx.fxml.FXML;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController {
    //formatters for currency and percentages
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal tipPercentage = new BigDecimal(0.15);

    //GUI controls defined in FXML and used by controllers code
    @FXML
    private Label tipPercentageLabel;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private Slider tipPercentageSlider;
    
    
    // called by FXMLLoader to initialize the controller
   public void initialize() {
      // 0-4 rounds down, 5-9 rounds up 
      currency.setRoundingMode(RoundingMode.HALF_UP);
      
      // Binding tipPercentageSlider to tipPercentageLabel to update text auto
      tipPercentageLabel.textProperty().bind(tipPercentageSlider.valueProperty().asString("%.0f%%"));

      // listener for amountTextField to update results whenever textField is changed
      amountTextField.textProperty().addListener(
              new ChangeListener<String>(){

          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              amountTextFieldChanged();
              amountTextField.requestFocus();
            }
              });
      
      // listener for changes to tipPercentageSlider's value
      tipPercentageSlider.valueProperty().addListener(
         new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, 
               Number oldValue, Number newValue) {
               tipPercentage = 
                  BigDecimal.valueOf(newValue.intValue() / 100.0);
              // tipPercentageLabel.setText(percent.format(tipPercentage));
            
               amountTextFieldChanged();
               
            }
         }
      );
   }
   
   // Method that updates the tip and total textFields 
   public void amountTextFieldChanged(){
       try 
        {
            BigDecimal amount = new BigDecimal(amountTextField.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);
            
            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
            
        }
        catch (NumberFormatException e)
        {
            if (!amountTextField.getText().equals(""))
            {
            amountTextField.setText("Enter Amount");
            }
            amountTextField.selectAll();
            amountTextField.requestFocus();
            tipTextField.setText("");
            totalTextField.setText("");
            
                    
        }
   }
}