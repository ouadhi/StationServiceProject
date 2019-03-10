
package stationservice.UIcomponate;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageDialog extends Stage {

	public StageDialog(Stage owner, AnchorPane pane) {

		initOwner(owner);
		initModality(Modality.APPLICATION_MODAL);
		setResizable(false);
		initStyle(StageStyle.UNDECORATED);
		Scene scene = new Scene(pane, pane.getPrefWidth(), pane.getPrefHeight());
		setScene(scene);
	}

}
