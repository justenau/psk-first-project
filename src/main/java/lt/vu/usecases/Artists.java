package lt.vu.usecases;

import lt.vu.entities.Artist;
import lt.vu.persistence.ArtistsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Artists implements Serializable {
    @Inject
    private ArtistsDAO artistsDAO;

    private Artist artistToCreate = new Artist();
    private List<Artist> allArtists;
    @PostConstruct
    public void init(){
        loadArtists();
    }

    public void loadArtists() {
        this.allArtists = artistsDAO.loadAll();
    }

    public List<Artist> getAllArtists(){
        return allArtists;
    }

    @Transactional
    public String createArtist(){
        this.artistsDAO.persist(artistToCreate);
        return "success";
    }

    public Artist getArtistToCreate() {
        return artistToCreate;
    }

    public void setArtistToCreate(Artist artistToCreate) {
        this.artistToCreate = artistToCreate;
    }
}