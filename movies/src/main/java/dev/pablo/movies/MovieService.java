package dev.pablo.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
	@Autowired // For a CONSTRUCTOR-instance the class for us
	private MovieRepository movieRepository;
	public List<Movie> allMovies() {
		return movieRepository.findAll();
	}

	// New method to get a single movie from database
	public Optional<Movie> singleMovie(String imdbId) {
		return movieRepository.findMovieByImdbId(imdbId);
	}
}
