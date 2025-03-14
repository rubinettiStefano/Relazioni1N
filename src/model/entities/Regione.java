package model.entities;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Regione
{
	private Long id;
	private String nome,area_geografica;

	private ArrayList<Provincia> provincias = new ArrayList<>();


	public void link(Provincia p)
	{
		p.setRegione(this);
		provincias.add(p);
	}


	public ArrayList<Provincia> getProvincias()
	{
		return provincias;
	}

	public void setProvincias(ArrayList<Provincia> provincias)
	{
		this.provincias = provincias;
	}


	public int sommaAbitanti()
	{
		int res=0;
		for(Provincia p : provincias)
			res+=p.getAbitanti();

		return res;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getArea_geografica()
	{
		return area_geografica;
	}

	public void setArea_geografica(String area_geografica)
	{
		this.area_geografica = area_geografica;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Regione.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("nome='" + nome + "'")
				.add("area_geografica='" + area_geografica + "'")
				.toString();
	}
}
