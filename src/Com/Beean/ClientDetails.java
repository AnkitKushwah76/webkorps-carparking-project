package Com.Beean;

public class ClientDetails {
	
	private String clientName;
	private String carNumber;
	private String carColor;
	private String inTime;
	private String outTime;
	public ClientDetails(String clientName, String carNumber, String carColor, String inTime, String outTime) {
		super();
		this.clientName = clientName;
		this.carNumber = carNumber;
		this.carColor = carColor;
		this.inTime = inTime;
		this.outTime = outTime;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	@Override
	public String toString() {
		return "clientName=" + clientName + ", carNumber=" + carNumber + ", carColor=" + carColor
				+ ", inTime=" + inTime + ", outTime=" + outTime +"";
	}
	
	
	
	

}
