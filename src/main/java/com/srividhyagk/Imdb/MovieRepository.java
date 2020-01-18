package com.srividhyagk.Imdb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer>{
	Movie findByTitle(String title);
	List<Movie> findByCategory(String category);
}