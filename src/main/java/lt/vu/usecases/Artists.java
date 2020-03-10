package lt.vu.usecases;

import lt.vu.entities.Artist;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
public class Artists implements Serializable {

    private List<Artist> allArtists;
    @PostConstruct
    public void init(){
        loadArtists();
    }

    public void loadArtists() {
        // TODO this is a mock implementation - later we will connect it to real data store
        List<Artist> artists = new ArrayList<Artist>();
        artists.add(new Artist("Tame Impala"));
        artists.add(new Artist("Foals"));
        this.allArtists = artists;
    }

    public List<Artist> getAllArtists(){
        return allArtists;
    }
}