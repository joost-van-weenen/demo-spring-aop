package com.example.demo.brug;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RequestMapping("/bruggen")
@RestController
public class BrugController {
    final BrugRepository brugRepo;

    public BrugController(@NonNull BrugRepository brugRepo) {
        this.brugRepo = Objects.requireNonNull(brugRepo);
    }

    @GetMapping
    public List<BrugRepository.Brug> findAll() {
        return brugRepo.findAll();
    }
}
