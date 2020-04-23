package com.issc.dao;

import com.issc.entity.Apps;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppsRepository extends JpaRepository<Apps,Integer> {
    Apps findById(int id);
}
