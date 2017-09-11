import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Badminton {

	private String  userId;
	private String  date;
	private String  time;
	private String  place;
	private boolean cancle;
	private int     charge;
	private final int[][] weekend = 
		{{9, 12, 40}, 
		{12, 18, 50}, 
		{18, 22, 60}};
	private final int[][] weekday = 
		{{9, 12, 40}, 
		{12, 18, 50}, 
		{18, 20, 80}, 
		{20, 22, 60}};
	
	public Badminton(String userId, String date, String time, String place) {
		this.userId = userId;
		this.date = date;
		this.time = time;
		this.place = place;
		cancle = false;
		setCharge();
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	
	public void setEndTime(String time) {
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPlace() {
		return place;
	}
	
	public void setCancle() {
		this.cancle = true;
		changeCharge();
	}
	public boolean getCancle() {
		return cancle;
	}
	
	public int getCharge() {
		return charge;
	}	
	private void setCharge() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			Date dataTime = dateFormat.parse(date);
			calendar.setTime(dataTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		String begTime = time.split("~")[0].split(":")[0];
		String endTime = time.split("~")[1].split(":")[0];
		charge = getMoney(week, Integer.parseInt(begTime), Integer.parseInt(endTime));
	}
	
	private int getMoney(int week, int begTime, int endTime) {
		//周末
		if (week == 0 || week == 6) {
			return getMoneyByTime(begTime, endTime, weekend);
		} else {//周一到周五
			return getMoneyByTime(begTime, endTime, weekday);
		}
	}
	
	private int getMoneyByTime(int begTime, int endTime, int[][] day) {
		int money = 0;
		for (int i = 0; i < day.length; i++) {
			int beg = begTime > day[i][0] ? begTime : day[i][0];
			int end = endTime > day[i][1] ? day[i][1] : endTime;
			if (end > beg) {
				money += (end - beg) * day[i][2];
			}
		}
		return money;
	}
	
	private void changeCharge() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		try {
			Date dataTime = dateFormat.parse(date);
			calendar.setTime(dataTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		//周末
		if (week == 0 || week == 6) {
			charge /= 4;
		} else {//周一到周五
			charge /= 2;
		}
	}
}
