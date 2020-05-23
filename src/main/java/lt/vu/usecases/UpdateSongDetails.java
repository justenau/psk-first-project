package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Song;
import lt.vu.persistence.AlbumsDAO;
import lt.vu.persistence.SongsDAO;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateSongDetails implements Serializable {

    private Song song;

    @Inject
    private SongsDAO songsDAO;


    @PostConstruct
    private void loadSong() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer songId = Integer.parseInt(requestParameters.get("songId"));

        this.song = songsDAO.findOne(songId);
    }

    @Transactional
    public String updateSongMonthlyListeners() {
        try{
            songsDAO.update(this.song);
        } catch (OptimisticLockException e) {
            return "/songDetails.xhtml?faces-redirect=true&songId=" + this.song.getId() + "&error=optimistic-lock-exception";
        } catch (Exception e){
            System.out.println("ERROR:" + e.getMessage());
        }
        return "/albumDetails?faces-redirect=true&albumId=" + this.song.getAlbum().getId();
    }
}