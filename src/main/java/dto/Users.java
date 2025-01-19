package dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Users 

{
	private String name;
    private String movies;
	private Integer id;
	private String createdAt;
	
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getMovies() {
		return movies;
	}
	public void setMovies(String string) {
		this.movies = string;
	}
	public Integer getId() {
		return id;
	}
	public int setId(Integer id) {
		return this.id = id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
