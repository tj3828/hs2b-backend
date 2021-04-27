package com.hs2b.backend.Repository;

import com.hs2b.backend.Entity.ListTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListsRepository extends JpaRepository<ListTest, Integer> {
}
