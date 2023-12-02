package preProcessor;

public class PreProcessorToUpperImpl implements PreProcessor{
    @Override
    public String preProcessing(String message) {
        return message.toUpperCase();
    }
}
