package ru.ksergey.container;

import java.util.HashMap;

public class IoCContainer {
    private HashMap<Class<?>, Class<?>> registerTypes = new HashMap<>();

    public <TypeInterface, TypeImplementation> void register(
            Class<TypeInterface> interfaceType,
            Class<TypeImplementation> typeImplementationType
    ) {
        registerTypes.put(interfaceType, typeImplementationType);
    }

    public <TypeInterface> TypeInterface resolve(Class<TypeInterface> interfaceType)
            throws Exception {
        Class<?> implementationType = registerTypes.get(interfaceType);

        if (implementationType != null) {
            try {
                TypeInterface result = interfaceType.cast(implementationType
                        .getDeclaredConstructor()
                        .newInstance());

                return result;
            } catch (Exception e) {
                throw new Exception("Что-то пошло не так при создании экземпляра "
                        + implementationType.getName()
                );
            }
        }
        throw new RuntimeException("Тип " + interfaceType.getName() + " не найден");
    }


}
