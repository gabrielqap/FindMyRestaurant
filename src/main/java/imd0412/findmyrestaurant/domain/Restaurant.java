package imd0412.findmyrestaurant.domain;

import java.util.List;

public class Restaurant
{
	private String name;

	private String address;

	private String speciality;

	private List<Review> reviews;

	public Restaurant(String name, String address, String speciality)
	{
		this.name = name;
		this.address = address;
		this.speciality = speciality;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getSpeciality()
	{
		return speciality;
	}

	public void setSpeciality(String speciality)
	{
		this.speciality = speciality;
	}

	@Override
	public String toString()
	{
		return String.format("%s - %s - %s", this.name, this.speciality, this.address);
	}

	public List<Review> getReviews()
	{
		return reviews;
	}

	public void setReviews(List<Review> reviews)
	{
		this.reviews = reviews;
	}
}
