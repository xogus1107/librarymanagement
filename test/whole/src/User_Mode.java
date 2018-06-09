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
		
		System.out.println("유저모드 시작");
		Scanner scan = new Scanner(System.in);
		String select;
		
		while(true){
		System.out.println("번호를 입력하시오(1:책검색 2.책목록 3.내책 4.내정보)");
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
			System.out.println("번호를 잘못 입력하였습니다");
			break;
		}
		}
		// TODO Auto-generated constructor stub
		
	}

	// 책의 목록을 출력하는 기능! javaFX로 알아서 구현해줘 ㅎㅎ

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

		System.out.println(userlist.get(id_index).getID()+" ");
		System.out.println(userlist.get(id_index).getname()+" ");
		System.out.println(userlist.get(id_index).getbirthday()+" ");
		System.out.println(userlist.get(id_index).getphone()+" ");
		System.out.println(userlist.get(id_index).get_totalfee()+" ");

		user_namemodify();
		user_birthmodify();
		user_phonemodify();

	}

	public void user_namemodify() {
		Scanner scan = new Scanner(System.in);
		String name;
		System.out.println("이름을 수정하시오");
		name = scan.nextLine();
		userlist.get(id_index).setname(name);
	}

	public void user_birthmodify() {
		Scanner scan = new Scanner(System.in);
		String birth;
		System.out.println("생일을 수정하시오");
		birth = scan.nextLine();
		userlist.get(id_index).setbirthday(birth);
	}

	public void user_phonemodify() {
		Scanner scan = new Scanner(System.in);
		String phone;
		System.out.println("핸드폰번호를 수정하시오");
		phone = scan.nextLine();
		userlist.get(id_index).setphone(phone);
	}

	public void booklist() {
		for (int i = 0; i < booklist.size(); i++) {
			System.out.print(booklist.get(i).getcode()+" ");
			System.out.print(booklist.get(i).getname()+" ");
			System.out.print(booklist.get(i).getwriter()+" ");
			System.out.print(booklist.get(i).getpublisher()+" ");
			System.out.println(booklist.get(i).getstate()+" ");
		}
	}

	// Switch 구문을 이용하여 1번 이름 2번 저자 3번 출판사 4번 코드로 책을 검색하는 기능~!
	public void book_Search() {
		Scanner scan = new Scanner(System.in);
		String search;
		System.out.println("책 검색 시작!");
		System.out.println("번호를 입력하시오(1.제목 2.저자 3.출판사 4.코드");
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
			System.out.println("잘못입력했습니다");
			break;
		}
	}

	public void name_Search() {
		Scanner scan = new Scanner(System.in);
		String name;
		System.out.println("제목을 입력하시오");
		name = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (name.equals(booklist.get(i).getname())) {
				System.out.print(booklist.get(i).getcode()+" ");
				System.out.print(booklist.get(i).getname()+" ");
				System.out.print(booklist.get(i).getwriter()+" ");
				System.out.print(booklist.get(i).getpublisher()+" ");
				System.out.println(booklist.get(i).getstate()+" ");
			}
		}
		System.out.println("일치하는 제목이 없습니다");
	}

	public void writer_Search() {
		Scanner scan = new Scanner(System.in);
		String writer;
		System.out.println("저자를 입력하시오");
		writer = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (writer.equals(booklist.get(i).getwriter())) {
				System.out.print(booklist.get(i).getcode()+" ");
				System.out.print(booklist.get(i).getname()+" ");
				System.out.print(booklist.get(i).getwriter()+" ");
				System.out.print(booklist.get(i).getpublisher()+" ");
				System.out.println(booklist.get(i).getstate()+" ");
			}
		}
		System.out.println("일치하는 저자가 없습니다");
	}

	public void publisher_Search() {
		Scanner scan = new Scanner(System.in);
		String publisher;
		System.out.println("출판사를 입력하시오");
		publisher = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (publisher.equals(booklist.get(i).getpublisher())) {
				System.out.print(booklist.get(i).getcode()+" ");
				System.out.print(booklist.get(i).getname()+" ");
				System.out.print(booklist.get(i).getwriter()+" ");
				System.out.print(booklist.get(i).getpublisher()+" ");
				System.out.println(booklist.get(i).getstate()+" ");
			}
		}
		System.out.println("일치하는 출판사가 없습니다");
	}

	public void code_Search() {
		Scanner scan = new Scanner(System.in);
		String code;
		System.out.println("코드를 입력하시오");
		code = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (Integer.valueOf(code) == booklist.get(i).getcode()) {
				System.out.print(booklist.get(i).getcode()+" ");
				System.out.print(booklist.get(i).getname()+" ");
				System.out.print(booklist.get(i).getwriter()+" ");
				System.out.print(booklist.get(i).getpublisher()+" ");
				System.out.println(booklist.get(i).getstate()+" ");
			}
		}
		System.out.println("일치하는 코드가 없습니다");
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
						System.out.print(booklist.get(j).getcode()+" ");
						System.out.print(booklist.get(j).getname()+" ");
						System.out.print(booklist.get(j).getwriter()+" ");
						System.out.print(booklist.get(j).getpublisher()+" ");
						latefee(id_index, j);
						System.out.println(userlist.get(id_index).get_fee(i)+" ");
					}
				}
			}
		}
	}
}
