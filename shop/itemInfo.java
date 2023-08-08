package shop;

public class itemInfo {
	private int itemNum;
	private String itemName;
	private int itemPoint;
	private String itemEffect;
	
	public itemInfo(int itemNum, String itemName, int itemPoint, String itemEffect) {
		super();
		this.itemNum = itemNum;
		this.itemName = itemName;
		this.itemPoint = itemPoint;
		this.itemEffect = itemEffect;
	}
	

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPoint() {
		return itemPoint;
	}

	public void setItemPoint(int itemPoint) {
		this.itemPoint = itemPoint;
	}

	public String getItemEffect() {
		return itemEffect;
	}

	public void setItemEffect(String itemEffect) {
		this.itemEffect = itemEffect;
	}

	@Override
	public String toString() {
		return "\n아이템 번호 : " + itemNum + "\n" + itemName + "\n 가격 : " + itemPoint + "\n 효과 : "
				+ itemEffect + "\n";
	}
	
	

}
