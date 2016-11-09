package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "MeasureDefinition" database table.
 * 
 */
@Entity
@Table(name="\"MeasureDefinition\"")
@NamedQuery(name="MeasureDefinition.findAll", query="SELECT m FROM MeasureDefinition m")
public class MeasureDefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idMeasureDef\"")
	private int idMeasureDef;

	@Column(name="\"measureName\"")
	private String measureName;

	@Column(name="\"measureType\"")
	private String measureType;

	//bi-directional many-to-one association to LifeStatus
	@OneToMany(mappedBy="measureDefinition")
	private List<LifeStatus> lifeStatuses;

	//bi-directional many-to-one association to MeasureDefaultRange
	@OneToMany(mappedBy="measureDefinition")
	private List<MeasureDefaultRange> measureDefaultRanges;

	//bi-directional many-to-one association to HealthMeasureHistory
	@OneToMany(mappedBy="measureDefinition")
	private List<HealthMeasureHistory> healthMeasureHistories;

	public MeasureDefinition() {
	}

	public int getIdMeasureDef() {
		return this.idMeasureDef;
	}

	public void setIdMeasureDef(int idMeasureDef) {
		this.idMeasureDef = idMeasureDef;
	}

	public String getMeasureName() {
		return this.measureName;
	}

	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}

	public String getMeasureType() {
		return this.measureType;
	}

	public void setMeasureType(String measureType) {
		this.measureType = measureType;
	}

	public List<LifeStatus> getLifeStatuses() {
		return this.lifeStatuses;
	}

	public void setLifeStatuses(List<LifeStatus> lifeStatuses) {
		this.lifeStatuses = lifeStatuses;
	}

	public LifeStatus addLifeStatus(LifeStatus lifeStatus) {
		getLifeStatuses().add(lifeStatus);
		lifeStatus.setMeasureDefinition(this);

		return lifeStatus;
	}

	public LifeStatus removeLifeStatus(LifeStatus lifeStatus) {
		getLifeStatuses().remove(lifeStatus);
		lifeStatus.setMeasureDefinition(null);

		return lifeStatus;
	}

	public List<MeasureDefaultRange> getMeasureDefaultRanges() {
		return this.measureDefaultRanges;
	}

	public void setMeasureDefaultRanges(List<MeasureDefaultRange> measureDefaultRanges) {
		this.measureDefaultRanges = measureDefaultRanges;
	}

	public MeasureDefaultRange addMeasureDefaultRange(MeasureDefaultRange measureDefaultRange) {
		getMeasureDefaultRanges().add(measureDefaultRange);
		measureDefaultRange.setMeasureDefinition(this);

		return measureDefaultRange;
	}

	public MeasureDefaultRange removeMeasureDefaultRange(MeasureDefaultRange measureDefaultRange) {
		getMeasureDefaultRanges().remove(measureDefaultRange);
		measureDefaultRange.setMeasureDefinition(null);

		return measureDefaultRange;
	}

	public List<HealthMeasureHistory> getHealthMeasureHistories() {
		return this.healthMeasureHistories;
	}

	public void setHealthMeasureHistories(List<HealthMeasureHistory> healthMeasureHistories) {
		this.healthMeasureHistories = healthMeasureHistories;
	}

	public HealthMeasureHistory addHealthMeasureHistory(HealthMeasureHistory healthMeasureHistory) {
		getHealthMeasureHistories().add(healthMeasureHistory);
		healthMeasureHistory.setMeasureDefinition(this);

		return healthMeasureHistory;
	}

	public HealthMeasureHistory removeHealthMeasureHistory(HealthMeasureHistory healthMeasureHistory) {
		getHealthMeasureHistories().remove(healthMeasureHistory);
		healthMeasureHistory.setMeasureDefinition(null);

		return healthMeasureHistory;
	}

}