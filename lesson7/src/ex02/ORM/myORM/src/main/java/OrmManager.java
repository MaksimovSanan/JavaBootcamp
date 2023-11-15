import annotations.OrmColumn;
import annotations.OrmColumnId;
import annotations.OrmEntity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrmManager {
    public void save(Object entity) {
        OrmEntity OrmEntityAnnotation;
        Class<?> targetClass = entity.getClass();
        if((OrmEntityAnnotation = targetClass.getAnnotation(OrmEntity.class)) == null) {
            throw new RuntimeException("Not OrmEntity class");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO ").append(OrmEntityAnnotation.table()).append("(");

        List<Field> ormColumns = new ArrayList<>();

        for(Field field: targetClass.getDeclaredFields()) {
            if(field.getAnnotation(OrmColumn.class) != null) {
                OrmColumn ormColumn = field.getAnnotation(OrmColumn.class);
                stringBuilder.append(ormColumn.name()).append(", ");
                ormColumns.add(field);
            }
            if(field.getAnnotation(OrmColumnId.class) != null) {
                stringBuilder.append(field.getName()).append(", ");
                ormColumns.add(field);
            }
        }
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());

        stringBuilder.append(") VALUES (");
        for(Field field: ormColumns) {
            field.setAccessible(true);

            try {
                Object value = field.get(entity);
                stringBuilder.append(formatValue(value)).append(", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length()).append(");");

        System.out.println(stringBuilder);
    }

    public void update(Object entity) {
        OrmEntity ormEntity;
        Class<?> targetClass = entity.getClass();
        if((ormEntity = targetClass.getAnnotation(OrmEntity.class)) == null) {
            throw new RuntimeException("Not OrmEntity class");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE ").append(ormEntity.table()).append(" SET ");
        Map<Field, String> ormColumns = new HashMap<>();
        Field primaryKeyField = null;

        for(Field field: targetClass.getDeclaredFields()) {
            if(field.getAnnotation(OrmColumn.class) != null) {
                OrmColumn ormColumn = field.getAnnotation(OrmColumn.class);
                ormColumns.put(field, ormColumn.name());
            }
            if(field.getAnnotation(OrmColumnId.class) != null) {
                primaryKeyField = field;
            }
        }
        for(Map.Entry<Field, String> entry: ormColumns.entrySet()) {
            stringBuilder.append(entry.getValue()).append(" = ");
            entry.getKey().setAccessible(true);
            try {
                stringBuilder.append(formatValue(entry.getKey().get(entity))).append(", ");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
        primaryKeyField.setAccessible(true);
        try {
            stringBuilder.append(" WHERE ").append(primaryKeyField.getName())
                    .append(" = ")
                    .append(formatValue(primaryKeyField.get(entity)))
                    .append(";");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuilder);
    }


//    public <T> T findById(Long id, Class<T> aClass) {
//
//    }

    private String formatValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
    }
}
