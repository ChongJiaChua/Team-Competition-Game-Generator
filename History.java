import sheffield.*;

public class History {

    private int[][] winners;
    
    public History() {
        winners = new int[Team.count()][Team.count()];
    }

    public void archive(String fileName) {
        EasyWriter output = new EasyWriter(fileName);
        for(int r=0; r<Team.count(); r++) 
            for(int c=0; c<Team.count(); c++) {
               output.print(winners[r][c]*2);
               if  (  c < Team.count()-1  )
                    output.print(",");
               else  output.println();
            }
        output.println();
    }

    public Team[] getTeamsInOrder() {
        //Replace the following line for task 2
        //Creating a new array to store the sum of scores of each team
        int [] totalWins = new int[Team.count()];
        for (int i = 0; i < winners.length; i++) {
            for (int j = 0; j < winners[i].length; j++) {
                totalWins[i] += winners[i][j];
            }
        }
        
        //Selection sort
        Team[] teams = Team.values();
        for (int i = 0; i < totalWins.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < totalWins.length; j++) {
                if (totalWins[j] > totalWins[max]) {
                    max = j;
                }
            }
            if (max != i) {
                int tempWins = totalWins[i];
                totalWins[i] = totalWins[max];
                totalWins[max] = tempWins;
                Team tempTeam = teams[i];
                teams[i] = teams[max];
                teams[max] = tempTeam;
            }
        }
        return teams;
    }

    public void display() {
        final String COLUMN_BREAK = "  |  ";
        
        //The heading
        System.out.print(" ".repeat(Team.LONGEST_NAME));
        for (Team c : Team.values()) {
           System.out.print(COLUMN_BREAK);        
           System.out.print(c);
        }
        System.out.println(COLUMN_BREAK);

        //The rows
        for (Team r : Team.values())  {
           System.out.print(r);
           for (int c = 0; c<Team.count(); c++)  {
                System.out.print(COLUMN_BREAK); 
                String number = String.valueOf(winners[r.ordinal()][c]);       
                System.out.print(" ".repeat(6-number.length()));
                System.out.print(number);
                System.out.print(" ".repeat(4));
           }
           System.out.println(COLUMN_BREAK);
        }

    }

    public void initializeFrom(String fileName) {
        //Write the body of this method for task 1
        //declaring the constant 
        final int NUMBER_OF_COLUMNS_AND_ROWS = 4;
        
        //Counting the number of lines to make sure it does not exceed 4 lines
        int lineNumber = 0;
        EasyReader fileLines = new EasyReader(fileName);
        while(!fileLines.eof()){
            fileLines.readString();
            lineNumber++;
        }
        //Throw error if the number of lines exceeds the requirement
        if (lineNumber > 5) {
            Assignment3.giveUp("There are too many lines in the file");
        }
        
        //Populating the winners array with data of history.csv
        EasyReader fileInput = new EasyReader(fileName);
        for (int i = 0; i < NUMBER_OF_COLUMNS_AND_ROWS; i++) {
            String line = fileInput.readString();
            String[] data = line.split(",");

            //Throw an error if a line is missing 
            if (data.length < 1) {
                Assignment3.giveUp("Line " + (i + 1) + " is not in the file");
            }
            //Checking whether the columns have a value or is empty
            int totalColumns = 0;
            for (String column : data) {
                if (!column.isEmpty()) {
                    totalColumns++;
                }
            }
            //Throw an error if the line has less than 4 columns
            if (totalColumns != NUMBER_OF_COLUMNS_AND_ROWS) {
                Assignment3.giveUp("There are " + totalColumns
                    + " columns in line " + (i + 1));
            }

            for (int j = 0; j < NUMBER_OF_COLUMNS_AND_ROWS; j++) {
                winners[i][j] = Integer.valueOf(data[j]);
            }
        }
        display();
    }

    public void update(Team winner, Team loser) {
        winners[winner.ordinal()][loser.ordinal()]++;      
    }

    public static void main(String[] args) {
        History history = new History();
        history.initializeFrom("history.csv");
        for (Team h : history.getTeamsInOrder())
          System.out.println(h);
    }

}