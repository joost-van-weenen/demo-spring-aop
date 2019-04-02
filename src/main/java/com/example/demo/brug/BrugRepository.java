package com.example.demo.brug;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public interface BrugRepository {
    class Brug {

        private String id;
        @JsonCreator
        public Brug(String id) {
            this.id = id;
        }

    }

    List<Brug> findAll();
}
