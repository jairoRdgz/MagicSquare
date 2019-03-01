package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import model.MagicSquare;
/**
 * This class is in charge of all the actions in the application
 */
public class MagicSquareController {
	//-----------------------------------------------------------
	//Relation
	//-----------------------------------------------------------
	private MagicSquare magic;
	
	//-----------------------------------------------------------
	//JavaFx Objects
	//-----------------------------------------------------------
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCreate;

    @FXML
    private TextField txtorder;

    @FXML
    private ComboBox<String> start;

    @FXML
    private ComboBox<String> direction;

    @FXML
    private GridPane square;
    
    //---------------------------------------------------------------
    //Methods
    //---------------------------------------------------------------
    
    /**
     * This method is in charge of converting the values from the comboBox that represents
     * the start position
     * @param ini says what the start position is
     * @return a number that will represent which is the start position
     */
    public int position(String ini){

		int flag = 0;
		if(ini == "UP") {		
			flag =1;
		}else if(ini =="Left") {
			flag = 2;
		}else if(ini == "Down") {
			flag = 3;
		}else if(ini == "Right") {
			flag = 4;
		}
		return flag;
	}
    /**
     * This method is in charge of converting the values from the comboBox that represents
     * the direction for the filling
     * @param direc the direction for the filing
     * @return a number that represents which is the direction of the filing
     */
	public int direction(String direc) {
		int flag = 0;
		if(direc == "NO") {
			flag =1;
		}else if(direc =="NE") {
			flag = 2;
		}else if(direc == "SE") {
			flag = 3;
		}else if(direc == "SO") {
			flag = 4;
		}
		return flag;
	}
    
    @FXML
    /**
     * this method is in charge of creating and filling the magic square
     * @param event when the button is pressed
     */
    public void createMagicSquare(ActionEvent event) throws NumberFormatException{
    	Alert sirve = new Alert(AlertType.ERROR);
    	sirve.setTitle("Magic Square");
    	sirve.setHeaderText(null);
    	sirve.initStyle(StageStyle.UTILITY);
        
    	try {
    	
    		int order = Integer.parseInt(txtorder.getText());
            String ini = start.getValue();
            String direc = direction.getValue();
            
        	if(magic.isValid(order)==true) {
        		//--------------------------------------------------------------------
        		//AQUI VA 
        		//--------------------------------------------------------------------
        		square.getChildren().clear();
        		if(ini == "UP") {
        			if(direc=="NO" || direc == "NE") {
        	    		square.setGridLinesVisible(true);
        	    		//square.setAlignment(Pos.BASELINE_CENTER);
        	    		int i = position(ini);
        	    		int j = direction(direc);
        	    		int[][] ms = magic.createSquare(order);
        	    		magic.fillSquare(j, i, order, ms);
        	    		for(int k = 0; k<ms.length ; k++) {
        	    			for(int l = 0; l<ms[k].length ; l++) {
        	    				Button label = new Button(ms[l][k]+"");
        	    				square.add(label, k, l);
        	    			}
        	    		}
        			}else {
        				sirve.setContentText("Sorry but in this position the square can only be fill with NE-NO \n Please try again with a valid option");
        				sirve.show();
        			}
        		}else if(ini == "Left") {
        			if(direc == "NO" || direc == "SO") {
        				square.setGridLinesVisible(true);
        	    		square.setAlignment(Pos.BASELINE_CENTER);
        	    		int i = position(ini);
        	    		int j = direction(direc);
        	    		int[][] ms = magic.createSquare(order);
        	    		magic.fillSquare(j, i, order, ms);
        	    		for(int k = 0; k<ms.length ; k++) {
        	    			for(int l = 0; l<ms[k].length ; l++) {
        	    				Button label = new Button(ms[l][k]+"");
        	    				square.add(label, k, l);
        	    			}
        	    		}
        			}else {
        				sirve.setContentText("Sorry but in this position the square can only be fill with SO-NO \n Please try again with a valid option");
        				sirve.show();
        			}
        		}else if(ini == "Down") {
        			if(direc == "SO" || direc == "SE") {
        				square.setGridLinesVisible(true);
        	    		square.setAlignment(Pos.BASELINE_CENTER);
        	    		int i = position(ini);
        	    		int j = direction(direc);
        	    		int[][] ms = magic.createSquare(order);
        	    		magic.fillSquare(j, i, order, ms);
        	    		for(int k = 0; k<ms.length ; k++) {
        	    			for(int l = 0; l<ms[k].length ; l++) {
        	    				Button label = new Button(ms[l][k]+"");
        	    				square.add(label, k, l);
        	    			}
        	    		}
        			}else {
        				sirve.setContentText("Sorry but in this position the square can only be fill with SO-SE \n Please try again with a valid option");
        				sirve.show();
        			}
        		}else if(ini == "Right") {
        			if(direc == "NE" || direc == "SE") {
        				square.setGridLinesVisible(true);
        	    		square.setAlignment(Pos.BASELINE_CENTER);
        	    		int i = position(ini);
        	    		int j = direction(direc);
        	    		int[][] ms = magic.createSquare(order);
        	    		magic.fillSquare(j, i, order, ms);
        	    		for(int k = 0; k<ms.length ; k++) {
        	    			for(int l = 0; l<ms[k].length ; l++) {
        	    				Button label = new Button(ms[l][k]+"");
        	    				square.add(label, k, l);
        	    			}
        	    		}
        			}else {
        				sirve.setContentText("Sorry but in this position the square can only be fill with NE-SE \n Please try again with a valid option");
        				sirve.show();
        			}
        		}
        	}else {
        		sirve.setContentText("Sorry but this program only works with odd numbers. \n\n Please try again with an odd number");
        		sirve.showAndWait();
        	}
    		
    	}catch(NegativeArraySizeException e) {
    		sirve.setContentText("Please use a positive number");
			sirve.show();
    	}
    }

    @FXML
    void initialize() {
    	magic= new MagicSquare();
        start.getItems().add("UP");
        start.getItems().add("Left");
        start.getItems().add("Down");
        start.getItems().add("Right");
        
        direction.getItems().add("NO");
        direction.getItems().add("NE");
        direction.getItems().add("SO");
        direction.getItems().add("SE");
    }
}
