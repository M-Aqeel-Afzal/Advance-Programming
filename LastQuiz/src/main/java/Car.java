import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="carTable")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int CarID;
	private int OwnerID;
	private String LicenePlate;
	private String Make;
	private String Model;
	public int getCarID() {
		return CarID;
	}
	public void setCarID(int carID) {
		CarID = carID;
	}
	public int getOwnerID() {
		return OwnerID;
	}
	public void setOwnerID(int ownerID) {
		OwnerID = ownerID;
	}
	public String getLicenePlate() {
		return LicenePlate;
	}
	public void setLicenePlate(String licenePlate) {
		LicenePlate = licenePlate;
	}
	public String getMake() {
		return Make;
	}
	public void setMake(String make) {
		Make = make;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
}
