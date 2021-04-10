import org.apache.ibatis.reflection.TypeParameterResolver;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class TypeTest {

  public class A<K, V> {

    public Map<K, V> map;
  }

  public class SubA<T> extends A<T, T> {

  }

  public class TestType {

    private SubA<Long> subA;
  }

  @Test
  public void testParameterizedType() throws NoSuchFieldException {
    Field subA = TestType.class.getDeclaredField("subA");
    System.out.println(subA.getGenericType());
    System.out.println(subA.getGenericType() instanceof ParameterizedType);
    Type type = TypeParameterResolver.resolveFieldType(subA,
        ParameterizedTypeImpl.make(SubA.class, new Type[]{Long.class}, TestType.class));
    //TypeParameterResolver.resolveFieldType(subA, TestType.class.getField("subA").getGenericType());
    System.out.println(type.getClass());
    ParameterizedType parameterizedType = (ParameterizedType) type;
    System.out.println(parameterizedType.getRawType());
    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
    for (Type actualTypeArgument : actualTypeArguments) {
      System.out.println("actualTypeArgument:" + actualTypeArgument);
    }

    System.out.println(parameterizedType.getOwnerType());
  }
}
