package list;

import java.util.HashMap;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method2();
	}

	
/*
	中缀转后缀表达式
	1，初始化两个栈，从左至右扫描中缀表达式
	2，遇到操作数时压入栈2
	3，遇到运算符时，比较栈顶运算优先级，
		3.1，如果栈为空或为左括号，直接入栈1
		3.2，如果优先级比栈顶高，压栈1
		3.3，否则将栈1顶弹出，压入栈2，回到3.1
	4，遇到左括号，直接压栈1，遇到右括号，弹出s1中所有的元素压入栈2直到遇到左括号
	重复2-4
	5，将栈1剩余元素压入栈2
	6，栈2全部弹出
*/
	
	public static void method1() {
		String str = "1+2*3/9-5+1-5*20";
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Character> s2 = new Stack<Character>();
		boolean isNum = false;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch(c) {
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case '0':
				int temp = c - '0';
				if(isNum) {
					temp = temp + s1.pop() * 10;
					s1.push(temp);
				}else {
					s1.push(temp);
				}
				isNum = true;
				break;
			case '+':
			case '-':
				if(!s2.isEmpty()) {
					char c1 = s2.pop();
					int res = 0;
					int n2 = s1.pop();
					int n1 = s1.pop();
					if(c1 == '+') {
						res = n1 + n2;
					}
					if(c1 == '-') {
						res = n1 - n2;
					}
					if(c1 == '*') {
						res = n1 * n2;
					}
					if(c1 == '/') {
						res = n1 / n2;
					}
					s1.push(res);
				}
				s2.push(c);
				isNum = false;
				break;
			case '*':
			case '/':
				if(!s2.isEmpty()) {
					char c1 = s2.peek();
					if(c1 == '-' || c1 == '+') {
						
					}else {
						s2.pop();
						int res = 0;
						int n2 = s1.pop();
						int n1 = s1.pop();
						if(c1 == '*') {
							res = n1 * n2;
						}
						if(c1 == '/') {
							res = n1 / n2;
						}
						s1.push(res);
					}
				}
				s2.push(c);
				isNum = false;
				break;
			}
		}
		
		while(!s2.isEmpty()) {
			char c1 = s2.pop();
			int res = 0;
			int n2 = s1.pop();
			int n1 = s1.pop();
			if(c1 == '+') {
				res = n1 + n2;
			}
			if(c1 == '-') {
				res = n1 - n2;
			}
			if(c1 == '*') {
				res = n1 * n2;
			}
			if(c1 == '/') {
				res = n1 / n2;
			}
			s1.push(res);
		}
		System.out.println(s1.peek());
	}
	
	
	public static void method2() {
		String str = "1+((2+3)*4)-5";
		Stack<Character> s1 = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
		for(int i = 0; i < str.length(); i++) {
			int res = getNextNum(str, i);
			if(res == 0) {
				char c1 = str.charAt(i);
				if(c1 == '(') {
					s1.push(c1);
					continue;
				}
				if(c1 == ')') {
					while((c1 = s1.pop()) != '(') {
						sb.append(c1);
					}
					continue;
				}
				if(s1.isEmpty()) {
					s1.push(c1);
					continue;
				}
				char c2 = s1.peek();
				
				if(c2 == '(') {
					s1.push(c1);
					continue;
				}
				int pri = map.get(c1) - map.get(c2);
				if(pri > 0) {
					s1.push(c1);
				}else {
					System.out.println(c1 + ":" + c2);
					while(!s1.isEmpty() && pri <= 0) {
						c2 = s1.pop();
						pri = map.get(c1) - map.get(c2);
						sb.append(c2);
					}
					s1.push(c1);
				}
			}else {
				sb.append(str.substring(i, i + res));
				i = i + res - 1;
			}
			
			
		}
		
		while(!s1.isEmpty()) {
			sb.append(s1.pop());
		}
		System.out.println(sb.toString());
		
	}
	
	public static int getNextNum(String str, int start) {
		int res = 0;
		for(int i = start; i < str.length(); i++) {
			char c = str.charAt(i);
			switch(c) {
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
					res++;
					break;
				default:
					return res;	
			}
		}
		return res;
	}
	
	
	
}
