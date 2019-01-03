package es.serban.airlines.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

public @Data class Airport {
	
	private String id;
	private String name;
	
	@JsonCreator
	public Airport(@JsonProperty("code") String id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

}
