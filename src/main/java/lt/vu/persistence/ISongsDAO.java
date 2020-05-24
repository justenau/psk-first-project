package lt.vu.persistence;

import lt.vu.entities.Song;

import javax.enterprise.context.ApplicationScoped;

public interface ISongsDAO {
    void persist(Song song);

    Song findOne(Integer id);

    Song update(Song song);
}
