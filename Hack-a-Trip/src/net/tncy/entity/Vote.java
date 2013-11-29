package net.tncy.entity;

import java.util.Date;

import com.google.appengine.api.datastore.Key;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = { @NamedQuery(name = "findVoteByIdTravel", query = "select v from Vote v where v.idTravel = :idTravel"), @NamedQuery(name = "findVoteByIdTravelAndByMember", query = "select v from Vote v where v.idTravel = :idTravel and v.member =  :member"), @NamedQuery(name = "findVoteByIdTravelAndByIdLocationAndByMember", query = "select v from Vote v where v.idTravel = :idTravel and v.idLocation = :idLocation and v.member =  :member")})
public class Vote
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	private String idTravel;
	private String idLocation;
	private String member;

	public final String getIdTravel()
	{
		return idTravel;
	}

	public final void setIdTravel(String idTravel)
	{
		this.idTravel = idTravel;
	}

	public final String getIdLocation()
	{
		return idLocation;
	}

	public final void setIdLocation(String idLocation)
	{
		this.idLocation = idLocation;
	}

	public final String getMember()
	{
		return member;
	}

	public final void setMember(String member)
	{
		this.member = member;
	}

}