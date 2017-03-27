/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phase.pkg2;

/**
 *
 * @author murti
 */

/*
class SLL inherits class Node
*/
public class DoublyLinkList<T> extends DNode<T> {
    
    private DNode head;
    private DNode tail;
    
    //Constructor
    public DoublyLinkList()
    {
        head = null;
        tail = null;
    }
    
    //returns 1 if list is empty, else 0
    public boolean isEmpty()
    {
        return head == null;
    }
    
    //Adds a Node at the first position and returns true
    //when successful
    public boolean addFirst (int key, T value) 
    {
        DNode a=new DNode(key, value);
        if(isEmpty()){
             head = a;
             return true;
             }
        else
         {
            a.setNext(head);
            head.setPrevious(a);
            head=a;
            return true;
            }
	}
    //Adds a DNdoe at the last position and returns true
    //when successful
    public boolean addLast(int key, T value)
    {
        DNode a = new DNode(key, value);
        if(isEmpty())
        {
            head = a;
            return true;
        }
        else
        {
            tail.setNext(a);
            a.setPrevious(tail);
            
        }
        tail = a;
        return true;
    }
    
    //clears the whole list
    public void clear()
    {
        if(!isEmpty())
        {
            head = null;
        }
    }
    //Inserts Node at a particular position and
    //returns true when successful
    public boolean insertAt(int key, T value, int number)
    {
        DNode a = new DNode(key, value);
        DNode itr =head;
        DNode itrn = head.getNext();
        
        for(int i = 1; i< number; i++)
        {
            itr = itr.getNext();
            itrn = itrn.getNext();
        }
        a.setPrevious(itr);
        a.setNext(itrn);
        itr.setNext(a);
        itrn.setPrevious(a);
        return true;
    }
    
    //Inserts a Node before the node where a particular key is found and 
    //returns true when successful
    public boolean insertBefore(int key, T value, int KEY)
    {
        DNode a = new DNode(key, value);
        DNode itr = head;
        DNode ptr =itr.getNext();

        while(ptr.getKey() != KEY)
        {
            itr = itr.getNext();
            ptr = ptr.getNext();
        }

        a.setNext(ptr);
        a.setPrevious(itr);
        itr.setNext(a);
        ptr.setPrevious(a);
        return true;
    }
    
    //Inserts Node after the node where a particular key is found
    //and returns true when successful
    public boolean insertAfter(int key, T value, int KEY)
    {
        DNode a = new DNode(key, value);
        DNode itr = head;
        DNode itrn = head.getNext();


        while(itr.getKey() != KEY)
        {
            itr = itr.getNext();
            itrn = itrn.getNext();
        }

        a.setNext(itrn);
        a.setPrevious(itr);
        itr.setNext(a);
        itrn.setPrevious(a);
        return true;
    }
    
    //Deletes the first element of the list
    public void deleteFirst()
    {
        head = head.getNext();
    }
    
    //Deletes the last element of the list
    public void deleteLast()
    {
        tail = tail.getPrevious();
    }
    //Deletes Node at a particular position
    public boolean remove(int number)
    {
        DNode itr = head;
        DNode itrfront = itr.getNext();

        for (int i=1; i < number-1; i++)
        {
            if(itrfront.getNext()==null)
            {
                System.out.println("Position out of bounds of the list");
                return false;
            }

            itrfront = itrfront.getNext();
            itr = itr.getNext();
        }  
         itr.setNext(itrfront.getNext()); 
         itrfront.getNext().setPrevious(itr);
         return true;
    }   
    //Deletes the node passed
    public boolean deleteNode(DNode del)
    {
        DNode itr = head;
        DNode itrfront = itr.getNext();
        while(itr!=del)
        {
            if(itr == null) return false;
            itr = itr.getNext();
            itrfront = itrfront.getNext();
        }

        itr.setNext(itrfront.getNext());
        itrfront.getNext().setPrevious(itr);
        return true;
    }
    
    //Deletes the node after a particular key is found
    public boolean deleteAfter(int key)
    {
        DNode itr = head;


        while(itr.getKey()!=key)
        {
            if(itr == null) return false;
            itr = itr.getNext();
       }
        itr.getNext().getNext().setPrevious(itr);
        itr.setNext(itr.getNext().getNext());
        return true;
    }
    
    //Deletes the node before a particular key is found
    public boolean deleteBefore(int key)
    {
        DNode itr = head;
        DNode ptr = itr.getNext().getNext();

        while(ptr.getKey() != key)
        {
            if(itr == null) return false;
            itr = itr.getNext();
            ptr = ptr.getNext();
        }
        ptr.setPrevious(itr);
        itr.setNext(ptr);
        return true;
    }
    
    //returns size of the List
    public int size() 
    {
        int size = 0;
        for(DNode n = head; n.getNext() != null; n = n.getNext())
                size++;     
        return size;
        }

    //Searches for a particular key and returns the data item present at that node
    public T getvalue(int key)
    {
    DNode itr = head;
    while((itr!=null) && (itr.getKey()!=key))
        {
            itr = itr.getNext();
        }
    return (T) itr.getValue();
    }
    
    //Searches for a particular data item and returns 
    //that node
    public DNode search(T value) 
    {
            DNode itr=head;
            while ((itr != null) && (itr.getValue()!=value))
                    itr=itr.getNext();
            return itr;
    }
    
    //Searches for a particular data item and returns
    //the key at that node
    public int searchk(T value) 
        {
            DNode itr=head;
            while ((itr != null) && (itr.getValue()!=value))
                    itr=itr.getNext();
            return itr.getKey();
    }

    //Searches for a particular key and returns the data item present after that node
    public int searchNext(int key)
    {
        DNode itr = head;
        while((itr!=null) && (itr.getKey()!=key))
            {
             itr = itr.getNext();
            }
        return itr.getNext().getKey();
    } 
    
    @Override
    public String toString()
    {
        DNode itr = head;
         StringBuilder sb = new StringBuilder();
         while(itr!=null)
         {
             sb.append(itr.getValue());
         }
         
         return sb.toString();
    }
   
    
    
    
    
        
    
    
    
    
}
