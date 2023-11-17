package ml_model;


import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MessageClassifier {

    private DocumentCategorizerME categorizer;

    public MessageClassifier(String modelPath) throws IOException {
        InputStream modelIn = new FileInputStream(modelPath);
        categorizer = new DocumentCategorizerME(new DoccatModel(modelIn));
        modelIn.close();
        
    }

    // Метод для обучения модели на основе предоставленных данных
    public void trainModel(String trainingDataPath, String modelPath) throws IOException {
        ObjectStream<String> lineStream = new PlainTextByLineStream(() ->
                getClass().getResourceAsStream(trainingDataPath), "UTF-8");
        ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

        TrainingParameters params = new TrainingParameters();
        params.put(TrainingParameters.ITERATIONS_PARAM, 100);
        params.put(TrainingParameters.CUTOFF_PARAM, 5);

        DoccatModel model = DocumentCategorizerME.train("ru", sampleStream, params, null);
        OutputStream modelOut = new FileOutputStream(modelPath);
        model.serialize(modelOut);
        modelOut.close();
    }

    // Метод для предсказания категории и важности нового сообщения
    public void predict(String message) {
        String[] messages = new String[]{message}; // Обернем строку в массив строк
        double[] outcome = categorizer.categorize(messages);
        String category = categorizer.getBestCategory(outcome);

        System.out.println("Predicted Category: " + category);
    }
    
    
    public static void main(String[] args) throws IOException {
        MessageClassifier classifier = new MessageClassifier("path/to/your/model.bin");

        
        // classifier.trainModel("/path/to/training/data.txt", "path/to/your/model.bin");

        // Пример использования модели для предсказания категории нового сообщения
        classifier.predict("Добрый день, у меня пропали бонусы за покупки в категории \"рестораны\". Как восстановить утерянные бонусы?");
    }
    
}
