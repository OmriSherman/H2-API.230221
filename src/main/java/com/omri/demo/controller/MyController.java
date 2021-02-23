package com.omri.demo.controller;

import com.omri.demo.model.Catalog;
import com.omri.demo.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private ICatalogService catalogService;

    @RequestMapping("/CATALOG")
    public List<Catalog> findCatalog() {
        return catalogService.GetCatalog();
    }

    @RequestMapping("/CATALOG/{inv_code}")
    public Catalog getById(@PathVariable long inv_code) {
        return catalogService.getItem(inv_code);
    }

}
