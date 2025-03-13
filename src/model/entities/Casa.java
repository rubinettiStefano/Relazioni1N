package model.entities;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Casa
{
	private Long id;
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

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
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

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Casa.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("indirizzo='" + indirizzo + "'")
				.add("pmq=" + pmq)
				.add("classeEnergetica='" + classeEnergetica + "'")
				.add("piano=" + piano)
				.toString();
	}
}
