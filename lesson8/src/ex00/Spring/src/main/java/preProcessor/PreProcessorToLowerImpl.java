package preProcessor;

public class PreProcessorToLowerImpl implements PreProcessor{
    @Override
    public String preProcessing(String message) {
        return message.toLowerCase();
    }
}
