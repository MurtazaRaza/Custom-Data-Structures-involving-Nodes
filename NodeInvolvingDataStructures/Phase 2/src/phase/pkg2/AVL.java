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
public class AVL<T extends Comparable <T>> extends BST<T>
{
    
    private DNode root;
     
    @Override
    public boolean isEmpty()
    {
        return root==null;
    }
    
    //Gets the parent node of the given node
    @Override
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
    
    //Gives height of the given node
    public int Height(DNode temp)
    {
        if(temp == null)
            return -1;
        
        return(1+ Math.max(Height(temp.getLeft()), Height(temp.getRight())));
    }
    
    
    //Single rotate left function
    public DNode rotateLeft(DNode par)
     {
         DNode child = par.getLeft();
         par.setLeft(child.getRight());
         child.setRight(par);
         par.setHeight(Math.max(Height(par.getLeft()),Height(par.getRight()))+1);
         child.setHeight(Math.max(Height(child.getLeft()), par.getHeight() )+1);
         return child;
     }
    //single rotate right function
    public DNode rotateRight(DNode par)
     {
         DNode child=par.getRight();
         par.setRight(child.getLeft());
         child.setLeft(par);
         par.setHeight(Math.max(Height(par.getLeft()), Height(par.getRight()))+1);
         child.setHeight(Math.max(Height(child.getRight()),par.getHeight())+1);
         return child;
     }
    //double rotate left function
    public DNode rotateRightLeft(DNode par)
     {
         par.setLeft(rotateRight(par.getLeft()));
         return rotateLeft(par);
     }
    
    //double rotate right function
    public DNode rotateLeftRight(DNode par)
     {
         par.setRight(rotateLeft(par.getRight()));
         return rotateRight(par);
     } 
    
    void insertion(T value)
    {
         root=insert(value,root);
    }
     
     
    DNode insert(T value,DNode<T> n)
    {
         if (n == null)
         { 
             n = new DNode(value, 0);
         }
         else
            if (value.compareTo(n.getValue()) < 0)
                {
                n.setLeft(insert(value,n.getLeft()));
                DNode par=n.getLeft();
                
                if( Height(par.getRight())-Height(par.getLeft())==2 )
                   {
                    if( Height(par.getLeft())==1)
                    par= rotateLeft(par);
                else
                    par=rotateRightLeft(par);
                    }
                }
             
            else
                 if(value.compareTo(n.getValue()) > 0)
                    {
                        n.setRight(insert(value,n.getRight()));
                        DNode par=n.getRight();
                        if(Height(par)-Height(par)==2)
                        {
                            if(Height(par.getRight())==1)
                                par= rotateRight(par);
                        
                            else
                                par = rotateLeftRight(par);
                        }
                    }
            else
                n.setHeight(Math.max(Height(n.getLeft()), Height(n.getRight()))+1);
                return n;
     }
    
    
    @Override
    public String toString(DNode root)
    {
        StringBuilder builder = new StringBuilder();
        if (isEmpty())
            return " ";
        else
        {
            builder.append(toString(root.getLeft()));
            builder.append(toString(root.getRight()));
            return builder.append(root.getValue().toString()).toString();
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
    }
