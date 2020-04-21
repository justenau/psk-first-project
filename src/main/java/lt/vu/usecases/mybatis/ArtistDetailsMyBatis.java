package lt.vu.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.AlbumContributorMapper;
import lt.vu.mybatis.dao.AlbumMapper;
import lt.vu.mybatis.dao.ArtistMapper;
import lt.vu.mybatis.model.Album;
import lt.vu.mybatis.model.AlbumContributor;
import lt.vu.mybatis.model.Artist;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class ArtistDetailsMyBatis {
    @Inject
    private ArtistMapper artistMapper;

    @Inject
    private AlbumContributorMapper albumContributorMapper;

    @Inject
    private AlbumMapper albumMapper;

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
        this.loadArtist();
    }

    private void loadArtist() {
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer artistId = Integer.parseInt(requestParameters.get("artistId"));

        this.artist = artistMapper.selectByPrimaryKey(artistId);
    }

    @Transactional
    public String addArtistContributorForAlbum() {
        Album album = albumMapper.selectByPrimaryKey(Integer.parseInt(albumId));

        AlbumContributor albumContributor = new AlbumContributor();
        albumContributor.setAlbumId(album.getId());
        albumContributor.setArtistId(artist.getId());
        albumContributor.setRole(artistRole);

        albumContributorMapper.insert(albumContributor);

        return "artistDetails?artistId=" + artist.getId() + "&faces-redirect=true";
    }

    public Album getAlbum(int albumId){
        return albumMapper.selectByPrimaryKey(albumId);
    }
}
