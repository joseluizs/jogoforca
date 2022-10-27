package br.com.joseluiz.jogoforca.game;

import br.com.joseluiz.jogoforca.core.Word;

public class Game {

	public void start() {
		Word word = new Word("casa");
		word.hasChar('a');
		word.hasChar('c');
		word.hasChar('s');
		System.out.println(word);
		System.out.println(word.discovered());
	}

}
