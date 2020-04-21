package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Song;
import org.mybatis.cdi.Mapper;

import java.util.List;
@Mapper
public interface SongMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SONG
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SONG
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    int insert(Song record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SONG
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    Song selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SONG
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    List<Song> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SONG
     *
     * @mbg.generated Tue Apr 21 18:53:42 EEST 2020
     */
    int updateByPrimaryKey(Song record);
}