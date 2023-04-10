public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1_Score, int player2_Score) {
        String gameResult = "";
        if (player1_Score == player2_Score) {
            gameResult = getMinusScore(player1_Score);
        } else if (player1_Score >= 4 || player2_Score >= 4) {
            int minusScore = player1_Score - player2_Score;
            if (minusScore == 1) gameResult = "Advantage player1";
            else if (minusScore == -1) gameResult = "Advantage player2";
            else if (minusScore >= 2) gameResult = "Win for player1";
            else gameResult = "Win for player2";
        } else {
            gameResult = getNormalScore(player1_Score, player2_Score);
        }
        return gameResult;
    }

    private static String getNormalScore(int player1_Score, int player2_Score) {
        int tempScore;
        String result = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1_Score;
            else {
                result += "-";
                tempScore = player2_Score;
            }
            switch (tempScore) {
                case 0 -> result += "Love";
                case 1 -> result += "Fifteen";
                case 2 -> result += "Thirty";
                case 3 -> result += "Forty";
            }
        }
        return result;
    }

    private static String getMinusScore(int player1_Score) {
        return switch (player1_Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";
        };
    }
}
