public enum Player {
   ALEX (Team.GRYFFINDOR),
   ANIS (Team.SLYTHERIN),
   CHUA (Team.RAVENCLAW),
   COLM (Team.GRYFFINDOR),
   DANA (Team.SLYTHERIN),
   DEYU (Team.HUFFLEPUFF),
   ECHO (Team.RAVENCLAW),
   EMMA (Team.GRYFFINDOR),
   ERIK (Team.HUFFLEPUFF),
   IDER (Team.RAVENCLAW),
   JACK (Team.SLYTHERIN),
   JOEL (Team.HUFFLEPUFF),
   JUDE (Team.RAVENCLAW),
   KYLE (Team.GRYFFINDOR),
   LILY (Team.SLYTHERIN),
   LUKE (Team.RAVENCLAW),
   MARC (Team.SLYTHERIN),
   MARK (Team.GRYFFINDOR),
   MOAZ (Team.RAVENCLAW),
   NOAH (Team.SLYTHERIN),
   OWEN (Team.HUFFLEPUFF),
   RAUL (Team.HUFFLEPUFF),
   RHEA (Team.RAVENCLAW),
   RORY (Team.GRYFFINDOR),
   RYAN (Team.HUFFLEPUFF),
   SEAN (Team.GRYFFINDOR),
   THEO (Team.SLYTHERIN),
   TUGI (Team.HUFFLEPUFF);

   private Team playersTeam;
   private Player(Team t)  {
      playersTeam = t;
   }

   public boolean isIn(Team t)  {
      return playersTeam == t;
   }

   public static Player called(String name)  {
      //This is a bad way to do this but
      //you haven't learned the right way yet
      switch(name.toUpperCase())  {
         case 
            "ALEX", "ANIS", "CHUA", "COLM",
            "DANA", "DEYU", "ECHO", "EMMA", 
            "ERIK", "IDER", "JACK", "JOEL", 
            "JUDE", "KYLE", "LILY", "LUKE", 
            "MARC", "MARK", "MOAZ", "NOAH", 
            "OWEN", "RAUL", "RHEA", "RORY", 
            "RYAN", "SEAN", "THEO", "TUGI" ->
               {  return Player.valueOf(name.toUpperCase()); }
         default -> {  return null;  }
      }
   }

}