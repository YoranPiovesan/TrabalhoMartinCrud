package com.view.produto;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;



import com.dao.ProdutoDao;
import com.entity.Produto;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerProduto  extends Application implements Initializable{
	ProdutoDao dao = new ProdutoDao();
	
	List<Produto> listaProduto = new ArrayList<Produto>();
	  @FXML
	    private TextField textFieldNome;

	    @FXML
	    private TextField textFieldTipo;

	    @FXML
	    private TextField textFieldPreco;

	    @FXML
	    private Button buttonInserir;

	    @FXML
	    private TextArea textAreaListProdutos;

	    @FXML
	    private TextField textFieldFindID;

	    @FXML
	    private Label labelLabelID;

	    @FXML
	    private Label labelID;

	    @FXML
	    private Button buttonAlterar;
	    
	    @FXML
	    void DeletarProduto(ActionEvent event) {
	    	String idString= textFieldFindID.getText();
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Deletar Produto");
	    	alert.setHeaderText("Você está prestes a deletar um produto");
	    	alert.setContentText("Tem certeza que deseja deletar o produto?");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	            dao.Deletar(idString, listaProduto);
	        	limpaCampos();
	        	listarProduto();
	    	}
	    }
	    @FXML
	    void AlterarProduto(ActionEvent event) {
	    	Produto produto = pegaDados();
	    	String idString= textFieldFindID.getText();
	    	textFieldNome.setText(produto.getNome());
			textFieldTipo.setText(produto.getTipo());
			textFieldPreco.setText(produto.getPreco() + "");
	    	dao.Alterar(produto,idString, listaProduto );
	    	listarProduto();
	    }
	    @FXML
	    void buscarProduto(ActionEvent event) {
	    	String idString= textFieldFindID.getText();
	    	Produto produto = null;
	    	if (!idString.equals("")) {
				try {
				produto = new ProdutoDao().findByNome(idString, listaProduto);
				} catch (Exception e) {
				}
				if (produto != null) { 
					labelLabelID.setVisible(true);
					labelID.setVisible(true);
					labelID.setText(produto.getNome());
					textFieldNome.setText(produto.getNome());
					textFieldTipo.setText(produto.getTipo());
					textFieldPreco.setText(produto.getPreco() + "");
				}
			}
	    }
	    @FXML
	    void inserirProduto(ActionEvent event) {
	    	Produto produto = pegaDados();
	    	listaProduto.add(produto);
			limpaCampos();
			listarProduto();
	    }
	    

	    @FXML
	    void sair(ActionEvent event) {
	    	 System.exit(0);
	    }
		public void execute() {
			launch();
		}
		private void limpaCampos() {
			textFieldTipo.clear();
			textFieldPreco.clear();
			textFieldNome.clear();
			textFieldNome.requestFocus();
			labelLabelID.setVisible(false);
			labelID.setVisible(false);
			labelID.setText("");
		}
		@Override
		public void start(Stage stage) {
			try {
				AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("Produto.fxml"));
				Scene sc = new Scene(pane);
				stage.setScene(sc);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void initialize(URL location, ResourceBundle resources) {
		listarProduto();
		}
		private Produto pegaDados() {
			return new Produto(textFieldNome.getText(), textFieldTipo.getText(), Double.valueOf(textFieldPreco.getText()));
		}
	    
		private void listarProduto() {
			textAreaListProdutos.clear();
			listaProduto.forEach(produto -> {
				textAreaListProdutos.appendText(produto.toString() + "\n");
			});
		}


}
