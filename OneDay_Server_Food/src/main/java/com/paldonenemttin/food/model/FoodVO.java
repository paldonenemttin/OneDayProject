package com.paldonenemttin.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class FoodVO {
	
	private String fd_code;
	private String fd_name;
	private Integer fd_year;
	private String cp_name;
	private String it_name;
	private Integer fd_ones;
	private Integer fd_all;
	private Integer fd_kral;
	private Integer fd_prot;
	private Integer fd_fat;
	private Integer fd_carb;
	private Integer fd_suga;

}
