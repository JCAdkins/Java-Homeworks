import java.util.Stack;

/**
   This program simulates an undo stack. Note that operations
   must be undone in the opposite order in which they are first
   issued.
*/
public class Stackz
{
   public static void main(String[] args)
   {
      Stack<String> commands = new Stack<>();
      commands.push("Insert 'Hello'");
      commands.push("Insert ','");
      commands.push("Insert ' '");
      commands.push("Insert 'World'");
      commands.push("Insert '?'");
      commands.push("Delete '?'");
      commands.push("Insert '!'");

      // Now we undo the last four commands
      int a = commands.size();
      for (int i = 1; i <= a; i++)
      {
         String command = commands.pop();
         System.out.println("Undo " + command);
      }
   }
}