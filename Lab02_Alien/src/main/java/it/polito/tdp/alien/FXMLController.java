package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private AlienDictionary model;
	
	public void setModel(AlienDictionary model) {
		this.model=model;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void doReset(ActionEvent event) {
    txtRisultato.clear();
    txtParola.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String parola=txtParola.getText().toLowerCase();
    	/*if((parola.matches("([a-zA-Z])"))==false) {
    		txtRisultato.setText("non ci devono essere numeri");   //vedi come si verifica che non ci siano numeri
    		return ;}*/
       if(parola.length()==0) {
    	   txtRisultato.setText("devi inserire una parola");
    	   txtParola.clear();}
       else{if(parola.contains(" ")){
    	   int k=parola.indexOf(" ");
    	   String aliena=parola.substring(0,k);
    	   String traduzione=parola.substring(k+1,parola.length());
    	   txtParola.clear();
    	   model.addWord(aliena, traduzione);
    	   
    	   txtRisultato.setText("hai inserito una parola");
       }       else{
    	   txtRisultato.setText(model.traslateWord(parola));
       if(model.traslateWord(parola)==null)
    	   txtRisultato.setText("la parola non e' presente nel dizionario");
       txtParola.clear();}}
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
