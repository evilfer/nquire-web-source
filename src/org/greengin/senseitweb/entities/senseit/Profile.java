package org.greengin.senseitweb.entities.senseit;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.datanucleus.jpa.annotations.Extension;

@Entity
public class Profile {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	String id;

	@Basic
	String title;
	

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	Collection<SensorInput> sensorInputs;

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Collection<SensorInput> getSensorInputs() {
		return sensorInputs;
	}

	public void setSensorInputs(Collection<SensorInput> sensorInputs) {
		this.sensorInputs = sensorInputs;
	}
	
}
