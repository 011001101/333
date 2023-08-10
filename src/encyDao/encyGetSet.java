package encyDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class encyGetSet {
    private String plantNO;
    private String plantName;
    private String plantOrigin;
    private String plantFamily;
    private String plantGroup;
    private String plantLuminous;
    private String plantWatering;
    private String plantPoint;
    private String param;
    
    private static int current;
	
    public encyGetSet(String plantNO, String plantName, String plantOrigin, String plantFamily, String plantGroup,
			String plantLuminous, String plantWatering, String plantPoint) {
		
		this.plantNO = plantNO;
		this.plantName = plantName;
		this.plantOrigin = plantOrigin;
		this.plantFamily = plantFamily;
		this.plantGroup = plantGroup;
		this.plantLuminous = plantLuminous;
		this.plantWatering = plantWatering;
		this.plantPoint = plantPoint;
	}
    public String getParam() {
		return param;
	}
    public void setParam(String param) {
		this.param = param;
	}
	public encyGetSet() {
		
	}
	public static int getCurrent() {
		
		return current;
	}
	public static void setCurrent(int a) {
		current = a;
	}
	public List<String> getAll(){
		
		return Arrays.asList(plantNO,
	            plantName,
	            plantOrigin,
	            plantFamily,
	            plantGroup,
	            plantLuminous,
	            plantWatering,
	            plantPoint);
	}
	public String getPlantNO() {
		return plantNO;
	}
	public void setPlantNO(String plantNO) {
		this.plantNO = plantNO;
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
		return "encyGetSet [plantNO=" + plantNO + ", plantName=" + plantName + ", plantOrigin=" + plantOrigin
				+ ", plantFamily=" + plantFamily + ", plantGroup=" + plantGroup + ", plantLuminous=" + plantLuminous
				+ ", plantWatering=" + plantWatering + ", plantPoint=" + plantPoint + "]";
	}
    
    

}
