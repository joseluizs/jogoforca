package br.com.joseluiz.jogoforca.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.joseluiz.jogoforca.game.GameException;
import br.com.joseluiz.jogoforca.utils.RandomUtils;

public class Dictionary {
	
	private static final String FILE_NAME = "dicionario.txt";
	
	private static Dictionary instance;
	
	private List<String> words = new ArrayList<>();
	
	private Dictionary() {
		load();
	}
	
	public static Dictionary getInstance() {
		if (instance == null) {
			instance = new Dictionary();
		}
		return instance;
	}
	
	private void load() {
		try (Scanner sc = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))){
			
			while (sc.hasNext()) {
				String word = sc.nextLine().trim();
				words.add(word);
			}
			if (words.size() == 0) {
				throw new GameException("A lista de palavras não pode ser vazia!");
			}
		}
	}
	
	public Word nextWord() {
		int pos = RandomUtils.newRandomNumber(0, words.size());
		return new Word(words.get(pos));
	}
	
}
