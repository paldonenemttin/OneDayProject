package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.ScoreVO;

public class ScoreServiceV1 {

	Scanner scan;
	List<ScoreVO> scoreList;

	String strName;
	Integer intKor;
	Integer intEng;
	Integer intMath;
	Integer intSien;
	Integer intHist;

	Integer sumTotal;
	Float floatAvg;

	public ScoreServiceV1() {
		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();

	}

	public void makescore() {

		Integer intNum = 0;
		while (true) {
			System.out.println("=".repeat(50));
			System.out.println("학생 이름을 입력하시오");
			System.out.println("=".repeat(50));
			System.out.println("이름 >>");
			strName = scan.nextLine();

			System.out.println("=".repeat(50));
			System.out.println(strName + "의 성적을 입력하세요(성적범위 0 ~ 100 , 입력을 중단하려면 QUIT");
			System.out.println("=".repeat(50));
			System.out.println("국어 >>");
			String strNum = scan.nextLine();
			
			try {
				intKor = Integer.valueOf(strNum);
			} catch (Exception e) {
				System.out.println("숫자로 입력하세요");
				continue;
			}
			if (intKor < 0 && intKor > 100) {
				System.out.println("입력하는 성적의 범위는 0 ~ 100까지 입니다");
				continue;
			}

			System.out.println("영어 >>");
			String strNum1 = scan.nextLine();
			try {
				intEng = Integer.valueOf(strNum1);
			} catch (Exception e) {
				System.out.println("숫자로 입력하세요");
				continue;
			}
			if (intEng < 0 && intEng > 100) {
				System.out.println("입력하는 성적의 범위는 0 ~ 100까지 입니다");
				continue;
			}

			System.out.println("수학 >>");
			String strNum2 = scan.nextLine();
			try {
				intMath = Integer.valueOf(strNum2);
			} catch (Exception e) {
				System.out.println("숫자로 입력하세요");
				continue;
			}
			if (intMath < 0 && intMath > 100) {
				System.out.println("입력하는 성적의 범위는 0 ~ 100까지 입니다");
				continue;
			}

			System.out.println("과학 >>");
			String strNum3 = scan.nextLine();
			try {
				intSien = Integer.valueOf(strNum3);
			} catch (Exception e) {
				System.out.println("숫자로 입력하세요");
				continue;
			}
			if (intMath < 0 && intMath > 100) {
				System.out.println("입력하는 성적의 범위는 0 ~ 100까지 입니다");
				continue;
			}

			System.out.println("국사 >>");
			String strNum4 = scan.nextLine();
			try {
				intHist = Integer.valueOf(strNum4);
			} catch (Exception e) {
				System.out.println("숫자로 입력하세요");
				continue;
			}
			if (intHist < 0 && intHist > 100) {
				System.out.println("입력하는 성적의 범위는 0 ~ 100까지 입니다");
				continue;
			}
			
			
			System.out.println("=".repeat(50));
			System.out.println(strName + "학생의 성적이 추가되었습니다");
			System.out.println("=".repeat(50));
			System.out.printf("국어 : %d\n", intKor);
			System.out.printf("영어 : %d\n", intEng);
			System.out.printf("수학 : %d\n", intMath);
			System.out.printf("과학 : %d\n" , intSien);
			System.out.printf("국사 : %d\n" , intHist);
			
			sumTotal = intKor;
			sumTotal += intEng;
			sumTotal += intMath;
			sumTotal += intSien;
			sumTotal += intHist;
			floatAvg = (float) sumTotal / 5;

			ScoreVO scoreVO = new ScoreVO();
			scoreVO.setKor(intKor);
			scoreVO.setEng(intEng);
			scoreVO.setMath(intMath);
			scoreVO.setSien(intSien);
			scoreVO.setHist(intHist);
			scoreVO.setName(strName);
			scoreVO.setTotal(sumTotal);
			scoreVO.setAvg(floatAvg);
			scoreList.add(scoreVO);

		}
	}

	Integer sumKor = 0;
	Integer sumEng = 0;
	Integer sumMath= 0;;
	Integer sumSien = 0;
	Integer sumHist = 0;
	Integer totalSum = 0;
	Float totalAvg = 0.0f;

	public void totalAvg() {
		Integer nCount = 0;
		for (int i = 0; i < scoreList.size(); i++) {
			nCount++;
			sumKor += intKor;
		}
		for (int i = 0; i < scoreList.size(); i++) {
			sumEng += intEng;
		}
		for (int i = 0; i < scoreList.size(); i++) {
			sumMath += intMath;
		}
		for (int i = 0; i < scoreList.size(); i++) {
			sumSien += intSien;
		}
		for (int i = 0; i < scoreList.size(); i++) {
			sumHist += intHist;
		}
		for (int i = 0; i < scoreList.size(); i++) {
			totalAvg += floatAvg;
		}
		for (int i = 0; i < scoreList.size(); i++) {
			totalSum += sumTotal;
		}

		totalAvg = floatAvg / nCount;

	}

	public void printScore() {

		System.out.println("=".repeat(50));
		System.out.println("학생\t국어\t영어\t수학\t과학\t국사\t총점\t평균");
		System.out.println("=".repeat(50));

		for (int i = 0; i < scoreList.size(); i++) {
			ScoreVO vo = scoreList.get(i);
			System.out.printf("%d\t %d\t %d\t %d\t %d\t %d\t %d\t %d\n", strName, intKor, intEng, intMath, intSien,
					intHist, sumTotal, floatAvg);
		}

		System.out.println("=".repeat(50));
		System.out.printf("%d\t %d\t %d\t %d\t %d\t %d\t %d\t %d", "총점", sumKor, sumEng, sumMath, sumSien, sumHist,
				totalSum, totalAvg);
	}

}
