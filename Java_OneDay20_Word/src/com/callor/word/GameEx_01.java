package com.callor.word;

import com.callor.word.impl.GameServiceV2;
import com.callor.word.service.GameService;

public class GameEx_01 {
	
	public static void main(String[] args) {
		
		GameService gmService = new GameServiceV2();
		
		gmService.prontWord();
	
	}

}
