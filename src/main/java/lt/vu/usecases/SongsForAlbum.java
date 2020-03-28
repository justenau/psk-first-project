package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Album;
import lt.vu.entities.Song;
import lt.vu.persistence.AlbumsDAO;
import lt.vu.persistence.SongsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class SongsForAlbum implements Serializable {

    @Inject
    private AlbumsDAO albumsDAO;
    @Inject
    private SongsDAO songsDAO;

    @Getter @Setter
    private Album album;
    @Getter @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));
        this.album = albumsDAO.findOne(albumId);
    }

    @Transactional
    public String createSong() {
        songToCreate.setAlbum(this.album);
        songsDAO.persist(songToCreate);
        return "/songs?faces-redirect=true&albumId=" + this.album.getId();
    }
}
