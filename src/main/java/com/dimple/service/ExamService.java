package com.dimple.service;

import com.dimple.entity.Exam;

import java.util.List;

/**
 * 试卷表(Exam)表服务接口
 *
 * @author makejava
 * @since 2019-05-01 11:39:00
 */
public interface ExamService {

    /**
     * 通过ID查询单条数据
     *
     * @param examId 主键
     * @return 实例对象
     */
    Exam queryById(Integer examId);

    /**
     * 新增数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    int insert(Exam exam);

    /**
     * 修改数据
     *
     * @param exam 实例对象
     * @return 实例对象
     */
    int update(Exam exam);

    /**
     * 通过主键删除数据
     *
     * @param examId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer examId);

    int deleteByIds(String ids);

    /**
     * 批量获取exam
     *
     * @param exam exam条件
     * @return
     */
    List<Exam> findExamList(Exam exam);

}