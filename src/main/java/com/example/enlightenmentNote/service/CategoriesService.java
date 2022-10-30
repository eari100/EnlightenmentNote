package com.example.enlightenmentNote.service;

import com.example.enlightenmentNote.domain.categories.CategoriesRepo;
import com.example.enlightenmentNote.dto.CategoriesListResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoriesService {

    private final CategoriesRepo categoriesRepo;

    public List<CategoriesListResDto> findAll() {
        return categoriesRepo.findAll().stream()
                .map(CategoriesListResDto::new)
                .collect(Collectors.toList());
    }
}
