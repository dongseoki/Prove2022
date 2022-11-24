package com.example.prove2022.test;

import com.himart.arcus.aop.ArcusCache;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TestRepository {
//    List<TestDTO> getTestDTOLIst(String id);
    List<TestDTO> getTestDTOLIst(TestDTO param);

    @ArcusCache(prefix = "testPrefix")
    List<TestDTO> getTestDTOListAnnotationTest(TestDTO param);
}
