import sheffield.*;

public class Match {
    
    private static EasyReader keyboard = new EasyReader();

    Team one, other;
    History history;

    private Player getPlayerFromOneOfTheTeams() {
        //Replace the next line for task 4
        //Prompting for a player name
        String name = keyboard.readString("Who scored? ");
        Player scorer = Player.called(name);

        /*Checking whether the player given matches the name
            of the players playing in the 2 teams*/
        if (scorer == null) {
            System.out.println(
                "That is not the name of a player from any team");
            return null;
        }
        if (scorer.isIn(one) || scorer.isIn(other)) {
            return scorer;
        }
        else {
            System.out.println("The scorer must be from " 
                + one.toString() + " or " + other.toString());
            return null;
        }
    }

    public Match (Team a, Team b, History h) {
        one = a;
        other = b;
        history = h;
    }

    public Team getWinnerAndUpdateHistory() {
        final int GOAL_SCORE = 10, SNITCH_SCORE = 150;
        //Replace the rest of this method for task 5
        //Printing out the name of the teams that are currently playing
        System.out.println("A match between " 
            + one.toString() + "and " + other.toString());
        //declaring the variables
        int scoreOfOne = 0;
        int scoreOfOther = 0;
        Player scorer;
        boolean snitch = false;
        //adding the points to the team that scored
        while (!snitch) {
            scorer = getPlayerFromOneOfTheTeams();
            if (scorer != null) {
                if (!snitch) {
                    if (scorer.isIn(one)) {
                        scoreOfOne += GOAL_SCORE;
                    } 
                    else if (scorer.isIn(other)) {
                        scoreOfOther += GOAL_SCORE;
                    }
                }
                //asking whether the player who scored caught the snitch
                String snitchCondition = keyboard.readString(
                    "Did they catch the snitch? ");
                //adding the snitch score to the team that caught it
                if (snitchCondition.equalsIgnoreCase("y")) {
                    snitch = true;
                    if (scorer.isIn(one)) {
                        scoreOfOne += SNITCH_SCORE;
                        scoreOfOne -= GOAL_SCORE;
                    } 
                    else if (scorer.isIn(other)) {
                        scoreOfOther += SNITCH_SCORE;
                        scoreOfOther -= GOAL_SCORE;
                    }
                }
            }
        }
        //finalising the winner of the match
        Team winner, loser;
        if (scoreOfOne > scoreOfOther) {
            winner = one;
            loser = other;
        } 
        else {
            winner = other;
            loser = one;
        }
        //updating the history after the match
        history.update(winner, loser);
        
        //calculating the margin by which the winning team won.
        int margin;
        if (scoreOfOne > scoreOfOther) {
            margin = scoreOfOne - scoreOfOther;
        } 
        else {
            margin = scoreOfOther - scoreOfOne;
        }
        
        //printing out the winner of the match
        System.out.println("The winner is " + winner 
            + "by " + margin + " points");
        System.out.println();

        return winner;
    }


    public static void main (String[] args)  {
        Match m = new Match(
            Team.valueOf(args[0].toUpperCase()), 
            Team.valueOf(args[1].toUpperCase()), 
            null);
        System.out.println(m.getPlayerFromOneOfTheTeams());
    }

}