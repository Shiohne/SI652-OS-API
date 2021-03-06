package goingto.com.controller;

import goingto.com.model.interaction.Tip;
import goingto.com.resource.interaction.TipResource;
import goingto.com.resource.interaction.SaveTipResource;
import goingto.com.resource.converter.TipConverter;
import goingto.com.service.TipService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TipController {

    @Autowired
    TipService tipService;
    
    @Autowired
    TipConverter mapper;

    @ApiOperation("Return all Tips")
    @GetMapping("/tips")
    public ResponseEntity<List<TipResource>> getAllTips() {
        List<Tip> tips = new ArrayList<>();
        tips = tipService.getAllTips();
        var result = tips.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(result);

    }

    @ApiOperation("Return Tip by id")
    @GetMapping("/tips/{id}")
    public TipResource getTipById(@PathVariable(name = "id") Integer tipId) {
        return mapper.convertToResource(tipService.getTipById(tipId));
    }

    @ApiOperation("Create new Tip")
    @PostMapping("/tips")
    public TipResource createTip(@Valid @RequestBody SaveTipResource resource) {
        return mapper.convertToResource(tipService.createTip(mapper.convertToEntity(resource)));
    }
    @ApiOperation("Update existing Tip by id")
    @PutMapping("/tips/{id}")
    public TipResource updateTip(@PathVariable(name = "id") Integer tipId, @Valid @RequestBody SaveTipResource resource) {
        return mapper.convertToResource(tipService.updateTip(tipId, mapper.convertToEntity(resource)));
    }
    @ApiOperation("Delete existing Tip by id")
    @DeleteMapping("/tips/{id}")
    public ResponseEntity<?> deleteTip(@PathVariable(name = "id") Integer tipId) {
        return tipService.deleteTip(tipId);
    }
}
