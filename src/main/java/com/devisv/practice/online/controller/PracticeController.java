package com.devisv.practice.online.controller;

import com.devisv.practice.online.model.Practice;
import com.devisv.practice.online.service.PracticeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practice")
public class PracticeController {

  private final PracticeService practiceService;

  public PracticeController(PracticeService practiceService) {
    this.practiceService = practiceService;
  }

  @PostMapping
  public Practice create(@RequestBody Practice practice) {
    practiceService.create(practice);
    return practice;
  }

  @PutMapping
  public void update(@RequestBody Practice practice) {
    practiceService.update(practice);
  }
}
