/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    // we will be using hashset to store the nodes and check if the node is present in the set or not
    //we use currentNode and prevNode to store the current and previous node
    //detatch the loop by setting the next of prevNode to null

    //time complexity is O(n)
    //space complexity is O(n)
    
    public static void removeLoop(Node head) {
        // code here
        Node currentNode=head;
        Node prevNode=null;
        HashSet<Node> set=new HashSet<>();
        
        if(currentNode==null)
        return;
        
        while(currentNode!=null)
        {
            if(set.isEmpty())
            {
                set.add(currentNode);
                
            }
            else
            {
                if(set.contains(currentNode))
                {
                    prevNode.next=null;
                    break;
                }
                else
                set.add(currentNode);
            }
            prevNode=currentNode;
            currentNode=currentNode.next;
        }
        // return true;
    }
}