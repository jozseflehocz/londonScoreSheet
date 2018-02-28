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
    int redUndergrounds = 0; // red player's victory points for undergrounds
    int redCardDisplayPoints = 0; // red player's victory points for cards on display 
    int redPointsInHand = 0; // red players's collected victory points during the game
    int redUnpaidLoans = 0; // red player's unpaid loans

    int blueScore = 0; //Total score of blue player
    int bluePovertyPoints = 0; // blue player's poverty points 
    int blueMoney = 0; // blue player's total amount of money
    int blueBuildingPoints = 0; // blue player's victory points for buildings
    int blueUndergrounds = 0; // blue player's victory points for undergrounds
    int blueCardDisplayPoints = 0; // blue player's victory points for cards on display 
    int bluePointsInHand = 0; // blue players's collected victory points during the game
    int blueUnpaidLoans = 0; // blue player's unpaid loans

    int minPoverty = 0; //Minimum poverty points among players

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Count red player's number of cards in hand, to convert to poverty points
     *
     * @param v
     */

    public void increaseRedPovertyPoints(View v) {
        redPovertyPoints = redPovertyPoints + 1;
        calculateScore();
    }

    /**
     * Count red player's money
     *
     * @param v
     */

    public void increaseRedMoney(View v) {
        redMoney = redMoney + 1;
        calculateScore();
    }

    /**
     * Count red player's victory points on his buildings
     * (Each borough that you have a building counter in scores
     * a number of victory points as indicated on the board.)
     *
     * @param v
     */
    public void increaseRedBuildings(View v) {
        redBuildingPoints += 1;
        calculateScore();
    }

    /**
     * Count red player's undergrounds each worth 2 victory points
     *
     * @param v
     */
    public void increaseRedUndergrounds(View v) {
        redUndergrounds = redUndergrounds + 1;
        calculateScore();
    }

    /**
     * Count red player's victory points on cards on his card display
     *
     * @param v
     */
    public void increaseRedCardDisplay(View v) {
        redCardDisplayPoints = redCardDisplayPoints + 1;
        calculateScore();
    }

    /**
     * Red player's victory points won while running the city
     *
     * @param v
     */
    public void increaseRedHand(View v) {
        redPointsInHand = redPointsInHand + 1;
        calculateScore();
    }

    /**
     * Count red player's unpaid loans of 10 pounds,
     * with each the victory points should be decreased by 7
     *
     * @param v
     */
    public void decreaseRedLoan(View v) {
        redUnpaidLoans = redUnpaidLoans + 1;
        calculateScore();
    }

    /**
     * Count blue player's number of cards in hand, to convert to poverty points
     *
     * @param v
     */

    public void increaseBluePovertyPoints(View v) {
        bluePovertyPoints = bluePovertyPoints + 1;
        calculateScore();
    }

    /**
     * Count blue player's money, then divide by 3 to convert victory points
     *
     * @param v
     */

    public void increaseBlueMoney(View v) {
        blueMoney = blueMoney + 1;
        calculateScore();
    }

    /**
     * Count blue player's victory points on his buildings
     * (Each borough that you have a building counter in scores
     * a number of victory points as indicated on the board.)
     *
     * @param v
     */
    public void increaseBlueBuildings(View v) {
        blueBuildingPoints = blueBuildingPoints + 1;
        calculateScore();
    }

    /**
     * Count blue player's undergrounds
     *
     * @param v
     */
    public void increaseBlueUndergrounds(View v) {
        blueUndergrounds = blueUndergrounds + 1;
        calculateScore();
    }

    /**
     * Count blue player's victory points on cards on his card display
     *
     * @param v
     */
    public void increaseBlueCardDisplay(View v) {
        blueCardDisplayPoints = blueCardDisplayPoints + 1;
        calculateScore();
    }

    /**
     * Blue player's victory points won while running the city
     *
     * @param v
     */
    public void increaseBlueHand(View v) {
        bluePointsInHand = bluePointsInHand + 1;
        calculateScore();
    }

    /**
     * Count blue player's unpaid loans of 10 pounds,
     * with each the victory points should be decreased by 7
     *
     * @param v
     */
    public void decreaseBlueLoan(View v) {
        blueUnpaidLoans = blueUnpaidLoans + 1;
        calculateScore();
    }


    /**
     * Calculates penalty of players after the poverty points,
     * then display the players total score
     */
    public void calculateScore() {

        //total scores should be reseted before every calculation
        redScore = 0;
        blueScore = 0;

        //Red player's score
        //https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        // (Take one victory point for each lot of £3 you have.)
        redScore += Math.round(((double) redMoney / 3) * 10d) / 10d;

        //Each borough that you have a building counter in scores
        //a number of victory points as indicated on the board.
        redScore += redBuildingPoints;

        // (Add two victory points to this value if there is an Underground
        // counter in the borough)
        redScore += redUndergrounds * 2;

        //Each card in your Building Display, irrespective of whether the card has been
        //flipped or built on top of, scores a number of victory points as indicated
        // on the card
        redScore += redCardDisplayPoints;

        //Count the victory points in hand that you have gained.
        redScore += redPointsInHand;

        //Each unpaid loan of £10 loses you seven victory points.
        redScore += -7 * redUnpaidLoans;

        //Blue player's score
        //https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        // (Take one victory point for each lot of £3 you have.)
        blueScore += Math.round(((double) blueMoney / 3) * 10d) / 10d;
        //Each borough that you have a building counter in scores
        //a number of victory points as indicated on the board.
        blueScore += blueBuildingPoints;
        // (Add two victory points to this value if there is an Underground
        // counter in the borough)
        blueScore += blueUndergrounds * 2;

        //Each card in your Building Display, irrespective of whether the card has been
        //flipped or built on top of, scores a number of victory points as indicated
        // on the card
        blueScore += blueCardDisplayPoints;

        //Count the victory points in hand that you have gained.
        blueScore += bluePointsInHand;

        //Each unpaid loan of £10 loses you seven victory points.
        blueScore += -7 * blueUnpaidLoans;
        calculatePovertyPoints();
        displayScore();
    }

    /**
     * Calculates players penalty after his poverty points
     * Consult the Poverty Points table to determine your VP Penalty.     *
     */
    public void calculatePovertyPoints() {

        //final PPs = (PPs + 1 / card in your hand) - min(PPs players )
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
        } else if (povertyDifference < 0) {
            povertyDifference = -1 * povertyDifference;
            // Blue player's victory point adjustment by poverty point table
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
     * Reset all points and display scores
     *
     * @param v
     */
    public void resetScore(View v) {
        redScore = 0;
        redPovertyPoints = 0;
        redMoney = 0;
        redBuildingPoints = 0;
        redUndergrounds = 0;
        redCardDisplayPoints = 0;
        redPointsInHand = 0;
        redUnpaidLoans = 0;

        blueScore = 0;
        bluePovertyPoints = 0;
        blueMoney = 0;
        blueBuildingPoints = 0;
        blueUndergrounds = 0;
        blueCardDisplayPoints = 0;
        bluePointsInHand = 0;
        blueUnpaidLoans = 0;

        calculatePovertyPoints();
        displayScore();
    }

    /**
     * Displays players total score, and poverty points for easier checking
     */
    public void displayScore() {
        TextView scoreView = (TextView) findViewById(R.id.red_player_score);
        scoreView.setText(String.valueOf(redScore));
        scoreView = (TextView) findViewById(R.id.red_player_poverty);
        scoreView.setText(String.valueOf(redPovertyPoints));
        scoreView = (TextView) findViewById(R.id.blue_player_score);
        scoreView.setText(String.valueOf(blueScore));
        scoreView = (TextView) findViewById(R.id.blue_player_poverty);
        scoreView.setText(String.valueOf(bluePovertyPoints));
    }
}
