package com.ebit.smartgst.utils;

import com.ebit.smartgst.model.Dept;
import com.ebit.smartgst.model.DeptDTO;

public class GstUtils {

	public static Dept deptMapper(DeptDTO deptDto) {
		Dept dept =  new Dept();
		dept.setName(deptDto.getName());
		return dept;
	}
}
