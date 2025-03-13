package model.entities;

import java.util.StringJoiner;

public class Stanza
{
	private Long id;
	private int lato1,lato2;
	private String tipo;

	//RIFERIMENTO AL PADRE
	private Casa casa;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getLato1()
	{
		return lato1;
	}

	public void setLato1(int lato1)
	{
		this.lato1 = lato1;
	}

	public int getLato2()
	{
		return lato2;
	}

	public void setLato2(int lato2)
	{
		this.lato2 = lato2;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public Casa getCasa()
	{
		return casa;
	}

	public void setCasa(Casa casa)
	{
		this.casa = casa;
	}

	public int calcolaArea()
	{
		return lato1*lato2;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Stanza.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("lato1=" + lato1)
				.add("lato2=" + lato2)
				.add("tipo='" + tipo + "'")
				.toString();
	}
}
