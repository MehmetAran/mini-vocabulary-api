package vocabulary.model;

import java.util.List;

public class WordDetails {
	private String  word;
	private List<String> translates;
	private List<Sentence> sentences;
	private Voices voices;
	private List<String> imagesLinks;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public List<String> getTranslates() {
		return translates;
	}
	public void setTranslates(List<String> translates) {
		this.translates = translates;
	}
	public List<Sentence> getSentences() {
		return sentences;
	}
	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}
	public Voices getVoices() {
		return voices;
	}
	public void setVoices(Voices voices) {
		this.voices = voices;
	}
	public List<String> getImagesLinks() {
		return imagesLinks;
	}
	public void setImagesLinks(List<String> imagesLinks) {
		this.imagesLinks = imagesLinks;
	}
	@Override
	public String toString() {
		return "WordDetails [word=" + word + ", translates=" + translates + ", sentences=" + sentences + ", voices="
				+ voices + ", imagesLinks=" + imagesLinks + ", getWord()=" + getWord() + ", getTranslates()="
				+ getTranslates().toString() + ", getSentences()=" + getSentences().toString() + ", getVoices()=" + getVoices().toString()
				+ ", getImagesLinks()=" + getImagesLinks().toString() + "]";
	}
	
	
	
	
}
