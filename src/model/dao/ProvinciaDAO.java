package model.dao;

import model.entities.Provincia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProvinciaDAO
{
	//metodo che appartiene alla classe e che converte una riga del result set
	//in un oggetto Provincia
	public static Provincia convertiRigaInProvincia(ResultSet rs)throws Exception
	{
		Provincia p = new Provincia();
		p.setId(rs.getLong("id"));
		p.setNome(rs.getString("nome"));
		p.setAbitanti(rs.getInt("abitanti"));
		return p;
	}

	private Connection con;

	public ProvinciaDAO(Connection con)
	{
		this.con = con;
	}

	//metodo che riceve un id e restituisce la provincia con quell'ID
	//se non abbiamo province con quell'ID allora restitusce null
	public Provincia findById(Long id) throws Exception
	{
		Statement st = con.createStatement();
		//eseguo la lettura, posso ricevere un result set di 1 o 0 righe
		ResultSet rs = st.executeQuery("SELECT * FROM provincia WHERE id="+id);

		//se il result set ha una riga la converto in un oggetto e la restituisco
		if(rs.next())
			return convertiRigaInProvincia(rs);
		//altrimenti restituisco null
		return null;
	}

	//metodo per la lettura di tutte le province presenti sul db
	public ArrayList<Provincia> findAll() throws Exception
	{
		Statement st = con.createStatement();
		//qui uso lo statement per eseguire la lettura sul db, ottenendo
		//un result set contenente tutte le righe lette
		ResultSet rs = st.executeQuery("SELECT * FROM provincia");
		//creo una lista vuota
		ArrayList<Provincia> result = new ArrayList<>();
		//scorro il result set riga per riga
		while(rs.next())
		{
			//converto ogni riga in un oggetto provincia grazie al metodo che ho scritto
			//sopra e lo aggiungo alla lista
			result.add(convertiRigaInProvincia(rs));
		}
		//che poi restituisco
		return result;
	}

	//metodo fare UPSERT (update o insert in base a necessità)
	public void save(Provincia p) throws Exception
	{
		Statement st = con.createStatement();
		//se l'oggetto non ha un id significa che è un oggetto nuovo ancora mai
		//messo sul db, quindi vogliamo fare una insert
		//andremo ad estrapolare i dati per fare una query di insert
		if(p.getId()==null)
		{
			String query="INSERT INTO provincia(nome,abitanti,id_regione) VALUES " +
					"('[nome]','[abitanti]','[id_regione]')";
			query=	query.replace("[nome]",p.getNome()+"")
					.replace("[abitanti]",p.getAbitanti()+"")
					.replace("[id_regione]",p.getRegione().getId()+"");
			st.execute(query);
		}
		else//altrimenti se esiste già fa un update
		{
			String query="UPDATE  provincia SET nome='[nome]',abitanti='[abitanti]' WHERE id='[id]'";
			query=	query.replace("[nome]",p.getNome()+"")
					.replace("[abitanti]",p.getAbitanti()+"")
					.replace("[id]",p.getId()+"");
			st.execute(query);
		}
	}

	public void delete(Long id) throws Exception
	{
		Statement s1 = con.createStatement();
		s1.execute("DELETE FROM provincia WHERE id="+id);
	}



}
