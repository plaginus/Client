package com.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter  
@AllArgsConstructor  
@NoArgsConstructor 
public class Laptop extends ComputerEquipment {
	@JsonCreator
	public Laptop(@JsonProperty("cpu") String cpu, @JsonProperty("hddCapacity") int hddcapacity, @JsonProperty("type") String type) {
		super(cpu, hddcapacity);
		
		this.type = type;
	}
	@JsonProperty
	private String type;
	
	public void Show() {
		System.out.printf("Type - %s \n", type);
		super.Show();
	}
}
