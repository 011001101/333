package eventloop;

public class NowFlower {
	private String set;
	private long time;
	private long num;

	public NowFlower(String set, long time) {
		this.set = set;
		this.time = time;
	}

	public String getSet() {
		return set;
	}

	public long getTime() {
		return time;
	}

	public void increase() {
		num++;
	}

	public boolean isDone() {
		return num == time;
	}
}
