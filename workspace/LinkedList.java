/*
Bella Li 9/24/25


This is a program that keeps and manipulates a linked list of
     String data. The data will be provided by the user one item at a time.
     The user should be able to do the following operations:
                    -add "String"
                               adds an item to your list (maintaining alphabetical order)
                    -remove "String"
                               if the item exists removes the first instance of it
                    -show
                               should display all items in the linked list
                    -clear
                              should clear the list
 Input:  commands listed above
 Output:  the results to the screen of each menu
     choice, and error messages where appropriate.
*/
public class LinkedList{


 //instance varialbes go here (think about what you need to keep track of!)
 public ListNode head;
 public int size;


 //constructors go here
 public LinkedList()
 {
   head = null;
   size = 0;
 }


 //precondition: the list has been initialized
 //postcondition: reverses the ENTIRE linked list (the tail will be the new head and the head the new tail)
 public ListNode reverse(){
   ListNode temp = head;
   ListNode tempNext = null;
   ListNode tempPrev = null;


   head = tempNext;


   while (temp != null) {


           tempNext = temp.getNext();
           temp.setNext(tempPrev);
           tempPrev = temp;
           // Go to next node
           temp = tempNext;
       }


       head = tempPrev;
       return tempPrev; //placeholder
 }


 //precondition: the list has been initialized, n is not larger than the number of elements in the list, list will always contain at least one element
 //postcondition: Reverses each "chunk" of n nodes (if there aren't enough nodes at the end to fit into a chunk, they are left without being reversed)
 public ListNode nReverse(LinkedList ogList, int n){
   ListNode temp = head;
   ListNode tempNext = null;
   ListNode tempPrev = null;
   ListNode tempEnd = null;
   ListNode prevChunkEnd = null;


   while (temp != null) {
     ListNode chunkStart = temp;
     tempEnd = temp;
     for (int i = 0; i < n && tempEnd != null; i++) { // finds the end of the temp chunk
       tempEnd = tempEnd.getNext();
     }


     int count = 0;
     tempPrev = null;
     ListNode node = temp;
     while (node != tempEnd) { // reverses the chunk
       tempNext = node.getNext();
       node.setNext(tempPrev);
       tempPrev = node;
       node = tempNext;
       count++;
     }


     if (prevChunkEnd == null) {
       head = tempPrev; // set new head for the first chunk
     } else {
       prevChunkEnd.setNext(tempPrev);
     }
     chunkStart.setNext(tempEnd);
     prevChunkEnd = chunkStart;
     temp = tempEnd;
   }
   return head;
 }


 //precondition: the list has been initialized
 //postcondition: the ListNode containing the appropriate value has been added and returned
 public ListNode addAValue(String line) {
   ListNode newNode = new ListNode(line, null);
   if (head == null || head.getValue().compareTo(line) > 0) {
       newNode.setNext(head);
       head = newNode;
       return newNode;
   }
   ListNode current = head;
   while (current.getNext() != null && current.getNext().getValue().compareTo(line) < 0) {
       current = current.getNext();
   }
   newNode.setNext(current.getNext());
   current.setNext(newNode);
   return newNode;
 }


 //precondition: the list has been initialized
 //postcondition: the ListNode containing the appropriate value has been deleted and returned.
 //if the value is not in the list returns null
 public ListNode deleteAValue(String line) {
 if (head == null) {
   System.out.println(line + " not found");
   return null;
 }
 if (head.getValue().equals(line)) {
   ListNode removed = head;
   head = head.getNext();
   return removed;
 }
 ListNode current = head;
 while (current.getNext() != null && !current.getNext().getValue().equals(line)) {
   current = current.getNext();
 }
 if (current.getNext() == null) {
   System.out.println(line + " not found");
   return null;
 }
 ListNode removed = current.getNext();
 current.setNext(removed.getNext());
 return removed;
 }


 //precondition: the list has been initialized
 //postconditions: returns a string containing all values appended together with spaces between.
 public String showValues() {
   StringBuilder sb = new StringBuilder();
   ListNode current = head;
   while (current != null) {
       sb.append(current.getValue());
       if (current.getNext() != null) sb.append(" ");
       current = current.getNext();
   }
   return sb.toString();
 }


 //precondition: the list has been initialized
 //postconditions: clears the list.
 public void clear() {
   head = null;
 }
}