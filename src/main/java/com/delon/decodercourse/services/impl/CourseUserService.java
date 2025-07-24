package com.delon.decodercourse.services.impl;

import com.delon.decodercourse.repositories.CourseUserRepository;
import com.delon.decodercourse.services.iface.ICourseUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseUserService implements ICourseUserService {

    private final CourseUserRepository courseUserRepository;
}
