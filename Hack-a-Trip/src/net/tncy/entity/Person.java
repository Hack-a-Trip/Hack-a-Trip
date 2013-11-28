package net.tncy.entity;

import com.google.appengine.api.datastore.Key;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class Person
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String firstName;

	private String lastName;

	private String mailAdress;

	private String password;

	// Accessors for the fields. JPA doesn't use these, but your application does.

	public Key getKey()
	{
		return key;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getMailAdress()
	{
		return mailAdress;
	}

	public void setMailAdress(String mailAdress)
	{
		this.mailAdress = mailAdress;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
