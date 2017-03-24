package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rasmusthrane on 24/03/17.
 */
public class Model implements ModelInterface {

   private static ArrayList<Joke> jokes = new ArrayList<>();
   private static final File jokeFile = new File("src/Model/jokes.txt");

   private static void loadJokes() {
      try {
         Scanner input = new Scanner(jokeFile);

         while (input.hasNext()) {
            int rating = Integer.parseInt(input.nextLine());
            String title = input.nextLine();
            String content = "";

            while (!input.hasNext("#")) {
               content += input.nextLine();
               if (!input.hasNext("#")) {
                  content += "\n";
               }
            }

            Joke joke = new Joke(title, content, rating);
            jokes.add(joke);

            input.nextLine(); // Skip the "#"
         }
      } catch (FileNotFoundException ex) {
         System.out.println(ex);
      }
   }

   private static void saveJokes() {
      try {
         PrintStream output = new PrintStream(jokeFile);

         for (Joke j : jokes) {
            output.println(j.getRating());
            output.println(j.getTitle());
            output.println(j.getContent());
            output.println("#");
         }
      } catch (FileNotFoundException ex) {
         System.out.println(ex);
      }
   }

   public static ArrayList<Joke> getJokes() {
      return jokes;
   }

   // For debug purposes
   private static void printJokes() {
      for (Joke j : jokes) {
         System.out.println(j.getRating());
         System.out.println(j.getTitle());
         System.out.println(j.getContent());
      }
   }
}
