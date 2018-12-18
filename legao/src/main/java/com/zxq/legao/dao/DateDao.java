package com.zxq.legao.dao;

import com.zxq.legao.entity.po.DatePO;

public interface DateDao {
    DatePO selectDateByID(Integer dateID);
}
