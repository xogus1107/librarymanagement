package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Userlist_controller implements Initializable {
	ArrayList<User> userlist;
	ArrayList<Book> booklist;

	@FXML
	private TableView<User> myUserList;
	@FXML
	private TableColumn<User, String> IDColumn;
	@FXML
	private TableColumn<User, String> usernameColumn;
	@FXML
	private TableColumn<User, String> birthColumn;
	@FXML
	private TableColumn<User, String> phoneColumn;
	@FXML
	private TableColumn<User, Long> totalfeeColumn;

	private ObservableList<User> myListuserlist = FXCollections.observableArrayList();

	public Userlist_controller()
	{
		this.userlist = Main.userlist;
		this.booklist = Main.booklist;
		
		for (int i = 0; i < userlist.size(); i++) {
			total_latefee(i);
			
			myListuserlist.add(new User(new SimpleStringProperty(userlist.get(i).getID()),
					new SimpleStringProperty(userlist.get(i).getname()),
					new SimpleStringProperty(userlist.get(i).getbirthday()),
					new SimpleStringProperty(userlist.get(i).getphone()), 
					new SimpleLongProperty(userlist.get(i).get_totalfee())));
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		IDColumn.setCellValueFactory(cellData -> cellData.getValue().getTableID());
		usernameColumn.setCellValueFactory(cellData -> cellData.getValue().getTablename());
		birthColumn.setCellValueFactory(cellData -> cellData.getValue().getTablebirthday());
		phoneColumn.setCellValueFactory(cellData -> cellData.getValue().getTablephone());
		totalfeeColumn.setCellValueFactory(cellData -> cellData.getValue().getTabletotalfee().asObject());
		myUserList.setItems(myListuserlist);

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
