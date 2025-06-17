package com.example.music_management.repository;
import com.example.music_management.entity.IE;
import com.example.music_management.mapper.IEMapper;
//import com.example.music_management.viewmodel.AlbumViewModel;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IERepository {
  private final IEMapper ieMapper;

  public IERepository(IEMapper ieMapper) {
    this.ieMapper = ieMapper;
  }

  public List<IE> getAllIE(long userId) {
    return ieMapper.selectAllIE(userId);
  }

  public Integer getIncomeSum(long userId) {
    return ieMapper.selectIncomeSum(userId);
  }

  public Integer getExpenseSum(long userId) {
    return ieMapper.selectExpenseSum(userId);
  }
  
  public void insertIE(IE ie) {
    ieMapper.insertIE(ie);
  }
  public List<IE> getAllIEWithMusicCount(long userId){
        return ieMapper.selectAllIEWithMusicCount(userId);
  }

  public void deleteIEById(long ieId){
    ieMapper.deleteIEById(ieId);
  }
  
  public IE selectIEById(long ieId) {
    return ieMapper.selectIEById(ieId);
  }

  public void updateIE(IE ie) {
    ieMapper.updateIE(ie);
  }
}
