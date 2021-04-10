//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.ibatis.reflection.factory;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.apache.ibatis.reflection.ReflectionException;
import org.apache.ibatis.reflection.Reflector;

public class DefaultObjectFactory implements ObjectFactory, Serializable {
  private static final long serialVersionUID = -8855120656740914948L;

  public DefaultObjectFactory() {
  }

  public <T> T create(Class<T> type) {
    return this.create(type, (List)null, (List)null);
  }

  public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
    Class<?> classToCreate = this.resolveInterface(type);
    return this.instantiateClass(classToCreate, constructorArgTypes, constructorArgs);
  }

  public void setProperties(Properties properties) {
  }

  private <T> T instantiateClass(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
    try {
      Constructor constructor;
      if (constructorArgTypes != null && constructorArgs != null) {
        constructor = type.getDeclaredConstructor((Class[])constructorArgTypes.toArray(new Class[constructorArgTypes.size()]));

        try {
          return constructor.newInstance(constructorArgs.toArray(new Object[constructorArgs.size()]));
        } catch (IllegalAccessException var7) {
          if (Reflector.canControlMemberAccessible()) {
            constructor.setAccessible(true);
            return constructor.newInstance(constructorArgs.toArray(new Object[constructorArgs.size()]));
          } else {
            throw var7;
          }
        }
      } else {
        constructor = type.getDeclaredConstructor();

        try {
          return constructor.newInstance();
        } catch (IllegalAccessException var8) {
          if (Reflector.canControlMemberAccessible()) {
            constructor.setAccessible(true);
            return constructor.newInstance();
          } else {
            throw var8;
          }
        }
      }
    } catch (Exception var9) {
      String argTypes = (String)((List)Optional.ofNullable(constructorArgTypes).orElseGet(Collections::emptyList)).stream().map(Class::getSimpleName).collect(Collectors.joining(","));
      String argValues = (String)((List)Optional.ofNullable(constructorArgs).orElseGet(Collections::emptyList)).stream().map(String::valueOf).collect(Collectors.joining(","));
      throw new ReflectionException("Error instantiating " + type + " with invalid types (" + argTypes + ") or values (" + argValues + "). Cause: " + var9, var9);
    }
  }

  protected Class<?> resolveInterface(Class<?> type) {
    Class classToCreate;
    if (type != List.class && type != Collection.class && type != Iterable.class) {
      if (type == Map.class) {
        classToCreate = HashMap.class;
      } else if (type == SortedSet.class) {
        classToCreate = TreeSet.class;
      } else if (type == Set.class) {
        classToCreate = HashSet.class;
      } else {
        classToCreate = type;
      }
    } else {
      classToCreate = ArrayList.class;
    }

    return classToCreate;
  }

  public <T> boolean isCollection(Class<T> type) {
    return Collection.class.isAssignableFrom(type);
  }
}
