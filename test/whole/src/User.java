import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class User {
	private String ID;
	private String PW;
	private String name;
	private String birthday;
	private String phone;
	private int[] rent_booklist = new int[3];
	private long[] rent_time = new long[3];
	private long[] fee = new long[3];

	public User(String ID, String PW, String name, String birthday, String phone, int rent_bookcode0,
			int rent_bookcode1, int rent_bookcode2, long rent_time0, long rent_time1, long rent_time2, long fee0,
			long fee1, long fee2) throws IOException {
		this.ID = ID;
		this.PW = PW;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;

		this.rent_booklist[0] = rent_bookcode0;
		this.rent_booklist[1] = rent_bookcode1;
		this.rent_booklist[2] = rent_bookcode2;

		this.rent_time[0] = rent_time0;
		this.rent_time[1] = rent_time1;
		this.rent_time[2] = rent_time2;

		this.fee[0] = fee0;
		this.fee[1] = fee1;
		this.fee[2] = fee2;

	}

	public String getname() {
		return name;
	}

	public String getID() {
		return ID;
	}

	public String getPW() {
		return PW;
	}

	public String getbirthday() {
		return birthday;
	}

	public String getphone() {
		return phone;
	}

	public int get_rentlist(int index) {
		return rent_booklist[index];
	}

	public long get_renttime(int index) {
		return rent_time[index];
	}

	public long get_fee(int index) {
		return fee[index];
	}

	public long get_totalfee() {
		long totalfee = 0;
		for (int i = 0; i < 3; i++) {
			totalfee += fee[i];
		}
		return totalfee;
	}

	public void setname(String name) {
		this.name = name;
	}

	public void setbirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public void set_rentlist(int index, int code) {
		this.rent_booklist[index] = code;
	}

	public void set_renttime(int index, long time) {
		this.rent_time[index] = time;
	}

	public void set_fee(int index, long fee) {
		this.fee[index] = fee;
	}

}
