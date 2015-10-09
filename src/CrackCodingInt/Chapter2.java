
package CrackCodingInt;

import java.util.HashMap;
import java.util.Random;

public class Chapter2 {
    
    //Private helper functions to print and make linked lists
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
    
    private int LL_to_int(LinkedListNode node) {
        int num = 0;
        int multiplier = 1;
        LinkedListNode runner = node;
        while (runner != null) {
            num += ((int)runner.data * multiplier);
            multiplier *= 10;     
            runner = runner.next;
        }
        return num;
    }
    
    private LinkedListNode int_to_LL(int i) {
        int num = i%10;
        LinkedListNode head = new LinkedListNode(num);
        LinkedListNode next = head;
        i = (i - num)/10;
        num = i%10;
        while(i > 0) {
            next.next = new LinkedListNode(num);
            next = next.next;
            i = (i - num)/10;
            num = i%10;
        }
        return head;
    }
    
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
    
    public void twoPointThree(LinkedListNode c) {
    /** Implement an algorithm to delete a node in the middle of a single linked list, given 
    *   only access to that node
    *   EXAMPLE
    *   Input: the node ‘c’ from the linked list a->b->c->d->e
    *   Result: nothing is returned, but the new linked list looks like a->b->d->e
    **/
        if (c.next != null) {
            LinkedListNode next = c.next;
            next.data = c.data;
            c.next = next.next;
        }
        c = null;     
    }
    
    public LinkedListNode twoPointFour(LinkedListNode nodeA, LinkedListNode nodeB) {
    /** You have two numbers represented by a linked list, where each node 
     * contains a single digit   The digits are stored in reverse order, 
     * such that the 1’s digit is at the head of the list. Write a function 
     * that adds the two numbers and returns the sum as a linked list 
    **/
        int a = this.LL_to_int(nodeA);
        System.out.println(String.valueOf(a));
        int b = this.LL_to_int(nodeB);
        System.out.println(String.valueOf(b));
        
        int sum = a + b;
        System.out.println("Sum: " + String.valueOf(sum));
        LinkedListNode headOfSum = this.int_to_LL(sum);
        
        return headOfSum;
    }
    
    public static void main(String[] args) {
        Chapter2 c2 = new Chapter2();
        LinkedListNode head;
        
        // 2.1  Remove duplicates using HashMap
        /**
        head = c2.makeList(15, 10);
        c2.printList(head);
        c2.twoPointOneA(head);
        c2.printList(head);
        System.out.println(""); **/
        
        // 2.1 Remove duplicates without extra buffer
        /**
        head = c2.makeList(15, 10);
        c2.printList(head);
        c2.twoPointOneB(head);
        c2.printList(head);
        System.out.println(""); **/
        
        // 2.2 Return nth node from tail
        /**
        head = c2.makeList(10, 10);
        c2.printList(head);
        LinkedListNode nth = c2.twoPointTwo(head, 3);
        System.out.println(nth.data.toString()); **/
        
        // 2.3 Delete node in the middle 
        /**
        head = c2.makeList(5,10);
        c2.printList(head);
        c2.twoPointThree(head.next.next.next);
        c2.printList(head **/
        
        // 2.4 Add two numbers stored as linked lists
        
        LinkedListNode headA = c2.makeList(3,9);
        LinkedListNode headB = c2.makeList(3,9);
        c2.printList(headA);
        c2.printList(headB);
        LinkedListNode sum = c2.twoPointFour(headA, headB);
        c2.printList(sum); 
        
        
    }

}
