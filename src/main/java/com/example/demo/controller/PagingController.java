package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "paging")
public class PagingController {

    private final PagingService pagingService;

    @Autowired
    public PagingController(PagingService pagingService) {
        this.pagingService = pagingService;
    }

    @GetMapping
    public Page<Customer> getData(@RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
                                  @RequestParam(value = "perPage", defaultValue = "3", required = false) Integer perPage,
                                  @RequestParam(value = "orderBy", defaultValue = "ASC", required = false) Sort.Direction orderBy,
                                  @RequestParam(value = "sort", defaultValue = "id", required = false) String sort) {
        Page<Customer> response = pagingService.getData(page, perPage, orderBy, sort);
        return response;
    }

}
