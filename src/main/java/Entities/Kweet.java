package Entities;


import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Named
public class Kweet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String messageContents;

	@ManyToOne
	private Account owner;

	@OneToMany
	private List<Account> mentions;

	@ManyToMany
	private List<Trend> trends;

	public Kweet(String messageContents, Account owner) {
		this.messageContents = messageContents;
		this.owner = owner;
	}

	public Kweet() {
	}

	public Kweet(String messageContents, Account owner, int id) {
		this.messageContents = messageContents;
		this.owner = owner;
		this.id = id;
	}

	public String getMessageContents() {
		return messageContents;
	}

	public void setMessageContents(String messageContents) {
		this.messageContents = messageContents;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	public List<Account> getMentions() {
		return mentions;
	}

	public void setMentions(List<Account> mentions) {
		this.mentions = mentions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public Account getOwner(){
		return owner;
	}

	public List<Trend> getTrends() {
		return trends;
	}

	public void setTrends(List<Trend> trends) {
		this.trends = trends;
	}
}
