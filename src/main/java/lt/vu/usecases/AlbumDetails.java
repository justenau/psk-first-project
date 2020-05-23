package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Album;
import lt.vu.entities.AlbumContributor;
import lt.vu.entities.Artist;
import lt.vu.entities.Song;
import lt.vu.persistence.AlbumContributorsDAO;
import lt.vu.persistence.AlbumsDAO;
import lt.vu.persistence.ArtistsDAO;
import lt.vu.persistence.SongsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
@ViewScoped
public class AlbumDetails implements Serializable {
    @Inject
    private AlbumsDAO albumsDAO;

    @Inject
    private SongsDAO songsDAO;

    @Inject
    private ArtistsDAO artistsDAO;

    @Inject
    private AlbumContributorsDAO albumContributorsDAO;

    @Getter
    private Album album;

    @Getter
    @Setter
    private String songId;

    @Getter
    @Setter
    private String artistId;

    @Getter
    @Setter
    private String artistRole;

    @Getter @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        loadAlbum();
    }

    private void loadAlbum() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));

        this.album = albumsDAO.findOne(albumId);
    }

    @Transactional
    public String addArtistContributorForAlbum() {
        Artist artist = artistsDAO.findOne(Integer.parseInt(artistId));

        AlbumContributor albumContributor = new AlbumContributor();
        albumContributor.setArtist(artist);
        albumContributor.setAlbum(album);
        albumContributor.setRole(artistRole);

        albumContributorsDAO.persist(albumContributor);

        return "/albumDetails?faces-redirect=true&albumId=" + this.album.getId();
    }

    @Transactional
    public String addSong() {
        songToCreate.setAlbum(this.album);
        songToCreate.setMonthlyListeners(0);
        songsDAO.persist(songToCreate);
        return "/albumDetails?faces-redirect=true&albumId=" + this.album.getId();
    }
}