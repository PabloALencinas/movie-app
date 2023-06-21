package dev.pablo.movies;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data // This is for Getters and Setters instead of declaring every single one of them
@AllArgsConstructor // All constructors
@NoArgsConstructor

public class Movie {
	// Let's declare every data that we will put into the Database for each Movie that will be uploaded
	@Id // This is for letting know to the framework that this data needs to be treated as a UNIQUE IDENTIFIERS for each movie inside the DB
	private ObjectId id;
	private String imdbId;
	private String title;
	private String releaseData;
	private String trailerLink;
	private String poster;
	private List<String> genres;
	private List<String> backdrops;
	@DocumentReference // This will cause, the database, to store only the ID's of the review and the reviews will be in a separate collection
	private List<Review> reviewIds;



}
