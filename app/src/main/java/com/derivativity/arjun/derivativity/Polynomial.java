package com.derivativity.arjun.derivativity;

import java.util.ArrayList;


public class Polynomial
{
    private static final String allowedChars = "123456789^+-x";
    private ArrayList<Term> terms;

    // Ex. 2x^3+8x^7-2x^2+4x^5

    public String toString()
    {
        String out = "";
        for (Term t : terms)
        {
            if (t.getCoefficient() > 0 && terms.indexOf(t) != 0)
                out += "+" + t.toString();
            else
                out += t.toString();
        }
        return out;
    }

    public boolean parsePolynomial(String poly)
    {
        // no "/" division
        // no "*" multiplication
        // only chars allowed: ^ + - and numbers

        terms = new ArrayList<Term>();

        for (char c : poly.toCharArray())
            if (allowedChars.indexOf(c) == -1)
                return false;

        // probably valid polynomial

        // split string into term strings

        if (poly.charAt(0) == '-')
            poly = "-" + poly.substring(1).replaceAll("-", "+-");
        else
            poly = poly.replaceAll("-", "+-");

//		 System.out.println(poly);//
        // ////////////////////////////////////////////////

        String[] termArr = poly.split("\\+");

        for (String s : termArr)
        {
            Term t = new Term();
//			 System.out.println(s);
            t.parseTerm(s);
            terms.add(t);
        }

//		for (Term t : terms)
//		{
//			System.out.println(t.toString());
//		}


        // for (String s : termArr)
        // {
        // Term t = new Term();
        // if (t.parseTerm(s))
        // {
        // t = t.getDerivative(t);
        // terms.add(t);
        // } else
        // return false;
        // }

        return true;
    }

    public ArrayList<Term> getDerivative()
    {
        ArrayList<Term> arr = new ArrayList<Term>();

        //System.out.println(terms.size());

        for (Term t : terms)
        {
            arr.add(t.getDerivative());
        }
//		for (Term f : arr)
//			System.out.println(f.toString());

        return arr;
    }

    public ArrayList<Term> getTerms()
    {
        return terms;
    }

    public void setTerms(ArrayList<Term> terms)
    {
        this.terms = terms;
    }

}
