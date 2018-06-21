package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class mybook_controller implements Initializable {
	ArrayList<User> userlist;
	ArrayList<Book> booklist;
	int user_idx;
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
	
	public mybook_controller()
	{
		this.userlist = Main.userlist;
		this.booklist = Main.booklist;
		this.user_idx = Controller.user_idx;
		
		for(int i = 0; i < 3; i++)
		{
			if(userlist.get(user_idx).get_rentlist(i) != 0)
			{
				for(int j = 0; j < booklist.size(); j++)
				{
					if(userlist.get(user_idx).get_rentlist(i) == booklist.get(j).getcode())
					{
						latefee(user_idx, j);
						myListbooklist.add(new Book(new SimpleIntegerProperty(booklist.get(j).getcode()),
								new SimpleStringProperty(booklist.get(j).getname()),
								new SimpleStringProperty(booklist.get(j).getwriter()),
								new SimpleStringProperty(booklist.get(j).getpublisher()),
								new SimpleIntegerProperty((int)userlist.get(user_idx).get_fee(i))));
					}
				}
			}
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
