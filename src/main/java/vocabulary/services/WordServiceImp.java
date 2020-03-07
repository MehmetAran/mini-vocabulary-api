package vocabulary.services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import vocabulary.model.Sentence;
import vocabulary.model.Voices;
import vocabulary.model.WordDetails;


@Service
public class WordServiceImp implements WordService{
	Document doc;
	public List<String> getTranslatesOfWord(String word) throws IOException {
		ArrayList<String> translates = new ArrayList<String>();
		doc = Jsoup.connect("https://tureng.com/tr/turkce-ingilizce/" + word).get();
		Elements elements = doc.select("td.tr.ts");
		for (org.jsoup.nodes.Element element : elements) {
			translates.add(element.text());
			if(translates.size() == 5)
				return translates;
		}
		return translates;
	}

	public Voices getVoicesOfWord(String word) throws IOException {
		Voices voices = new Voices();
		Elements elements = doc.select("source[src$=.mp3]");
		voices.setUsAccentVoice(elements.get(0).attr("src"));
		voices.setEngAccentVoice(elements.get(1).attr("src"));
		voices.setAusAccentVoices(elements.get(2).attr("src"));
		return voices;
	}

	public List<Sentence> getSentenceAboutWord(String word) throws IOException {
		ArrayList<Sentence> sentences = new ArrayList<Sentence>();

		Document doc = Jsoup.connect("https://www.cumlesozluk.com/word/2358/" + word + ".html").get();
		Elements elements = doc.select("li");
		for (org.jsoup.nodes.Element element : elements) {
			// System.out.println(element);
			int firstEnglishSentenceIndex = element.toString().indexOf("</a>") + 4;
			int lastEnglishSentencesIndex = element.toString().indexOf("\n");
			if (lastEnglishSentencesIndex > 0 && firstEnglishSentenceIndex > 0) {
				int firstTurkisSentenceIndex = element.toString().substring(lastEnglishSentencesIndex)
						.indexOf("green\">") + lastEnglishSentencesIndex + 7;
				int lastTurkishSentencesIndex = element.toString().substring(firstTurkisSentenceIndex).indexOf("</s")
						+ firstTurkisSentenceIndex;
				if (firstTurkisSentenceIndex > 0 && lastTurkishSentencesIndex > 0) {

					String english = element.toString().substring(firstEnglishSentenceIndex, lastEnglishSentencesIndex);
					String turkish = element.toString().substring(firstTurkisSentenceIndex, lastTurkishSentencesIndex);
					english = english.replace("<b>", "");
					english = english.replace("</b>", "");
					english = english.replace("<br>", "");
					english = english.replace("</br>", "");
					turkish = turkish.replace("<b>", "");
					turkish = turkish.replace("</b>", "");
					turkish = turkish.replace("<br>", "");
					turkish = turkish.replace("</br>", "");
					Sentence sentence = new Sentence();
					sentence.setEnglishSentence(english);
					sentence.setTurkishSentence(turkish);
					sentences.add(sentence);				
					if(sentences.size() == 5)
						return sentences;
					
				}
			}
		}
		return sentences;
	}

	public List<String> getImagesLinksByWord(String word) throws IOException {
		ArrayList<String> imagesLinks = new ArrayList<String>();
		Document doc = Jsoup.connect("https://www.shutterstock.com/tr/search/" + word).get();
		Elements elements = doc.select("img");
		for (Element element : elements) {
			imagesLinks.add(elements.attr("src"));
			if(imagesLinks.size() == 2)
				return imagesLinks;
				
		}
		return imagesLinks;
	}
	public WordDetails getWordDetails(String word) throws IOException {
		WordDetails wordDetails = new WordDetails();
		wordDetails.setWord(word);
		wordDetails.setTranslates(getTranslatesOfWord(wordDetails.getWord()));
		wordDetails.setSentences(getSentenceAboutWord(wordDetails.getWord()));
		wordDetails.setVoices(getVoicesOfWord(wordDetails.getWord()));
		wordDetails.setImagesLinks(getImagesLinksByWord(wordDetails.getWord()));
		return wordDetails;
	}

}
