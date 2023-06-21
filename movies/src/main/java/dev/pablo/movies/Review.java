package dev.pablo.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data // This is for Getters and Setters instead of declaring every single one of them
@AllArgsConstructor // All constructors
@NoArgsConstructor
public class Review {
	@Id
	private ObjectId id;
	private String body;

	// Constructor
	public Review(String body) {
		this.body = body;
	}
}
