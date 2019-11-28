package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class Controller {

    @FXML private AnchorPane rootPane;
    @FXML private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bp,bm,bu,bd,beq,bcl,bdot;
    @FXML private RadioButton rad1 = new RadioButton(), rad2 = new RadioButton();
    @FXML private ToggleGroup tg = new ToggleGroup();
    @FXML private TextArea resultNum;

    private String operator = "";
    private float number1 = 0.0f;
    private Model model = new Model();
    private boolean start = true;


    @FXML public void loadFirst(ActionEvent event) throws  IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("UI/Num.fxml"));
        rootPane.getChildren().setAll(pane);
        rad1.setSelected(true);
    }

    @FXML public void loadSecond(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("UI/Shiz.fxml"));
        rootPane.getChildren().setAll(pane);
        rad2.setSelected(true);
    }

    @FXML public void processNumpad (ActionEvent event) {
        if (start) {
            resultNum.setText("0");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();

        if (!".".equals(value) & resultNum.getText().equals("0"))
            resultNum.setText("");
        if (".".equals(value) & model.countCharOccurences(resultNum.getText(), '.') > 0)
            resultNum.setText(resultNum.getText());
        else
        resultNum.setText(resultNum.getText() + value);

    }

    @FXML public void processOperator (ActionEvent event) {
        String value = ((Button)event.getSource()).getText();

        if ("C".equals(value)) {
            resultNum.setText("0");
            number1 = 0.0f;
            return;
        }
        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;
            operator = value;
            number1 = Float.parseFloat(resultNum.getText());
            resultNum.setText("0");

        } else {
            if (operator.isEmpty())
                return;
            resultNum.setText(String.valueOf(model.calculate(number1, Float.parseFloat(resultNum.getText()), operator)));
            operator = "";
            start = true;
        }
    }

    @FXML public void initialize() {
        rad1.setToggleGroup(tg);
        rad2.setToggleGroup(tg);
    }

}

