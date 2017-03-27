/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phase.pkg2;

/**
 *
 * @author murti
 * @param <T>
 */

/*
class Node containing any T type of data type, 
key and link to next node. All private.

**//*
class DNode containing any T type of data type, 
key and link to next node. All private.

**/
public class DNode<T> 
{
    private int key;
    private T value;
    private DNode next;
    private DNode previous;
    private DNode left;
    private DNode right;
    private int height;
    
    //Constructors
    public DNode()
    {
        next = null;
        previous = null;
    }
    //For linklists
    public DNode(int k, T data)
    {
        key = k;
        value = data;
        next = null;
        previous = null;
    }
    //For trees
    public DNode(T data, int k)
    {
        key = k;
        value = data;
        left = null;
        right = null;
               
    }
    
    
    public void setKey(int k)
    {
        key = k;
    }
    
    public void setValue(int data)
    {
        key = data;
    }
    
    public void setNext(DNode n)
    {
        next = n;
    }
    public void setPrevious(DNode p)
    {
        previous = p;
    }
    
    public int getKey()
    {
        return key;
    }

    /**
     *
     * @return
     */
    public T getValue()
    {
        return (T) value;
    }
    
    public DNode getPrevious()
    {
        return previous;
    }
    public DNode getNext()
    {
        return next;
    }
    public void setLeft(DNode l)
    {
        left = l;
    }
    public void setRight(DNode r)
    {
        right = r;
    }
    public DNode getLeft()
    {
        return left;
    }
    public DNode getRight()
    {
        return right;
    }
    public void setHeight(int h)
    {
        height = h;
    }
    public int getHeight()
    {
        return height;
    }
}
