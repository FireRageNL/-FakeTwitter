package Entities;

import Logic.Utilities.Hashing;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Named
public class Trend implements Serializable {

	@Id
	@GeneratedValue
	public int id;

	@Column(unique = true)
	private String name;

	@ManyToMany
	private List<Kweet> kweets;

	public Trend(){
		//Empty  constructor for JPA
	}

	public Trend(int id, String name, List<Kweet> kweets) {
		this.id = id;
		this.name = name;
		this.kweets = kweets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Kweet> getKweets() {
		return kweets;
	}

	public void setKweets(List<Kweet> kweets) {
		this.kweets = kweets;
	}
}
