package com.callor.word.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.domain.WordVO;
import com.callor.word.service.GameService;

public class GameServiceV2 implements GameService {
	
	List<WordVO> wordList;
	Scanner scan;
	Random rnd;
	
	public GameServiceV2() {
		// TODO Auto-generated constructor stub
		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);
		rnd = new Random();
	}

	@Override
	public void loadWord() {
		// TODO Auto-generated method stub
		String fileName = "src/com/callor/word/word.txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);

			String reader = new String();
			while ((reader = buffer.readLine()) != null) {
				String word[] = reader.split(":");
				WordVO wordVO = new WordVO();
				wordVO.setEnglish(word[0]);
				wordVO.setKorea(word[1]);
				wordList.add(wordVO);
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			// TODO filereader catch
			System.out.println("파일을 여는 중 문제가 발생했습니다");
		} catch (IOException e) {
			// TODO: buffer catch
			System.out.println("파일의 데이터를 읽는 중 문제가 발생했습니다");
		}
		
	}

	@Override
	public void saveEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prontWord() {
		// TODO Auto-generated method stub

		WordVO word = this.wordSet();
		String strEng = word.getEnglish();
		
		String[] strWords = strEng.split("");
		while(true) {
			Integer wPoint = 0;
			for (int j = 0; j < 100; j++) {
				int index = rnd.nextInt(strWords.length);
				int index1 = rnd.nextInt(strWords.length);
				String temp = strWords[index];
				strWords[index] = strWords[index1];
				strWords[index] = temp;
			}
			System.out.println("=".repeat(50));
			System.out.println("다음 5개의 단어를 " + "맞춰주세요(그만두기:End)");
			System.out.println(Arrays.toString(strWords));
			System.out.println("-".repeat(50));
			System.out.print(">> ");
			String strKey = scan.nextLine();
			
			if (strKey.equals("End")) {
				System.out.println("황금을 가질 기회를 날렸군요");
				return;
			} else if (strKey.equals(word.getEnglish())) {
				System.out.println("와 정답!");
				wPoint++;
			}else {
				System.out.println("땡");
				wPoint--;
				continue;
			}
			WordVO wordVO = new WordVO();
			wordVO.setCount(wPoint);
			wordVO.setEnglish(strEng);
			wordVO.setKorea(word.toString());
			wordList.add(wordVO);
		}
			
	}
	
	protected WordVO wordSet() {
		
		Random rnd = new Random();
		
		rnd.nextInt(100);

		Integer nSize = wordList.size();
		Integer num = rnd.nextInt(nSize);

		WordVO wordVO = wordList.get(num);
		return wordVO;
	}

}
