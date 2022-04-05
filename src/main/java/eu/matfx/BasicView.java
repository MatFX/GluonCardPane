package eu.matfx;

import java.util.ArrayList;
import java.util.List;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.CardCell;
import com.gluonhq.charm.glisten.control.CardPane;
import com.gluonhq.charm.glisten.control.LifecycleEvent;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BasicView extends View {

	private CardPane<IVisible> cardPane;
	
    public BasicView() {
        
    	
    	cardPane = new CardPane<>();
    	//without cell factory and using the toString from GroupViewObject, it's the same problem. 
    	//The displayable view starts with group 5 and the user cannot scroll up to group 1.
    	//The user must scroll to the end of the list view and than it's possible to scroll to group 1.
    	cardPane.setCellFactory(p -> new CardCell<IVisible>() 
		{
		    private final GroupItem groupitem;
            {
            	groupitem = new GroupItem();
 
            }
         
            
            @Override
            public void updateItem(IVisible iVisibleItem, boolean empty) 
            {
            	//ich glaube das brauch ich nicht, vermute dass es neben den ifs auch ein Problem war.
            	//super.updateItem(iVisibleItem, empty);
            	if (iVisibleItem != null && !empty) 
                {
            		groupitem.setIVisible(iVisibleItem);
            		setGraphic(groupitem);
            		this.setStyle("-fx-background-color: #00000000");
                    
            	} 
            	else
            	{
            		System.out.println("setGraphic null");
            	    setGraphic(null);
                    setText(null);
                }
            }

			
			
		});
    	
        
        setCenter(cardPane);
        
        HBox hBoxButton = new HBox(15);
		hBoxButton.setPadding(new Insets(15, 15, 15, 15));
		
		Button repaintButton = new Button("Repaint Button");
		repaintButton.setOnAction(new EventHandler<ActionEvent>() 
		{

			@Override
			public void handle(ActionEvent event) 
			{
				repaintView();
				
			}
			
		});
		
		Button clearButton = new Button("Clear");
		clearButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				cardPane.getItems().clear();
				
			}
			
		});
		hBoxButton.getChildren().addAll(repaintButton, clearButton);
		
		
		
		setBottom(hBoxButton);
        

		//The variant with repaintView after shown view doesn't work, because the newValue is true before the view is displayed on screen. 
		this.showingProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				
				System.out.println("showing property oldValue " + oldValue + " newValue " + newValue);
				//if(newValue)
				//	repaintView();
				
			}
			
		});
		
		this.setOnShown(new EventHandler<LifecycleEvent>() {

			@Override
			public void handle(LifecycleEvent event) {
				
				//this works; the first item at the card pane in the visible area is group 1 
				if(event.getEventType() == LifecycleEvent.SHOWN)
				{
					System.out.println("onShown SHOWN");
					repaintView();
				}
			}
			
		});

		
	}

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }
    
    public void repaintView() 
	{
		if(cardPane != null)
		{
			
			if(cardPane.getItems().size() == 0)
			{
				List<GroupViewObject> groupViewObjectList = new ArrayList<GroupViewObject>();
				
				groupViewObjectList.add(new GroupViewObject(1, "Group"));
				groupViewObjectList.add(new GroupViewObject(2, "Group"));
				groupViewObjectList.add(new GroupViewObject(3, "Group"));
				groupViewObjectList.add(new GroupViewObject(4, "Group"));
				groupViewObjectList.add(new GroupViewObject(5, "Group"));
				groupViewObjectList.add(new GroupViewObject(6, "Group"));
				groupViewObjectList.add(new GroupViewObject(7, "Group"));
				groupViewObjectList.add(new GroupViewObject(8, "Group"));
				groupViewObjectList.add(new GroupViewObject(9, "Group"));
				groupViewObjectList.add(new GroupViewObject(10, "Group"));
				groupViewObjectList.add(new GroupViewObject(11, "Group"));
				groupViewObjectList.add(new GroupViewObject(12, "Group"));
				groupViewObjectList.add(new GroupViewObject(13, "Group"));
				groupViewObjectList.add(new GroupViewObject(14, "Group"));
				groupViewObjectList.add(new GroupViewObject(15, "Group"));
				groupViewObjectList.add(new GroupViewObject(16, "Group"));
				groupViewObjectList.add(new GroupViewObject(17, "Group"));
				groupViewObjectList.add(new GroupViewObject(18, "Group"));
				groupViewObjectList.add(new GroupViewObject(19, "Group"));
				groupViewObjectList.add(new GroupViewObject(20, "Group"));
				groupViewObjectList.add(new GroupViewObject(21, "Group"));
				groupViewObjectList.add(new GroupViewObject(22, "Group"));
				groupViewObjectList.add(new GroupViewObject(23, "Group"));
				groupViewObjectList.add(new GroupViewObject(24, "Group"));
				groupViewObjectList.add(new GroupViewObject(25, "Group"));
				groupViewObjectList.add(new GroupViewObject(26, "Group"));
				groupViewObjectList.add(new GroupViewObject(27, "Group"));
				groupViewObjectList.add(new GroupViewObject(28, "Group"));
				groupViewObjectList.add(new GroupViewObject(29, "Group"));
				groupViewObjectList.add(new GroupViewObject(30, "Group"));
				groupViewObjectList.add(new GroupViewObject(31, "Group"));
				groupViewObjectList.add(new GroupViewObject(32, "Group"));
				groupViewObjectList.add(new GroupViewObject(33, "Group"));
				groupViewObjectList.add(new GroupViewObject(34, "Group"));
				groupViewObjectList.add(new GroupViewObject(35, "Group"));
				groupViewObjectList.add(new GroupViewObject(36, "Group"));
				groupViewObjectList.add(new GroupViewObject(37, "Group"));
				groupViewObjectList.add(new GroupViewObject(38, "Group"));
				groupViewObjectList.add(new GroupViewObject(39, "Group"));
				groupViewObjectList.add(new GroupViewObject(40, "Group"));
				groupViewObjectList.add(new GroupViewObject(41, "Group"));
				
				
				cardPane.getItems().addAll(groupViewObjectList);
				
				/*
				for(int i = 0; i < groupViewObjectList.size(); i++)
				{
					cardPane.getItems().add(groupViewObjectList.get(i));
				}*/
				
				
				
			}
		
		}
		
	}
    
}