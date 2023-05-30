package com.fanvox.controller;

import com.fanvox.db.entitiy.Studio;
import com.fanvox.service.StudioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/studio")
public class StudioController {
    private final StudioService studioService;

    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    @GetMapping("/all")
    public Iterable<Studio> getAllStudios() {
        return studioService.getAllStudios();
    }

    @PostMapping("/add")
    public String addNewStudio(@RequestParam String name) {
        return studioService.createStudio(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudio(@PathVariable Long id) {
        return studioService.deleteStudio(id);
    }
}
