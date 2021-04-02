package com.callor.score.service;

public class ScoreServiceV2 extends ScoreServiceV1 {

	public void selectMenu() {

		while (true) {
			System.out.println("=".repeat(50));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(50));
			System.out.println("a. 학생별 성적 입력");
			System.out.println("b. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(50));
			System.out.println("업무선택 >>");
			String strMenu = scan.nextLine();
			
			try {
				if (!strMenu.equals("a") || !strMenu.equals("b")|| !strMenu.equals("QUIT")) {
				  }
			} catch (Exception e) {
				System.out.print("메뉴를 잘못 입력했습니다");
				System.out.println("메뉴 1 ,2 와 QUIT 중에 다시 바르게 입력해주세요");
				continue;
			}
				
				
			}
			
			if (strMenu.equals("a")) {
				this.makescore();
			}else if (strMenu.equals("QUIT")) {
				return;
			}
			if (strMenu.equals("b")) {
				this.printScore();
			} else if (strMenu.equals("QUIT")) {
				return;
			}
		}

	}

	
}
