package com.fanvox.service;

import com.fanvox.db.entitiy.Studio;
import com.fanvox.db.repository.StudioRepository;
import org.springframework.stereotype.Service;

@Service
public class StudioService {
    private final StudioRepository studioRepository;

    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    public String createStudio(String name) {
        Studio studio = new Studio();
        studio.setName(name);
        studioRepository.save(studio);
        return "Studio created";
    }

    public Iterable<Studio> getAllStudios() {
        return studioRepository.findAll();
    }

    public String deleteStudio(Long id) {
        studioRepository.deleteById(id);
        return "Studio is deleted";
    }
}
