package lt.vu.persistence;

import lt.vu.entities.Album;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class AlbumsDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Album> loadAll() {
        return em.createNamedQuery("Album.findAll", Album.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Album album){
        this.em.persist(album);
    }

    public Album findOne(Integer id) { return em.find(Album.class, id); }
}