package application;

import java.io.InputStream;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class ControllerLL {
	
	LinkedList<Node> ll = new LinkedList<Node>();
	@FXML TextField textf1,textf2;
	@FXML HBox hbox1;
    Node n1 = new Node("Head");
    Node n2 = new Node("Null");
	Node node ;
	String url="/application/arrow.png";
	Class<?> clazz=this.getClass();
	InputStream input1=clazz.getResourceAsStream(url);
	Image image1=new Image(input1);
    ImageView imageView1=new ImageView(image1);
    
    
    @FXML public void addAction (ActionEvent e) {
		
		hbox1.getChildren().clear();
        String a = textf1.getText();
        String b = textf2.getText();
        
		if(a.equalsIgnoreCase("") || b.equalsIgnoreCase("") || Integer.parseInt(b)> ll.size()+1 || Integer.parseInt(b) < 0 ) {
			Alert alert = new Alert(AlertType.WARNING);
			 alert.setTitle("WARNING");
			 alert.setContentText("VALUE IS WRONG");
			 alert.showAndWait();
			 hbox1.getChildren().addAll(n1.label,imageView1);
			 for (int r = 0; r < ll.size(); r++) {
				    Node n = new Node();
		        	n = ll.get(r);
		        	ImageView imageView2=new ImageView(image1);
		        	hbox1.getChildren().addAll(n.label,imageView2);
			 }
			 hbox1.getChildren().add(n2.label);
		}else {
	    

    	node = new Node(a);
        ll.add(Integer.parseInt(b), node);
        
        textf1.clear(); 
        textf2.clear();       
        hbox1.getChildren().addAll(n1.label,imageView1);

        for (int r = 0; r < ll.size(); r++) {
        	node = ll.get(r);
        	ImageView imageView2=new ImageView(image1);
        	hbox1.getChildren().addAll(node.label,imageView2);
        }
        
        hbox1.getChildren().add(n2.label);
		}
	}

	@FXML public void addFirstAction (ActionEvent e) {
		
		hbox1.getChildren().clear();
		node = new Node(textf1.getText());		
        ll.addFirst(node);
        textf1.clear(); 
        
        hbox1.getChildren().addAll(n1.label,imageView1);

        for (int r = 0; r < ll.size(); r++) {
        	node = ll.get(r);
        	ImageView imageView2=new ImageView(image1);
        	hbox1.getChildren().addAll(node.label,imageView2);
        }
        hbox1.getChildren().add(n2.label);
        
	}
	
	@FXML public void addLastAction (ActionEvent e) {		
		hbox1.getChildren().clear();

		node= new Node(textf1.getText());
        ll.addLast(node);
        textf1.clear(); 
        
        hbox1.getChildren().addAll(n1.label,imageView1);

        for (int r = 0; r < ll.size(); r++) {
        	node = ll.get(r);
        	ImageView imageView2=new ImageView(image1);
        	hbox1.getChildren().addAll(node.label,imageView2);
        }
        hbox1.getChildren().add(n2.label);
	}
	
	@FXML public void removeAction (ActionEvent e) {
		if (!ll.isEmpty()) {
			if(textf1.getText().equalsIgnoreCase("") ) {
				Alert alert = new Alert(AlertType.WARNING);
				 alert.setTitle("WARNING");
				 alert.setContentText("ENTER VALUE!");
				 alert.showAndWait();
			}else {
		    String str1 = textf1.getText();
		    int temp = 0;
		    for (int r = 0; r < ll.size(); r++) {
		    	node = ll.get(r);	
		    	String str2 = node.getData();    	
		    	if(Integer.parseInt(str1) == Integer.parseInt(str2)) {
		    		ll.remove(node);
		    		temp++;
		    	}	
		    }
		    if(temp == 0) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("WARNING");
				alert.setContentText("KHONG TON TAI GIA TRI !");
				alert.showAndWait();
			}
	        textf1.clear(); 
	        hbox1.getChildren().clear();
	        hbox1.getChildren().addAll(n1.label,imageView1);
			 for (int r = 0; r < ll.size(); r++) {
				    Node n = new Node();
		        	n = ll.get(r);
		        	ImageView imageView2=new ImageView(image1);
		        	hbox1.getChildren().addAll(n.label,imageView2);
			 }
			 hbox1.getChildren().add(n2.label);
			}
		}
		else {
			textf1.clear();
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setContentText("LINKEDLIST IS EMPTY");
			alert.showAndWait();
		}
			
	}
	
}
