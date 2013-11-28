package net.tncy.entity;

import java.util.Date;

import com.google.appengine.api.datastore.Key;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Travel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	private String name;
	private String city;
	private String country;
	private Date beginDate;
	private Date endDate;
	private Integer maxBudget;

	public String getCity()
	{
		return city;
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
