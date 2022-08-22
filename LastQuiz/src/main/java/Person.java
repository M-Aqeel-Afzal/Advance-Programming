import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="personTable")
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int personID;
private String name;
private String surname;
@OneToMany(cascade=CascadeType.ALL)
List<Car> list ;




public List<Car> getList() {
	return list;
}
public void setList(List<Car> list) {
	this.list = list;
}
public int getPersonID() {
	return personID;
}
public void setPersonID(int personID) {
	this.personID = personID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}

}
