package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Artist;
import lt.vu.persistence.ArtistsDAO;
import lt.vu.rest.contracts.ArtistDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/artists")
public class ArtistsController {
    @Inject
    @Getter
    @Setter
    private ArtistsDAO artistsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Artist artist = artistsDAO.findOne(id);
        if (artist == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setName(artist.getName());

        return Response.ok(artistDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response add(
            ArtistDTO artistData) {

        Artist newArtist = new Artist();
        newArtist.setName(artistData.getName());

        artistsDAO.persist(newArtist);

        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer artistID,
            ArtistDTO artistData) {
        try {
            Artist existingArtist = artistsDAO.findOne(artistID);
            if (existingArtist == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            existingArtist.setName(artistData.getName());

            artistsDAO.update(existingArtist);

            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}