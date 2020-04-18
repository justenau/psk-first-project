package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="SONG")
@Getter @Setter
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name="ALBUM_ID")
    private Album album;

    public Song(){}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Song song = (Song) o;
//        return Objects.equals(id, song.id) &&
//                Objects.equals(title, song.title);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, title);
//    }

}
