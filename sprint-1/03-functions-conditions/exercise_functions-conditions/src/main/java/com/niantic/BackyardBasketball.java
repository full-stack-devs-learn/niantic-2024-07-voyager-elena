package com.niantic;

public class BackyardBasketball {
    /*
     * Teams that play in the backyard league want to be able
     * to calculate their winning percentage.
     *
     * Each team knows how many games they have won and how many
     * games they have lost. When they call this function they
     * will provide their wins and losses.
     *
     * You need to perform the calculation and return their
     * winning percentage as a whole number.
     *
     * Example:
     * If a team has won 7 games and lost 3 games their winning
     * percentage is 70%.
     *
     * calculateWinningPercentage(7, 3) -> 70
     * calculateWinningPercentage(5, 5) -> 50
     * calculateWinningPercentage(5, 10) -> 33
     *
     */
    public int calculateWinningPercentage(int gamesWon, int gamesLost) {
        int gamesTotal = gamesWon + gamesLost;
        int winningPercentage = (int) Math.round((double) gamesWon / gamesTotal * 100);
        return winningPercentage;
    }

    /*
     * The calculatePointsScored function should calculate
     * the number of points a player scored in a game.
     *
     * shotPercentage = the percent of shots made
     * shotsTaken = the number of shots the player took
     * isThree = if true, the player shot a 3 pointer otherwise a 2
     *
     * calculatePointsScored(70, 10, false) -> 14
     * calculatePointsScored(70, 10, true) -> 21
     * calculatePointsScored(67, 15, false) -> 20
     *
     */
    public int calculatePointsScored(int shotPercentage, int shotsTaken, boolean isThree) {
        int successfulShots = (int) Math.round(shotsTaken * shotPercentage / 100.00);
        int pointsPerShot = 2;

        if (isThree) {
            pointsPerShot = 3;
        }

        int pointsScored = successfulShots * pointsPerShot;

        return pointsScored;
    }


    /*
     * Calculate the minimum number of shots that are required
     * to score the desired number of points.
     *
     * shotPercentage = the estimated % of shots that will go in (whole number)
     * desiredScore = the number of points you want to score
     * isThree = if true, the player will shoot a 3 pointer otherwise a 2
     *
     * Example:
     * If a player has a 50% scoring average, and he wants to score 10 points,
     * how many shots will he have to take (if he is NOT shooting 3 pointers)
     *
     * calculateShotsRequired(50, 10, false) -> 10
     *
     * calculateShotsRequired(50, 10, true) -> 8
     * calculateShotsRequired(75, 15, true) -> 7
     * calculateShotsRequired(80, 18, true) -> 8
     * calculateShotsRequired(67, 24, false) -> 18     *
     *
     */
    public int calculateShotsRequired(int shotPercentage, int desiredScore, boolean isThree) {
        int pointsPerShot = 2;
        int neededScore;

        if (isThree) {
            pointsPerShot = 3;
        }

        // make neededScore divisible by pointsPerShort
        if (desiredScore % pointsPerShot == 0) {
            neededScore = desiredScore;
        } else {
            neededScore = desiredScore + (pointsPerShot - desiredScore % pointsPerShot);
        }

        double averagePointsPerShot = pointsPerShot * shotPercentage / 100.0;
        int shotsRequired = (int) Math.round(neededScore / averagePointsPerShot);

        return shotsRequired;
    }
}