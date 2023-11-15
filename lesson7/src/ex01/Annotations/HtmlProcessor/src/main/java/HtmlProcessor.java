import annotation.HtmlForm;
import annotation.HtmlInput;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes({"annotation.HtmlForm", "annotation.HtmlInput"})
@SupportedSourceVersion(value = SourceVersion.RELEASE_8)
public class HtmlProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Elements elementUtils = processingEnv.getElementUtils();

        for (Element element : roundEnv.getElementsAnnotatedWith(HtmlForm.class)) {
            if (element.getKind() == ElementKind.CLASS) {
                TypeElement typeElement = (TypeElement) element;
                HtmlForm htmlFormAnnotation = typeElement.getAnnotation(HtmlForm.class);
                String fileName = htmlFormAnnotation.fileName();
                String action = htmlFormAnnotation.action();
                String method = htmlFormAnnotation.method();
                try {
                    generateHtmlFile(fileName, action, method, typeElement);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    private void generateHtmlFile(String fileName, String action, String method, TypeElement typeElement) throws IOException {
        Filer filer = processingEnv.getFiler();
        FileObject fileObject = filer.createResource(StandardLocation.CLASS_OUTPUT, "", fileName);
        try (OutputStream outputStream = fileObject.openOutputStream();
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            writer.write("<form action=\"" + action + "\" method=\"" + method + "\">");

            for (Element enclosedElement : typeElement.getEnclosedElements()) {
                if (enclosedElement.getKind() == ElementKind.FIELD) {
                    HtmlInput htmlInputAnnotation = enclosedElement.getAnnotation(HtmlInput.class);
                    if (htmlInputAnnotation != null) {
                        String inputType = htmlInputAnnotation.type();
                        String inputName = htmlInputAnnotation.name();
                        String placeholder = htmlInputAnnotation.placeholder();
                        writer.write("\n\t<input type=\"" + inputType + "\" name=\"" + inputName +
                                "\" placeholder=\"" + placeholder + "\">");
                    }
                }
            }

            writer.write("\n\t<input type=\"submit\" value=\"Send\">");
            writer.write("\n</form>");
        }
    }
}
