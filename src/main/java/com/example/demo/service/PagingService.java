package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.PagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PagingService {

    private final PagingRepository pagingRepository;

    @Autowired
    public PagingService(PagingRepository pagingRepository) {
        this.pagingRepository = pagingRepository;
    }

    public Page<Customer> getData(Integer page, Integer perPage, Sort.Direction orderBy, String sort) {
        return pagingRepository.findAll(genPageRequest(page, perPage, orderBy, sort));
    }

    private PageRequest genPageRequest(Integer page, Integer perPage, Sort.Direction orderBy, String sort) {
        return PageRequest.of(page - 1, perPage, new Sort(orderBy, sort));
    }

}