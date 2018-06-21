package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	
	ArrayList<User> userlist = new ArrayList<>();
	ArrayList<Book> booklist = new ArrayList<>();
	public static int user_idx;
	@FXML
	private TextField txtUserName;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private TextField ID;
	@FXML
	private TextField password;
	@FXML
	private TextField name;
	@FXML
	private TextField birthday;
	@FXML
	private TextField phone;
	
	public Controller() throws NumberFormatException, IOException {
		this.userlist = Main.userlist;
		this.booklist = Main.booklist;
	}
	

	public void Login(ActionEvent event) throws Exception {
		

		if (txtUserName.getText().equals("admin") && txtPassword.getText().equals("12345")) {
			
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();


		}
		for (int i = 0; i < userlist.size(); i++) {
			if (txtUserName.getText().equals(userlist.get(i).getID())
					&& txtPassword.getText().equals(userlist.get(i).getPW())) {
				user_idx = i;
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();

			}

		}

	}
	
	public void signup(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void sign(ActionEvent event) throws IOException{
		userlist.add(new User(ID.getText(), password.getText()
				,name.getText(), birthday.getText(),phone.getText(),
				0,0,0,0,0,0,0,0,0));
		
		BufferedWriter bufUser = new BufferedWriter(new FileWriter("user.txt"));
		BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
		for(int i = 0; i < userlist.size(); i++)
		{
			bufUser.write(userlist.get(i).getID() + " ");
			bufUser.write(userlist.get(i).getPW() + " ");
			bufUser.write(userlist.get(i).getname() + " ");
			bufUser.write(userlist.get(i).getbirthday() + " ");
			bufUser.write(userlist.get(i).getphone() + " ");
			bufUser.write(userlist.get(i).get_rentlist(0) + " ");
			bufUser.write(userlist.get(i).get_rentlist(1) + " ");
			bufUser.write(userlist.get(i).get_rentlist(2) + " ");
			bufUser.write(userlist.get(i).get_renttime(0) + " ");
			bufUser.write(userlist.get(i).get_renttime(1) + " ");
			bufUser.write(userlist.get(i).get_renttime(2) + " ");
			bufUser.write(userlist.get(i).get_fee(0) + " ");
			bufUser.write(userlist.get(i).get_fee(1) + " ");
			bufUser.write(userlist.get(i).get_fee(2) + "");
			bufUser.newLine();
		}
		
		for(int i = 0; i < booklist.size(); i++)
		{
			bufBook.write(booklist.get(i).getcode() + " ");
			bufBook.write(booklist.get(i).getname() + " ");
			bufBook.write(booklist.get(i).getwriter() + " ");
			bufBook.write(booklist.get(i).getpublisher() + " ");
			bufBook.write(booklist.get(i).getstate() + "");
			bufBook.newLine();
		}
		
		bufUser.close();
		bufBook.close();
		
	}
	
	/*
	public void exit(ActionEvent event) throws IOException {
		BufferedWriter bufUser = new BufferedWriter(new FileWriter("user.txt"));
		BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
		for(int i = 0; i < userlist.size(); i++)
		{
			bufUser.write(userlist.get(i).getID() + " ");
			bufUser.write(userlist.get(i).getPW() + " ");
			bufUser.write(userlist.get(i).getname() + " ");
			bufUser.write(userlist.get(i).getbirthday() + " ");
			bufUser.write(userlist.get(i).getphone() + " ");
			bufUser.write(userlist.get(i).get_rentlist(0) + " ");
			bufUser.write(userlist.get(i).get_rentlist(1) + " ");
			bufUser.write(userlist.get(i).get_rentlist(2) + " ");
			bufUser.write(userlist.get(i).get_renttime(0) + " ");
			bufUser.write(userlist.get(i).get_renttime(1) + " ");
			bufUser.write(userlist.get(i).get_renttime(2) + " ");
			bufUser.write(userlist.get(i).get_fee(0) + " ");
			bufUser.write(userlist.get(i).get_fee(1) + " ");
			bufUser.write(userlist.get(i).get_fee(2) + "");
			bufUser.newLine();
		}
		
		for(int i = 0; i < booklist.size(); i++)
		{
			bufBook.write(booklist.get(i).getcode() + " ");
			bufBook.write(booklist.get(i).getname() + " ");
			bufBook.write(booklist.get(i).getwriter() + " ");
			bufBook.write(booklist.get(i).getpublisher() + " ");
			bufBook.write(booklist.get(i).getstate() + "");
			bufBook.newLine();
		}
		
		bufUser.close();
		bufBook.close();
	}
*/

}
