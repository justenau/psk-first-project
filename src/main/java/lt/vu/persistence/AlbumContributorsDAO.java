package lt.vu.persistence;

import lt.vu.entities.AlbumContributor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AlbumContributorsDAO {
    @Inject
    private EntityManager em;

    public List<AlbumContributor> loadAll() {
        return em.createNamedQuery("AlbumContributor.findAll", AlbumContributor.class).getResultList();
    }

    public void persist(AlbumContributor albumContributor) {
        this.em.persist(albumContributor);
    }

    public AlbumContributor findOne(Integer id) {
        return em.find(AlbumContributor.class, id);
    }
}