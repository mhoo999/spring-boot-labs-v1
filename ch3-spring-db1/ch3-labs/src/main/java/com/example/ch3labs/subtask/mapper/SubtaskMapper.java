package com.example.ch3labs.subtask.mapper;

import com.example.ch3labs.subtask.domain.Subtask;
import com.example.ch3labs.subtask.dto.SubtaskResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubtaskMapper {

    void save(Subtask subtask);
    List<Subtask> findByParentId(Long parentId);
    Subtask findById(Long id);
    void update(Subtask subtask);
    void delete(Long id);
}
