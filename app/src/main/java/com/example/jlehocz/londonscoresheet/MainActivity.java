package com.example.jlehocz.londonscoresheet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int redPoints = 0;
    int redPoverty = 0;
    int redMoney = 0;
    int redBuildings = 0;
    int redUndergrounds = 0;
    int redCardDisplay = 0;
    int redHand = 0;
    int redLoan = 0;

    int bluePoints = 0;
    int bluePoverty = 0;
    int blueMoney = 0;
    int blueBuildings = 0;
    int blueUndergrounds = 0;
    int blueCardDisplay = 0;
    int blueHand = 0;
    int blueLoan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the poverty points for red player by 1
     */

    public void increaseRedPoverty(View v) {
        redPoverty = redPoverty + 1;
    }

    /**
     * Increase the money for red player by 1
     */

    public void increaseRedMoney(View v) {
        redMoney = redMoney + 1;
    }

    /**
     * Increase the victory points for buildings of red player by 1
     */

    public void increaseRedBuildings(View v) {
        redBuildings = redBuildings + 1;
    }

    /**
     * Increase the undergrounds of red player by 1
     */

    public void increaseRedUndergrounds(View v) {
        redUndergrounds = redUndergrounds + 1;
    }

    /**
     * Increase the victory points for cards on display of red player by 1
     */

    public void increaseRedCardDisplay(View v) {
        redCardDisplay = redCardDisplay + 1;
    }

    /**
     * Increase the victory points for cards on display of red player by 1
     */

    public void increaseRedHand(View v) {
        redHand = redHand + 1;
    }

    /**
     * Inccrease the unpaid loans of red player by 1
     */

    public void decreaseRedLoan(View v) {
        redLoan = redLoan + 1;
    }

    /**
     * Increase the poverty points for blue player by 1
     */

    public void increasebluePoverty(View v) {
        bluePoverty = bluePoverty + 1;
    }

    /**
     * Increase the money for blue player by 1
     */

    public void increaseblueMoney(View v) {
        blueMoney = blueMoney + 1;
    }

    /**
     * Increase the victory points for buildings of blue player by 1
     */

    public void increaseblueBuildings(View v) {
        blueBuildings = blueBuildings + 1;
    }

    /**
     * Increase the undergrounds of blue player by 1
     */

    public void increaseblueUndergrounds(View v) {
        blueUndergrounds = blueUndergrounds + 1;
    }

    /**
     * Increase the victory points for cards on display of blue player by 1
     */

    public void increaseblueCardDisplay(View v) {
        blueCardDisplay = blueCardDisplay + 1;
    }

    /**
     * Increase the victory points for cards on display of blue player by 1
     */

    public void increaseblueHand(View v) {
        blueHand = blueHand + 1;
    }

    /**
     * Increase the unpaid loans of blue player by 1
     */

    public void decreaseblueLoan(View v) {
        blueLoan = blueLoan + 1;
    }

    /**
     * Reset all values to 0
     */
    public void resetScore(View v) {
        redPoints = 0;
        redPoverty = 0;
        redMoney = 0;
        redBuildings = 0;
        redUndergrounds = 0;
        redCardDisplay = 0;
        redHand = 0;
        redLoan = 0;

        bluePoints = 0;
        bluePoverty = 0;
        blueMoney = 0;
        blueBuildings = 0;
        blueUndergrounds = 0;
        blueCardDisplay = 0;
        blueHand = 0;
        blueLoan = 0;
    }
}
