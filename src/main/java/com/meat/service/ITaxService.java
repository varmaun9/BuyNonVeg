package com.meat.service;

import com.meat.domain.Tax;

import java.util.List;

public interface ITaxService {

    Tax create(Tax tax);

    void deleteTax(String taxId);

    List<Tax> getAll();

    Tax getTax(String taxId);

    Tax updateTax(Tax tax);

}
