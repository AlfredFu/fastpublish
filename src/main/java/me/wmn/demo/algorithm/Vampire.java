package me.wmn.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Vampire {
	
	/**
	 * 求四位数的吸血鬼数字
	 * @param from
	 * @param to
	 * @return
	 */
	public static List<Integer> getVampireNumFromTo(int from, int to){
		List<Integer> vampire = new ArrayList<Integer>();
		
		for(int i = from; i <= to; i++){
			char[] charArr = Integer.toString(i).toCharArray();

			for(int j = 0; j < charArr.length; j ++){
				for(int k = 0; k < charArr.length; k++){
					if(j == k){
						continue;
					}
					int num1 = Integer.parseInt(String.valueOf(new char[]{charArr[j], charArr[k]}));
					char[] unSelChar = new char[2];
					int q = 0;
					for(int h = 0 ; h < charArr.length; h++){
						if(h != j && h !=k){
							unSelChar[q++] = charArr[h];
						}
					}
 					int num2 = Integer.parseInt(String.valueOf(unSelChar));
					if (i == num1 * num2 && vampire.indexOf(i) == -1){
						vampire.add(i);
	 					System.out.println(""+num1 + " * " + num2 + " equals:" + i);

					}
				}
			}
			//break;
		}
		return vampire;
		
	}
	
	public static List<Integer> getVampireNum(int from, int to){
		List<Integer> vampire = new ArrayList<Integer>();
		if(from > 1000 && to <= 9999){
			for(int i = from; i < to; i++){
				int[] bitNum = new int[4];
				bitNum[0] = i / 1000;
				bitNum[1] = (i % 1000) / 100;
				bitNum[2] = ((i % 1000) % 100) / 10;
				bitNum[2] = ((i % 1000) % 100) % 10;
				
				for(int j = 0; j < 4; j++){
					for(int k = 0; k < 4; k++){
						if(j == k) continue;
						int num1 = j *10 + k;
						int num2 = Integer.valueOf(bitNum.toString().replace(String.valueOf(bitNum[j]), "").replace(String.valueOf(bitNum[k]), ""));
						
						
						if(num1 * num2 == i){
							System.out.println(i + " = " + num1);
							vampire.add(i);
						}
					}
				}
			}
		}

		
				
		return vampire;
	}
	
	
	
	

	public static void main(String[] args) {
//		long start = System.currentTimeMillis();
//		
//		System.out.println(getVampireNumFromTo(1000, 9999));
//		long end = System.currentTimeMillis();
//		System.out.println(end - start);
		
//		
//        for(int i = 1001; i < 9999; i++) {            
//            productTest(i, com(a(i), b(i)), com(c(i), d(i)));
//            productTest(i, com(a(i), b(i)), com(d(i), c(i)));
//            productTest(i, com(a(i), c(i)), com(b(i), d(i)));
//            productTest(i, com(a(i), c(i)), com(d(i), b(i)));
//            productTest(i, com(a(i), d(i)), com(b(i), c(i)));
//            productTest(i, com(a(i), d(i)), com(c(i), b(i)));
//            productTest(i, com(b(i), a(i)), com(c(i), d(i)));
//            productTest(i, com(b(i), a(i)), com(d(i), c(i)));
//            productTest(i, com(b(i), c(i)), com(d(i), a(i)));
//            productTest(i, com(b(i), d(i)), com(c(i), a(i)));
//            productTest(i, com(c(i), a(i)), com(d(i), b(i)));
//            productTest(i, com(c(i), b(i)), com(d(i), a(i)));
//        } 
		
		System.out.println(getVampireNum(1000, 9999));
		
	}
	
	
  
        static int a(int i) {
            return i/1000;
        }
        static int b(int i) {
            return (i%1000)/100;
        }
        static int c(int i) {
            return ((i%1000)%100)/10;
        }
        static int d(int i) {
            return ((i%1000)%100)%10;
        }
        static int com(int i, int j) {
            return (i * 10) + j;
        }
        static void productTest (int i, int m, int n) {
            if(m * n == i) System.out.println(i + " = " + m + " * " + n);
        }


}
