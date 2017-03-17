package com.thoughtworks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SeedController {

    private SeedRepository seedRepository;

    @Autowired
    public SeedController(SeedRepository seedRepository) {
        this.seedRepository = seedRepository;
    }

    @RequestMapping("/seeds")
    public ResponseEntity<Map<String, String>> getSeeds() {
        Map<String, String> resultMap = new HashMap<>();
        if (seedRepository.hasSeeds()) {
            resultMap.put("seeds", "some seeds");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(resultMap);
        } else {
            resultMap.put("error", "not found");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(resultMap);
        }
    }

}
