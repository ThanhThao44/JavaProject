package application;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;

import javafx.util.Duration;

public class AVLTree extends Datatype
{
    private Node root; 
    
    public AVLTree()
    {
        root = null;
    }
    
    public boolean isEmpty()
    {
        return root == null;
    }
    
    public void makeEmpty()
    {
        root = null;
    }
    
    public void insert(int data)
    {
        root = insert(data, root);
    }
    
    private int height(Node t )
    {
        return t == null ? -1 : t.getHeight();
    }
    
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    
    private Node minValueNode(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }
    private Node insert(int x, Node t)
    {
        if (t == null)
            t = new Node(x);
        else if (x < t.getValue())
        {
            t.setLeft(insert( x, t.getLeft() )) ;
            if( height( t.getLeft()) - height( t.getRight() ) == 2 )
                if( x < t.getLeft().getValue() )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( x > t.getValue() )
        {
        	t.setRight( insert( x, t.getRight() ));
            if( height( t.getRight() ) - height( t.getLeft() ) == 2 )
                if( x > t.getRight().getValue())
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
          ;  // Duplicate; do nothing
        t.setHeight( max( height( t.getLeft() ), height( t.getRight() ) ) + 1);
        return t;
    }
    /* Rotate binary tree node with left child */     
    private Node rotateWithLeftChild(Node k2)
    {
        Node k1 = k2.getLeft();
        k2.setLeft( k1.getRight()) ;
        k1.setRight( k2);
        k2.setHeight( max( height( k2.getLeft() ), height( k2.getRight() ) ) + 1);
        k1.setHeight( max( height( k1.getLeft() ), k2.getHeight() ) + 1);
        return k1;
    }

    /* Rotate binary tree node with right child */
    private Node rotateWithRightChild(Node k1)
    {
        Node k2 = k1.getRight();
        k1.setRight( k2.getLeft()) ;
        k2.setLeft (k1);
        k1.setHeight ( max( height( k1.getLeft() ), height( k1.getRight() ) ) + 1);
        k2.setHeight (max( height( k2.getRight() ), k1.getHeight() ) + 1);
        return k2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private Node doubleWithLeftChild(Node k3)
    {
        k3.setLeft( rotateWithRightChild( k3.getLeft() ));
        return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */      
    private Node doubleWithRightChild(Node k1)
    {
        k1.setRight( rotateWithLeftChild( k1.getRight() )) ;
        return rotateWithRightChild( k1 );
    }    
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(Node r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(int val)
    {
        return search(root, val);
    }
    private boolean search(Node r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.getValue();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(Node r)
    {
        if (r != null)
        {
        	nodelist.add(r);
            System.out.print(r.getData() +" "+r.getHeight()+"   ");
            preorder(r.getLeft());             
            preorder(r.getRight());
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(Node r)
    {
        if (r != null)
        {
            postorder(r.getLeft());             
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
            
        }
    }     
public SequentialTransition AddAni(Node node, double offsetX, double offsetY) {
		
		SequentialTransition st = new SequentialTransition();
		
		TranslateTransition moveX = new TranslateTransition();
		moveX.setDuration(Duration.millis(1000));
		moveX.setNode(node.label);
		moveX.setToX(offsetX);
		moveX.setAutoReverse(false);
		
		TranslateTransition moveY = new TranslateTransition();
		moveY.setDuration(Duration.millis(1000));
		moveY.setNode(node.label);
		moveY.setToY(offsetY);
		moveY.setAutoReverse(false);
		
		st.getChildren().addAll(moveX,moveY);
		return st;
	}
	
	public FadeTransition DelAni(Node node) {
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.millis(500));
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setNode(node.label);
		
		return ft;
	}
	public Node findNode(int data) {
		for (int i=0;i<nodelist.size();i++) {
			tmp = nodelist.get(i);
			if (tmp.getValue() == data) return tmp;
		}
		return null;
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public void delete(int value)
	{
		if(deleteNode(root,value)!=null)
			System.out.println("remove succesful");;
	}
	 public Node deleteNode(Node root, int value) {
	        // STEP 1: PERFORM STANDARD BST DELETE

	        if (root == null)
	            return root;

	        // If the value to be deleted is smaller than the root's value,
	        // then it lies in left subtree
	        if ( value < root.getValue() )
	            root.setLeft( deleteNode(root.getLeft(), value));

	        // If the value to be deleted is greater than the root's value,
	        // then it lies in right subtree
	        else if( value > root.getValue() )
	            root.setRight( deleteNode(root.getRight(), value));

	        // if value is same as root's value, then This is the node
	        // to be deleted
	        else {
	            // node with only one child or no child
	            if( (root.getLeft() == null) || (root.getRight() == null) ) {

	                Node temp;
	                if (root.getLeft() != null)
	                        temp = root.getLeft();
	                else
	                    temp = root.getRight();

	                // No child case
	                if(temp == null) {
	                    temp = root;
	                    root = null;
	                }
	                else // One child case
	                    root = temp; // Copy the contents of the non-empty child

	                temp = null;
	            }
	            else {
	                // node with two children: Get the inorder successor (smallest
	                // in the right subtree)
	                Node temp = minValueNode(root.getRight());

	                // Copy the inorder successor's data to this node
	                root.setData( temp.getData()) ;

	                // Delete the inorder successor
	                root.setRight (deleteNode(root.getRight(), temp.getValue()));
	            }
	        }

	        // If the tree had only one node then return
	        if (root == null)
	            return root;

	        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
	        root.setHeight( Math.max(height(root.getLeft()), height(root.getRight())) + 1);

	        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
	        //  this node became unbalanced)
	        int balance = getBalance(root);
System.out.println(balance);
System.out.println( getBalance(root.getRight()));
	        // If this node becomes unbalanced, then there are 4 cases

	        // Left Left Case
	        if (balance > 1 && getBalance(root.getLeft()) >= 0)
	            this.root= rotateWithLeftChild(root);

	        // Left Right Case
	        if (balance > 1 && getBalance(root.getLeft()) < 0) {
	            this.root= doubleWithLeftChild(root);
	        }

	        // Right Right Case
	        if (balance < -1 && getBalance(root.getRight()) <= 0)
	             this.root=rotateWithRightChild(root);

	        // Right Left Case
	        if (balance < -1 && getBalance(root.getRight()) > 0) {
	        	this.doubleWithRightChild(root);
	        }

	        return root;
	    }
	 private int getBalance(Node N) {
	        if (N == null)
	            return 0;
	        return height(N.getLeft()) - height(N.getRight());
	    }
	public void draw(Node node,double offsetX, double offsetY)
	{
		if (node != null) {
			node.setLabel(node.form());
			System.out.println(node.getData());
			AddAni(node,offsetX,offsetY).play();
			if (node.getLeft()!= null) draw(node.getLeft(),offsetX+100,offsetY+100);
			if (node.getRight() != null) draw(node.getRight(),offsetX-100,offsetY+100);
		}
		
	}
	
	public void draw(java.util.LinkedList<Node> nodelist1,double offsetX, double offsetY)
	{
		if (nodelist1.size()==0) return;
		java.util.LinkedList<Node> nodelist2=new java.util.LinkedList<Node>();
		java.util.LinkedList<Node> nodelist3=new java.util.LinkedList<Node>();
		nodelist1.get(0).setLabel(nodelist1.get(0).form());
		AddAni(nodelist1.get(0),offsetX,offsetY).play();
		for (int i=1;i<nodelist1.size();i++) {
			if(nodelist1.get(i).getValue()>nodelist1.get(0).getValue()) nodelist2.add(nodelist1.get(i));
			else nodelist3.add(nodelist1.get(i));
		}
		if(nodelist2.size()!=0)
		{draw(nodelist2,offsetX+150,offsetY+100);
		Arrow arrowr=new Arrow(offsetX+75/2,offsetY+50,offsetX+150,offsetY+100);
		nodelist1.get(0).setArrowr(arrowr);}
		if(nodelist3.size()!=0) {
		draw(nodelist3,offsetX-150,offsetY+100);
		Arrow arrowl=new Arrow(offsetX,offsetY+50,offsetX-150,offsetY+100);
		nodelist1.get(0).setArrowl(arrowl);
		}
	}
	public void drawNotAni(java.util.LinkedList<Node> nodelist1,double offsetX, double offsetY)
	{
		if (nodelist1.size()==0) return;
		java.util.LinkedList<Node> nodelist2=new java.util.LinkedList<Node>();
		java.util.LinkedList<Node> nodelist3=new java.util.LinkedList<Node>();
		nodelist1.get(0).setLabel(nodelist1.get(0).form());
		Add(nodelist1.get(0),offsetX,offsetY).play();
		for (int i=1;i<nodelist1.size();i++) {
			if(nodelist1.get(i).getValue()>nodelist1.get(0).getValue()) nodelist2.add(nodelist1.get(i));
			else nodelist3.add(nodelist1.get(i));
		}
		if(nodelist2.size()!=0)
		{drawNotAni(nodelist2,offsetX+150,offsetY+100);
		Arrow arrowr=new Arrow(offsetX+75/2,offsetY+50,offsetX+150,offsetY+100);
		nodelist1.get(0).setArrowr(arrowr);}
		if(nodelist3.size()!=0) {
		drawNotAni(nodelist3,offsetX-150,offsetY+100);
		Arrow arrowl=new Arrow(offsetX,offsetY+50,offsetX-150,offsetY+100);
		nodelist1.get(0).setArrowl(arrowl);
		}
	}
public SequentialTransition Add(Node node, double offsetX, double offsetY) {
		
		SequentialTransition st = new SequentialTransition();
		
		TranslateTransition moveX = new TranslateTransition();
		moveX.setDuration(Duration.millis(1));
		moveX.setNode(node.label);
		moveX.setToX(offsetX);
		moveX.setAutoReverse(false);
		
		TranslateTransition moveY = new TranslateTransition();
		moveY.setDuration(Duration.millis(1));
		moveY.setNode(node.label);
		moveY.setToY(offsetY);
		moveY.setAutoReverse(false);
		
		st.getChildren().addAll(moveX,moveY);
		return st;
	}

}

