package eu.matfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GroupItem extends StackPane 
{
	
	private IVisible iVisibleItem;
	
	private Label groupDescription;

	public GroupItem()
	{
		super();
		
		GridPane gridPaneContent = new GridPane();
		gridPaneContent.setStyle("-fx-background-color: #458484;");
		this.setMinHeight(60);
		this.setPrefHeight(60);
		
		HBox leftHBox = new HBox(5);
		leftHBox.setAlignment(Pos.CENTER);
		//leftHBox.setBorder(border);
		VBox.setVgrow(leftHBox, Priority.ALWAYS);
		
		gridPaneContent.addColumn(0, leftHBox);
		
		HBox rightHBox = new HBox(5);
		rightHBox.setPadding(new Insets(0,0,0,15));
		rightHBox.setAlignment(Pos.CENTER);
		//VBox.setVgrow(rightHBox, Priority.ALWAYS);
		
		groupDescription = new Label("Gruppenbezeichnung");
		groupDescription.setStyle("-fx-text-fill: #FFFFFF");
		rightHBox.getChildren().addAll(groupDescription);
		
		
		gridPaneContent.addColumn(1, rightHBox);
		
		gridPaneContent.setBorder(getBorder());
		
		this.getChildren().add(0, gridPaneContent);
	}
	
	public void setIVisible(IVisible iVisibleItem) {
		this.iVisibleItem = iVisibleItem;
		groupDescription.setText(iVisibleItem.getDescriptionText());
	}
	
	

}
