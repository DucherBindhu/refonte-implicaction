package com.dynonuggets.refonteimplicaction.controller;

import com.dynonuggets.refonteimplicaction.dto.CompanyDto;
import com.dynonuggets.refonteimplicaction.exception.ImplicactionException;
import com.dynonuggets.refonteimplicaction.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {


    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<Page<CompanyDto>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = "ASC") String sortOrder
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(sortOrder), sortBy));
        Page<CompanyDto> companyDtos = companyService.getAll(pageable);
        return ResponseEntity.ok(companyDtos);
    }

    @PostMapping
    public ResponseEntity<CompanyDto> create(@RequestBody CompanyDto companyDto) throws ImplicactionException {
        CompanyDto companyCreated = companyService.saveOrUpdateCompany(companyDto);
        return ResponseEntity.ok(companyCreated);
    }

    @PutMapping
    public ResponseEntity<CompanyDto> update(@RequestBody CompanyDto companyDto) throws ImplicactionException {
        CompanyDto companyCreated = companyService.saveOrUpdateCompany(companyDto);
        return ResponseEntity.ok(companyCreated);
    }
}
