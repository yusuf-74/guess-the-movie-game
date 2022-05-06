package guess.a.movie;
import java.io.File;
import java.util.*;
public class GuessAMovie {
    public static void main(String[] args) throws Exception{
        System.out.println("hey there ... \n in this game you are going to guess the name of a movie that i will randomly choose");
        System.out.println("you have 10 wrong guesses per movie");
     
       Game game = new Game ();
       
       while (!game.game_ended())
       {
   
       game.check_if_letter_in();
       game.disply();
       }
       if (game.game_won)
               System.out.println("congrats you won !");
       else 
               System.out.println("u lost !");
            
          }
        }
    
    

