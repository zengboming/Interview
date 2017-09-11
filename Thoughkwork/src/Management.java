import java.util.ArrayList;

public class Management {

	private ArrayList<Badminton> listA;
	private ArrayList<Badminton> listB;
	private ArrayList<Badminton> listC;
	private ArrayList<Badminton> listD;
	
	public Management() {
		listA = new ArrayList<>();
		listB = new ArrayList<>();
		listC = new ArrayList<>();
		listD = new ArrayList<>();
	}
	
	public void input(String input) {
		//���Ϊ�գ���ӡ�������
		if (input.length() == 0) {
			getAllList();
			return;
		}
		
		String[] array = input.split(" ");
		//Ԥ��
		if (array.length == 4) {
			//���ʱ���Ƿ�Ϸ�
			if (!checkTime(array)) {
				return;
			}
			//���ʱ���Ƿ��ͻ
			if (isConflict(array[1], array[2], array[3])) {
				System.out.println("Error: the booking conflicts with existing bookings!");
				return;
			}
			//�ɹ�Ԥ��
			add(array[0], array[1], array[2], array[3]);
			System.out.println("Success: the booking is accepted!");
		} else if (array.length == 5) {//ȡ��Ԥ��
			if (!array[4].equals("C")) {
				System.out.println("Error: the booking is invalid!");
				return;
			}
			//���ʱ���Ƿ�Ϸ�
			if (!checkTime(array)) {
				return;
			}
			//���ʱ���Ƿ����
			Badminton badminton = isExist(array[1], array[2], array[3]);
			if (badminton == null) {
				System.out.println("Error: the booking being cancelled does not exist!");
				return;
			} 
			//ȡ��Ԥ��
			cancel(badminton);
			System.out.println("Success: the booking is accepted!");
		} else {
			System.out.println("Error: the booking is invalid!");
			return;
		}
	}
	
	private boolean checkTime(String[] array) {
		int beg = Integer.parseInt(array[2].split("~")[0].split(":")[0]);
		int end = Integer.parseInt(array[2].split("~")[1].split(":")[0]);
		//ʱ��Υ��
		if (beg >= end) {
			System.out.println("Error: the booking is invalid!");
			return false;
		}
		//ʱ�䲻������
		if (Integer.parseInt(array[2].split("~")[0].split(":")[1]) != 0 
			|| Integer.parseInt(array[2].split("~")[1].split(":")[1]) != 0) {
			System.out.println("Error: the booking is invalid!");
			return false;
		}
		
		return true;
	}
	
	private Badminton isExist(String date, String time, String place) {
		switch (place) {
		case "A":
			return exist(date, time, listA);
		case "B":
			return exist(date, time, listB);
		case "C":
			return exist(date, time, listC);
		case "D":
			return exist(date, time, listD);
		default:
			return null;
		}
	}
	
	private Badminton exist(String date, String time, ArrayList<Badminton> list) {
		for (Badminton badminton : list) {
			if (badminton.getDate().equals(date) 
			 && badminton.getTime().equals(time)
			 && !badminton.getCancle()) {
				return badminton;
			}
		}
		return null;
	}
	
	private boolean isConflict(String date, String time, String place) {
		switch (place) {
		case "A":
			return conflict(date, time, listA);
		case "B":
			return conflict(date, time, listB);
		case "C":
			return conflict(date, time, listC);
		case "D":
			return conflict(date, time, listD);
		default:
			return false;
		}
	}
	
	private boolean conflict(String date, String time, ArrayList<Badminton> list) {
		for (Badminton badminton : list) {
			if (badminton.getDate().equals(date)
			 && !badminton.getCancle()
			 && intersection(badminton.getTime(), time)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean intersection(String badTime, String time) {
		int badBeg = Integer.parseInt(badTime.split("~")[0].split(":")[0]);
		int badEnd = Integer.parseInt(badTime.split("~")[1].split(":")[0]);
		int beg = Integer.parseInt(time.split("~")[0].split(":")[0]);
		int end = Integer.parseInt(time.split("~")[1].split(":")[0]);
		int b = badBeg > beg ? badBeg : beg;
		int e = badEnd > end ? end : badEnd;
		if (e > b) {
			return true;
		}
		return false;
	}
	
	private void add(String userId, String date, String time, String place) {
		Badminton badminton = new Badminton(userId, date, time, place);
		switch (place) {
		case "A":
			listA.add(badminton);
			break;
		case "B":
			listB.add(badminton);
			break;
		case "C":
			listC.add(badminton);
			break;
		case "D":
			listD.add(badminton);
			break;
		default:
			break;
		}
	}
	
	private void cancel(Badminton badminton) {
		badminton.setCancle();
	}
	
	private void getAllList() {
		int sum = 0;
		System.out.println("�������");
		System.out.println("---");
		System.out.println("����:A");
		sum += getList(listA);
		System.out.println("\n����:B");
		sum += getList(listB);
		System.out.println("\n����:C");
		sum += getList(listC);
		System.out.println("\n����:D");
		sum += getList(listD);
		System.out.println("---");
		System.out.println("�ܼ�: " + sum + "Ԫ");
	}
	
	private int getList(ArrayList<Badminton> list) {
		if (list.isEmpty()) {
			System.out.println("С��: 0Ԫ");
			return 0;
		}
		
		int sum = 0;
		for (Badminton badminton : list) {
			if (badminton.getCancle()) {
				System.out.println(badminton.getDate() + " " + badminton.getTime() + " ΥԼ�� " + badminton.getCharge() + "Ԫ");
			} else {
				System.out.println(badminton.getDate() + " " + badminton.getTime() + " " + badminton.getCharge() + "Ԫ");
			}
			
			sum += badminton.getCharge();
		}
		System.out.println("С��: " + sum + "Ԫ");
		return sum;
	}
	
}
