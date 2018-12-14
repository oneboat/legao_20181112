package com.zxq.legao.service;


import com.zxq.legao.entity.po.ClassRoomPO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dengzhenxiang
 * @since 2018-11-27
 */
public interface ClassRoomService {
    int insertClassRoom(ClassRoomPO classRoomPO);

    int deleteClassRoom(List<Integer> classRoomIDs);

    int updateClassRoom(ClassRoomPO classRoomPO);

    String selectClassRoom(Integer page, ClassRoomPO classRoomPO, HttpServletRequest request);

    ClassRoomPO selectClassRoomByID(Integer classRoomID);

    List<ClassRoomPO> findAllClassRoomName();
}
