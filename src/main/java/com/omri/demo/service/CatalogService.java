package com.omri.demo.service;

import com.omri.demo.model.Catalog;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.DayOfWeek;
import java.util.List;

@Service
public class CatalogService implements ICatalogService {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Catalog> GetCatalog() {
        String sql = "SELECT * FROM CATALOG";
        return jtm.query(sql, new BeanPropertyRowMapper<>(Catalog.class));
    }

    @Override
    public Catalog getItem(long item_no) {
        String sql = "SELECT * FROM CATALOG " + " WHERE item_no = ?";
        return jtm.queryForObject(sql, new Object[]{item_no},
                new BeanPropertyRowMapper<>(Catalog.class));
    }

   @Override
    public int changeQuan(char sign, int amount, long item_no) {
        String sql = "UPDATE CATALOG " + " SET amount = (amount ? ?)" + " WHERE item_no=?";
        return jtm.update(sql, new Object[]{sign,amount,item_no},
                new BeanPropertyRowMapper<>(Catalog.class));
    }


    public int addItem(String name, int amount, int inv_code) {
        return jtm.update("INSERT INTO CATALOG (name, amount, inv_code) " + "VALUES (?, ?, ?)",
                new Object[]{name, amount, inv_code});

    }

    @Override
    public int deleteItem(long item_no) {
        return jtm.update("DELETE FROM CATALOG WHERE item_no=?", new Object[] {item_no});
    }
}
