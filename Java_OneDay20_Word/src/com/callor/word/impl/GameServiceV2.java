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
		this.loadWord();
	}

	@Override
	public void loadWord() {
		// TODO txt 파일에서 단어 불러오는 메소드
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
			// TODO fileReader catch
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
		// TODO 사용자가 게임을 수행하게 하는 메소드

		System.out.println("괴도 뤼팡이 황금이 숨겨진 금고의 열쇠를 주려 합니다");
		System.out.println("금을 얻고 싶다면 5개의 영단어를 맞춰주세요, 관심없음:End");
		System.out.println("(정답을 맞출때마다 포인트가 2점씩 증가)");
		System.out.println("=".repeat(50));
		Integer wPoint = 0;
		for (int i = 0; i < 1600; i++) {
			while (wPoint < 10) {
				Random rnd = new Random();

				WordVO word = this.wordSet();
				String strEng = word.getEnglish();
				String strKor = word.getKorea();

				String[] strWords = strEng.split("");

				// 단어 배열을 섞는 소스

				for (int j = 0; j < 100; j++) {
					int index = rnd.nextInt(strWords.length);
					int index1 = rnd.nextInt(strWords.length);
					String temp = strWords[index];
					strWords[index] = strWords[index1];
					strWords[index] = temp;
				}
				System.out.println(Arrays.toString(strWords));
				System.out.println("-".repeat(50));
				System.out.print(">> ");
				String strKey = scan.nextLine();
				if (strKey.equals("End")) {
					System.out.println("황금을 가질 기회를 날렸군요");
					return;
				} else if (strKey.equals(word.getEnglish())) {
					System.out.println("와 정답!");
					wPoint += 2;
				} else {
					System.out.println("재도전은 re, 힌트는 hint(포인트 1점씩 차감) 끝내기는 End");
					System.out.print(">> ");
					String strKey2 = scan.nextLine();
					if (strKey2.equals("re")) {
						continue;
					} else if (strKey2.equals("hint") && wPoint > 0) {
						System.out.println(word.getKorea());
						wPoint--;
						continue;
					} else if (strKey2.equals("hint") && wPoint <= 0) {
						System.out.println("포인트가 없어 힌트는 없습니다");
						continue;
					} else {
						System.out.println("황금을 가질 기회를 날렸군요");
						return;
					}
				}
				WordVO wordVO = new WordVO();
				wordVO.setCount(wPoint);
				wordVO.setEnglish(strEng);
				wordVO.setKorea(word.getKorea());
				wordList.add(wordVO);
			}
			
		}
		System.out.println("축하합니다 열쇠를 얻었습니다!");
		

	}

	protected WordVO wordSet() {
		// TODO 단어를 랜덤으로 불러오게 하는 메소드

		Random rnd = new Random();

		rnd.nextInt(100);

		Integer nSize = wordList.size();
		Integer num = rnd.nextInt(nSize);

		WordVO wordVO = wordList.get(num);
		return wordVO;
	}

}
