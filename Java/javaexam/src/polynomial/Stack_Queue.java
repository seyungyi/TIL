package polynomial;

public class Stack_Queue {
	public static void main(String[] args) {
		polynomial();
	}

	public static void polynomial() {
		float[] a_coef = { 1, 1 };
		int[] a_exp = { 1, 0 };

		float[] b_coef = { 5, -10, 5, -10 };
		int[] b_exp = { 3, 2, 1, 0 };

		Polynomial a = new Polynomial();
		Polynomial b = new Polynomial();

		Polynomial result;
		for (int i = 0; i < a_exp.length; i++) {
			a.newTerm(a_coef[i], a_exp[i]);
		}
		for (int i = 0; i < b_exp.length; i++) {
			b.newTerm(b_coef[i], b_exp[i]);
		}
		result = a.add(b);
		System.out.print("다항식 a + 다항식 b = ");
		result.print();
		
		result = a.Mul(b);
		System.out.print("다항식 a * 다항식 b = ");
		result.print();
	}
}

class Term {
	float coef;
	int exp;

	Term() {
		this.coef = 0;
		this.exp = 0;
	}
}


class Polynomial {
	Term termArray[];
	int terms;

	public Polynomial() {
		this.terms = 0;
		this.termArray = new Term[10];
		for (int i = 0; i < termArray.length; i++) {
			termArray[i] = new Term();
		}
	}

	void print() {
		String result = "";
		for (int i = 0; i < this.termArray.length; i++) {
			if (this.termArray[i].coef == 0) {
				continue;
			} else {
				if (i != 0) {
					result = result + " + " + this.termArray[i].coef + "x^" + this.termArray[i].exp;
				} else {
					result = this.termArray[i].coef + "x^" + this.termArray[i].exp;
				}
			}
		}
		if (result == "")
			System.out.println("0");
		else
			System.out.println(result);
	}

	void newTerm(float coef, int exp) {
		if (this.termArray.length == this.terms) {
			Term temp[] = new Term[this.termArray.length * 2];
			for (int i = 0; i < this.termArray.length; i++) {
				temp[i] = termArray[i];
			}
			this.termArray = temp;
		}
		this.termArray[this.terms].coef = coef;
		this.termArray[this.terms++].exp = exp;
	}

	Polynomial add(Polynomial b) {
		//구현 부분
		for(int i=0; i<termArray.length; i++) {
			for(int j=0; j<termArray.length; i++) {
				if(this.termArray[i].exp != b.termArray[j].exp) {
					continue;
				} else {
					this.termArray[i].coef += b.termArray[j].coef;
					break;
				}	
			}
		}
		return b;
	}

	public Polynomial Mul(Polynomial b) {
		//구현 부분
		return b;
	}
}


