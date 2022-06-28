package com.restservice.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservice.RestServiceDemoApplication;
import com.restservice.DTO.MovieAndDirectorDTO;

import com.restservice.Entity.*;
import com.restservice.Repository.DirectorRepository;
import com.restservice.Repository.MovieRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.restservice.Entity.*;
import com.restservice.Exceptions.*;

@Transactional
@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepo;

	@Autowired
	DirectorRepository directorRepo;

	@Autowired
	MovieAndDirectorDTO obj;

	public List<Director> get() {
		try {
			return directorRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new CustomGenericException("404", "no details found in the database");

		}
	}

	public Movie getByMovieTitle(MovieAndDirectorDTO title) {
		try {
			return movieRepo.findByMovieTitle(title.getMovie_Title());
		} catch (

		Exception e) {
			// TODO: handle exception
			throw new CustomGenericException("404", "details not found");

		}

	}

	public void addMovie(MovieAndDirectorDTO d) {
		try {
			Director director = directorRepo.findMovieByDirector(d.getFirst_Name(), d.getLast_Name());
			if (director != null) {
				List<Movie> list = director.getMovieList();
				Movie mov = new Movie();
				mov.setMovie_Title(d.getMovie_Title());
				mov.setMovie_Running_Time(Time.valueOf(d.getMovie_Running_Time()));
				mov.setRelease_date(LocalDate.parse(d.getRelease_date()));
				list.add(mov);
				director.setMovieList(list);
				directorRepo.save(director);
			} else {
				Movie mov = new Movie();
				mov.setMovie_Title(d.getMovie_Title());
				mov.setMovie_Running_Time(Time.valueOf(d.getMovie_Running_Time()));
				mov.setRelease_date(LocalDate.parse(d.getRelease_date()));
				Director dir = new Director();
				List<Movie> m = new ArrayList<>();
				m.add(mov);
				dir.setAddress(d.getAddress());
				dir.setContact_Number(d.getContact_Number());
				dir.setEmail(d.getEmail());
				dir.setFirst_Name(d.getFirst_Name());
				dir.setLast_Name(d.getLast_Name());
				dir.setMovieList(m);
				directorRepo.save(dir);
			}
		} catch (

		Exception e) {
			// TODO: handle exception
			throw new CustomGenericException("404", "details not found");

		}

	}

	public List<Movie> searchMovieByDirectorName(MovieAndDirectorDTO d) {
		try {
			Director director = directorRepo.findMovieByDirector(d.getFirst_Name(), d.getLast_Name());
			return director.getMovieList();
		} catch (

		Exception e) {
			// TODO: handle exception
			throw new CustomGenericException("404", "details not found");

		}
	}

	public List<Director> searchDirectorDetailsByTitle(MovieAndDirectorDTO d) throws CustomGenericException {
		try {
			Movie movie = movieRepo.findByMovieTitle(d.getMovie_Title());
			List<Director> list = movie.getDirectorSet();
			List<Director> list1 = new ArrayList<>();
			for (Director di : list) {
				Director dic = new Director();
				dic.setAddress(di.getAddress());
				dic.setContact_Number(di.getContact_Number());
				dic.setEmail(di.getEmail());
				dic.setFirst_Name(di.getFirst_Name());
				dic.setLast_Name(di.getFirst_Name());
				dic.setDirector_Id(di.getDirector_Id());
				list1.add(dic);
			}
			return list1;

		} catch (

		Exception e) {
			// TODO: handle exception
			throw new CustomGenericException("404", "details not found");

		}
	}

	public Integer updateMovieReleaseDate(MovieAndDirectorDTO dtoObj) {
		try {
			Integer ret = movieRepo.updateMovieReleaseDate(LocalDate.parse(dtoObj.getRelease_date()),
					dtoObj.getMovie_Title());
			return ret;
		} catch (

		Exception e) {
			// TODO: handle exception
			throw new CustomGenericException("404", "details not found");

		}
	}

	public Integer updateDirectorDetails(MovieAndDirectorDTO dtoObj) {
		try {
			Integer ret = directorRepo.updateDirectorDetails(dtoObj.getFirst_Name(), dtoObj.getLast_Name(),
					dtoObj.getAddress(), dtoObj.getContact_Number());
			return ret;
		} catch (

		Exception e) {
			// TODO: handle exception
			throw new CustomGenericException("404", "details not found");

		}
	}

	public Integer removeMovie(MovieAndDirectorDTO dtoObj) {
		try {
			Integer ret = movieRepo.removeMovie(dtoObj.getMovie_Title());
			return ret;
		} catch (

		Exception e) {
			// TODO: handle exception
			throw new CustomGenericException("404", "details not found");

		}
	}
}
