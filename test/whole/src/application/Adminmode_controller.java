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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Adminmode_controller {
	ArrayList<User> userlist;
	ArrayList<Book> booklist;
	int bookindex;
	int userindex;
	int userindex2;
	@FXML
	private TextField txtBookName;
	@FXML
	private TextField txtuserName;
	@FXML
	private TextField setBcode;
	@FXML
	private TextField setBname;
	@FXML
	private TextField setBwriter;
	@FXML
	private TextField setBpublisher;
	@FXML
	private TextField addBcode;
	@FXML
	private TextField addBname;
	@FXML
	private TextField addBwriter;
	@FXML
	private TextField addBpublisher;
	@FXML
	private TextField delBname;

	@FXML
	Label lcode;
	@FXML
	Label lname;
	@FXML
	Label lwriter;
	@FXML
	Label lpublisher;
	@FXML
	Label lcode1;
	@FXML
	Label lname1;
	@FXML
	Label lwriter1;
	@FXML
	Label lpublisher1;
	@FXML
	Label lstate;
	@FXML
	Label username;
	@FXML
	Label expression;
	@FXML
	Label book1;
	@FXML
	Label book2;
	@FXML
	Label book3;
	@FXML
	Label expression2;
	public Adminmode_controller() throws NumberFormatException, IOException {
		this.userlist = Main.userlist;
		this.booklist = Main.booklist;
	}

	public void book_list(ActionEvent event) throws IOException {

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Booklist.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void user_list(ActionEvent event) throws IOException {

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Userlist.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void issueduser_list(ActionEvent event) throws IOException {

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Issueduser.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void managebook(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("managebook.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void bookadd(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("bookadd.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void add(ActionEvent event) throws IOException {

		booklist.add(new Book(Integer.valueOf(addBcode.getText()), addBname.getText(), addBwriter.getText(),
				addBpublisher.getText(), 0));
		expression.setText("추가완료");
		BufferedWriter bufUser = new BufferedWriter(new FileWriter("user.txt"));
		BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
		for (int i = 0; i < userlist.size(); i++) {
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

		for (int i = 0; i < booklist.size(); i++) {
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
	public void bookset(ActionEvent event) throws IOException{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("bookset.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void set(ActionEvent event) throws IOException{
		booklist.get(bookindex).setCode(Integer.valueOf(setBcode.getText()));
		booklist.get(bookindex).setName(setBname.getText());
		booklist.get(bookindex).setWriter(setBwriter.getText());
		booklist.get(bookindex).setPublisher(setBpublisher.getText());
		
		lcode1.setText(Integer.toString(booklist.get(bookindex).getcode()));
		lname1.setText(booklist.get(bookindex).getname());
		lwriter1.setText(booklist.get(bookindex).getwriter());
		lpublisher1.setText(booklist.get(bookindex).getpublisher());
		
		BufferedWriter bufUser = new BufferedWriter(new FileWriter("user.txt"));
		BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
		for (int i = 0; i < userlist.size(); i++) {
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

		for (int i = 0; i < booklist.size(); i++) {
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
	
	

	public void bookdelete(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("bookdelete.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	public void delete(ActionEvent event) throws IOException {
		for (int i = 0; i < booklist.size(); i++) {
			if (booklist.get(i).getname().equals(delBname.getText())) {
				booklist.remove(i);
			}
		}
		expression.setText("삭제완료");
		BufferedWriter bufUser = new BufferedWriter(new FileWriter("user.txt"));
		BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
		for (int i = 0; i < userlist.size(); i++) {
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

		for (int i = 0; i < booklist.size(); i++) {
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

	public void manageuser(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("manageuser.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void rentbook(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("rentbook.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void rent(ActionEvent event) throws IOException {
		int rent_count = 0;
		long time = System.currentTimeMillis();

		if (booklist.get(bookindex).getstate() == 1) {
			expression.setText("대여중인책입니다");
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			if (userlist.get(userindex).get_rentlist(i) != 0) {
				rent_count++;
			}
		}
		
		if (rent_count == 3) {
			expression.setText("책을 더이상빌릴수없습니다");
			return;
		} 
		for(int i = 0; i<3; i++)
		{
			if(userlist.get(userindex).get_rentlist(i)==0)
			{
				userlist.get(userindex).set_rentlist(i, booklist.get(bookindex).getcode());
				userlist.get(userindex).set_renttime(i, time);
				booklist.get(bookindex).setState(1);
				expression.setText("대출완료");
				break;
			}
		}
		BufferedWriter bufUser = new BufferedWriter(new FileWriter("user.txt"));
		BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
		for (int i = 0; i < userlist.size(); i++) {
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

		for (int i = 0; i < booklist.size(); i++) {
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

	public void usersearch(ActionEvent event) throws IOException {

		for (int i = 0; i < userlist.size(); i++) {
			if (txtuserName.getText().equals(userlist.get(i).getname())) {
				userindex = i;
				username.setText(userlist.get(i).getname());
			}
		}
	}

	public void search(ActionEvent event) throws IOException {

		for (int i = 0; i < booklist.size(); i++) {
			if (txtBookName.getText().equals(booklist.get(i).getname())) {
				bookindex = i;
				lcode.setText(Integer.toString(booklist.get(i).getcode()));
				lname.setText(booklist.get(i).getname());
				lwriter.setText(booklist.get(i).getwriter());
				lpublisher.setText(booklist.get(i).getpublisher());
				lstate.setText(Integer.toString(booklist.get(i).getstate()));

			}
		}
	}
	public void returnbook(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("returnbook.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void usersearchR(ActionEvent event) throws IOException {
		for (int i = 0; i < userlist.size(); i++) {
			if (txtuserName.getText().equals(userlist.get(i).getname())) {
				userindex2 = i;
			}
		}
		for (int i = 0; i < booklist.size(); i++) {
			if (userlist.get(userindex2).get_rentlist(0) == booklist.get(i).getcode()) {
				book1.setText(booklist.get(i).getname());
			}
			if (userlist.get(userindex2).get_rentlist(1) == booklist.get(i).getcode()) {
				book2.setText(booklist.get(i).getname());
			}
			if (userlist.get(userindex2).get_rentlist(2) == booklist.get(i).getcode()) {
				book3.setText(booklist.get(i).getname());
			}

		}
		
	}
	public void returnfunc(ActionEvent event) throws IOException {
		long fee;
		for (int i = 0;i <3; i++)
		{
			
			if(userlist.get(userindex2).get_rentlist(i)==booklist.get(bookindex).getcode())
			{
				fee =latefee(userindex2,bookindex);
				userlist.get(userindex2).set_rentlist(i,0);
				userlist.get(userindex2).set_renttime(i, 0);
			

				if (fee > 0) {
					expression2.setText("연체료"+fee+"원 지불완료");
					userlist.get(userindex2).set_fee(i, 0);
					
					
				}
			}
		}
		booklist.get(bookindex).setState(0);

		BufferedWriter bufUser = new BufferedWriter(new FileWriter("user.txt"));
		BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
		for (int i = 0; i < userlist.size(); i++) {
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

		for (int i = 0; i < booklist.size(); i++) {
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
	public long latefee(int user_index,int book_index) {
		long latefee = 0;
		long time = System.currentTimeMillis();
		long temp = 0;
		
		for (int i = 0; i < 3; i++) {
			if (userlist.get(user_index).get_rentlist(i) == booklist.get(book_index).getcode()) {
				temp = (time - userlist.get(user_index).get_renttime(i))/1000;
		
				if (temp > 10) {
					latefee = (temp - 10) * 100;
					userlist.get(user_index).set_fee(i, latefee);
					
				}
			}
		}
		return latefee;
	}
}
