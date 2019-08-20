package application;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


	public class Main extends Application {
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			FlowPane root = new FlowPane();
			root.setHgap(200);
		    root.setPadding(new Insets(30,30,30,80));
		    
		    
		    BackgroundImage myBI= new BackgroundImage(new Image("/application/layout.png"),
		            BackgroundRepeat.SPACE,BackgroundRepeat.SPACE, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		    root.setBackground(new Background(myBI));
		    
		    // Button 1
		    Button button1= new Button("Stack");
		    button1.setMinSize(100, 50);
		   
		    root.getChildren().add(button1);  
		    
		        
		    // Button 2
		    Button button2 = new Button("Linked List");
		    button2.setMinSize(100, 50);
		    root.getChildren().add(button2);
		        
		   
		    Scene scene = new Scene(root, 560, 300);
		    primaryStage.setTitle("NHOM 1");
		    primaryStage.setScene(scene);
		    primaryStage.show();
		       
		    button1.setOnAction(new EventHandler<ActionEvent>() {
		    	   
		            @Override
		            public void handle(ActionEvent event) {
		            	Stage window1 = new Stage();
		            	try {
		    				Parent root1 = FXMLLoader.load(getClass().getResource("Stack.fxml"));
		    				window1.setScene(new Scene(root1));
		    				window1.setTitle("Stack");
		    				window1.show();
		    			} catch(Exception e) {
		    				e.printStackTrace();
		    			}
		            }
		       });

		    button2.setOnAction(new EventHandler<ActionEvent>() {
		    	   
		            @Override
		            public void handle(ActionEvent event) {
		            	Stage window2 = new Stage();
		            	try {
		    				Parent root2 = FXMLLoader.load(getClass().getResource("LinkedList.fxml"));
		    				window2.setScene(new Scene(root2));
		    				window2.setTitle("LinkedList");
		    				window2.show();
		    			} catch(Exception e) {
		    				e.printStackTrace();
		    			}
		            }
		       });
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}
