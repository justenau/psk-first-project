package lt.vu.mybatis.model;

public class Album {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ALBUM.ID
     *
     * @mbg.generated Sat Mar 28 21:42:37 EET 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ALBUM.TITLE
     *
     * @mbg.generated Sat Mar 28 21:42:37 EET 2020
     */
    private String title;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ALBUM.ID
     *
     * @return the value of PUBLIC.ALBUM.ID
     *
     * @mbg.generated Sat Mar 28 21:42:37 EET 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ALBUM.ID
     *
     * @param id the value for PUBLIC.ALBUM.ID
     *
     * @mbg.generated Sat Mar 28 21:42:37 EET 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ALBUM.TITLE
     *
     * @return the value of PUBLIC.ALBUM.TITLE
     *
     * @mbg.generated Sat Mar 28 21:42:37 EET 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ALBUM.TITLE
     *
     * @param title the value for PUBLIC.ALBUM.TITLE
     *
     * @mbg.generated Sat Mar 28 21:42:37 EET 2020
     */
    public void setTitle(String title) {
        this.title = title;
    }
}