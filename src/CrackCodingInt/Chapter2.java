
package CrackCodingInt;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;

public class Chapter2 {
    
    public void twoPointOneA(LinkedListNode node) {
    // Write code to remove duplicates from an unsorted linked list
       HashMap hm = new HashMap();
       LinkedListNode prev = null;
       while (node != null) {
           if (hm.containsKey(node.data)) {
               prev.next = node.next;
           } else {
               hm.put(node.data, true);
               prev = node;
           }
           node = node.next;
       }
    }
    
    public void twoPointOneB(LinkedListNode head) {
    // FOLLOW UP
    // How would you solve this problem if a temporary buffer is not allowed?
        if (head == null) {
            return;
        }
        LinkedListNode currentNode = head;
        while(currentNode != null) {
            LinkedListNode runner = currentNode;
            while(runner.next != null) {
                if(runner.next.data == currentNode.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            currentNode = currentNode.next;
        }
    }
    
    private void printList(LinkedListNode node) {
        while(node != null) {
            System.out.print(node.data.toString()+ " ");
            node = node.next;
        }
        System.out.print("\n");
    }
    
    private LinkedListNode makeList(int length, int bound) {
        Random r = new Random();
        LinkedListNode head = new LinkedListNode(r.nextInt(bound));
        LinkedListNode curr = head;
        for(int i=1; i<length; i++) {
            curr.next = new LinkedListNode(r.nextInt(bound));
            curr = curr.next;
        }
        return head;
    }
    
    public LinkedListNode twoPointTwo(LinkedList ll, int n) {
    // Implement an algorithm to find the nth to last element of a singly linked list
        
        return new LinkedListNode(new Object());
    }
    
    public void twoPointThree(LinkedList ll, LinkedListNode c) {
    /** Implement an algorithm to delete a node in the middle of a single linked list, given 
    *   only access to that node
    *   EXAMPLE
    *   Input: the node ‘c’ from the linked list a->b->c->d->e
    *   Result: nothing is returned, but the new linked list looks like a->b->d->e
    **/
        
    }
    
    public static void main(String[] args) {
        Chapter2 c2 = new Chapter2();
        LinkedListNode head = c2.makeList(15, 10);
        c2.printList(head);
        c2.twoPointOneA(head);
        c2.printList(head);
        System.out.println("");
        head = c2.makeList(15, 10);
        c2.printList(head);
        c2.twoPointOneB(head);
        c2.printList(head);
    }

}
