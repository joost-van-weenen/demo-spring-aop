package com.example.demo.ignite;

import com.example.demo.brug.BrugNotFoundException;
import com.example.demo.brug.BrugRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IgniteBrugRepository implements BrugRepository {
    private static Logger log = LoggerFactory.getLogger(IgniteBrugRepository.class);
    @Override
    public List<Brug> findAll() {
        log.warn("Find all bridges results in wrapped not found exception");
        throw new IgniteException("Wrapped in Ignite", new BrugNotFoundException("Not found"));
    }
}
