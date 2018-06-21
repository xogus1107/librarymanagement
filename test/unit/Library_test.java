package Library;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;


public class Library_test {

	@Test
	 public void test_input_adminloginid() {
		 	String id;
		 	id="admin";
		 	assertTrue(admin_id_Check(id));
	 }
	
	@Test
	 public void test_input_adminloginpw() {
		 	String pw;
		 	pw="12345";
		 	assertTrue(admin_pw_Check(pw));
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

			public String getPW(String string) {
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
		
	@Test
	 public void test_load_userlist() throws IOException{
		 
			ArrayList<User> userlist = new ArrayList<>();
			BufferedReader bufferUser = new BufferedReader(new FileReader("user.txt"));
			String s;
			while ((s = bufferUser.readLine()) != null) {
				String[] split = s.split(" ");
				userlist.add(new User(split[0], split[1], split[2], split[3], split[4], Integer.valueOf(split[5]),
						Integer.valueOf(split[6]), Integer.valueOf(split[7]), Long.valueOf(split[8]),
						Long.valueOf(split[9]), Long.valueOf(split[10]), Long.valueOf(split[11]), Long.valueOf(split[12]),
						Long.valueOf(split[13])));

			}
			bufferUser.close();
			for(int i = 0; i < userlist.size(); i++)
			{
				System.out.print(userlist.get(i).getID() + " ");
				System.out.print(userlist.get(i).getPW("2222") + " ");//!!!error
				System.out.print(userlist.get(i).getname() + " ");
				System.out.print(userlist.get(i).getbirthday() + " ");
				System.out.print(userlist.get(i).getphone() + " ");
				System.out.print(userlist.get(i).get_rentlist(0) + " ");
				System.out.print(userlist.get(i).get_rentlist(1) + " ");
				System.out.print(userlist.get(i).get_rentlist(2) + " ");
				System.out.print(userlist.get(i).get_renttime(0) + " ");
				System.out.print(userlist.get(i).get_renttime(1) + " ");
				System.out.print(userlist.get(i).get_renttime(2) + " ");
				System.out.print(userlist.get(i).get_fee(0) + " ");
				System.out.print(userlist.get(i).get_fee(1) + " ");
				System.out.print(userlist.get(i).get_fee(2) + "\n");
			}
			assertNotNull(userlist);
			assertNotNull(userlist.get(0).getID());
			assertEquals(userlist.get(0).getPW("2222"),"ji951045");
			assertEquals(userlist.get(0).getname(),"Á¶À¯¼º");
			assertEquals(userlist.get(0).getbirthday(),"19951206");
			assertEquals(userlist.get(0).getphone(),"01033597208");
	}

	@Test
	 public void test_save_userlist() throws IOException{
		ArrayList<User> userlist = new ArrayList<>();
		BufferedWriter bufUser = new BufferedWriter(new FileWriter("user.txt"));
		for(int i = 0; i < userlist.size(); i++)
		{
			bufUser.write(userlist.get(i).getID() + " ");
			bufUser.write(userlist.get(i).getPW("2222") + " "); //!!!error
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
			bufUser.close();
		}
			assertNotNull(userlist);
			assertNotNull(userlist.get(0).getID());
			assertNotNull(userlist.get(0).getPW());
			assertNotNull(userlist.get(0).getname());
			assertNotNull(userlist.get(0).getbirthday());
			assertNotNull(userlist.get(0).getphone());
	}
	
	@Test
	 public void test_load_booklist() throws IOException{
		 
			ArrayList<Book> booklist = new ArrayList<>();
			BufferedReader bufferBook = new BufferedReader(new FileReader("book.txt"));
			String s;
			while ((s = bufferBook.readLine()) != null) {
				String[] split = s.split(" ");
				booklist.add(new Book(Integer.valueOf(split[0]), split[1], split[2], split[3], Integer.valueOf(split[4])));

			}
			bufferBook.close();
			for(int i = 0; i < booklist.size(); i++)
			{
				System.out.print(booklist.get(i).getcode() + " ");
				System.out.print(booklist.get(i).getname() + " ");
				System.out.print(booklist.get(i).getwriter() + " ");
				System.out.print(booklist.get(i).getpublisher() + " ");
				System.out.print(booklist.get(i).getstate() + "\n");
			}
			BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
			for(int i = 0; i <booklist.size(); i++)
			{
				bufBook.write(booklist.get(i).getcode() + " ");
				bufBook.write(booklist.get(i).getname() + " ");
				bufBook.write(booklist.get(i).getwriter() + " ");
				bufBook.write(booklist.get(i).getpublisher() + " ");
				bufBook.write(booklist.get(i).getstate() + "");
				bufBook.newLine();
			}
			assertNotNull(booklist);
			assertEquals(booklist.get(0).getcode(),"testcode");
			assertEquals(booklist.get(0).getname(),"testname");
			assertEquals(booklist.get(0).getwriter(),"testwriter");
			assertEquals(booklist.get(0).getpublisher(),"00000000");
			assertEquals(booklist.get(0).getstate(),"01000000000");
	}
	
	@Test
	 public void test_save_booklist() throws IOException{
		ArrayList<Book> booklist = new ArrayList<>();
		BufferedReader bufferBook = new BufferedReader(new FileReader("book.txt"));
		String s;
		while ((s = bufferBook.readLine()) != null) {
			String[] split = s.split(" ");
			booklist.add(new Book(Integer.valueOf(split[0]), split[1], split[2], split[3], Integer.valueOf(split[4])));

		}
		bufferBook.close();
		BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
		for(int i = 0; i < booklist.size(); i++)
		{
			bufBook.write(booklist.get(i).getcode() + " ");
			bufBook.write(booklist.get(i).getname() + " ");
			bufBook.write(booklist.get(i).getwriter() + " ");
			bufBook.write(booklist.get(i).getpublisher() + " ");
			bufBook.write(booklist.get(i).getstate() + "");
			bufBook.newLine();
		}
		bufBook.close();
		
	
			assertNotNull(booklist);
			assertNotNull(booklist.get(0).getcode());
			assertNotNull(booklist.get(0).getname());
			assertNotNull(booklist.get(0).getwriter());
			assertNotNull(booklist.get(0).getpublisher());
			assertNotNull(booklist.get(0).getstate());
	}

	@Test
	 public void test_get_fee(int user_index,int book_index) {
		ArrayList<User> userlist = new ArrayList<>();
		ArrayList<Book> booklist = new ArrayList<>();
		long[] fee = new long[3];
		long totalfee = 0;		
		long latefee = 0;
		long time = System.currentTimeMillis();
		long temp = 0;
	for (int i = 0; i < 3; i++) {
		totalfee += fee[i];
	}

	for (int i = 0; i < 3; i++) {
		if (userlist.get(user_index).get_rentlist(i) == booklist.get(book_index).getcode()) {
			temp = (time - userlist.get(user_index).get_renttime(i)) / 1000;
			if (temp > 10) {
				latefee = (temp - 10) * 100;
				userlist.get(user_index).set_fee(i, latefee);
			}
		}
		 	assertNotNull(latefee);
	}
	}
	
	