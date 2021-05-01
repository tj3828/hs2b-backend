package com.hs2b.backend.web.controller;

import com.hs2b.backend.domain.list.ListTest;
import com.hs2b.backend.domain.list.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    ListsRepository listsRepository;

    @GetMapping("/api/test")
    public List<ListTest> getValues() {
        return listsRepository.findAll();
    }

    @PostMapping("/api/value")
    public ListTest setValue(ListTest list) {
        return listsRepository.save(list);
    }

}
