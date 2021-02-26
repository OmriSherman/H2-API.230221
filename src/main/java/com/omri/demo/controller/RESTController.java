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

    @PostMapping("/catalog/insert")
    public String insert(@RequestBody Catalog catalog) {
        catalogService.addItem(catalog.getName(),catalog.getAmount(), catalog.getInv_code());
        return (catalog.getName() + " has been added!");
    }
    //NOT WORKING
    @PostMapping("/catalog/{item_no}/{sign}/{amount}")
    public String changeQuantity(@PathVariable long item_no, @PathVariable char sign, @PathVariable int amount) {
        catalogService.changeQuan(item_no,sign,amount);
        return ("amount has been changed!");
    }

    @DeleteMapping("/catalog/{item_no}")
    public String deleteFromTable(@PathVariable long item_no) {
        catalogService.deleteItem(item_no);
        return "item number: " + item_no + "has been deleted from the table!";
    }

}
