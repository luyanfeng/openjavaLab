package test.junit;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;
import org.luyanfeng.myblog.action.BasicAction;
import org.luyanfeng.myblog.entity.UserEntity;

public class ReflectionTest {
	
	@Test
	public void test(){
		BasicAction<UserEntity> obj = new BasicAction<UserEntity>();
		Type gs = obj.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)gs;
		Type type = pt.getActualTypeArguments()[0];
		Class entityClass = (Class)type;
		System.out.println(entityClass);
	}
}
