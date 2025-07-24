package com.springboot21.demo.repository;

import com.springboot21.demo.entity.AssetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetStatusRepository extends JpaRepository<AssetStatus,Long> {

}
