package com.meat.service;

import com.meat.domain.Seo;

import java.util.List;

public interface ISeoService {

    Seo create(Seo seo);

    void deleteSeo(String seoId);

    List<Seo> getAll();

    Seo getSeo(String seoId);

    Seo updateSeo(Seo seo);

}
