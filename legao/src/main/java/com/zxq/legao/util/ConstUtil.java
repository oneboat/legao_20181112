package com.zxq.legao.util;

public class ConstUtil {
	//salt
	public final static String MD5_SALT = "a1b2c3d4e5";
	//每页显示的条数
	public final static Integer PAGESIZE = 1;
	//学生表默认展示字段名（对应数据库）
	public final static String[] DEFAULT_STUDENT_FIELDS_DB={"name","telphone","importanceGrade","schoolAreaID","sex","status","source","followID","birthday"};
	//学生表默认展示字段名（对应中文名）
	public final static String[] DEFAULT_STUDENT_FIELDS_ZH={"姓名","电话","重要程度","校区","性别","状态","来源","跟进人","生日"};
	//学生表全部字段名（对应数据库）
	public final static String[] STUDENT_FIELDS_DB={"nickName","name","parentRelat","parentName","telphone","weChatID","education","birthday","sex","createDate","sparePhone","markPeople","advisor","area","willDate","baseSituation","status","importanceGrade","source","teacherName","schoolAreaID","followID"};
	//学生表全部字段名（对应中文名）
	public final static String[] STUDENT_FIELDS_ZH={"昵称","姓名","家长关系","家长姓名","联系电话","微信","学历","生日","性别","录入日期","备用电话","市场人员","顾问","学员所属地区","期望时间","基本情况","状态","重要程度","来源","老师","校区","跟进"};


}
