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
public class BST <T extends Comparable <T>> extends BinaryTree<T>
{
    private DNode root;
    
    public BST()
    {
        root = null;
    }
    public boolean isEmpty()
    {
        return root==null;
    }
    //Gives parent of send Node
    public DNode getParent(DNode<T> child)
    {
        DNode<T> itr= root;
        DNode ptr = null;
        
        if(isEmpty())
        {
            System.out.println("No items.");
            return ptr;
        }
        while(1>0)
        {
            if(itr.getValue()==child.getValue())
            {
                return ptr;
            }
            else
            {
                if(child.getValue().compareTo(itr.getValue()) <0)
                {
                 ptr = itr;
                 itr = itr.getLeft();
                }
                if(itr == null)
                {
                    System.out.println("No such Node exists in tree.");
                    return ptr;
                }
                
                else if(child.getValue().compareTo(itr.getValue()) >0)
                {
                    ptr = itr;
                    itr = itr.getRight();
                    if(itr == null)
                    {
                        System.out.println("No such Node exists in tree.");
                    }
                    
                }
            }
        }
        
    }
    
    public void clear()
    {
        root = null;
    }
    //Creates and adds a new DNode according to BST
    public boolean add(T value, int k)
    {
        if(isEmpty())
        {
            DNode root = new DNode(value, k);
            return true;
        }
        else
        {
            DNode<T> itr = root;    
            while(1>0)
            {
                if(value == itr.getValue())
                {
                    System.out.println("Cannot be inserted, value already exists.");
                    return false;
                }
                else if (value.compareTo(itr.getValue()) <0)
                {
                    if(itr.getLeft()==null)
                    {
                        DNode obj = new DNode(value, k);
                        itr.setLeft(obj);
                        return true;
                    }
                    else
                        itr = itr.getLeft();
                    
                }
                else if(value.compareTo(itr.getValue()) >0)
                {
                    if(itr.getRight() == null)
                    {
                        DNode obj = new DNode(value, k);
                        itr.setRight(obj);
                        return true;
                    }
                    else
                        itr = itr.getRight();
                }
              
            }
        }   
    }
    //Searches for a particular value and gives that DNode
    
     public DNode search(T value, int k)
    {
        DNode itr=root;
        while(itr!=null)
        {
            if (value==itr.getValue()){
                System.out.println("Item Found");
                return  itr;
            }
            else if(itr.getLeft() != null)
            {
                
                itr=itr.getLeft();
            }
            else if(itr.getRight() != null){
                itr=itr.getRight();
            }
         }
        return itr;
        }
    //returns the minimum elememnt in the BST
public DNode min(DNode from)
{
    DNode itr = from;
    
    while(1>0)
    {
        if(itr.getLeft() == null)
        {
            return itr;
        }
        else 
        {
            itr = itr.getLeft();
            }
        }
    }

public DNode max(DNode from)
{
    DNode itr = from;
    
    while(1>0)
    {
        if(itr.getRight() == null)
        {
            return itr;
        }
        else 
        {
            itr = itr.getRight();
            }
        }
    }

public void removeNode(DNode del)
{
    DNode ch;
    DNode pardel = getParent(del);
    if(del.getLeft() != null)
    {
        ch = del.getLeft();
    
                }
    else
    {
         ch = del.getRight();
    }
    
    if(del == root)
    {
        root = ch;
    }
    else
    {
        if(pardel.getLeft() == del)
        {
            pardel.setLeft(ch);
        }
        else
        {
            pardel.setRight(ch);
        }
        
    }
               
}

public void deleteNode(T item)
{
    DNode del = search(item, 0);
    
    if(del.getLeft()==null || del.getRight() == null)
    {
        removeNode(del);
    }
    
    else
    {
        DNode ch = min(del.getRight());
        ch.setLeft(del.getLeft());
        ch.setRight(del.getRight());
        
        DNode delpar = getParent(del);
        
        if(delpar == null)
        {
            root = ch;
        }
        else
        {
            if(delpar.getLeft() == del)
            {
                delpar.setLeft(ch);
            }
            else
            {
                delpar.setRight(ch);
            }
        }
        
    }
}
    

//Converts the entire BST into one string
public String toString(DNode root)
{
    StringBuilder builder = new StringBuilder();
    if (isEmpty())
        return "";
    else{
    builder.append(toString(root.getLeft()));
    builder.append(toString(root.getRight()));
    return builder.append(root.getValue().toString()).toString();
    }
}

//Gives the number of DNodes in the BST
public int size(DNode current) 
{   
 
  if (current == null) return 0;
  
  return 1 + size(current.getLeft()) + size(current.getRight());
}
    
    
}
