//Bella Li 9/24/25
//This file contains an example of how to read user input. Used in conjunction with the linked list class to test the program.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
   public static void main(String[] args)
       throws IOException
   {
       // Enter data using BufferReader
       BufferedReader reader = new BufferedReader(
           new InputStreamReader(System.in));


       // Reading data using readLine
       LinkedList list = new LinkedList();
       String input= reader.readLine();
       while(!input.equals("exit"))
       {
         if(input.length()>3 && input.substring(0, 3).equals("add"))
         {
           System.out.println(list.addAValue(input.substring(4)).getValue());
         }
         else if(input.equals("show"))
         {
           System.out.println(list.showValues());
         }
         else if(input.length() > 7 && input.substring(0, 6).equals("remove")){
             System.out.println("removing "+input.substring(7));
             ListNode lalala = list.deleteAValue(input.substring(7));
             if (lalala != null){
               System.out.println(lalala.getValue());
             }
            
         }
         else if(input.equals("clear"))
         {
           list.clear();
           System.out.println("list cleared");
         }else if (input.equals("reverse")){
           list.reverse();
           System.out.println("list reversed: " + list.showValues());


         }else if (input.contains("nreverse")){ // example: "nreverse 3" -- don't foget the space
           list.nReverse(list, Integer.parseInt(input.substring(9)));
           System.out.println("list nreversed: " + list.showValues());


         }else if(!input.equals("exit")){
             System.out.println("I don't know how to "+input);
         }
         input= reader.readLine();
       }
       // Printing the read line
       System.out.println("thanks for playing!");
   }
}