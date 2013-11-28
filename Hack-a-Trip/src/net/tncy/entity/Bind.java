package net.tncy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.google.appengine.api.datastore.Key;

@Entity
@NamedQueries(value={
		@NamedQuery(name="findTrip", query="select b.travel from Bind b where b.member = :userEmail")
})
public class Bind {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	private Key travel;
	private String member;
	
	public Key getTravel() {
		return travel;
	}
	public void setTravel(Key travel) {
		this.travel = travel;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	
}
