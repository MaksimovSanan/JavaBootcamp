package app;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Class<?> targetClass = greet();

        printFieldsAndMethods(targetClass);
        System.out.println("---------------------");

        System.out.println("Let’s create an object.");
        Object targetObject = createObject(targetClass);
        System.out.println("Object created: " + targetObject);
        System.out.println("---------------------");

        changeField(targetObject);
        System.out.println("Object updated: " + targetObject);
        System.out.println("---------------------");

        callMethod(targetObject);

    }

    private static Class<?> greet() {
        System.out.println("Classes:");
        System.out.println("  - User");
        System.out.println("  - Car");
        System.out.println("---------------------");
        System.out.println("Enter class name:");
        String className = scanner.nextLine();
        System.out.println("---------------------");

        Class<?> targetClass = null;
        try {
            targetClass = Class.forName("models." + className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return targetClass;
    }

    private static void printFieldsAndMethods(Class<?> targetClass) {
        System.out.println("fields:");
        for(Field field: targetClass.getDeclaredFields()) {
            System.out.println("\t" + field.getType().getSimpleName() + " " + field.getName());
        }
        System.out.println("methods:");
        for(Method method: targetClass.getDeclaredMethods()) {
            System.out.print("\t" + method.getReturnType().getSimpleName() + " " + method.getName() + "(");
            Parameter[] parameters = method.getParameters();
            for(int i = 0; i < parameters.length; ++i) {
                System.out.print(parameters[i].getType().getSimpleName());
                if(i < parameters.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println(")");
        }
    }
    private static Object createObject(Class<?> targetClass) {
        Object targetObject = null;
        try {
            targetObject = targetClass.newInstance();
            for (Field field : targetObject.getClass().getDeclaredFields()) {
                System.out.println(field.getName() + ":\n" + "-> ");
                String value = scanner.nextLine();
                Class<?> classOfType = field.getType();
                setValueToField(value, field, targetObject);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return targetObject;
    }

    private static void changeField(Object targetObject){
            System.out.println("Enter name of the field for changing:");
            System.out.print("-> ");
            String fieldToChange = scanner.nextLine();
        try {
            Field field = targetObject.getClass().getDeclaredField(fieldToChange);
            System.out.println("Enter String value:");
            System.out.print("-> ");
            String value = scanner.nextLine();
            setValueToField(value, field, targetObject);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private static void callMethod(Object targetObject) {
        System.out.println("Enter name of the method for call:");
        System.out.print("-> ");
        String method = scanner.nextLine();
        String methodName = method.substring(0, method.indexOf('('));
        String[] methodParameters = method.substring(method.indexOf('(') + 1, method.indexOf(')')).split(",");
        if(methodParameters[0].equals("")) {
            methodParameters = new String[0];
        }

//        Class<?> parameters[] = new Class[]{};
//         kak-to zabivat Class<?> parameters[] cherez parser dly String
//
//        Method targetMethod = null;
//        try {
//            targetMethod = targetObject.getClass().getDeclaredMethod("grow", parameters);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }
//        Object[] args = new Object[parameters.length];

        Method targetMethod = myGetDeclaredMethod(targetObject, methodName, methodParameters);

        Object[] args = new Object[methodParameters.length];
        for(int i = 0; i < methodParameters.length; ++i) {
            System.out.println("Enter " + methodParameters[i] + " value");
            System.out.print("-> ");
            String value = scanner.nextLine();
            if (methodParameters[i].equals("Integer")) {
                args[i] = Integer.parseInt(value);
            } else if (methodParameters[i].equals("String")) {
                args[i] = value;
            }
        }

        targetMethod.setAccessible(true);
        Object result = null;
        try {
            if(methodParameters.length > 0) {
                result = targetMethod.invoke(targetObject, args);
            }
            else {
                result = targetMethod.invoke(targetObject);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        if(result != null) {
            System.out.println("Method returned:");
            System.out.println(result);
        }
    }

    private static void setValueToField(String value, Field field, Object targetObject) {
        try {
            field.setAccessible(true);
            Class<?> classOfType = field.getType();
            if (classOfType == Integer.class) {
                field.set(targetObject, Integer.parseInt(value));
            } else if (classOfType == String.class) {
                field.set(targetObject, value);
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Method myGetDeclaredMethod(Object targetObject, String methodName, String[] methodParameters) {
        Method targetMethod = null;
        Method[] methods = targetObject.getClass().getDeclaredMethods();
        for(Method anotherOneMethod: methods) {
            if(anotherOneMethod.getName().equals(methodName)) {
                Parameter[] parameters = anotherOneMethod.getParameters();
                if(Arrays.equals(methodParameters, Arrays.stream(parameters).map(parameter-> parameter.getType().getSimpleName()).toArray())){
                    targetMethod = anotherOneMethod;
                    break;
                }
            }
        }
        return targetMethod;
    }
}
