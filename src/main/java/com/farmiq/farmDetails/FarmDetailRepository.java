package com.farmiq.farmDetails;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface FarmDetailRepository extends JpaRepository<FarmDetail,Long> {
}
