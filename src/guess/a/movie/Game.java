package guess.a.movie;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class Game   {
     private String picked_movie ;
     private String hidden_movie ;
     private String right_letters ;
     private String wrong_letters ;
     String [] moviess = new String [25];
     private int points = 0;
     public boolean game_won = false;
     int movie_index;
     
     
     
    public Game () throws Exception
    {
        int i = 0;
        File movies = new File("movies.txt");
     Scanner sc = new Scanner (movies) ;
    Random random = new Random();
    movie_index = random.nextInt(24);
       while (sc.hasNext())
       {moviess[i] = sc.nextLine();
       i++;}
       picked_movie = moviess[movie_index];
       hidden_movie = picked_movie.replaceAll("[a-zA-Z]", "-");
       right_letters = "";
       wrong_letters = "";
       hidden_movie = picked_movie.replaceAll("[a-zA-Z]", "-");
        System.out.println("you are guessing : " + hidden_movie);
       
    }
    public String guess ()
    {
         System.out.print("Guess a letter : ");
        Scanner scan = new Scanner(System.in);
        String guessed = scan.nextLine().toLowerCase();
        if (!guessed.matches("[a-z]"))
        {System.out.println("please enter valid letter..");
        System.out.println("you are guessing : " +hidden_movie);
        return guess();}
        
        else if (right_letters.contains(guessed) || wrong_letters.contains(guessed))
        { System.out.println("you already gussed this letter before");
        System.out.println("you are guessing : " +hidden_movie);
        return guess();
        }
        
        
        else 
            return guessed;
    }
    
    public void check_if_letter_in()
    {
    String guessedd = guess();
    if (picked_movie.toLowerCase().contains(guessedd))
        right_letters+= guessedd;
    else 
    {
    wrong_letters+= " " +guessedd;
    points++;
    }
    }
    public void disply ()
    {
    if (!right_letters.isEmpty())
    {
        hidden_movie = picked_movie.replaceAll("[a-zA-Z&&[^" + right_letters +"]]", "-");
        System.out.println("you guessed (" + points +") wrong letters : " + wrong_letters  );
        System.out.println("you are guessing : " +picked_movie.replaceAll("[a-zA-Z&&[^" + right_letters +"]]", "-"));
        
    }
    else 
    {
        System.out.println("you guessed (" + points +") wrong letters : " + wrong_letters  );
        System.out.println("you are guessing : " + picked_movie.replaceAll("[a-zA-Z]", "-"));
    }
    }
    public boolean game_ended()
    {
    if (points >= 10)
        return true ;
    else if (!hidden_movie.contains("-"))
    { 
        game_won = true;
        return true;
    }
         else 
        return false;
            
    }
    
    
     
     
     
    
}
