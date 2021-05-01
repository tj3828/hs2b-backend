package com.hs2b.backend.domain.list;

import com.hs2b.backend.domain.list.ListTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListsRepository extends JpaRepository<ListTest, Integer> {
}
