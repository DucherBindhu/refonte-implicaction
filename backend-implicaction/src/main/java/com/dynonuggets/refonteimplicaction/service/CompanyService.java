package com.dynonuggets.refonteimplicaction.service;

import com.dynonuggets.refonteimplicaction.adapter.CompanyAdapter;
import com.dynonuggets.refonteimplicaction.dto.CompanyDto;
import com.dynonuggets.refonteimplicaction.model.Company;
import com.dynonuggets.refonteimplicaction.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyAdapter companyAdapter;

    /**
     * @return la liste paginée des entreprises
     */
    public Page<CompanyDto> getAll(Pageable pageable) {
        return companyRepository.findAll(pageable)
                .map(companyAdapter::toDto);
    }

    @Transactional
    public CompanyDto saveOrUpdateCompany(CompanyDto companyDto) {
        Company company = companyAdapter.toModel(companyDto);
        final Company saved = companyRepository.save(company);
        return companyAdapter.toDto(saved);
    }
}