package model;

import java.util.ArrayList;

public class Casa
{
	private int id;
	private String indirizzo;
	private int pmq;
	private String classeEnergetica;
	private int piano;

	//LISTA DI FIGLI
	private ArrayList<Stanza> stanze = new ArrayList<>();

	public void link(Stanza s)
	{
		stanze.add(s);
		s.setCasa(this);
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getIndirizzo()
	{
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo)
	{
		this.indirizzo = indirizzo;
	}

	public int getPmq()
	{
		return pmq;
	}

	public void setPmq(int pmq)
	{
		this.pmq = pmq;
	}

	public String getClasseEnergetica()
	{
		return classeEnergetica;
	}

	public void setClasseEnergetica(String classeEnergetica)
	{
		this.classeEnergetica = classeEnergetica;
	}

	public int getPiano()
	{
		return piano;
	}

	public void setPiano(int piano)
	{
		this.piano = piano;
	}

	public ArrayList<Stanza> getStanze()
	{
		return stanze;
	}

	public void setStanze(ArrayList<Stanza> stanze)
	{
		this.stanze = stanze;
	}

	public int calcArea()
	{
		int res =0;
		for(Stanza s:stanze)
		{
			res +=  s.calcolaArea();
		}
		return res;
	}

	public int numeroBagni()
	{
		int res=0;
		for(Stanza s:stanze)
			if(s.getTipo().equals("bagno"))
				res++;

		return res;
	}
}
