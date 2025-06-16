package com.example.music_management.service;

import com.example.music_management.entity.IE;
import com.example.music_management.form.IEForm;
import com.example.music_management.repository.IERepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IEService {
  private final IERepository ieRepository;

  public IEService(IERepository ieRepository) {
    this.ieRepository = ieRepository;
  }

  public List<IE> getAllIE(long userId) {
    return ieRepository.getAllIE(userId);
  }

  public Integer getIncomeSum(long userId) {
    return ieRepository.getIncomeSum(userId);
  }

  public Integer getExpenseSum(long userId) {
    return ieRepository.getExpenseSum(userId);
  }

  public void createIE(IEForm ieForm, long userId) {
    IE ie = new IE();

    ie.setType(ieForm.getType());
    ie.setAmount(ieForm.getAmount());
    ie.setCategory(ieForm.getCategory());
    ie.setUserId(userId);

    ieRepository.insertIE(ie);
  }
  public List<IE> getAllIEWithMusicCount(long userId) {
	 return ieRepository.getAllIEWithMusicCount(userId);
  }
}
