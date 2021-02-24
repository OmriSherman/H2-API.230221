package com.omri.demo.service;

import com.omri.demo.model.Catalog;
import java.util.List;

public interface ICatalogService {

    List<Catalog> GetCatalog();
    Catalog getItem(long item_no);
    Catalog changeQuan(char sign, int amount, long item_no);
    Catalog addItem(String name, int amount, int inv_code);
    Catalog deleteItem(long item_no);
}
