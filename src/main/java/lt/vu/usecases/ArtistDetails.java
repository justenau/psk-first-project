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
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
@RequestScoped
public class ArtistDetails implements Serializable {
    @Inject
    private ArtistsDAO artistsDAO;

    @Inject
    private AlbumContributorsDAO albumContributorsDAO;

    @Inject
    private AlbumsDAO albumsDAO;

    @Getter
    private Artist artist;

    @Getter
    @Setter
    private String albumId;

    @Getter
    @Setter
    private String artistRole;

    @PostConstruct
    public void init() {
        loadArtist();
    }

    private void loadArtist() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer artistId = Integer.parseInt(requestParameters.get("artistId"));

        this.artist = artistsDAO.findOne(artistId);
    }

    @Transactional
    public String addArtistContributorForAlbum() {
        Album album = albumsDAO.findOne(Integer.parseInt(albumId));

        AlbumContributor albumContributor = new AlbumContributor();
        albumContributor.setAlbum(album);
        albumContributor.setArtist(artist);
        albumContributor.setRole(artistRole);

        albumContributorsDAO.persist(albumContributor);

        return "artistDetails?artistId=" + artist.getId() + "&faces-redirect=true";
    }
}