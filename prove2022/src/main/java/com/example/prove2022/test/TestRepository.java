package com.example.prove2022.test;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestRepository {
//    List<TestDTO> getTestDTOLIst(String id);
    List<TestDTO> getTestDTOLIst(TestDTO param);
}
