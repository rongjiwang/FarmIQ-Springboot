package com.farmiq.farmDetails;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FarmDetailController {
    private FarmDetailRepository repository;

    public FarmDetailController(FarmDetailRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/farmdetails")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Map<String, String>> farmdetails() {
        return repository.findAll().stream().map(
                b -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("id", b.getId().toString());
                    m.put("name", b.getName());
                    return m;
                }
        ).collect(Collectors.toList());
    }
}
