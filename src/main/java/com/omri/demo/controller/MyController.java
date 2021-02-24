package com.omri.demo.controller;

import com.omri.demo.model.Catalog;
import com.omri.demo.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

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

    @PostMapping("/catalog")
    public List<Catalog> addItem(@PathVariable long item_no, @PathVariable String name,
                                 @PathVariable int amount, @PathVariable int inv_code) {
        return catalogService.GetCatalog();
    }

    @PutMapping("/catalog/{item_no}")
    public List<Catalog> changeQuan(@PathVariable char sign,
                                    @PathVariable int amount, @PathVariable int inv_code) {
        return catalogService.GetCatalog();
    }

    @DeleteMapping("/catalog/{item_no}")
    public List<Catalog> deleteItem(@PathVariable long item_no) {
        return catalogService.GetCatalog();
    }

}
