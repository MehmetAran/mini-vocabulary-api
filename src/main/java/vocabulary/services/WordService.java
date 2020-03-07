package vocabulary.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import vocabulary.model.Sentence;
import vocabulary.model.Voices;
import vocabulary.model.WordDetails;

@Service
public interface WordService {
	public List<String> getTranslatesOfWord(String word) throws IOException;
	public Voices getVoicesOfWord(String word) throws IOException;
	public List<Sentence> getSentenceAboutWord(String word) throws IOException;
	public List<String> getImagesLinksByWord(String word) throws IOException;
	public WordDetails getWordDetails(String word) throws IOException;
}
