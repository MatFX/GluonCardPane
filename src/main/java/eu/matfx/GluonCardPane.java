package eu.matfx;


import com.gluonhq.attach.display.DisplayService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.Avatar;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.gluonhq.charm.glisten.license.License;


public class GluonCardPane extends MobileApplication {

    @Override
    public void init() {
        addViewFactory(HOME_VIEW, BasicView::new);
    }

    @Override
    public void postInit(Scene scene) {
    	
    	Swatch.BLUE.assignTo(scene);
        scene.getStylesheets().add(GluonCardPane.class.getResource("/style.css").toExternalForm());        

        // Fix for phones with tablet form factor 
        if (Platform.isAndroid() && DisplayService.create().map(DisplayService::isTablet).orElse(false)) {
            scene.getStylesheets().removeIf(s -> s.contains("glisten_android_tablet"));
            scene.getStylesheets().add(Avatar.class.getResource("glisten_android.css").toExternalForm());
        }
        
        ((Stage) scene.getWindow()).getIcons().add(new Image(GluonCardPane.class.getResourceAsStream("/icon.png")));
    	
  
    }

    public static void main(String args[]) {
        launch(args);
    }
}
