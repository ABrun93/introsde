package restful.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="healthprofile")
@XmlType(propOrder = { "weight", "height", "history", "BMI" })
@XmlAccessorType(XmlAccessType.FIELD)
public class HealthProfile {
	private double weight; // in kg
	private double height; // in m
	private List<Date> history = new ArrayList<Date>(); 

	public HealthProfile(double weight, double height) {
		this.weight = weight;
		this.height = height;
		this.history.add(new Date());
	}

	public HealthProfile() {
		this.weight = 85.5;
		this.height = 1.72;
		this.history.add(new Date());
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		setHistory();
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		setHistory();
	}
	
	public void setSizes(double weight, double height) {
		this.weight = weight;
		this.height = height;
		setHistory();
	}
	
	public void setHistory() {
		this.history.add(new Date());
	}	
	
	public List<Date> getHistory() {
		return history;
	}

	@XmlElement(name="bmi")
	public double getBMI() {
		return this.weight/(Math.pow(this.height, 2));
	}
		
	public String toString() {
		return "{"+this.height+","+this.weight+","+getHistory().toString()+","+this.getBMI()+","+"}";
	}
	
}