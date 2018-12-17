package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.PagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagingService {

    private final PagingRepository pagingRepository;

    @Autowired
    public PagingService(PagingRepository pagingRepository) {
        this.pagingRepository = pagingRepository;
    }

    public Page<Customer> getData(Integer page, Integer perPage, Sort.Direction orderBy, String sort) {
        PageRequest pageRequest = PageRequest.of(page, perPage, orderBy, sort);

        List<Customer> customerList = pagingRepository.findAll();

        int start = (page-1) * perPage;
        int end = start+perPage;
        System.out.println("start:" + start + ", end:" + end);

        Page<Customer> response = new PageImpl<>(customerList.subList(start, end), pageRequest, customerList.size());

        return response;
    }

}
