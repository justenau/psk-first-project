package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Album;
import lt.vu.entities.AlbumContributor;
import lt.vu.entities.Artist;
import lt.vu.persistence.AlbumContributorsDAO;
import lt.vu.persistence.AlbumsDAO;
import lt.vu.persistence.ArtistsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class AlbumContributors implements Serializable {
    @Inject
    private AlbumContributorsDAO albumContributorsDAO;

    @Inject
    private AlbumsDAO albumsDAO;

    @Inject
    private ArtistsDAO artistsDAO;

    @Getter
    @Setter
    private AlbumContributor albumContributorToCreate = new AlbumContributor();

    @Getter
    @Setter
    private Album album = new Album();

    @Getter
    @Setter
    private Artist artist = new Artist();

    @Getter
    @Setter
    private String artistRole;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));
        Integer artistId = Integer.parseInt(requestParameters.get("artistId"));
        String artistRole = requestParameters.get("artistRole");

        this.album = albumsDAO.findOne(albumId);
        this.artist = artistsDAO.findOne(artistId);
        this.artistRole = artistRole;
    }

    @Transactional
    public String createAlbumContributor() {
        albumContributorToCreate.setAlbum(album);
        albumContributorToCreate.setArtist(artist);
        albumContributorToCreate.setRole(artistRole);

        albumContributorsDAO.persist(albumContributorToCreate);
        return "/players?faces-redirect=true&tournamentId=" + this.artist.getId();
    }
}
