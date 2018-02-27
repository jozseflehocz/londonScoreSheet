package com.example.jlehocz.londonscoresheet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int redScore = 0; //Total score of red player
    int redPovertyPoints = 0; // red player's poverty points 
    int redMoney = 0; // red player's total amount of money
    int redBuildingPoints = 0; // red player's victory points for buildings
    int redUndergroundPoints = 0; // red player's victory points for undergrounds
    int redCardDisplayPoints = 0; // red player's victory points for cards on display 
    int redPointsInHand = 0; // red players's collected victory points during the game
    int redUnpaidLoans = 0; // red player's unpaid loans

    int blueScore = 0; //Total score of blue player
    int bluePovertyPoints = 0; // blue player's poverty points 
    int blueMoney = 0; // blue player's total amount of money
    int blueBuildingPoints = 0; // blue player's victory points for buildings
    int blueUndergroundPoints = 0; // blue player's victory points for undergrounds
    int blueCardDisplayPoints = 0; // blue player's victory points for cards on display 
    int bluePointsInHand = 0; // blue players's collected victory points during the game
    int blueUnpaidLoans = 0; // blue player's unpaid loans

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*Pay off as many loans as possible. To repay a loan, you must pay £15 to the bank.
             Calculate your final PPs = (PPs + 1 / card in your hand) - min(PPs players )

         Discard your remaining cards.
    Consult the Poverty Points table to determine your VP Penalty.
             VPs Number =
            VPs won while running the city
+ 1 VP / lot of £3
+ x VPs / borough occupied by one of your building, increased by 2 if there is
    an Underground counter (x varies according to the borough)
+ VPs scored by the cards in your Building Display
- 7 VPs / unpaid loan of £10
- VP Penalty
 The player with the most victory points is the winner.
             If there is a tie, then the tied player who has the fewest poverty points is the winner.
    If there is still a tie, then the tied player who occupies the most boroughs on the map
    is the winner. If the tie is still not broken, then the tied player who has the single
    highest value victory point card is the winner.*/

    

    /**
     * Count red player's poverty points, which equals the number of cards in hand     *
     *
     * @param v
     */

    public void increaseRedPovertyPoints(View v) {
        redPovertyPoints = redPovertyPoints + 1;
        calculateForRedPlayer();
    }

    /**
     * Count red player's money, then divide by 3 to convert victory points     *
     *
     * @param v
     */

    public void increaseRedMoney(View v) {
        redMoney = redMoney + 1;
        calculateForRedPlayer();
    }

    /**
     * Count red player's victory points on his buildings
     *
     * @param v
     */
    public void increaseRedBuildings(View v) {
        redBuildingPoints = redBuildingPoints + 1;
        calculateForRedPlayer();
    }

    /**
     * Count red player's undergrounds each worth 2 victory points
     *
     * @param v
     */
    public void increaseRedUndergrounds(View v) {
        //redUndergroundPoints = redUndergroundPoints + 1;
        redScore += 2;
        calculateForRedPlayer();
    }

    /**
     * Count red player's victory points on cards on his card display
     *
     * @param v
     */
    public void increaseRedCardDisplay(View v) {
        //redCardDisplayPoints = redCardDisplayPoints + 1;
        redScore += 1;
        calculateForRedPlayer();
    }

    /**
     * Count red player's victory points collected during the game
     *
     * @param v
     */
    public void increaseRedHand(View v) {
        //redPointsInHand = redPointsInHand + 1;
        redScore += 1;
        calculateForRedPlayer();
    }

    /**
     * Count red player's unpaid loans of 10 pounds,
     * with each the victory points should be decreased by 7
     *
     * @param v
     */
    public void decreaseRedLoan(View v) {
        //redUnpaidLoans = redUnpaidLoans + 1;
        redScore += -7;
        calculateForRedPlayer();
    }

    /**
     * Calculates red player's penalty after the poverty points,
     * then display the player's total score
     */
    public void calculateForRedPlayer() {
        //https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        redScore += (int) (Math.round((redMoney / 3) * 10d) / 10d);
        redScore += redBuildingPoints;

        calculateRedPovertyPoints();
        displayForRedPlayer();
    }

    /**
     * Calculates red player's penalty after his poverty points
     */
    public void calculateRedPovertyPoints() {

        int povertyDifference = redPovertyPoints - bluePovertyPoints;

        //The lowest poverty point becomes 0, the highest decreased with the lowest
        if (povertyDifference > 0) {
            // Red player's victory point adjustment by poverty point table
            if (povertyDifference > 10) {
                redScore = redScore - 15 - 3 * (povertyDifference - 10);
            } else if (povertyDifference == 10) {
                redScore = redScore - 15;
            } else if (povertyDifference == 9) {
                redScore = redScore - 13;
            } else if (povertyDifference == 8) {
                redScore = redScore - 11;
            } else if (povertyDifference == 7) {
                redScore = redScore - 9;
            } else if (povertyDifference == 6) {
                redScore = redScore - 7;
            } else if (povertyDifference == 5) {
                redScore = redScore - 5;
            } else if (povertyDifference == 4) {
                redScore = redScore - 3;
            } else if (povertyDifference == 3) {
                redScore = redScore - 2;
            } else {
                redScore = redScore - 1;
            }
        }
    }

    /**
     * Displays red player's total score
     */
    public void displayForRedPlayer() {
        TextView scoreView = (TextView) findViewById(R.id.red_player_score);
        scoreView.setText(String.valueOf(redScore));
    }

    /**
     * Count blue player's poverty points, which equals the number of cards in hand     *
     *
     * @param v
     */

    public void increaseBluePovertyPoints(View v) {
        bluePovertyPoints = bluePovertyPoints + 1;
        calculateForBluePlayer();
    }

    /**
     * Count blue player's money, then divide by 3 to convert victory points     *
     *
     * @param v
     */

    public void increaseBlueMoney(View v) {
        blueMoney = blueMoney + 1;
        //https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        blueScore = (int) (Math.round((blueMoney / 3) * 10d) / 10d);
        calculateForBluePlayer();
    }

    /**
     * Count blue player's victory points on his buildings
     *
     * @param v
     */
    public void increaseBlueBuildings(View v) {
        //blueBuildingPoints = blueBuildingPoints + 1;
        blueScore += 1;
        calculateForBluePlayer();
    }

    /**
     * Count blue player's undergrounds each worth 2 victory points
     *
     * @param v
     */
    public void increaseBlueUndergrounds(View v) {
        //blueUndergroundPoints = blueUndergroundPoints + 1;
        blueScore += 2;
        calculateForBluePlayer();
    }

    /**
     * Count blue player's victory points on cards on his card display
     *
     * @param v
     */
    public void increaseBlueCardDisplay(View v) {
        //blueCardDisplayPoints = blueCardDisplayPoints + 1;
        blueScore += 1;
        calculateForBluePlayer();
    }

    /**
     * Count blue player's victory points collected during the game
     *
     * @param v
     */
    public void increaseBlueHand(View v) {
        //bluePointsInHand = bluePointsInHand + 1;
        blueScore += 1;
        calculateForBluePlayer();
    }

    /**
     * Count blue player's unpaid loans of 10 pounds,
     * with each the victory points should be decreased by 7
     *
     * @param v
     */
    public void decreaseBlueLoan(View v) {
        //blueUnpaidLoans = blueUnpaidLoans + 1;
        blueScore += -7;
        calculateForBluePlayer();
    }

    /**
     * Calculates blue player's penalty after the poverty points,
     * then display the player's total score
     */
    public void calculateForBluePlayer() {
        calculateBluePovertyPoints();
        displayForBluePlayer();
    }

    /**
     * Calculates blue player's penalty after his poverty points
     */
    public void calculateBluePovertyPoints() {

        int povertyDifference = bluePovertyPoints - redPovertyPoints;

        //The lowest poverty point becomes 0, the highest decreased with the lowest
        if (povertyDifference > 0) {

            // Red player's victory point adjustment by poverty point table
            if (povertyDifference > 10) {
                blueScore = blueScore - 15 - 3 * (povertyDifference - 10);
            } else if (povertyDifference == 10) {
                blueScore = blueScore - 15;
            } else if (povertyDifference == 9) {
                blueScore = blueScore - 13;
            } else if (povertyDifference == 8) {
                blueScore = blueScore - 11;
            } else if (povertyDifference == 7) {
                blueScore = blueScore - 9;
            } else if (povertyDifference == 6) {
                blueScore = blueScore - 7;
            } else if (povertyDifference == 5) {
                blueScore = blueScore - 5;
            } else if (povertyDifference == 4) {
                blueScore = blueScore - 3;
            } else if (povertyDifference == 3) {
                blueScore = blueScore - 2;
            } else {
                blueScore = blueScore - 1;
            }
        }
    }

    /**
     * Displays blue player's total score
     */
    public void displayForBluePlayer() {
        TextView scoreView = (TextView) findViewById(R.id.blue_player_score);
        scoreView.setText(String.valueOf(blueScore));
    }


    /**
     * Reset all points and scores
     *
     * @param v
     */
    public void resetScore(View v) {
        redScore = 0;
        redPovertyPoints = 0;
        redMoney = 0;
        redBuildingPoints = 0;
        redUndergroundPoints = 0;
        redCardDisplayPoints = 0;
        redPointsInHand = 0;
        redUnpaidLoans = 0;

        blueScore = 0;
        bluePovertyPoints = 0;
        blueMoney = 0;
        blueBuildingPoints = 0;
        blueUndergroundPoints = 0;
        blueCardDisplayPoints = 0;
        bluePointsInHand = 0;
        blueUnpaidLoans = 0;

        displayForRedPlayer();
        displayForBluePlayer();
    }
}
