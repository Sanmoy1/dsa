/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/


class Solution {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node newNode=new Node(x);
        
        if(head==null)poin
        return newNode;
        
        Node current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        current.next=newNode;
        newNode.next=null;
        return head;
    }
}