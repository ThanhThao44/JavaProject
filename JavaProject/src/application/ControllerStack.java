package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class ControllerStack {
	Stack stack1 = new Stack(10);
    Node node;
	@FXML TextField textf;
	@FXML HBox hbox;
    
    
	@FXML public void pushAction (ActionEvent e) { 
		try {
			String str = textf.getText();;
			node = new Node(str);
			textf.clear();
		} catch (NumberFormatException | NullPointerException nfe) {
			node = new Node();
		}
		if(!stack1.isFull()) {
		    
		    stack1.push(node);
		    node.setLabel(node.form());
		    textf.clear();
		    hbox.getChildren().add(node.label);
		    
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			 alert.setTitle("WARNING");
			 alert.setContentText("STACK IS FULL");
			 alert.showAndWait();
		}
	}
         
	 @FXML public void popAction (ActionEvent e) {
		 if(!stack1.isEmpty()) {
			node = stack1.pop();
			hbox.getChildren().remove(node.getLabel());
			
		 }
		 else {
			 Alert alert = new Alert(AlertType.WARNING);
			 alert.setTitle("WARNING");
			 alert.setContentText("STACK IS EMPTY");
			 alert.showAndWait();
		 }
			 
	 }

}
