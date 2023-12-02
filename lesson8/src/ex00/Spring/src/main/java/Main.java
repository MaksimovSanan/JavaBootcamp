import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import printer.PrinterWithPrefixImpl;

public class Main {
    public static void main(String[] args) {
//        PreProcessor preProcessor = new PreProcessorToUpperImpl();
//        Renderer renderer = new RendererErrImpl(preProcessor);
//        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
//        printer.setPrefix("Prefix");
//        printer.print("Hello!");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        PrinterWithPrefixImpl printer = applicationContext.getBean("printerWithPrefixImplToUpper", PrinterWithPrefixImpl.class);
        printer.setPrefix("prefix");
        printer.print("Hello!");
    }
}
