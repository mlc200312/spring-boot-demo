package lab.springboot.core.param;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.springframework.beans.BeanUtils;

@SuppressWarnings("serial")
public class Param<T> implements Serializable{
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public Param() {
		// 使用反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass(); // 获取当前new的对象的泛型的父类类型
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
	}

	public T param2model() {
		try {
			T t = clazz.newInstance();
			BeanUtils.copyProperties(this, t);
			return t;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("copy has error!");
		}
	}

}
