package com.delon.decodercourse.services.impl;

import com.delon.decodercourse.repositories.ModuleRepository;
import com.delon.decodercourse.services.ModuleService;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }
}
