import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class User_Mode{
	private int id_index;
	private ArrayList<User> userlist;
	private ArrayList<Book> booklist;
	
	public User_Mode(int index, ArrayList<User> userlist, ArrayList<Book> booklist) throws IOException {
		this.id_index = index;
		this.userlist = userlist;
		this.booklist = booklist;		
		
		System.out.println("������� ����");
		System.out.println("��ȣ�� �Է��Ͻÿ�(1:å�˻� 2.å��� 3.��å 4.������)");
		Scanner scan = new Scanner(System.in);
		String select;
		
		while(true){
		select = scan.nextLine();
		switch (Integer.valueOf(select)) {
		case 1:
			book_Search();
			break;
		case 2:
			booklist();
			break;
		case 3:
			mybook();
			break;
		case 4:
			user_info();
			break;
		case 0:
			return;
		default:
			System.out.println("��ȣ�� �߸� �Է��Ͽ����ϴ�");
			break;
		}
		}
		// TODO Auto-generated constructor stub
		
	}

	// å�� ����� ����ϴ� ���! javaFX�� �˾Ƽ� �������� ����

	public void user_info() {
		for (int i = 0; i < 3; i++) {
			if (userlist.get(id_index).get_rentlist(i) != 0) {
				for (int j = 0; j < booklist.size(); j++) {
					if (userlist.get(id_index).get_rentlist(i) == booklist.get(j).getcode()) {
						latefee(id_index, j);
					}
				}
			}
		}

		System.out.println(userlist.get(id_index).getID());
		System.out.println(userlist.get(id_index).getname());
		System.out.println(userlist.get(id_index).getbirthday());
		System.out.println(userlist.get(id_index).getphone());
		System.out.println(userlist.get(id_index).get_totalfee());

		user_namemodify();
		user_birthmodify();
		user_phonemodify();

	}

	public void user_namemodify() {
		Scanner scan = new Scanner(System.in);
		String name;
		System.out.println("�̸��� �����Ͻÿ�");
		name = scan.nextLine();
		userlist.get(id_index).setname(name);
	}

	public void user_birthmodify() {
		Scanner scan = new Scanner(System.in);
		String birth;
		System.out.println("������ �����Ͻÿ�");
		birth = scan.nextLine();
		userlist.get(id_index).setbirthday(birth);
	}

	public void user_phonemodify() {
		Scanner scan = new Scanner(System.in);
		String phone;
		System.out.println("�ڵ�����ȣ�� �����Ͻÿ�");
		phone = scan.nextLine();
		userlist.get(id_index).setphone(phone);
	}

	public void booklist() {
		for (int i = 0; i < booklist.size(); i++) {
			System.out.print(booklist.get(i).getcode());
			System.out.print(booklist.get(i).getname());
			System.out.print(booklist.get(i).getwriter());
			System.out.print(booklist.get(i).getpublisher());
			System.out.println(booklist.get(i).getstate());
		}
	}

	// Switch ������ �̿��Ͽ� 1�� �̸� 2�� ���� 3�� ���ǻ� 4�� �ڵ�� å�� �˻��ϴ� ���~!
	public void book_Search() {
		Scanner scan = new Scanner(System.in);
		String search;
		System.out.println("å �˻� ����!");
		System.out.println("��ȣ�� �Է��Ͻÿ�(1.���� 2.���� 3.���ǻ� 4.�ڵ�");
		search = scan.nextLine();

		switch (Integer.valueOf(search)) {
		case 1:
			name_Search();
			break;
		case 2:
			writer_Search();
			break;
		case 3:
			publisher_Search();
			break;
		case 4:
			code_Search();
			break;
		default:
			System.out.println("�߸��Է��߽��ϴ�");
			break;
		}
	}

	public void name_Search() {
		Scanner scan = new Scanner(System.in);
		String name;
		System.out.println("������ �Է��Ͻÿ�");
		name = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (name.equals(booklist.get(i).getname())) {
				System.out.print(booklist.get(i).getcode());
				System.out.print(booklist.get(i).getname());
				System.out.print(booklist.get(i).getwriter());
				System.out.print(booklist.get(i).getpublisher());
				System.out.println(booklist.get(i).getstate());
			}
		}
		System.out.println("��ġ�ϴ� ������ �����ϴ�");
	}

	public void writer_Search() {
		Scanner scan = new Scanner(System.in);
		String writer;
		System.out.println("���ڸ� �Է��Ͻÿ�");
		writer = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (writer.equals(booklist.get(i).getwriter())) {
				System.out.print(booklist.get(i).getcode());
				System.out.print(booklist.get(i).getname());
				System.out.print(booklist.get(i).getwriter());
				System.out.print(booklist.get(i).getpublisher());
				System.out.println(booklist.get(i).getstate());
			}
		}
		System.out.println("��ġ�ϴ� ���ڰ� �����ϴ�");
	}

	public void publisher_Search() {
		Scanner scan = new Scanner(System.in);
		String publisher;
		System.out.println("���ǻ縦 �Է��Ͻÿ�");
		publisher = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (publisher.equals(booklist.get(i).getpublisher())) {
				System.out.print(booklist.get(i).getcode());
				System.out.print(booklist.get(i).getname());
				System.out.print(booklist.get(i).getwriter());
				System.out.print(booklist.get(i).getpublisher());
				System.out.println(booklist.get(i).getstate());
			}
		}
		System.out.println("��ġ�ϴ� ���ǻ簡 �����ϴ�");
	}

	public void code_Search() {
		Scanner scan = new Scanner(System.in);
		String code;
		System.out.println("�ڵ带 �Է��Ͻÿ�");
		code = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (Integer.valueOf(code) == booklist.get(i).getcode()) {
				System.out.print(booklist.get(i).getcode());
				System.out.print(booklist.get(i).getname());
				System.out.print(booklist.get(i).getwriter());
				System.out.print(booklist.get(i).getpublisher());
				System.out.println(booklist.get(i).getstate());
			}
		}
		System.out.println("��ġ�ϴ� �ڵ尡 �����ϴ�");
	}

	public long latefee(int user_index, int book_index) {
		long latefee = 0;
		long time = System.currentTimeMillis();
		long temp = 0;

		for (int i = 0; i < 3; i++) {
			if (userlist.get(user_index).get_rentlist(i) == booklist.get(book_index).getcode()) {
				temp = (time - userlist.get(user_index).get_renttime(i)) / 1000;
				if (temp > 10) {
					latefee = (temp - 10) * 100;
					userlist.get(user_index).set_fee(i, latefee);
				}
			}
		}
		return latefee;
	}

	public void mybook() {
		for (int i = 0; i < 3; i++) {
			if (userlist.get(id_index).get_rentlist(i) != 0) {
				for (int j = 0; j < booklist.size(); j++) {
					if (userlist.get(id_index).get_rentlist(i) == booklist.get(j).getcode()) {
						System.out.print(booklist.get(j).getcode());
						System.out.print(booklist.get(j).getname());
						System.out.print(booklist.get(j).getwriter());
						System.out.print(booklist.get(j).getpublisher());
						latefee(id_index, j);
						System.out.println(userlist.get(id_index).get_fee(i));
					}
				}
			}
		}
	}
}
