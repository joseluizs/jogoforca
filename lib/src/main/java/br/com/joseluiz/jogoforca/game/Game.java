package br.com.joseluiz.jogoforca.game;

import java.util.HashSet;
import java.util.Set;

import br.com.joseluiz.jogoforca.core.Dictionary;
import br.com.joseluiz.jogoforca.core.InvalidCharacterException;
import br.com.joseluiz.jogoforca.core.Word;
import br.com.joseluiz.jogoforca.ui.UI;

public class Game {
	
	private static final int MAX_ERRORS = 5;

	public void start() {

		UI.print("Bem vindo ao jogo da Forca!");
		
		Dictionary dictionary = Dictionary.getInstance();
		Word word = dictionary.nextWord();
		
		UI.print("A palavra tem " + word.size() + " letras! ");
		
		Set<Character> usedChar = new HashSet<>();
		int errorCount = 0;
		
		while (true) {
			UI.print(word);
			UI.printNewLine();
			
			char c;
			try {
				c = UI.readChar("Digite uma letra: ");
				if (usedChar.contains(c)) {
					throw new InvalidCharacterException("Esta letra já foi utilizada! ");
				}
				
				usedChar.add(c);
				if (word.hasChar(c)) {
					UI.print("Voce acertou uma letra! ");
				}
				else {
					errorCount++;
					
					if (errorCount < MAX_ERRORS) {
						UI.print("Voce errou ! Voce ainda pode errar " + (MAX_ERRORS - errorCount) + " vez(es)");
					}
				}
				
				UI.printNewLine();
				
				if (word.discovered()) {
					UI.print("PARABENS! Voce acertou a palavra correta: " + word.getOriginalWord());
					UI.print("Fim do Jogo!");
					break;
				}
				
				if (errorCount == MAX_ERRORS) {
					UI.print("Voce perdeu o jogo! A palavra correta era: " + word.getOriginalWord());
					UI.print("Fim do Jogo!");
					break;
				}
				
			}
			catch (InvalidCharacterException e) {
				UI.print("Erro: " + e.getMessage());
			}
		}
		
	}

}
