package com.derivativity.arjun.derivativity;
public class Term
{
	private int coefficient;
	private int exponent;
	private static final String numbers = "123456789";

	//TODO
	/*
	 * parse term with omitted coefficient Ex. x^3  and  -x^2
	 * parse term with exponent of 1 Ex. 5x^1 should be 5x
	 */
	
	public Term getDerivative()
	{
		Term d = new Term();
		d.coefficient = this.exponent * this.coefficient;
		d.exponent = this.exponent - 1;
		return d;
	}

	public Term getTerm()
	{
		Term t = new Term();
		t.coefficient = this.coefficient;
		t.exponent = this.exponent;
		return t;
	}

	public String toString(){
		return (this.getCoefficient()+"x^"+this.getExponent());
	}
	
	public boolean parseTerm(String str)
	{
		str = str.trim();

		// a term will be a "power function"
		// check if first character is a sign (nega, posi). if not, assume posi
		// sign.
		// count digits of coefficient until first variable encountered (an "x")
		// return true if valid term, false if not

		if ((str.charAt(0) != '-') && (str.charAt(0) != '+')
				&& numbers.indexOf(str.charAt(0)) == -1)
			return false;
		//
		// if (str.charAt(0) == '-')
		// this.sign = '-';
		// else if (str.charAt(0) == '+')
		// this.sign = '+';
		// else if (numbers.indexOf(str.charAt(0)) != -1)
		// sign = '+';
		// else
		// return false;

		// if (str.charAt(0) == '+' || str.charAt(0) == '-')
		// str = str.substring(1);

		try
		{
			this.coefficient = Integer.parseInt(str.substring(0,
					str.indexOf('x')));
			str = str.substring(str.indexOf('x') + 2);

			this.exponent = Integer.parseInt(str);

		} catch (Exception e)
		{
			return false;
		}
		return true;
	}

	public int getCoefficient()
	{
		return coefficient;
	}

	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}

	public int getExponent()
	{
		return exponent;
	}

	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}

}
