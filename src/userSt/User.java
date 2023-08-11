package userSt;

public class User {
	private String id;
	private int point;
	private int exp;

	public User(String id, int point, int exp) {
		this.id = id;
		this.point = point;
		this.exp = exp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
}
