package encyData;

public class ency {
	private String plantNo;
    private String plantName;
    private String plantOrigin;
    private String plantFamily;
    private String plantGroup;
    private String plantLuminous;
    private String plantWatering;
    private String plantPoint;
    
	public ency(String plantNo, String plantName, String plantOrigin, String plantFamily, String plantGroup,
			String plantLuminous, String plantWatering, String plantPoint) {
		super();
		this.plantNo = plantNo;
		this.plantName = plantName;
		this.plantOrigin = plantOrigin;
		this.plantFamily = plantFamily;
		this.plantGroup = plantGroup;
		this.plantLuminous = plantLuminous;
		this.plantWatering = plantWatering;
		this.plantPoint = plantPoint;
	}
	public ency() {
		
	}

	public String getPlantNO() {
		return plantNo;
	}

	public void setPlantNo(String plantNO) {
		this.plantNo = plantNO;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
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

	public String getPlantGroup() {
		return plantGroup;
	}

	public void setPlantGroup(String plantGroup) {
		this.plantGroup = plantGroup;
	}

	public String getPlantLuminous() {
		return plantLuminous;
	}

	public void setPlantLuminous(String plantLuminous) {
		this.plantLuminous = plantLuminous;
	}

	public String getPlantWatering() {
		return plantWatering;
	}

	public void setPlantWatering(String plantWatering) {
		this.plantWatering = plantWatering;
	}

	public String getPlantPoint() {
		return plantPoint;
	}

	public void setPlantPoint(String plantPoint) {
		this.plantPoint = plantPoint;
	}

	@Override
	public String toString() {
		return "ency [plantNO=" + plantNo + ", plantName=" + plantName + ", plantOrigin=" + plantOrigin
				+ ", plantFamily=" + plantFamily + ", plantGroup=" + plantGroup + ", plantLuminous=" + plantLuminous
				+ ", plantWatering=" + plantWatering + ", plantPoint=" + plantPoint + "]";
	}
	

}
