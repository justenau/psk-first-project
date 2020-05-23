package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="SONG")
@Getter @Setter
@EqualsAndHashCode(of={"title"})
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "MONTHLY_LISTENERS")
    private Integer monthlyListeners;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @ManyToOne
    @JoinColumn(name="ALBUM_ID")
    private Album album;

    public Song(){}

}
