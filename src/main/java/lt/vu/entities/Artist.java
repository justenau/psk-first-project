package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Artist.findAll", query = "select a from Artist as a")
})
@Table(name = "ARTIST")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Artist implements Serializable {
    public Artist() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @OneToMany(mappedBy = "artist")
    @Getter
    @Setter
    private List<AlbumContributor> albums;

    @Getter
    @Setter
    private String name;
}