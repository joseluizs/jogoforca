package br.com.joseluiz.jogoforca.game;

import br.com.joseluiz.jogoforca.core.Dictionary;
import br.com.joseluiz.jogoforca.core.Word;

public class Game {

	public void start() {

		Dictionary d = Dictionary.getInstance();
		System.out.println(d);
		
		Word w = d.nextWord();
		System.out.println(w.getOriginalWord());
		
		
	}

}
