import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin_mode {
	private ArrayList<User> userlist;
	private ArrayList<Book> booklist;

	public Admin_mode(ArrayList<User> userlist, ArrayList<Book> booklist) {
		this.userlist = userlist;
		this.booklist = booklist;

		Scanner scan = new Scanner(System.in);
		String select;

		while (true) {
			System.out.println("1.booklist 2.managebook 3. manageruser 4.userlist 5.issued user");
			select = scan.nextLine();
			switch (Integer.valueOf(select)) {
			case 1:
				booklist();
				break;
			case 2:
				managebook();
				break;
			case 3:
				manageuser();
				break;
			case 4:
				user_list();
				break;
			case 5:
				issued_user();
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}

	public void manageuser() {
		int user_index = userSearch();

		System.out.println("1.rentbook 2.returnbook");
		Scanner scan = new Scanner(System.in);
		String select;
		select = scan.nextLine();

		switch (Integer.valueOf(select)) {
		case 1:
			rentbook(user_index);
			break;
		case 2:
			return_book(user_index);
			break;
		default:
			break;
		}
	}

	public void rentbook(int user_index) {

		int book_index = bookSearch();
		int rent_count = 0;
		long time = System.currentTimeMillis();

		if (booklist.get(book_index).getstate() == 1) {
			System.out.println("이미 대여중인 책 입니다");
			return;
		}

		// 책 빌린 갯수 체크, 3개이상이면 못빌림
		for (int i = 0; i < 3; i++) {
			if (userlist.get(user_index).get_rentlist(i) != 0) {
				rent_count++;
			}
		}

		if (rent_count == 3) {
			System.out.println("책을 더 이상 빌릴 수 없습니다.");
			return;
		}

		// 값이 0인 인덱스를 찾아서 책의 코드값을 저장
		for (int i = 0; i < 3; i++) {
			if (userlist.get(user_index).get_rentlist(i) == 0) {
				userlist.get(user_index).set_rentlist(i, booklist.get(book_index).getcode());
				userlist.get(user_index).set_renttime(i, time);
				booklist.get(book_index).setState(1);
				break;
			}
		}
	}

	public void return_book(int user_index) {
		int return_bookindex = 0;
		int rent_listindex = 0;
		long fee = 0;
		for (int i = 0; i < 3; i++) {
			if (userlist.get(user_index).get_rentlist(i) != 0) {
				for (int j = 0; j < booklist.size(); j++) {
					if (userlist.get(user_index).get_rentlist(i) == booklist.get(j).getcode()) {
						System.out.print(booklist.get(j).getcode());
						System.out.print(booklist.get(j).getname());
						System.out.print(booklist.get(j).getwriter());
						System.out.print(booklist.get(j).getpublisher());
						System.out.println(booklist.get(j).getstate());
					}
				}
			}
		}
		return_bookindex = name_Search();

		for (int i = 0; i < 3; i++) {
			if (userlist.get(user_index).get_rentlist(i) == booklist.get(return_bookindex).getcode()) {
				fee = latefee(user_index, return_bookindex);
				userlist.get(user_index).set_rentlist(i, 0);
				userlist.get(user_index).set_renttime(i, 0);
				if (fee > 0) {
					System.out.printf("연체료 %d원 지불하였습니다", fee);
					userlist.get(user_index).set_fee(i, 0);
				}
			}
		}
		booklist.get(return_bookindex).setState(0);
	}

	// 6월 7일 책 반납 까지 완료 근데 위에 있는 책 반납 함수에서 연체료 저장 하는 부분을 구현해야함 latefee 함수를 이용하여
	// 연체료를 참조하는 함수들(userinfo, returnbooks)에 최신화된 연체료를 저장 할 수 있게 해야함
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

	public int userSearch() {
		Scanner scan = new Scanner(System.in);
		int index;
		String id;
		System.out.println("ID를 입력하시오");
		id = scan.nextLine();

		for (int i = 0; i < userlist.size(); i++) {
			if (id.equals(userlist.get(i).getID())) {
				index = i;
				total_latefee(index);
				System.out.print(userlist.get(index).getID());
				System.out.print(userlist.get(index).getname());
				System.out.print(userlist.get(index).getbirthday());
				System.out.print(userlist.get(index).getphone());
				System.out.println(userlist.get(index).get_totalfee());
				return index;
			}
		}
		System.out.println("일치하는 ID가 없습니다");
		return -1;
	}

	public void managebook() {
		System.out.println("1.bookadd 2.booksetting 3.bookdelete");
		Scanner scan = new Scanner(System.in);
		String select;
		select = scan.nextLine();

		switch (Integer.valueOf(select)) {
		case 1:
			bookAdd();
			break;
		case 2:
			bookSetting();
			break;
		case 3:
			bookDelete();
			break;
		default:
			break;
		}
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

	public void bookAdd() {
		Scanner scan = new Scanner(System.in);
		String code;
		String name;
		String writer;
		String publisher;
		int state = 0;
		System.out.println("코드를 입력하세요");
		code = scan.nextLine();
		System.out.println("이름을 입력하세요");
		name = scan.nextLine();
		System.out.println("저자를 입력하세요");
		writer = scan.nextLine();
		System.out.println("출판사를 입력하세요");
		publisher = scan.nextLine();

		// 중복 코드 및 책 제목 예외처리
		for (int i = 0; i < booklist.size(); i++) {
			if (Integer.valueOf(code) == booklist.get(i).getcode()) {
				return;
			}
			if (name.equals(booklist.get(i).getname())) {
				return;
			}
		}
		booklist.add(new Book(Integer.valueOf(code), name, writer, publisher, 0));
		// 책 추가 확인 테스트
		booklist();
	}

	public void bookSetting() {
		int index = bookSearch();
		if (index == -1) {
			return;
		}
		data_codemodify(index);
		data_namemodify(index);
		data_writermodify(index);
		data_publishermodify(index);
		// 책 수정 확인 테스트
		booklist();
	}

	public void data_codemodify(int index) {
		Scanner scan = new Scanner(System.in);
		String code;
		System.out.println("코드를 수정하시오");
		code = scan.nextLine();
		for (int i = 0; i < booklist.size(); i++) {
			if (Integer.valueOf(code) == booklist.get(i).getcode()) {
				System.out.println("이미 존재하는 코드입니다");
				return;
			}
		}
		booklist.get(index).setCode(Integer.valueOf(code));
	}

	public void data_namemodify(int index) {
		Scanner scan = new Scanner(System.in);
		String name;
		System.out.println("제목을 수정하시오");
		name = scan.nextLine();
		for (int i = 0; i < booklist.size(); i++) {
			if (name.equals(booklist.get(i).getname())) {
				System.out.println("이미 존재하는 제목입니다");
				return;
			}
		}
		booklist.get(index).setName(name);
	}

	public void data_writermodify(int index) {
		Scanner scan = new Scanner(System.in);
		String writer;
		System.out.println("저자를 수정하시오");
		writer = scan.nextLine();
		booklist.get(index).setWriter(writer);
	}

	public void data_publishermodify(int index) {
		Scanner scan = new Scanner(System.in);
		String publisher;
		System.out.println("출판사를 수정하시오");
		publisher = scan.nextLine();
		booklist.get(index).setPublisher(publisher);
	}

	public void bookDelete() {
		int index = bookSearch();
		if (index == -1) {
			return;
		}
		booklist.remove(index);
		// 책 제거 확인 테스트
		booklist();
	}

	public int bookSearch() {
		Scanner scan = new Scanner(System.in);
		String search;
		System.out.println("1.이름으로찾기 2.코드로찾기");
		search = scan.nextLine();

		switch (Integer.valueOf(search)) {
		case 1:
			return name_Search();
		case 2:
			return code_Search();
		default:
			System.out.println("잘못입력했습니다");
			return -1;
		}
	}

	public int name_Search() {
		Scanner scan = new Scanner(System.in);
		int index;
		String name;
		System.out.println("제목을 입력하시오");
		name = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (name.equals(booklist.get(i).getname())) {
				index = i;
				System.out.print(booklist.get(index).getcode());
				System.out.print(booklist.get(index).getname());
				System.out.print(booklist.get(index).getwriter());
				System.out.print(booklist.get(index).getpublisher());
				System.out.println(booklist.get(index).getstate());
				return index;
			}
		}
		System.out.println("일치하는 제목이 없습니다");
		return -1;
	}

	public int code_Search() {
		Scanner scan = new Scanner(System.in);
		int index;
		String code;
		System.out.println("코드를 입력하시오");
		code = scan.nextLine();

		for (int i = 0; i < booklist.size(); i++) {
			if (Integer.valueOf(code) == booklist.get(i).getcode()) {
				index = i;
				System.out.print(booklist.get(index).getcode());
				System.out.print(booklist.get(index).getname());
				System.out.print(booklist.get(index).getwriter());
				System.out.print(booklist.get(index).getpublisher());
				System.out.println(booklist.get(index).getstate());
				return index;
			}
		}
		System.out.println("일치하는 코드가 없습니다");
		return -1;
	}

	public void issued_user() {
		for (int i = 0; i < userlist.size(); i++) {
			total_latefee(i);
			if (userlist.get(i).get_totalfee() > 0) {
				System.out.print(userlist.get(i).getID());
				System.out.print(userlist.get(i).getname());
				System.out.println(userlist.get(i).get_totalfee());
			}
		}
	}

	public void user_list() {
		for (int i = 0; i < userlist.size(); i++) {
			total_latefee(i);
			System.out.print(userlist.get(i).getID());
			System.out.print(userlist.get(i).getname());
			System.out.print(userlist.get(i).getbirthday());
			System.out.print(userlist.get(i).getphone());
			System.out.println(userlist.get(i).get_totalfee());
		}
	}

}
