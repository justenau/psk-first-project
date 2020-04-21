package lt.vu.usecases.mybatis;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.AlbumMapper;
import lt.vu.mybatis.model.Album;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class AlbumsMyBatis {
    @Inject
    private AlbumMapper albumMapper;

    @Getter
    private List<Album> allAlbums;

    @Getter @Setter
    private Album albumToCreate = new Album();

    @PostConstruct
    public void init() {
        this.loadAllAlbums();
    }

    private void loadAllAlbums() {
        this.allAlbums = albumMapper.selectAll();
    }

    @Transactional
    public String createAlbum() {
        albumMapper.insert(albumToCreate);
        return "/myBatis/albums?faces-redirect=true";
    }
}