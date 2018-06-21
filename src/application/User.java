package application;

import java.io.IOException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.StringProperty;

public class User{
	private String ID;
	private String PW;
	private String name;
	private String birthday;
	private String phone;
	private int[] rent_booklist = new int[3];
	private long[] rent_time = new long[3];
	private long[] fee = new long[3];
	
	private StringProperty tableID;
	private StringProperty tablePW;
	private StringProperty tablename;
	private StringProperty tablebirthday;
	private StringProperty tablephone;
	private IntegerProperty[] table_rent_booklist = new IntegerProperty[3];
	private LongProperty[] table_rent_time = new LongProperty[3];
	private LongProperty[] table_fee = new LongProperty[3];
	private LongProperty table_totalfee;

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
	
	public User(StringProperty ID,StringProperty name, StringProperty birthday, StringProperty phone, LongProperty totalfee)
	{
		this.tableID = ID;
		this.tablename = name;
		this.tablebirthday = birthday;
		this.tablephone = phone;
		this.table_totalfee = totalfee;
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

	public StringProperty getTableID() {
		return tableID;
	}

	public StringProperty getTablePW() {
		return tablePW;
	}

	public StringProperty getTablename() {
		return tablename;
	}

	public StringProperty getTablebirthday() {
		return tablebirthday;
	}

	public StringProperty getTablephone() {
		return tablephone;
	}
	
	public IntegerProperty getTablerentlist(int index) {
		return table_rent_booklist[index];
	}

	public LongProperty getTablerenttime(int index) {
		return table_rent_time[index];
	}

	public LongProperty getTablefee(int index) {
		return table_fee[index];
	}

	public LongProperty getTabletotalfee() {
		return table_totalfee;
	}
}
