/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxloancalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author JavierCastilloM
 */
public class JavaFXLoanCalculator extends Application {

    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btnCalculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(15, 15, 15, 15));

        grid.add(new Label("Annual Interest Rate: "), 0, 0);
        grid.add(tfAnnualInterestRate, 1, 0);
        grid.add(new Label("Number of Years: "), 0, 1);
        grid.add(tfNumberOfYears, 1, 1);
        grid.add(new Label("Loan Amount: "), 0, 2);
        grid.add(tfLoanAmount, 1, 2);
        grid.add(new Label("Monthly Payment: "), 0, 3);
        grid.add(tfMonthlyPayment, 1, 3);
        grid.add(new Label("Total Payment: "), 0, 4);
        grid.add(tfTotalPayment, 1, 4);

        HBox box = new HBox();
        box.setAlignment(Pos.CENTER_RIGHT);
        box.getChildren().add(btnCalculate);
        grid.add(box, 1, 5);

        btnCalculate.setOnAction(event -> calculateLoan());

        Scene scene = new Scene(grid, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateLoan() {

        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        int years = Integer.parseInt(tfNumberOfYears.getText());
        double loan = Double.parseDouble(tfLoanAmount.getText());
        double monthlyInterestRate = interest / 1200;

        double monthlyPayment = (loan * monthlyInterestRate) / (1 - (Math.pow(1 / (1 + monthlyInterestRate), (12 * years))));

        tfMonthlyPayment.setText(String.format("$%.2f", monthlyPayment));
        tfTotalPayment.setText(String.format("$%.2f", monthlyPayment * 12 * years));

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
