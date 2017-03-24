package Model;

/**
 * Created by nitro on 3/24/17.
 */
public class Joke {

   private String title;
   private String content;
   private int rating;

   Joke(String title, String content, int rating) {
      this.title = title;
      this.content = content;
      this.rating = rating;
   }

   public String getTitle() {
      return title;
   }

   public String getContent() {
      return content;
   }

   public int getRating() {
      return rating;
   }
}
