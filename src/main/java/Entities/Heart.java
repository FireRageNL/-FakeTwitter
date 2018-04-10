package Entities;


import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Named
public class Heart implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Kweet likedKweet;

	@ManyToOne(cascade = CascadeType.ALL)
	private Account accountThatLikedKweet;

	public Heart(){
		//Empty constructor for JPA
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kweet getLikedKweet() {
		return likedKweet;
	}

	public void setLikedKweet(Kweet likedKweet) {
		this.likedKweet = likedKweet;
	}

	public Account getAccountThatLikedKweet() {
		return accountThatLikedKweet;
	}

	public void setAccountThatLikedKweet(Account accountThatLikedKweet) {
		this.accountThatLikedKweet = accountThatLikedKweet;
	}
}
