/*
  Linked Lists: Detect a Cycle
  https://www.hackerrank.com/challenges/ctci-linked-list-cycle

*/

/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    if(head == null) return false;
    Node faster = head.next;
    Node slower = head;
    
    while(faster != null && faster.next != null) {
        if(faster == slower)
            return true;
        
        faster = faster.next.next;
        slower = slower.next;
    }
    
    return false;

}
