package plant;

public class Herb {
	
	private int plantNo;
	private String plantName;
	private String plantScientific;
	private String plantOrigin;
	private String plantFamily;
	private boolean plantLuminous;
	private String plantWatering;
	private int plantPoint;
	
	
	
	public int getPlantNo() {
		return plantNo;
	}
	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getPlantScientific() {
		return plantScientific;
	}
	public void setPlantScientific(String plantScientific) {
		this.plantScientific = plantScientific;
	}
	public String getPlantOrigin() {
		return plantOrigin;
	}
	public void setPlantOrigin(String plantOrigin) {
		this.plantOrigin = plantOrigin;
	}
	public String getPlantFamily() {
		return plantFamily;
	}
	public void setPlantFamily(String plantFamily) {
		this.plantFamily = plantFamily;
	}
	public boolean isPlantLuminous() {
		return plantLuminous;
	}
	public void setPlantLuminous(boolean plantLuminous) {
		this.plantLuminous = plantLuminous;
	}
	public String getPlantWatering() {
		return plantWatering;
	}
	public void setPlantWatering(String plantWatering) {
		this.plantWatering = plantWatering;
	}
	public int getPlantPoint() {
		return plantPoint;
	}
	public void setPlantPoint(int plantPoint) {
		this.plantPoint = plantPoint;
	}
	
	
	public Herb(int plantNo, String plantName, String plantScientific, String plantOrigin, String plantFamily,
			boolean plantLuminous, String plantWatering, int plantPoint) {
		super();
		this.plantNo = plantNo;
		this.plantName = plantName;
		this.plantScientific = plantScientific;
		this.plantOrigin = plantOrigin;
		this.plantFamily = plantFamily;
		this.plantLuminous = plantLuminous;
		this.plantWatering = plantWatering;
		this.plantPoint = plantPoint;
	}
	
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
