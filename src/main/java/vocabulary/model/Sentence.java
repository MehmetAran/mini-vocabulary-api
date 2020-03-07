package vocabulary.model;

public class Sentence {
	private String englishSentence;
	private String turkishSentence;
	public String getEnglishSentence() {
		return englishSentence;
	}
	public void setEnglishSentence(String englishSentence) {
		this.englishSentence = englishSentence;
	}
	public String getTurkishSentence() {
		return turkishSentence;
	}
	public void setTurkishSentence(String turkishSentence) {
		this.turkishSentence = turkishSentence;
	}
	@Override
	public String toString() {
		return "Sentence [englishSentence=" + englishSentence + ", turkishSentence=" + turkishSentence
				+ ", getEnglishSentence()=" + getEnglishSentence() + ", getTurkishSentence()=" + getTurkishSentence()
				+ "]";
	}
	
	
}
