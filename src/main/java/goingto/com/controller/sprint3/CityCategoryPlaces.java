package goingto.com.controller.sprint3;

import goingto.com.model.geographic.Category;
import goingto.com.model.geographic.Place;
import goingto.com.resource.converter.PlaceConverter;
import goingto.com.service.CategoryService;
import goingto.com.service.CityService;
import goingto.com.service.PlaceService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@ApiOperation("/Controller for CityPlaces")
@RequestMapping("/api")
public class CityCategoryPlaces {

    @Autowired
    CityService cityService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    PlaceService placeService;

    @Autowired
    PlaceConverter mapper;

    @ApiOperation("Return Places by Category and City id")
    @GetMapping("/categories/{categoryId}/cities/{cityId}/places")
    public ResponseEntity<List<Place>> getAllPlacesByCategoryId(@PathVariable(name = "categoryId") Integer categoryId, @PathVariable(name = "cityId") Integer cityId) {
        var places = placeService.getByCategoryIdAndCityId(categoryId,cityId);
        //var result = places.stream().map(mapper::convertToResource).collect(Collectors.toList());
        return ResponseEntity.ok(places);
    }
}
