import annotations.OrmColumn;
import annotations.OrmColumnId;
import annotations.OrmEntity;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import java.util.Set;


@AutoService(Processor.class)
@SupportedAnnotationTypes({"annotations.OrmEntity", "annotations.OrmColumnId", "annotations.OrmColumn"})
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class ORMProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for(Element element: roundEnv.getElementsAnnotatedWith(OrmEntity.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                TypeElement typeElement = (TypeElement) element;
                OrmEntity OrmEntityAnnotation = typeElement.getAnnotation(OrmEntity.class);
                String tableName = OrmEntityAnnotation.table();
                System.out.println("DROP TABLE IF EXISTS " + tableName);

                createTable(tableName, typeElement);
            }
        }
        return true;
    }

    private void createTable(String tableName, TypeElement typeElement) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE IF NOT EXISTS\n").append(tableName).append("(\n");
        for (Element enclosedElement : typeElement.getEnclosedElements()) {
            if (enclosedElement.getKind() == ElementKind.FIELD) {
                OrmColumn OrmColumnAnnotation = enclosedElement.getAnnotation(OrmColumn.class);
                OrmColumnId OrmColumnIdAnnotation = enclosedElement.getAnnotation(OrmColumnId.class);
                if (OrmColumnIdAnnotation != null) {
                    stringBuilder.append(enclosedElement.getSimpleName()).append(" SERIAL PRIMARY KEY,\n");
                }
                else if(OrmColumnAnnotation != null) {
                    stringBuilder.append(OrmColumnAnnotation.name()).append(" ");

                    String sqlType = getSqlType(enclosedElement.asType());
                    stringBuilder.append(sqlType);

                    if(OrmColumnAnnotation.length() != -1) {
                        stringBuilder.append("(").append(OrmColumnAnnotation.length()).append(")");
                    }
                    stringBuilder.append(",\n");
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        stringBuilder.append(");");
        System.out.println(stringBuilder.toString());
    }

    public static String getSqlType(TypeMirror typeMirror) {
        String javaType = typeMirror.toString();
        switch (javaType) {
            case "java.lang.String":
                return "VARCHAR";
            case "java.lang.Integer":
                return "INT";
            case "java.lang.Double":
                return "DOUBLE";
            case "java.lang.Boolean":
                return "BOOLEAN";
            case "java.lang.Long":
                return "BIGINT";
            default:
                return "UNKNOWN";
        }
    }
}
