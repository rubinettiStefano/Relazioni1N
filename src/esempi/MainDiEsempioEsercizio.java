package esempi;

import model.entities.Casa;
import utility.ConnectionFactory;

import java.sql.Connection;
import java.util.Scanner;

public class MainDiEsempioEsercizio
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Connection con = ConnectionFactory.createConnection("nomevostrodb");
		TeamDao tdao = new TeamDao(con);
		Team team1 = tdao.findById(1);

		System.out.println(team1);

		for(Player p : team1.getPlayers())
			System.out.println(p);
	}
}
