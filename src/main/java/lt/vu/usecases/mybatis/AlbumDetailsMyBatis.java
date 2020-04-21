package lt.vu.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.AlbumContributorMapper;
import lt.vu.mybatis.dao.AlbumMapper;
import lt.vu.mybatis.dao.ArtistMapper;
import lt.vu.mybatis.dao.SongMapper;
import lt.vu.mybatis.model.Album;
import lt.vu.mybatis.model.AlbumContributor;
import lt.vu.mybatis.model.Artist;
import lt.vu.mybatis.model.Song;
import org.mybatis.cdi.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class AlbumDetailsMyBatis {
    @Inject
    private AlbumMapper albumMapper;

    @Inject
    private SongMapper songMapper;

    @Inject
    private ArtistMapper artistMapper;

    @Inject
    private AlbumContributorMapper albumContributorMapper;

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

    @Getter
    @Setter
    private Song songToCreate = new Song();

    @PostConstruct
    public void init() {
        loadAlbum();
    }

    private void loadAlbum() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer albumId = Integer.parseInt(requestParameters.get("albumId"));

        this.album = albumMapper.selectByPrimaryKey(albumId);
    }


    @Transactional
    public String addArtistContributorForAlbum() {

        AlbumContributor albumContributor = new AlbumContributor();
        albumContributor.setArtistId(Integer.parseInt(artistId));
        albumContributor.setAlbumId(album.getId());
        albumContributor.setRole(artistRole);

        albumContributorMapper.insert(albumContributor);

        return "/albumDetails?faces-redirect=true&albumId=" + this.album.getId();
    }

    @Transactional
    public String addSong() {
        songToCreate.setAlbumId(this.album.getId());
        songMapper.insert(songToCreate);
        return "/albumDetails?faces-redirect=true&albumId=" + this.album.getId();
    }
}
