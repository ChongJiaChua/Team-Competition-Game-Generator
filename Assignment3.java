public class Assignment3 {

    public static void giveUp(String reason) {
        System.out.println("Giving up because...");
        System.out.println(reason);
        //There are better was to do this 
        System.exit(0);
    }

    public static void main (String [] args) {

        History history = new History();
        history.initializeFrom("history.csv");

        new Competition(history).updateHistoryWithResultOfPlay(); 

        history.archive("history.csv");   

    }
}