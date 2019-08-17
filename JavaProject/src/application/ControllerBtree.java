package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class ControllerBtree {
	AVLTree tree=new AVLTree();
    Node node;
    double offset,fixset;
    private int indi;
	@FXML TextField textf;
	@FXML AnchorPane pane;
    
	private void setFixset(double i) {
		this.fixset = pane.getHeight()*i-GlobalVar.LABEL_HEIGHT/2;
	}
	private void setOffset(double i)
	{
		this.offset= pane.getWidth()*i;
	}
    
	public void initBtree() {
		this.indi = 3;
		setFixset(0.01);
		pane.getChildren().clear();
		
		tree.nodelist.clear();
		tree.isEmpty();
		System.out.println("Btree");
		setOffset(0.5);
			node = new Node();
			node.setValue(10);
			tree.insert(node.getValue());
			
			node.setValue(20);
			tree.insert(node.getValue());
			
			node.setValue(30);
			tree.insert(node.getValue());
			
			tree.preorder();
			tree.draw(tree.nodelist,offset,fixset);
			System.out.println(tree.nodelist.size());
			for(int i=0;i<tree.nodelist.size();i++) {
				pane.getChildren().add(tree.nodelist.get(i).label);
				if(tree.nodelist.get(i).getArrowl()!=null)
				pane.getChildren().add(tree.nodelist.get(i).getArrowl());
				if(tree.nodelist.get(i).getArrowr()!=null)
				pane.getChildren().add(tree.nodelist.get(i).getArrowr());
			}
//			Thread.sleep(500);
		
	}
	
	@FXML public void insertAction (ActionEvent e) { 
		System.out.println("insertBtree");
		try {
			int d = Integer.parseInt(textf.getText());
			node = new Node(d);
			textf.clear();
		} catch (NumberFormatException | NullPointerException nfe) {
			
		}
		pane.getChildren().clear();
		tree.insert(node.getValue());
		tree.nodelist.clear();
		tree.preorder();
		tree.drawNotAni(tree.nodelist,offset,fixset);
		for(int i=0;i<tree.nodelist.size();i++) {
			pane.getChildren().add(tree.nodelist.get(i).label);
			if(tree.nodelist.get(i).getArrowl()!=null&&tree.nodelist.get(i).getLeft()!=null)
			pane.getChildren().add(tree.nodelist.get(i).getArrowl());
			if(tree.nodelist.get(i).getArrowr()!=null&&tree.nodelist.get(i).getRight()!=null)
			pane.getChildren().add(tree.nodelist.get(i).getArrowr());		}
		
	}

	@FXML public void deleteAction (ActionEvent e) { 
		System.out.println("deleteNode");
		try {
			int d = Integer.parseInt(textf.getText());
			node = new Node(d);
			textf.clear();
		} catch (NumberFormatException | NullPointerException nfe) {
			
		}
		pane.getChildren().clear();
		tree.delete(node.getValue());
		tree.nodelist.clear();
		tree.preorder();
		tree.drawNotAni(tree.nodelist,offset,fixset);
		System.out.println(tree.nodelist.size());
		for(int i=0;i<tree.nodelist.size();i++) {
			pane.getChildren().add(tree.nodelist.get(i).label);
			if(tree.nodelist.get(i).getArrowl()!=null&&tree.nodelist.get(i).getLeft()!=null)
			pane.getChildren().add(tree.nodelist.get(i).getArrowl());
			if(tree.nodelist.get(i).getArrowr()!=null&&tree.nodelist.get(i).getRight()!=null)
			pane.getChildren().add(tree.nodelist.get(i).getArrowr());
		}
	}	
}
