package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "AlbumContributor.findAll", query = "select a from AlbumContributor as a")
})
@Table(name = "ALBUM_CONTRIBUTOR")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class AlbumContributor implements Serializable {
    public AlbumContributor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID")
    @Getter
    @Setter
    private Album album;

    @ManyToOne
    @JoinColumn(name = "ARTIST_ID")
    @Getter
    @Setter
    private Artist artist;

    @Getter
    @Setter
    private String role;
}