package lt.vu.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.ArtistMapper;
import lt.vu.mybatis.model.Artist;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ArtistsMyBatis {
    @Inject
    private ArtistMapper artistMapper;

    @Getter
    private List<Artist> allArtists;

    @Getter @Setter
    private Artist artistToCreate = new Artist();

    @PostConstruct
    public void init() {
        this.loadAllArtists();
    }

    private void loadAllArtists() {
        this.allArtists = artistMapper.selectAll();
    }

    @Transactional
    public String createArtist() {
        artistMapper.insert(artistToCreate);
        return "/myBatis/artists?faces-redirect=true";
    }
}