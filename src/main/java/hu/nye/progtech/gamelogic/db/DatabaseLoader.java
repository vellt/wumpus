package hu.nye.progtech.gamelogic;

import hu.nye.progtech.gamelogic.db.DbRepository;
import hu.nye.progtech.models.Hero;

import java.util.List;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class DatabaseLoader {

    DbRepository dbRepository= new DbRepository();

    public Hero getHeroData(int id){
        return dbRepository.getHeros().get(id);
    }

    public List<Hero> getHeroes(){
        return  dbRepository.getHeros();
    }

    public String deleteHero(int id){
        return dbRepository.delete(id);
    }
}
