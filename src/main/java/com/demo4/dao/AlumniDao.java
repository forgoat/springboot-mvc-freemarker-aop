package com.demo4.dao;

import com.demo4.entity.Alumni;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlumniDao {
    public int saveAlumni(Alumni alumni);
    public List<Alumni> findAll();
    public int delete(Integer id);
    public int updateInfo(@Param("id")Integer id,@Param("graduatedYear")String graduatedYear,@Param("workingArea")String workingArea,@Param("position")String position);
}
