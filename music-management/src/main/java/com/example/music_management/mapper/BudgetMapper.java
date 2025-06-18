package com.example.music_management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.music_management.entity.Album;
import com.example.music_management.entity.Budget;

@Mapper
public interface BudgetMapper {
    @Select("SELECT * FROM albums")
    List<Album> select();
    @Insert("INSERT INTO budgets (user_id, budget_amount) VALUES (#{userId}, #{budgetAmount})")
    @Options(useGeneratedKeys = true, keyProperty = "budgetId")
   void insertBudget(Budget budget);
   //ホーム画面　予算の金額表示
   @Select("select budget_amount from budgets where user_id = #{userId}")
   Integer selectBudgetAmount(long userId);

   @Update("update budgets set budget_amount = #{budgetAmount} where user_id = #{userId}")
    void updateBudgetAmount(Integer budgetAmount, long userId);
}
