package day4;

public class TwoArrayLab3{

	public static void main(String[] args) {
		char play[][] = { 
				{ 'X', 'X', 'X', 'R', 'X', 'R'},
				{ 'R', 'X', 'X', 'X', 'X', 'X'},
				{ 'X', 'X', 'R', 'X', 'X', 'X'},
				{ 'R', 'X', 'X', 'F', 'X', 'X'},
				{ 'X', 'R', 'X', 'R', 'X', 'R'},
				{ 'X', 'R', 'X', 'X', 'X', 'R'},
				};
		
		int catchNum = 0;
		/*
		 * R은 토끼이고 F는 여우다
		 * 여우의 위치는 정해져 있고 
		 * 정해진 위치에서 대각선과 직선으로만 이동 가능하다. 
		 * 위와 같은 2차원 배열 데이터에서
		 * 토끼를 몇마리 잡겠는가?
		 */
		int fPosi = 0;
		int fPosj = 0;
		
		// 구현
		hunt : for(int i=0; i<play.length; i++) {
			for(int j=0; j<play.length; j++) {
				if(play[i][j] == 'F') {
					fPosi = i;
					fPosj = j;
					break hunt;
				} 
			}
		}
		System.out.println("여우의 위치 : (" + fPosi + "," + fPosj+")");
		int count = 0;
		
		// 구현	
	       for(int i=0; i<play.length; i++) {
	        	if(play[fPosi][i] == 'R') {
	        		catchNum++;
	        		count++;
	        	}
	        }
	        System.out.println("행 방향으로 잡은 토끼 수 : " + count);
	        
	        count=0;
	        for(int i=0; i<play.length; i++) {
	        	if(play[i][fPosj] == 'R') {
	        		catchNum++;
	        		count++;
	        	}
	        }
	        System.out.println("열 방향으로 잡은 토끼 수 : " + count);
	        
	        count=0;
	        for(int i=fPosi-1; i>=0; i--) { // 좌측 위
	            for(int j=fPosj-1; j>=0; j--) {
	            	if(fPosi - fPosj == i - j) {
		            	if(play[i][j] == 'R') {
		                    catchNum++;
		            		count++;
	            		}
	            	}
	            }
	        }
	        // int i=fPosi;
	        // int j=fPosj;
	        // while(i >= 0 && j >= 0) {
	        //	if(play[i][j] == 'R')
	        //		catchNum++;
	        //		i--, j--;
			//}
	        System.out.println("좌측 위 방향 잡은 토끼 수 : " + count);
	        
	        count=0;
	        for(int i=fPosi+1; i<play.length; i++) {	// 좌측 아래
	            for(int j=fPosj-1; j>=0; j--) {
	            	if(fPosi + fPosj == i + j) {
		                if(play[i][j] == 'R') {
		                    catchNum++;
		                    count++;
		               }
	            	}
	            }
	        }
	        System.out.println("좌측 아래 방향 잡은 토끼 수 : " + count);
	        
	        count=0;
	        for(int i=fPosi-1; i>=0; i--) { // 우측 위
	        	for(int j=fPosj+1; j<play.length; j++) {
	        		if(fPosi + fPosj == i + j) {
	        			if(play[i][j] == 'R') {
	        				catchNum++;
	        				count++;
	        			}
	        		}
	        	}
	        }
	        System.out.println("우측 위 방향 잡은 토끼 수 : " + count);
	        
	        count=0;
	        for(int i=fPosi+1; i<play.length; i++) {	// 우측 아래
	        	for(int j=fPosj+1; j<play.length; j++) {
	        		if(fPosi - fPosj == i - j) {
		        		if(play[i][j] == 'R') {
		        			catchNum++;
		        			count++;
		        		}
	        		}
	        	}
	        }
	        System.out.println("우측 아래 방향 잡은 토끼 수 : " + count);
	        
//	        count=0;
//	        for(int i=0; i<play.length; i++) { // /대각선 방향
//	            for(int j=0; j<play.length; j++) {
//	            	if(fPosi + fPosj == i + j) {
//	            	if(play[i][j] == 'R') {
//	                    catchNum++;
//	            		count++;
//	            		}
//	            	}
//	            }
//	        }
//	        System.out.println("/대각선 방향 잡은 토끼 수 : " + count);
//	        count=0;
//	        for(int i=0; i<play.length; i++) {	// \대각선 방향
//	            for(int j=0; j<play.length; j++) {
//	            	if(fPosi - fPosj == i - j ) {
//	                    if(play[i][j] == 'R') {
//	                        catchNum++;
//	                        count++;
//	                    }
//	            	}
//	            }
//	        }
//	        System.out.println("\\대각선 방향으로 잡은 토끼 수 : " + count);

		System.out.printf("여우는 토끼를 %d 마리 잡는다.", catchNum);		
	}
}


