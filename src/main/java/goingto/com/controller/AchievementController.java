package goingto.com.controller;

import goingto.com.model.account.Achievement;
import goingto.com.resource.AchievementResource;
import goingto.com.resource.SaveAchievementResource;
import goingto.com.resource.converter.AchievementConverter;
import goingto.com.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AchievementController {
    @Autowired
    private AchievementConverter mapper;

    @Autowired
    private AchievementService achievementService;

    @GetMapping("/achievements")
    public ResponseEntity<List<Achievement>> getAllAchievements() {
        List<Achievement> achievements = new ArrayList<>();
        achievements = achievementService.getAllAchievements();
        return ResponseEntity.ok(achievements);

    }

    @GetMapping("/achievements/{id}")
    public AchievementResource getAchievementById(@PathVariable(name = "id") Integer achievementId) {
        return mapper.convertToResource(achievementService.getAchievementById(achievementId));
    }


    @PostMapping("/achievements")
    public AchievementResource createAchievement(@Valid @RequestBody SaveAchievementResource resource) {
        return mapper.convertToResource(achievementService.createAchievement(mapper.convertToEntity(resource)));
    }
    @PutMapping("/achievements/{id}")
    public AchievementResource updateAchievement(@PathVariable(name = "id") Integer achievementId, @Valid @RequestBody SaveAchievementResource resource) {
        return mapper.convertToResource(achievementService.updateAchievement(achievementId, mapper.convertToEntity(resource)));
    }

    @DeleteMapping("/achievements/{id}")
    public ResponseEntity<?> deleteAchievement(@PathVariable(name = "id") Integer achievementId) {
        return achievementService.deleteAchievement(achievementId);
    }


}
