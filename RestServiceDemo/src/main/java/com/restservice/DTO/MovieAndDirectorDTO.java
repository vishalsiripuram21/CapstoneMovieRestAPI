package com.restservice.DTO;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restservice.Entity.Director;
import com.restservice.Entity.Movie;
import com.restservice.Service.MovieService;

@Component
public class MovieAndDirectorDTO {


	private String Movie_Title;
	private String release_date;
	private String Movie_Running_Time;
	private List<Director> directorSet;
	private String First_Name;
	private String Last_Name;
	private String Address;
	private String Contact_Number;
	private String Email;
	private List<Movie> movieList;
	public String getMovie_Title() {
		return Movie_Title;
	}
	public void setMovie_Title(String movie_Title) {
		Movie_Title = movie_Title;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getMovie_Running_Time() {
		return Movie_Running_Time;
	}
	public void setMovie_Running_Time(String movie_Running_Time) {
		Movie_Running_Time = movie_Running_Time;
	}
	public List<Director> getDirectorSet() {
		return directorSet;
	}
	public void setDirectorSet(List<Director> directorSet) {
		this.directorSet = directorSet;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getContact_Number() {
		return Contact_Number;
	}
	public void setContact_Number(String contact_Number) {
		Contact_Number = contact_Number;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	public MovieAndDirectorDTO() {
		
	}
	public MovieAndDirectorDTO(String movie_Title, String release_date, String movie_Running_Time,
			List<Director> directorSet, String first_Name, String last_Name, String address, String contact_Number,
			String email, List<Movie> movieList) {
		super();
		Movie_Title = movie_Title;
		this.release_date = release_date;
		Movie_Running_Time = movie_Running_Time;
		this.directorSet = directorSet;
		First_Name = first_Name;
		Last_Name = last_Name;
		Address = address;
		Contact_Number = contact_Number;
		Email = email;
		this.movieList = movieList;
	}
	
}
