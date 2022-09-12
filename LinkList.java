/**
 * Implementing Singly Linked List without using Pre-Defined 
 * Class of the util package.
 *
 * @Aryan
 * @11-08-2022
 */
import java.util.*;
public class LinkList
{
    // Creating Head Object of Node Class
    Node head;
    //Variable size declaration
    private int size;
    //LinkList Class constructor initialising value to 0
    LinkList(){ //Can use Multiple LL OB to make Many Lists
        //Default Value
        this.size=0;
    }
    //Inner Class Node for each node of linked list
    class Node{
        //int Data type of Data variable
        //Node next to point to next node of linked list
        int data;
        
        Node next;
        
        //Constructor of Class Node
        Node(int data){
            //New Node is created with data var & next obj
            this.data = data;
            this.next = null;
            size++;
        }
    }
    //4 Operation of LinkList ADD<PRINT<DELETE<PRINT
    //Add Function>Position:First
    public void addFront(int data){
        //Creation of New Node
        Node newNode = new Node(data);
        //list empty Check Condition
        if(head == null){
            head = newNode;
            return;
        }
        //If List is Available
        else{
            //pointing NEW NODE to Previous Head Node
            //object.variable
            newNode.next = head;
            //Updating head to new node
            head = newNode;
            
        }
    }
    //Add Function>Position:Last
    public void addEnd(int data){
        Node newNode = new Node(data);
        //list empty Check Condition
        if(head == null){
            head = newNode;
            return;
        }
        //Temp Pointer for traversing list
        Node curNode = head;
        //Going to Last Node of List
        while(curNode.next != null){
            //Moving to next node until reaching last
            curNode = curNode.next;
        }
        //Pointing Last Node Pointer to new node
        curNode.next = newNode;
        /*No need to update the new node pointer to null
          as null is already the default value*/
    }
    //Print List
    public void printList(){
        //Checking for List Empty Condition
        if(head == null){
            System.out.println("List Empty");
            return;
        }
        //Temp Pointer for traversing list
        Node curNode = head;
        //Traversing List
        while(curNode != null){
            System.out.print(curNode.data+"->");
            curNode = curNode.next;
        }
        //Print NULL Pointer of Last Node
        System.out.println("NULL");
    }
    //Delete Function>Position:First
    public void deleteFront(){
        //Checking for List Empty Condition
        if(head == null){
            System.out.println("List Empty");
            return;
        }
        //Updating list size
        size--;
        //Transfer head to Next Element
        head=head.next;
        /* Java Garbage Collector will take care of
           the previous head or node*/
    }
    //Delete Function>Position:Last
    public void deleteEnd(){
        //Checking for List Empty Condition
        if(head == null){
            System.out.println("List Empty");
            return;
        }
        //Updating size
        size--;
        /*Checking if List have only 1 Element
            so to avoid error in while loop below*/
        if(head.next == null){
            head = null;
            return;
        }
        /*Creating lastNode & secondLast Node objects
           to track last and second last nodes so that
           last node is deleted while assigning null to previous node*/
        Node secondLast = head;
        Node lastNode = head.next;
        //Traversing List to 
        while(lastNode.next != null){
            secondLast = lastNode;
            lastNode = lastNode.next;
        }
        //Pointing Previous last node to null
        secondLast.next=null;
        //Last node is deleted
    }
    //Reversing By Iteration
    public void reverseIterate(){
        if(head == null || head.next==null){
            return;
        }
        Node prevNode = head;
        Node curNode = head.next;
        while(curNode != null){
            Node nextNode = curNode.next;
            curNode.next = prevNode;
            
            prevNode = curNode;
            curNode = nextNode;
        }
        head.next=null;
        head=prevNode;
    }
    //Reversing By Recursive
    public Node reverseRecur(Node head){
        if(head == null || head.next==null){
            return head;
        }
        Node newHead=reverseRecur(head.next);
        head.next.next=head;
        head.next=null;
        
        return newHead;
        
    }
    // Deleting nth node
    public Node removeFromEnd(Node head,int n,int size){
        if(head.next==null){
            return null;
        }
        if(n == size){
            head=head.next;
            return head;
        }
        Node curr=head;
        int i=1;
        int sn=size-n;
        while(i<sn){
            curr=curr.next;
            i++;
        }
        curr.next=curr.next.next;
        return head;
    }
    //Get List size func
    public int getSize(){
        return size;
    }
    //Main Function 
    public static void main(String[]args){
        //Object list of LinkList to call functions
        LinkList list = new LinkList();
        Scanner sc=new Scanner(System.in);
        list.addFront(5);
        list.addFront(7);
        list.addEnd(8);
        list.addFront(16);
        list.printList();
        int size=list.getSize();
        System.out.println(size);
        list.deleteFront();
        list.printList();
        list.deleteEnd();
        list.printList();
        System.out.println(list.getSize());
        
        //Expanding llist to show Reversing of List
        list.addFront(4);
        list.addFront(2);
        list.addEnd(8);
        list.addEnd(9);
        list.addEnd(80);
        //System.out.println("List To be Reversed::");
        //list.printList();
        //list.reverseIterate();
        //System.out.println("Reversed::");
        //list.printList();
        //System.out.println("Reversing with Recursion::");
        //list.head=list.reverseRecur(list.head);
        list.printList();
        System.out.println("SIZE"+list.getSize());
       
        size=list.getSize();
        System.out.println("Give nth node to delete:");
        int n=sc.nextInt();
        
        list.removeFromEnd(list.head,n,size);
        list.printList();
    }
}
