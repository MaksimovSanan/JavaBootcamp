package renderer;

import preProcessor.PreProcessor;

public class RendererStandardImpl implements Renderer{

    private final PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

    @Override
    public void rendering(String message) {
        System.out.println(preProcessor.preProcessing(message));
    }
}
