package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Person" database table.
 * 
 */
@Entity
@Table(name="\"Person\"")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="\"birthdate\"")
	private Date birthdate;

	@Column(name="\"email\"")
	private String email;

	@Id
	@Column(name="\"idPerson\"")
	private int idPerson;

	@Column(name="\"lastname\"")
	private String lastname;

	@Column(name="\"name\"")
	private String name;

	@Column(name="\"username\"")
	private String username;

	//bi-directional many-to-one association to LifeStatus
	@OneToMany(mappedBy="person")
	private List<LifeStatus> lifeStatuses;

	//bi-directional many-to-one association to HealthMeasureHistory
	@OneToMany(mappedBy="person")
	private List<HealthMeasureHistory> healthMeasureHistories;

	public Person() {
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<LifeStatus> getLifeStatuses() {
		return this.lifeStatuses;
	}

	public void setLifeStatuses(List<LifeStatus> lifeStatuses) {
		this.lifeStatuses = lifeStatuses;
	}

	public LifeStatus addLifeStatus(LifeStatus lifeStatus) {
		getLifeStatuses().add(lifeStatus);
		lifeStatus.setPerson(this);

		return lifeStatus;
	}

	public LifeStatus removeLifeStatus(LifeStatus lifeStatus) {
		getLifeStatuses().remove(lifeStatus);
		lifeStatus.setPerson(null);

		return lifeStatus;
	}

	public List<HealthMeasureHistory> getHealthMeasureHistories() {
		return this.healthMeasureHistories;
	}

	public void setHealthMeasureHistories(List<HealthMeasureHistory> healthMeasureHistories) {
		this.healthMeasureHistories = healthMeasureHistories;
	}

	public HealthMeasureHistory addHealthMeasureHistory(HealthMeasureHistory healthMeasureHistory) {
		getHealthMeasureHistories().add(healthMeasureHistory);
		healthMeasureHistory.setPerson(this);

		return healthMeasureHistory;
	}

	public HealthMeasureHistory removeHealthMeasureHistory(HealthMeasureHistory healthMeasureHistory) {
		getHealthMeasureHistories().remove(healthMeasureHistory);
		healthMeasureHistory.setPerson(null);

		return healthMeasureHistory;
	}

}