package com.zxq.legao.dao;


import com.zxq.legao.entity.po.DocPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DocDao {
	int insertDoc(DocPO docPO);

	int deleteDoc(List<Integer> docIDs);

	int updateDoc(DocPO docPO);

	List<DocPO> selectDoc(DocPO docPO);

	DocPO selectDocByID(DocPO docPO);
}
