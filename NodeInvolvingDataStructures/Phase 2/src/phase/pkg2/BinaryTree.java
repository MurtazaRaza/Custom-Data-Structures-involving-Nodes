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
public class BinaryTree<T> extends DNode<T>
{
    private DNode root;
    
    //Construcotr
    public BinaryTree()
    {
        root = null;
    }
    
    
    //Searching for a particular value in the binary tree
    //root will have to be passed along with the value to be searched
    public DNode search(T value, DNode node)
    {
    if(node != null){
        if(node.getValue() == value)
        {
           return node;
        } 
        else 
        {
            DNode foundNode = search(value, node.getLeft());
            if(foundNode == null) {
                foundNode = search(value, node.getRight());
            }
            return foundNode;
         }
        } 
    else 
    {
        return null;
        }
    }
    //Finds height of the binary tree
    public int Height(DNode temp)
    {
        if(temp == null)
            return -1;
        
        return(1+ Math.max(Height(temp.getLeft()), Height(temp.getRight())));
    }
    
    
    //Inorder function calling
    public void inorder()
     
       {
       
           inorder(root);
     
       }
    //Prints the tree inorder
    public void inorder(DNode a)
     {
         if (a!=null)
        {
            inorder(a.getLeft());
            System.out.print(a.getValue() +" ");
            
            inorder(a.getRight());
         
           }
     
       }
    //Preorder function calling
    public void preorder()
    {
        preorder(root);
    }
     //Prints the tree preorder
    public void preorder(DNode a)
     {
         if (a != null)
        {
            System.out.print(a.getValue() +" ");
            
            preorder(a.getLeft());             
            preorder(a.getRight());
         
         }
     }
     //Postorder function calling
    public void postorder()
    {
        postorder(root);
     
    }
     
    private void postorder(DNode n)
    {
        if (n != null)
        {
            postorder(n.getLeft());             
            postorder(n.getRight());
             
            System.out.print(n.getValue() +" ");
         
         }
     
     }
   
}

