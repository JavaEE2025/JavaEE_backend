package com.buaa.javahuikao.mapper;

/**
 * @Author: sxq
 * @Date: 2025/5/29 21:30
 * @Description:
 */

import com.buaa.javahuikao.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: StudentMapper
 * @Author: sxq
 * @Sate: 2025/5/29 21:30
 * @Description:
 */
@Mapper
public interface StudentMapper {
    List<StudentDTO> getStudentsByClassId(@Param("classId") int classId);
}