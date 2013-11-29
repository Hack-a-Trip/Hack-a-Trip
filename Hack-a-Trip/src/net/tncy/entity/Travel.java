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
@NamedQueries(value={
		@NamedQuery(name="findTravel", query="select t from Travel t where t.id = :travelId"),
		@NamedQuery(name="findTravelIdByEmail", query="select b.travel from Bind b where b.member = :userEmail"),
		@NamedQuery(name="findMembers", query="select b.member from Bind b where b.travel= :travelId"),
		@NamedQuery(name="findBind", query="select b from Bind b where b.travel= :travelId"),
		@NamedQuery(name="findOwner", query="select b.member from Bind b where b.travel= :travelId and b.isOwner = true")
})
public class Travel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	private static long ID = 0 ;
	private long id = ID++;
	private String  name;
	private String city;
	private String country;
	private Date beginDate;
	private Date endDate;
	private Integer maxBudget;

	public String getCity()
	{
		return city;
	}

	public long getId()
	{
		return id ;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public Date getBeginDate()
	{
		return beginDate;
	}

	public void setBeginDate(Date beginDate)
	{
		this.beginDate = beginDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public Integer getMaxBudget()
	{
		return maxBudget;
	}

	public void setMaxBudget(Integer maxBudget)
	{
		this.maxBudget = maxBudget;
	}

	public final Key getKey()
	{
		return key;
	}

	public final void setKey(Key key)
	{
		this.key = key;
	}

	public final String getName()
	{
		return name;
	}

	public final void setName(String name)
	{
		this.name = name;
	}
}
