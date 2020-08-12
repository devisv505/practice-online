package com.devisv.practice.online.service;

import com.devisv.practice.online.model.Practice;
import com.devisv.practice.online.repository.PracticeRepository;
import org.springframework.stereotype.Service;

@Service
public class PracticeService {

  private final PracticeRepository practiceRepository;

  public PracticeService(PracticeRepository practiceRepository) {
    this.practiceRepository = practiceRepository;
  }

  public void create(Practice practice) {
    practiceRepository.create(practice);
  }

  public void update(Practice practice) {
    practiceRepository.update(practice);
  }
}
