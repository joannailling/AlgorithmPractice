
package CrackCodingInt;

import java.util.HashMap;
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
    
    public LinkedListNode twoPointTwo(LinkedListNode head, int n) {
    // Implement an algorithm to find the nth to last element of a singly linked list
        
        if (head == null || n < 1) {
            return null;
        }
        LinkedListNode node1 = head;
        LinkedListNode node2 = head;
        
        for (int i = 0; i < (n-1); ++i) {
            if (node2 == null) {
                return null;
            }
            node2 = node2.next;
        }
        // at this point, node2 is n-1 nodes ahead of node1
        // keep moving both forward until node2 reaches tail
        while (node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
    
    public void twoPointThree(LinkedListNode node, LinkedListNode c) {
    /** Implement an algorithm to delete a node in the middle of a single linked list, given 
    *   only access to that node
    *   EXAMPLE
    *   Input: the node ‘c’ from the linked list a->b->c->d->e
    *   Result: nothing is returned, but the new linked list looks like a->b->d->e
    **/
        
        
    }
    
    public static void main(String[] args) {
        Chapter2 c2 = new Chapter2();
        LinkedListNode head;
        
        // Remove duplicates using HashMap
        head = c2.makeList(15, 10);
        c2.printList(head);
        c2.twoPointOneA(head);
        c2.printList(head);
        System.out.println("");
        
        // Remove duplicates without extra buffer
        head = c2.makeList(15, 10);
        c2.printList(head);
        c2.twoPointOneB(head);
        c2.printList(head);
        System.out.println("");
        
        // Return nth node from tail
        head = c2.makeList(10, 10);
        c2.printList(head);
        LinkedListNode nth = c2.twoPointTwo(head, 3);
        System.out.println(nth.data.toString());
        
    }

}
