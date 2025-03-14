package model.entities;

import java.util.StringJoiner;

public class Provincia
{
	private Long id;
	private String nome;
	private int abitanti;

	private Regione regione;

	public Regione getRegione()
	{
		return regione;
	}

	public void setRegione(Regione regione)
	{
		this.regione = regione;
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

	public int getAbitanti()
	{
		return abitanti;
	}

	public void setAbitanti(int abitanti)
	{
		this.abitanti = abitanti;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Provincia.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("abitanti=" + abitanti)
				.add("nome='" + nome + "'")
				.toString();
	}
}
