package com.restservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restservice.DTO.MovieAndDirectorDTO;
import com.restservice.DTO.ProductDTO;
import com.restservice.Entity.Director;
import com.restservice.Entity.Movie;
import com.restservice.Exceptions.CustomGenericException;
import com.restservice.Service.MovieService;

@RestController
@RequestMapping("/product")
public class WelcomeController {
	@Autowired
	MovieService serv;

	@GetMapping("/getAllDetails")
	public List<Director> getAllDetails() {
		try {
			return serv.get();
		} catch (CustomGenericException e) {
			// TODO: handle exception
			throw new CustomGenericException("404", "no data");
		}

	}

	@PostMapping("/addMovie")
	public ResponseEntity<String> addMovie(@RequestBody MovieAndDirectorDTO p) {
		serv.addMovie(p);
		return new ResponseEntity<>("data inserted successfully", HttpStatus.ACCEPTED);
	}

	@PostMapping("/getMoviedetailsByTitle")
	public Movie getMovie(@RequestBody MovieAndDirectorDTO p) {
		return serv.getByMovieTitle(p);
	}

	@PostMapping("/getMoviesByDirector")
	public List<Movie> getMovies(@RequestBody MovieAndDirectorDTO p) {
		return serv.searchMovieByDirectorName(p);
	}

	@PostMapping("/directorDetailsByTitle")
	public List<Director> getDirector(@RequestBody MovieAndDirectorDTO p) throws CustomGenericException{

			return serv.searchDirectorDetailsByTitle(p);
	}

	@PutMapping("/updateReleasedate")
	public ResponseEntity<String> updateReleaseDate(@RequestBody MovieAndDirectorDTO p) {
		Integer ret = serv.updateMovieReleaseDate(p);
		if (ret == 1)
			return new ResponseEntity<>("data updated successfully", HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>("updation failed", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateDirectorDetails")
	public ResponseEntity<String> updateDirectorDetails(@RequestBody MovieAndDirectorDTO p) {
		Integer res = serv.updateDirectorDetails(p);
		if (res == 1)
			return new ResponseEntity<>("data updated successfully", HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>("updation failed", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteMovie")
	public ResponseEntity<String> delete(@RequestBody MovieAndDirectorDTO p) {
		Integer res = serv.removeMovie(p);
		if (res == 1)
			return new ResponseEntity<>("Movie deleted successfully", HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>("movie deletion failed", HttpStatus.BAD_REQUEST);
	}

}
