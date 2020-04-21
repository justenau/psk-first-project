package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="ALBUM")
@Getter @Setter
@NamedQueries({
        @NamedQuery(name = "Album.findAll", query = "select a from Album as a")
})
@EqualsAndHashCode(of={"id"})
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="TITLE")
    private String title;

    @OneToMany(mappedBy = "album")
    private List<Song> songs = new ArrayList<>();

    @OneToMany(mappedBy = "album")
    @Getter
    @Setter
    private List<AlbumContributor> artists;

    public Album(){}
}
