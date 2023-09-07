package com.house.repository;

import com.house.entity.HouseHoldEntitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseHoldRepository extends JpaRepository<HouseHoldEntitty, Integer> {
}
