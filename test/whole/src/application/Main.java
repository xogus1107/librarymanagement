package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class Main extends Application implements Initializable {
	public static ArrayList<User> userlist = new ArrayList<>();
	public static ArrayList<Book> booklist = new ArrayList<>();
	@FXML
	private TableView<Book> myBookList;
	@FXML
	private TableColumn<Book, Integer> codeColumn;
	@FXML
	private TableColumn<Book, String> nameColumn;
	@FXML
	private TableColumn<Book, String> writerColumn;
	@FXML
	private TableColumn<Book, String> publisherColumn;
	@FXML
	private TableColumn<Book, Integer> stateColumn;
	
	private ObservableList<Book> myListbooklist = FXCollections.observableArrayList();


	public Main() throws NumberFormatException, IOException {
		BufferedReader bufferUser = new BufferedReader(new FileReader("user.txt"));
		BufferedReader bufferBook = new BufferedReader(new FileReader("book.txt"));
		String s;

		booklist.removeAll(booklist);
		userlist.removeAll(userlist);

		while ((s = bufferUser.readLine()) != null) {
			String[] split = s.split(" ");
			userlist.add(new User(split[0], split[1], split[2], split[3], split[4], Integer.valueOf(split[5]),
					Integer.valueOf(split[6]), Integer.valueOf(split[7]), Long.valueOf(split[8]),
					Long.valueOf(split[9]), Long.valueOf(split[10]), Long.valueOf(split[11]), Long.valueOf(split[12]),
					Long.valueOf(split[13])));
		}

		while ((s = bufferBook.readLine()) != null) {
			String[] split = s.split(" ");
			booklist.add(new Book(Integer.valueOf(split[0]), split[1], split[2], split[3], Integer.valueOf(split[4])));
		}

		bufferUser.close();
		bufferBook.close();

		for (int i = 0; i < booklist.size(); i++) {
			myListbooklist.add(new Book(new SimpleIntegerProperty(booklist.get(i).getcode()),
					new SimpleStringProperty(booklist.get(i).getname()),
					new SimpleStringProperty(booklist.get(i).getwriter()),
					new SimpleStringProperty(booklist.get(i).getpublisher()),
					new SimpleIntegerProperty(booklist.get(i).getstate())));
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		codeColumn.setCellValueFactory(cellData -> cellData.getValue().getTablecode().asObject());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getTablename());
		writerColumn.setCellValueFactory(cellData -> cellData.getValue().getTablewriter());
		publisherColumn.setCellValueFactory(cellData -> cellData.getValue().getTablepublisher());
		stateColumn.setCellValueFactory(cellData -> cellData.getValue().getTablestate().asObject());
		myBookList.setItems(myListbooklist);

	}

	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) throws IOException {
		launch(args);
		
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
}
