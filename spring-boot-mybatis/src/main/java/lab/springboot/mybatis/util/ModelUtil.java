package lab.springboot.mybatis.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.github.pagehelper.PageInfo;

public class ModelUtil {

	public static <T> T cast(Object o, Class<T> clazz) {
		if (o == null) {
			return null;
		}
		T t;
		try {
			t = clazz.newInstance();
			BeanUtils.copyProperties(o, t);
			return t;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("构建实体失败！");
		}
	}

	public static <T> Map<String, Object> toPage(PageInfo<T> pageInfo) {
		Map<String, Object> mapdata = new HashMap<String, Object>();
		mapdata.put("page", pageInfo.getPageNum());
		mapdata.put("records", pageInfo.getTotal());
		mapdata.put("total", pageInfo.getPages());
		mapdata.put("rows", pageInfo.getList());
		return mapdata;
	}
}
