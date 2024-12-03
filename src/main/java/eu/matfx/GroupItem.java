package eu.matfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class GroupItem extends GridPane 
{
	private Label groupDescription;

	public GroupItem()
	{
		super();
		this.setStyle("-fx-background-color: #458484;");
		this.setGridLinesVisible(true);
		this.getStyleClass().add("debugGridline");
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(20);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		this.getColumnConstraints().addAll(col1, col2);
		
		
		HBox leftHBox = new HBox(5);
		leftHBox.setAlignment(Pos.CENTER);
		//leftHBox.setBorder(border);
		VBox.setVgrow(leftHBox, Priority.ALWAYS);
		
		
		this.addColumn(0, leftHBox);
		
		HBox rightHBox = new HBox(5);
		rightHBox.setPadding(new Insets(0,0,0,15));
		rightHBox.setAlignment(Pos.CENTER);
		//VBox.setVgrow(rightHBox, Priority.ALWAYS);
		
		groupDescription = new Label("Gruppenbezeichnung");
		groupDescription.setStyle("-fx-text-fill: #FFFFFF");
		rightHBox.getChildren().addAll(groupDescription);
		
		
		this.addColumn(1, rightHBox);
		
		
		this.add(GroupItem.createHorizontalSpacer(), 0, 1);
		this.add(getButtonsHBox(), 1, 1);
		
		
		
		
		
	}
	
	private Node getButtonsHBox() 
	{
		HBox hBox = new HBox();
		hBox.setStyle("-fx-background-color: #CCCCCC;");
		HBox.setHgrow(hBox, Priority.ALWAYS);
		//hBox.getChildren().add(GroupItem.createHorizontalSpacer());		
		
		for(int i = 0; i < 3; i++)
		{
			
			if(i == 1)
			{
				System.out.println("addSpacer");
				hBox.getChildren().add(GroupItem.createHorizontalSpacer());
			}
				
			StackPane stackPane1 = new StackPane();
			stackPane1.setStyle("-fx-background-color: #FF0000;");
			stackPane1.setPrefSize(50, 50);
			
			ImageView imageView = new ImageView(ImageLoader.getImage());
			imageView.setFitWidth(50);
			imageView.setFitHeight(50);
			
			Button test1 = new Button("");
			test1.setStyle("-fx-background-color: #00FF00;");
			test1.setGraphic(imageView);
			stackPane1.getChildren().add(test1);
			
			hBox.getChildren().add(stackPane1);
		}
	
		return hBox;
	}
	
	public static Node createHorizontalSpacer() 
	{
		Region spacer = new Region();
		spacer.setStyle("-fx-background-color: #998877");
		HBox.setHgrow(spacer, Priority.ALWAYS);
		return spacer;
	}

	public void setIVisible(IVisible iVisibleItem) {
		groupDescription.setText(iVisibleItem.getDescriptionText());
	}
	
	

}
