package com.example.music_management.mapper;

import com.example.music_management.entity.Album;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import java.util.List;
import com.example.music_management.viewmodel.AlbumViewModel;
@Mapper
public interface AlbumMapper {

    @Select("SELECT * FROM albums")
    List<Album> selectAllAlbums();

    @Insert("INSERT INTO albums (title,artist,release_date) VALUES (#{title},#{artist},#{releaseDate})")
    @Options(useGeneratedKeys = true, keyProperty = "albumId")
    void insertAlbum(Album album);

    @Select("SELECT * FROM albums WHERE album_id = #{albumId}")
    Album selectAlbumById(long albumId);

    @Delete("DELETE FROM albums WHERE album_id = #{albumId}")
    void deleteAlbumById(long albumId);

    @Update("UPDATE albums SET title = #{title},artist = #{artist},release_date = #{releaseDate} WHERE album_id = #{albumId}")
    void updateAlbum(Album album);

    @Select("""
            SELECT albums.album_id, albums.title, artist, release_date, count(musics.music_id) AS music_count
            FROM albums
            LEFT OUTER JOIN musics ON albums.album_id = musics.album_id
            GROUP BY albums.album_id, albums.title, artist, release_date
            """)
    public List<AlbumViewModel> selectAllAlbumsWithMusicCount();

}
