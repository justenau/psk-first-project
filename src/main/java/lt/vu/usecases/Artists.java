package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
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

    @Getter
    @Setter
    private Artist artistToCreate = new Artist();

    @Getter
    private List<Artist> artists;

    @PostConstruct
    public void init() {
        loadArtists();
    }

    @Transactional
    public String createArtist() {
        this.artistsDAO.persist(artistToCreate);
        return "artists?faces-redirect=true";
    }

    private void loadArtists() {
        this.artists = artistsDAO.loadAll();
    }
}