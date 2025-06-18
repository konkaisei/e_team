package com.example.music_management.mapper;
import com.example.music_management.entity.IE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface IEMapper {

  @Select("select * from incomeExpense where user_id = #{userId}")
    List<IE> selectAllIE(long userId);

    @Select("select sum(amount) from incomeExpense where type = 0 and user_id = #{userId}")
    Integer selectIncomeSum(long userId);

    @Select("select sum(amount) from incomeExpense where type = 1 and user_id = #{userId}")
    Integer selectExpenseSum(long userId);

    @Insert("insert into incomeExpense (type, amount, category, user_id) values (#{type}, #{amount}, #{category}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "ieId")
    void insertIE(IE ie);
    
    @Select("select * from incomeExpense where user_id = #{userId}")
    public List<IE> selectAllIEWithMusicCount(long userId);

    @Delete("DELETE FROM incomeExpense WHERE IE_id = #{ieId}")
    void deleteIEById(long ieId);

    @Select("select * from incomeExpense where IE_id = #{ieId}")
    IE selectIEById(long ieId);

    @Update("update incomeExpense set type = #{type}, amount = #{amount}, category = #{category} where IE_id = #{ieId}")
    void updateIE(IE ie);
}
