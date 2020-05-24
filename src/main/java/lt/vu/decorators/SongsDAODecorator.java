package lt.vu.decorators;

import lt.vu.entities.Song;
import lt.vu.persistence.ISongsDAO;
import lt.vu.persistence.SongsDAO;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class SongsDAODecorator implements ISongsDAO {

    @Inject @Delegate @Any
    ISongsDAO songsDAO;

    public Song update(Song song){
        if(song.getMonthlyListeners() > 300){
            System.out.println("Popular song");
        }
        return songsDAO.update(song);
    }

}