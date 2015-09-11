package movies.loaddata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;

import edu.pragmatic.movies.db.dao.model.MovieDao;
import edu.pragmatic.movies.model.Actor;
import edu.pragmatic.movies.model.Movie;

public class BootStrap {

	@Test
	public void bootstrap() throws ParseException{
		MovieDao dao = new MovieDao();
//		1. The Shawshank Redemption (1994)	9.2
		saveShawshankRedemption(dao);
//		2. The Godfather (1972)	9.2
		saveTheGodfather(dao);
		
	}

	private void saveTheGodfather(MovieDao dao) throws ParseException {
		Movie godfather = new Movie();
		godfather.setActors(new ArrayList<Actor>());
		godfather.setDirectedBy("Francis Ford Coppola");
		godfather.setYearPublishedOn("1972");
		godfather.setName("The Godfather");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		Actor brando = new Actor("Marlon","Brando", sdf.parse("1924"));
		Actor pacino = new Actor("Al","Pacino", sdf.parse("1924"));
		Actor morganFreeman = new Actor("Morgan", "Freeman", sdf.parse("1940"));
		godfather.getActors().add(morganFreeman);
		godfather.getActors().add(pacino);
		godfather.getActors().add(brando);
		dao.save(godfather);
	}

	private void saveShawshankRedemption(MovieDao dao) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		Movie shawshankRedemption = new Movie();
		Actor timRobbins = new Actor("Tim", " Robbins", sdf.parse("1958"));
		Actor morganFreeman = new Actor("Morgan", "Freeman", sdf.parse("1937"));
		shawshankRedemption.setActors(new ArrayList<Actor>());
		shawshankRedemption.getActors().add(morganFreeman);
		shawshankRedemption.getActors().add(timRobbins);
		shawshankRedemption.setDirectedBy("Frank Darabont");
		shawshankRedemption.setYearPublishedOn("1994");
		shawshankRedemption.setName("The Shawshank Redemption 2");
		dao.save(shawshankRedemption);
	}
	
}
