package application;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Usermode_controller{
	ArrayList<User> userlist;
	ArrayList<Book> booklist;
	int user_idx;
	@FXML
	private TextField txtBookName;
	@FXML
	private TextField txtId;
	@FXML
	private TextField revname;
	@FXML
	private TextField revbirth;
	@FXML
	private TextField revphone;
	@FXML
	Label lcode;
	@FXML
	Label lname;
	@FXML
	Label lwriter;
	@FXML
	Label lpublisher;
	@FXML
	Label lstate;
	@FXML
	Label luid;
	@FXML
	Label luname;
	@FXML
	Label lubirthday;
	@FXML
	Label luphone;
	@FXML
	Label lutotalfee;
	
	/*
	 * private IntegerProperty code; private StringProperty name; private
	 * StringProperty writer; private StringProperty publisher; private
	 * StringProperty state;
	 */
	public Usermode_controller(){
		this.userlist = Main.userlist;
		this.booklist = Main.booklist;
		this.user_idx = Controller.user_idx;
	}
	
	public void search_book(ActionEvent event) throws IOException {

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Searchbook.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}	
	public void search(ActionEvent event) throws IOException {
		
		
		for(int i=0; i<booklist.size();i++)
		{
			if(txtBookName.getText().equals(booklist.get(i).getname()))
			{
		
				lcode.setText(Integer.toString(booklist.get(i).getcode()));
				lname.setText(booklist.get(i).getname());
				lwriter.setText(booklist.get(i).getwriter());
				lpublisher.setText(booklist.get(i).getpublisher());
				if(booklist.get(i).getstate()==0){
					lstate.setText("대여가능");
				}
				else if(booklist.get(i).getstate()==1)
				{
					lstate.setText("대여불가능");
				}
				
				
			}
		}
	}
	
	public void book_list(ActionEvent event) throws IOException {
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Booklist.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Book List");
		primaryStage.show();
	}

	public void Mybook(ActionEvent event) throws Exception {

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Mybook.fxml"));
		primaryStage.setTitle("Chart Test");
		primaryStage.setScene(new Scene(root, 700, 300));
		primaryStage.show();

	}


	public void MyInfo(ActionEvent event) throws IOException {
	

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("MyInfo.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();	
	

	}
	public void revise(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("revise.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void save(ActionEvent event) throws IOException{
		userlist.get(user_idx).setname(revname.getText());
		userlist.get(user_idx).setbirthday(revbirth.getText());
		userlist.get(user_idx).setphone(revphone.getText());
	}
	
public void Info(ActionEvent event) throws IOException {
	for (int i = 0; i < userlist.size(); i++) {
		if (userlist.get(user_idx).getID().equals(userlist.get(i).getID())) {
			total_latefee(user_idx);
			luid.setText(userlist.get(i).getID());
			luname.setText(userlist.get(i).getname());
			lubirthday.setText(userlist.get(i).getbirthday());
			luphone.setText(userlist.get(i).getphone());
			lutotalfee.setText(Long.toString(userlist.get(i).get_totalfee()));
		}
	}
	}
	
	public void total_latefee(int user_index) {
		long latefee = 0;
		long time = System.currentTimeMillis();
		long temp = 0;

		for (int i = 0; i < 3; i++) {
			if (userlist.get(user_index).get_rentlist(i) != 0) {
				temp = (time - userlist.get(user_index).get_renttime(i)) / 1000;
				if (temp > 10) {
					latefee = (temp - 10) * 100;
					userlist.get(user_index).set_fee(i, latefee);
				}
			}
		}
	}

}
