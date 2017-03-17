package com.thoughtworks;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krkrishn on 3/17/17.
 */
@RestController
public class SeedController {


    @RequestMapping("/seeds")
    public ResponseEntity<Map<String, String>> getSeeds() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("error", "not found");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(resultMap);
    }
}
