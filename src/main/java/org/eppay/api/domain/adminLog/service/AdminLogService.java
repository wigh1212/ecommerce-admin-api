package org.eppay.api.domain.adminLog.service;


import lombok.RequiredArgsConstructor;
import org.eppay.api.domain.adminLog.model.AdminLogDto;
import org.eppay.api.domain.adminLog.repository.AdminLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminLogService {
    private final AdminLogRepository repository;
    public List<AdminLogDto.Response> getList() throws Exception{
        return repository.findAll().stream().map(AdminLogDto.Response::fromEntity).collect(Collectors.toList());
    }
}