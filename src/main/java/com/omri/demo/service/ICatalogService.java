package com.omri.demo.service;

import com.omri.demo.model.Catalog;
import java.util.List;

public interface ICatalogService {

    List<Catalog> GetCatalog();
    Catalog getItem(long item_no);
    int changeQuan(long item_no, char sign, int amount);
    int addItem(String name, int amount, int inv_code);
    int deleteItem(long item_no);
}
