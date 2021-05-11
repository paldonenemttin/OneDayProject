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
public class EatDTO {
	
	private String my_date; // as 날짜
	 private String fd_code;
	 private String fd_name; //as 식품명
	 private Integer my_eats; // as 섭취량
	 private Integer fd_all; // as 총제공량
	 private Integer fd_kral; // as 칼로리
	 private Integer fd_prot; // as 단백질,
	 private Integer fd_fat; // as 지방
	 private Integer fd_carb; // as 탄수화물
	 private Integer fd_suga; // as 당류
}


