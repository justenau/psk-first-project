package lt.vu.mybatis.model;

import java.util.List;

public class AlbumContributor {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ALBUM_CONTRIBUTOR.ID
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    private Integer id;

    private Album album;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ALBUM_CONTRIBUTOR.ROLE
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    private String role;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ALBUM_CONTRIBUTOR.ALBUM_ID
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    private Integer albumId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ALBUM_CONTRIBUTOR.ARTIST_ID
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    private Integer artistId;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ALBUM_CONTRIBUTOR.ID
     *
     * @return the value of PUBLIC.ALBUM_CONTRIBUTOR.ID
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ALBUM_CONTRIBUTOR.ID
     *
     * @param id the value for PUBLIC.ALBUM_CONTRIBUTOR.ID
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ALBUM_CONTRIBUTOR.ROLE
     *
     * @return the value of PUBLIC.ALBUM_CONTRIBUTOR.ROLE
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    public String getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ALBUM_CONTRIBUTOR.ROLE
     *
     * @param role the value for PUBLIC.ALBUM_CONTRIBUTOR.ROLE
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ALBUM_CONTRIBUTOR.ALBUM_ID
     *
     * @return the value of PUBLIC.ALBUM_CONTRIBUTOR.ALBUM_ID
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ALBUM_CONTRIBUTOR.ALBUM_ID
     *
     * @param albumId the value for PUBLIC.ALBUM_CONTRIBUTOR.ALBUM_ID
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ALBUM_CONTRIBUTOR.ARTIST_ID
     *
     * @return the value of PUBLIC.ALBUM_CONTRIBUTOR.ARTIST_ID
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ALBUM_CONTRIBUTOR.ARTIST_ID
     *
     * @param artistId the value for PUBLIC.ALBUM_CONTRIBUTOR.ARTIST_ID
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Album getAlbum() {
        return album;
    }
}