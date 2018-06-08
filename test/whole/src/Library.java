import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
	private Scanner sc;
	private String today_date; // Ex: 2018/05/19
	private boolean Admin = true;
	private boolean User = true;
	private ArrayList<User> userlist = new ArrayList<>();
	private ArrayList<Book> booklist = new ArrayList<>();

	public Library() throws IOException {
		BufferedReader bufferUser = new BufferedReader(new FileReader("user.txt"));
		BufferedReader bufferBook = new BufferedReader(new FileReader("book.txt"));
		String s;
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
	}

	public static void main(String[] args) throws IOException {
		Library lib = new Library();
		Scanner scan = new Scanner(System.in);
		String select;
		
		for(int i = 0; i < lib.userlist.size(); i++)
		{
			System.out.print(lib.userlist.get(i).getID() + " ");
			System.out.print(lib.userlist.get(i).getPW() + " ");
			System.out.print(lib.userlist.get(i).getname() + " ");
			System.out.print(lib.userlist.get(i).getbirthday() + " ");
			System.out.print(lib.userlist.get(i).getphone() + " ");
			System.out.print(lib.userlist.get(i).get_rentlist(0) + " ");
			System.out.print(lib.userlist.get(i).get_rentlist(1) + " ");
			System.out.print(lib.userlist.get(i).get_rentlist(2) + " ");
			System.out.print(lib.userlist.get(i).get_renttime(0) + " ");
			System.out.print(lib.userlist.get(i).get_renttime(1) + " ");
			System.out.print(lib.userlist.get(i).get_renttime(2) + " ");
			System.out.print(lib.userlist.get(i).get_fee(0) + " ");
			System.out.print(lib.userlist.get(i).get_fee(1) + " ");
			System.out.print(lib.userlist.get(i).get_fee(2) + "\n");
		}
		
		for(int i = 0; i < lib.booklist.size(); i++)
		{
			System.out.print(lib.booklist.get(i).getcode() + " ");
			System.out.print(lib.booklist.get(i).getname() + " ");
			System.out.print(lib.booklist.get(i).getwriter() + " ");
			System.out.print(lib.booklist.get(i).getpublisher() + " ");
			System.out.print(lib.booklist.get(i).getstate() + "\n");
		}
		
		while (true) {
			select = scan.nextLine();
			
			switch (Integer.valueOf(select)) {
			case 1:
				lib.inputlogin();
				break;
			case 2:
				lib.signup();
				break;
			case 0:
				
				BufferedWriter bufUser = new BufferedWriter(new FileWriter("user.txt"));
				BufferedWriter bufBook = new BufferedWriter(new FileWriter("book.txt"));
				for(int i = 0; i < lib.userlist.size(); i++)
				{
					bufUser.write(lib.userlist.get(i).getID() + " ");
					bufUser.write(lib.userlist.get(i).getPW() + " ");
					bufUser.write(lib.userlist.get(i).getname() + " ");
					bufUser.write(lib.userlist.get(i).getbirthday() + " ");
					bufUser.write(lib.userlist.get(i).getphone() + " ");
					bufUser.write(lib.userlist.get(i).get_rentlist(0) + " ");
					bufUser.write(lib.userlist.get(i).get_rentlist(1) + " ");
					bufUser.write(lib.userlist.get(i).get_rentlist(2) + " ");
					bufUser.write(lib.userlist.get(i).get_renttime(0) + " ");
					bufUser.write(lib.userlist.get(i).get_renttime(1) + " ");
					bufUser.write(lib.userlist.get(i).get_renttime(2) + " ");
					bufUser.write(lib.userlist.get(i).get_fee(0) + " ");
					bufUser.write(lib.userlist.get(i).get_fee(1) + " ");
					bufUser.write(lib.userlist.get(i).get_fee(2) + "");
					bufUser.newLine();
				}
				
				for(int i = 0; i < lib.booklist.size(); i++)
				{
					bufBook.write(lib.booklist.get(i).getcode() + " ");
					bufBook.write(lib.booklist.get(i).getname() + " ");
					bufBook.write(lib.booklist.get(i).getwriter() + " ");
					bufBook.write(lib.booklist.get(i).getpublisher() + " ");
					bufBook.write(lib.booklist.get(i).getstate() + "");
					bufBook.newLine();
				}
				
				bufUser.close();
				bufBook.close();
				return;
			default:
				System.out.println("��ȣ�� �߸� �Է��Ͽ����ϴ�");
				break;
			}
		}
	}

	public void inputlogin() throws IOException {
		Login login = new Login(userlist);
		String id;
		String pw;

		Scanner scan = new Scanner(System.in);

		id = scan.nextLine();
		pw = scan.nextLine();

		System.out.println(id);
		System.out.println(pw);

		if (login.admin_id_Check(id) == true) {
			System.out.println("�����ھ��̵� �½��ϴ�");
			if (login.admin_pw_Check(pw) == true) {
				System.out.println("�����ڸ�� ����!");
				Admin_mode mode = new Admin_mode(userlist, booklist);
			} else {
				System.out.println("�н����尡 Ʋ�Ƚ��ϴ�");
			}
		} else if (login.id_Check(id) == true) {
			System.out.println("���̵� �½��ϴ�");
			if (login.pw_Check(pw, login.id_index) == true) {

				System.out.println("�α��� �Ϸ�!");
				User_Mode mode = new User_Mode(login.id_index, userlist, booklist);
			} else {
				System.out.println("�н����尡 Ʋ�Ƚ��ϴ�");
			}
		} else {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�");
		}

	}

	public void signup() throws IOException {
		Scanner scan = new Scanner(System.in);
		String ID;
		String PW;
		String name;
		String birthday;
		String phone;
		System.out.println("ID�� �Է��ϼ���");
		ID = scan.nextLine();
		System.out.println("PW�� �Է��ϼ���");
		PW = scan.nextLine();
		System.out.println("�̸��� �Է��ϼ���");
		name = scan.nextLine();
		System.out.println("������ �Է��ϼ���");
		birthday = scan.nextLine();
		System.out.println("�ڵ�����ȣ�� �Է��ϼ���");
		phone = scan.nextLine();

		// �ߺ� �ڵ� �� å ���� ����ó��
		for (int i = 0; i < userlist.size(); i++) {
			if (ID.equals(userlist.get(i).getID())) {
				System.out.println("�ߺ��� ID�Դϴ�");
				return;
			}
		}
		userlist.add(new User(ID, PW, name, birthday, phone, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		System.out.println("ȸ������ �Ϸ�!");
	}

}
