package goingto.com.controller;

import goingto.com.model.geographic.Locatable;
import goingto.com.service.LocatableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LocatableController {

    @Autowired
    private LocatableService locatableService;

    @GetMapping("/locatables")
    public ResponseEntity<List<Locatable>> listLocatable(){
        List<Locatable> locatables = new ArrayList<>();

        locatables = locatableService.listAllLocatables();
        if(locatables.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(locatables);
    }

    @GetMapping("/locatables/{id}")
    public ResponseEntity<Locatable>getById(@PathVariable Integer id)
    {
        Locatable locatable = locatableService.getLocatable(id);
        if(locatable ==null)
            return ResponseEntity.notFound().build();
        else
            return (ResponseEntity.ok(locatable));
    }

}
