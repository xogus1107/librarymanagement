import java.io.IOException;
import java.util.ArrayList;

public class Login{
	private ArrayList<User> userlist;
	public Login(ArrayList<User> userlist){
		this.userlist = userlist;
	}

	int id_index = -1;

	public boolean id_Check(String id) {
		for (int i = 0; i < userlist.size(); i++) {
			if (id.equals(userlist.get(i).getID())) {
				id_index = i;
				return true;
			}
		}
		return false;
	}

	public boolean pw_Check(String pw, int index) {
		for (int i = 0; i < userlist.size(); i++) {
			if (pw.equals(userlist.get(index).getPW())) {
				return true;
			}
		}
		return false;
	}

	public boolean admin_id_Check(String id) {
		if (id.equals("admin")) {
			return true;
		}
		return false;
	}

	public boolean admin_pw_Check(String pw) {
		if (pw.equals("12345")) {
			return true;
		}
		return false;
	}
}
