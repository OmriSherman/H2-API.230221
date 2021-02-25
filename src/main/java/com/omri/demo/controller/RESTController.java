package com.omri.demo.controller;

import com.omri.demo.model.Catalog;
import com.omri.demo.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    ICatalogService catalogService;

    @GetMapping("/catalog")
    public List<Catalog> findCatalog() {
        return catalogService.GetCatalog();
    }


    @GetMapping("/catalog/{item_no}")
    public Catalog getById(@PathVariable long item_no) {
        return catalogService.getItem(item_no);
    }

    @PutMapping("/catalog/{name},{amount},{inv_code}")
    public String insert(@PathVariable String name,
                                 @PathVariable int amount, @PathVariable int inv_code) {
        catalogService.addItem(name,amount,inv_code);
        return "{name} has been added!";
    }

    @PutMapping("/catalog/{item_no}")
    public List<Catalog> changeQuan(@PathVariable char sign,
                                    @PathVariable int amount, @PathVariable int inv_code) {
        return catalogService.GetCatalog();
    }

    @DeleteMapping("/catalog/{item_no}")
    public String deleteFromTable(@PathVariable long item_no) {
        catalogService.deleteItem(item_no);
        return "item number {item_no} has been deleted!";
    }

}
