package net.tncy.hackatrip;

import java.util.List;

public class Items
{
	int price;
	String origin;
	String description;
	Photos[] photos;
	String url;
	String nid;
	String link;
	boolean voted = false;
	int votes = 0;

	public Items()
	{

	}

	public Items(String origin, int price, String url, String nid, String link)
	{
		this.origin = origin;
		this.price = price;
		this.url = url;
		this.nid = nid;
		this.link = link;
	}

	public String toString(String s)
	{
		if (s.compareTo("place") == 0)
		{
			String p = Integer.toString(price);
			return "Ville : " + origin + "\n" + "Prix : " + p + "\n" + "Photos : " + photos[0].toString(s);
		}
		else
		{
			return "Ville : " + origin + "\n" + "Description : " + description + "\n" + "Photos : " + photos[0].toString(s);
		}
	}

	public void updateLocationsVoted(List<String> locationsVoted)
	{
		if (locationsVoted.contains(nid))
			voted = true;
	}
	
	public void updateTotalVoted(List<String> totalVoted)
	{
		int nb = 0;
		for(String s : totalVoted)
		{
			if(s.equals(nid))
				nb++;
		}
		votes = nb;
	}

	public final String getLink()
	{
		return link;
	}

	public final void setLink(String link)
	{
		this.link = link;
	}

	public final boolean isVoted()
	{
		return voted;
	}

	public final void setVoted(boolean voted)
	{
		this.voted = voted;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public String getOrigin()
	{
		return origin;
	}

	public void setOrigin(String origin)
	{
		this.origin = origin;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Photos[] getPhotos()
	{
		return photos;
	}

	public void setPhotos(Photos[] photos)
	{
		this.photos = photos;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public final String getNid()
	{
		return nid;
	}

	public final void setNid(String nid)
	{
		this.nid = nid;
	}

	public final int getVotes()
	{
		return votes;
	}

	public final void setVotes(int votes)
	{
		this.votes = votes;
	}
}
