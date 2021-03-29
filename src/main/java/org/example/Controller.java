package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;

public class Controller {

    @FXML
    private Button makeCoffeeBtn;

    @FXML
    private Button makeCoffeeWithMilkBtn;

    @FXML
    private TextField studentNameTxtField;

    @FXML
    private TextField tasteOfCoffeeTxtField;

    @FXML
    private Slider coffeeSlider;

    @FXML
    private Text quantityOfCoffeeText;

    @FXML
    private Slider cupVolumeSlider;

    @FXML
    private Slider sugarQuantitySlider;

    @FXML
    private Slider kettleVolumeSlider;

    @FXML
    private Slider waterTemperatureSlider;

    @FXML
    private Text studentNameText;

    @FXML
    private Text cupVolumeText;

    @FXML
    private Text tasteOfCoffeeText;

    @FXML
    private Text sugarQuantityText;

    @FXML
    private Text kettleVolumeText;

    @FXML
    private Text kettleTemperatureText;

    @FXML
    private Text resultCounterOfCoffeeCup;

    @FXML
    private  Text resultCounterOfCoffeeWithMilk;

    @FXML
    private  Text resultCounterOfMilk;

    @FXML
    private  Text resultCounterOfTeaCup;

    @FXML
    private  Text resultCounterOfTea;

    @FXML
    private Text unexpectedText;

    private  int  coffeeCupNumber = 0;
    private int coffeeWithMilkNumber =0;
    private int teaCupNumber = 0;
    private int totalCupVolume = 0;
    private int totalCoffeeNum = 0;
    private int totalSugarNum = 0;
    private int totalKettleVolume = 0;
    private int averageKettleTemperature = 0;
    private int totalTeaNum = 0;
    private int totalMilkNum =0;

    public void duplicateCode(int drinkNum)
    {
        boolean correctness = true;
        if(coffeeCupNumber+coffeeWithMilkNumber>8)
        {
            unexpectedText.setText("МНОГО КОФЕ ВРЕДНО...");
        }
        if(coffeeCupNumber+coffeeWithMilkNumber>13)
        {
            unexpectedText.setText("больше кофе не сделаешь)))))");
            correctness = false;
        }
        if(teaCupNumber>10)
        {
            unexpectedText.setText("Много чая тоже вредно!");
            correctness = false;
        }
        if(studentNameTxtField.getText().isEmpty())
        {
            studentNameText.setText("ВВЕДИТЕ ИМЯ!!!!");
            studentNameText.setFill(RED);
            correctness = false;
        }
        // Check coffee taste entering
        if((tasteOfCoffeeTxtField.getText().isEmpty())&&((drinkNum==1)||(drinkNum==0)))
        {
            tasteOfCoffeeText.setText("ВВЕДИТЕ ВКУС КОФЕ!!!");
            tasteOfCoffeeText.setFill(RED);
            correctness = false;
        }
        // Check water temperature entering
        if((waterTemperatureSlider.getValue()<91)&&((drinkNum==1)||(drinkNum==0)))
        {
            kettleTemperatureText.setText("Необходима температура не менее 91 гр.!!!");
            kettleTemperatureText.setFill(RED);
            correctness = false;
        }
        if(correctness)
        {
            studentNameText.setText(studentNameTxtField.getText());
            studentNameText.setFill(BLACK);
            totalCupVolume += (int)cupVolumeSlider.getValue();
            cupVolumeText.setText("Общий объем напитков " + String.valueOf(totalCupVolume)+"  мл.");
            if((drinkNum==1)||(drinkNum==0))
            {
                tasteOfCoffeeText.setText("Вкус кофе  " +'"'+ tasteOfCoffeeTxtField.getText()+'"');
                tasteOfCoffeeText.setFill(BLACK);
                totalCoffeeNum+=(int)coffeeSlider.getValue();
                quantityOfCoffeeText.setText("Общее кол-во кофе  " + String.valueOf(totalCoffeeNum)+"  ед.");
            }
            totalSugarNum+=(int)sugarQuantitySlider.getValue();
            sugarQuantityText.setText("Общее кол-во сахара  " + String.valueOf(totalSugarNum)+ "  ед.");
            totalKettleVolume+=(int)kettleVolumeSlider.getValue();
            kettleVolumeText.setText("Общий объем чайника " + String.valueOf(totalKettleVolume)+"  мл.");
            averageKettleTemperature+=(int)waterTemperatureSlider.getValue();
            averageKettleTemperature/=2;
            kettleTemperatureText.setText("Средняя t воды  "+String.valueOf(averageKettleTemperature)+ "  градусов");
            kettleTemperatureText.setFill(BLACK);
            if(drinkNum==1)
            {
                totalMilkNum += 10;
                resultCounterOfMilk.setText("Общее кол-во молока " + totalMilkNum+"  мл.");
            }
            Coffee coffee = new Coffee(5*(int)coffeeSlider.getValue(),tasteOfCoffeeTxtField.getText());
            Tea tea = new Tea(5, "Сортовой)");
            Sugar sugar = new Sugar(5*(int)sugarQuantitySlider.getValue());
            Cup cup = new Cup(100+((int)cupVolumeSlider.getValue()/10),(int)cupVolumeSlider.getValue(),"");
            Kettle kettle = new Kettle(200+((int)kettleVolumeSlider.getValue()/10),(int)kettleVolumeSlider.getValue(), (int)waterTemperatureSlider.getValue());
            Student student = new Student(studentNameTxtField.getText());
            if(drinkNum==0)
            {
                student.makeCoffee(sugar,coffee,kettle,cup,(int)waterTemperatureSlider.getValue());
                coffeeCupNumber++;
                resultCounterOfCoffeeCup.setText("Приготовлено  "+ coffeeCupNumber +"  ед. кофе без молока");
            }
            if(drinkNum==1)
            {
                student.makeCoffeeWithMilk(sugar, coffee, kettle, cup, (int) waterTemperatureSlider.getValue());
                coffeeWithMilkNumber++;
                resultCounterOfCoffeeWithMilk.setText("Приготовлено  " + coffeeWithMilkNumber + "  ед. кофе c молоком");
            }
            if(drinkNum==2)
            {
                student.makeTea(sugar, kettle, cup, tea);
                teaCupNumber++;
                totalTeaNum += 5;
                resultCounterOfTea.setText("Общее кол-во чая " + totalTeaNum + "  г");
                resultCounterOfTeaCup.setText("Общее кол-во чашек чая " + teaCupNumber + "  ед");
            }
        }
    }
    // Make coffee
    @FXML
    void click(ActionEvent event){
           duplicateCode(0);
        }

        // Make coffee with milk
        @FXML
        void secondClick(ActionEvent event) {
                duplicateCode(1);
        }
        // Make tea
        @FXML
        void thirdClick(ActionEvent event){
            duplicateCode(2);
        }
    }

