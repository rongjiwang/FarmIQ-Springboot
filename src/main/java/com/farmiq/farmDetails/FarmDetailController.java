package com.farmiq.farmDetails;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FarmDetailController {
    private FarmDetailRepository repository;

    public FarmDetailController(FarmDetailRepository repository) {
        this.repository = repository;
    }


    /* public void home(Model model) {
         if (!model.containsAttribute("farmList")) {
             System.out.println("Should Not Be Here");
             model.addAttribute("farmList", repository.findAll());
         }
     }*/
    //delete later- this comment
    @GetMapping("/farms")
    @CrossOrigin(origins = {"http://localhost:8000", "http://localhost:4200", "http://192.168.1.70:4200", "172.20.10.4:4200"})
    public Collection<Map<String, String>> farmdetails() {

        return repository.findAll().stream().map(
                b -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("geometry", b.getGeometry().toString());
                    m.put("id", b.getId().toString());
                    m.put("unitsHa", String.valueOf(b.getUnitsHa()));
                    m.put("calciumValue", String.valueOf(b.getCalciumValue()));
                    m.put("calciumPerHa", String.valueOf(b.getCalciumPerHa()));
                    m.put("sulfurValue", String.valueOf(b.getSulfurValue()));
                    m.put("sulfurPerHa", String.valueOf(b.getSulfurPerHa()));
                    m.put("NitrogenValue", String.valueOf(b.getNitrogenValue()));
                    m.put("NitrogenPerHa", String.valueOf(b.getNitrogenPerHa()));
                    m.put("phosphorusValue", String.valueOf(b.getPhosphorusValue()));
                    m.put("phosphorusPerHa", String.valueOf(b.getPhosphorusPerHa()));
                    m.put("potassiumValue", String.valueOf(b.getPotassiumValue()));
                    m.put("potassiumPerHa", String.valueOf(b.getPotassiumPerHa()));
                    System.out.println("Requesting Data!~");
                   /* m.put("name", b.getName());
                    m.put("area", String.valueOf(b.getArea()));
                    m.put("regionId", String.valueOf(b.getRegionId()));*/
                    return m;
                }
        ).collect(Collectors.toList());
    }
}
