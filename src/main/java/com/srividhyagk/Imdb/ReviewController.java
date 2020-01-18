package com.srividhyagk.Imdb;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/review")

public class ReviewController {

	@Autowired
	private ReviewRepository reviewrepo;
	@Autowired
	private MovieRepository movierepo;
	@Autowired
	private UserRepository userrepo;

	@PostMapping(path = "/comment")
	public @ResponseBody String addNewReview(@RequestParam(name = "movieid") int movie_id,
			@RequestParam(name = "userid") int user_id, @RequestParam(name = "comment") String comment,
			@RequestParam(name = "rating") int rating) {
		Reviews r = new Reviews();
		r.setMovie_id(movie_id);
		r.setUser_id(user_id);
		r.setComment(comment);
		r.setRating(rating);
		reviewrepo.save(r);
		return "Saved Review";

	}

	@GetMapping(path = "/comment")
	public @ResponseBody Iterable<Reviews> getAllReviews() {
		return reviewrepo.findAll();
	}

	@GetMapping(path = "/getReview")
	public @ResponseBody List<Reviews> getReviewByUsername(String username) {
		User u = userrepo.findByUsername(username);
		return reviewrepo.findByUser_id(u.getId());
	}

	@GetMapping(path = "/getReviewByMovieTitle")
	public @ResponseBody List<Reviews> getReviewByTitle(String title) {
		Movie m = movierepo.findByTitle(title);
		return reviewrepo.findByMovie_id(m.getId());

	}

	@GetMapping(path = "/getReviewByRating")
	public @ResponseBody List<Reviews> getReviewByRating(int rating) {
		return reviewrepo.findByRating(rating);

	}

	@GetMapping(path = "/getReviewByCategory")
	public @ResponseBody List<Movie> getReviewByCategory(String category) {
		List<Movie> ml = movierepo.findByCategory(category);
		return ml;

	}
	@DeleteMapping(path="/deleteReview")
	public @ResponseBody String removeReview(int id)
	{		
		reviewrepo.deleteById(id);
		return "Review removed";
		
	}
	@PutMapping(path="/updateReview")
	public ResponseEntity<Object> updateReview(@RequestParam(name="id")int id,@RequestParam(name = "movieid") int movie_id,
			@RequestParam(name = "userid") int user_id, @RequestParam(name = "comment") String comment,
			@RequestParam(name = "rating") int rating)
	{
		Optional<Reviews> updatedReview=reviewrepo.findById(id);
		if(!updatedReview.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		Reviews r = new Reviews();
		r.setMovie_id(movie_id);
		r.setUser_id(user_id);
		r.setComment(comment);
		r.setRating(rating);
		r.setId(id);
		reviewrepo.save(r);
		return ResponseEntity.noContent().build();
		
	}

}




