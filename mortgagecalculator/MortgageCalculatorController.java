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

public class MortgageCalculatorController {

    // formatters for currency and percentages
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    private BigDecimal customLoanDuration = new BigDecimal(1.0);

    // FXML stuff
    @FXML
    private Label customLoanLabel;

    @FXML
    private Slider customLoanSlider;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField interestRateTextField;

    @FXML
    private TextField downPaymentTextField;

    @FXML
    private Label thirtyYearLoanLabel;

    @FXML
    private Label loanAmountLabel;

    @FXML
    private Label tenYearLoanLabel;

    @FXML
    private Label twentyYearLoanLabel;

    @FXML
    private Label customLoanReportLabel;

    @FXML
    private void calculateButtonPressed(ActionEvent event) {
        try {

            // Variables for different things I need
            BigDecimal price = new BigDecimal(priceTextField.getText());
            BigDecimal basePrice = new BigDecimal(priceTextField.getText());
            BigDecimal downPayment = new BigDecimal(downPaymentTextField.getText());
            BigDecimal interest = new BigDecimal(interestRateTextField.getText());
            BigDecimal tenYears = new BigDecimal(120.0);
            BigDecimal twentyYears = new BigDecimal(240.0);
            BigDecimal thirtyYears = new BigDecimal(360.0);

            // Set the loan amount label then use calculatePrice() to determine the payment
            // for
            // the different loan lengths and set the labels they correspond to
            loanAmountLabel.setText(currency.format(price.subtract(downPayment)));
            price = calculatePrice(basePrice.subtract(downPayment), interest, tenYears);

            tenYearLoanLabel.setText(currency.format(price) + "/month");
            price = calculatePrice(basePrice.subtract(downPayment), interest, twentyYears);

            twentyYearLoanLabel.setText(currency.format(price) + "/month");
            price = calculatePrice(basePrice.subtract(downPayment), interest, thirtyYears);

            thirtyYearLoanLabel.setText(currency.format(price) + "/month");
            price = calculatePrice(basePrice.subtract(downPayment), interest, customLoanDuration.multiply(new BigDecimal(12)));

            customLoanReportLabel.setText(currency.format(price) + "/month");
        } catch (NumberFormatException e) {
            // If user enters in nothing or something other than number
            priceTextField.setText("Enter Amount");
            priceTextField.selectAll();
            priceTextField.requestFocus();
            downPaymentTextField.setText("Enter Amount");
            downPaymentTextField.selectAll();
            interestRateTextField.setText("Enter Rate");
            interestRateTextField.selectAll();

        }

    }

    // called by FXMLLoader to initialize the controller
    public void initialize() {
        // 0-4 rounds down, 5-9 rounds up
        currency.setRoundingMode(RoundingMode.HALF_UP);

        // listener for changes to customLoadSlider's value
        customLoanSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                customLoanDuration = BigDecimal.valueOf(newValue.intValue());
                customLoanLabel.setText(customLoanDuration.toString() + " years");
            }
        });
    }

    // Method returns the monthly price
    public BigDecimal calculatePrice(BigDecimal cPrincipal, BigDecimal cInterest, BigDecimal cNumMonths) {
        // Formula : M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1] P=principle, n=number
        // months, i=monthly interest rate

        
        // how big should the scale be? 2? more than 2 decimal places for interest and the calculations inside? Im not sure.
        //probably 2 for the monthly price divison/mulitplication tho
        cInterest = cInterest.divide(divisor, 2, RoundingMode.HALF_UP);
        BigDecimal monthlyPrice = new BigDecimal((cPrincipal
                .multiply(cInterest.multiply(pow(1 + cInterest.doubleValue(), cNumMonths.doubleValue()), 2,
                        RoundingMode.HALF_UP), 2, RoundingMode.HALF_UP) // numerator
                .divide(Math.pow(1 + cInterest.doubleValue(), cNumMonths.doubleValue()) - 1, 2, RoundingMode.HALF_UP)) // denominator
        );
        return monthlyPrice;
    }
}
