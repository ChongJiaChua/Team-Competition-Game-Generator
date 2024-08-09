
public enum Team {
    GRYFFINDOR,
    HUFFLEPUFF,
    RAVENCLAW,
    SLYTHERIN;
    

    public static final int LONGEST_NAME=10;

    public static int count()  {
        return values().length;
    }

    public String toString() {
        return 
            (name().charAt(0)+name().substring(1).toLowerCase() +
                 " ".repeat(LONGEST_NAME-1)).
                 substring(0, LONGEST_NAME);
    }

}