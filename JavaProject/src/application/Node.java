package application;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Node  {
	private String data;
	private int value;
	public Label label;
	private int height;
	private Node left, right; //for tree
	public Arrow arrowl;
	public Arrow arrowr;	
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Arrow getArrowl() {
		return arrowl;
	}

	public void setArrowl(Arrow arrowl) {
		this.arrowl = arrowl;
	}

	public Arrow getArrowr() {
		return arrowr;
	}

	public void setArrowr(Arrow arrowr) {
		this.arrowr = arrowr;
	}


	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

    public Node() {
    	
    }
    public Node(int value) {
		super();
		left = null;
        right = null;
        height = 0;
        arrowl= null;
    	arrowr = null;
		this.value = value;
		this.label = form();
	}
	public Node(String data) {
		super();
		this.data = data;
		this.label = form();
	}
    public Label form() {
    	Label label = new Label();
    	
    	label.setText("" + data);
    	label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));
    	label.setMinWidth(50);
    	label.setMinHeight(50);
    	label.setFont(new Font(30));
    	label.setAlignment(Pos.CENTER);
    	label.setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    	return label;
    }
    
	
	
	

}











