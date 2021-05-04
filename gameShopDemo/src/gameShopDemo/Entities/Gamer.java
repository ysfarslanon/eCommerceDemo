package gameShopDemo.Entities;

import java.time.LocalDate;
import java.util.Date;

public class Gamer implements Entity{
	private int id;
	private String nationalityId;
	private String firstName;
	private String lastName;
	private LocalDate birthofDate;
	public Gamer() {
		
	}
	public Gamer(int id, String nationalityId, String firstName, String lastName, LocalDate birthofDate) {
		
		this.id = id;
		this.nationalityId = nationalityId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthofDate = birthofDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthofDate() {
		return birthofDate;
	}
	public void setBirthofDate(LocalDate birthofDate) {
		this.birthofDate = birthofDate;
	}
	
	
}
