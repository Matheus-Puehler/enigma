import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class MapManager {
	
	private LinkedHashMap<String, String> map;
	private Random rand = new Random();
	private String perguntaAtual;
	private boolean JOGO_ACABADO = false;
	
	public MapManager() {
		
		map = new LinkedHashMap<>();
		novoJogo();
	}
	
	public void novoJogo() {
		map.clear();
		map.put("Quantos anos eu tenho?", "16");
		map.put("Qual o meu nome?", "patrick");
		map.put("Onde eu nasci?", "curitiba");
		nova_pergunta();
		JOGO_ACABADO = false;
	}
	
	private void gameOver() {
		JOGO_ACABADO = true;
		perguntaAtual = null;
		map.clear();
	}
	
	public boolean tentativa(String tentativa) {
		if(jogoAcabado()) return false;
		
		boolean acertou = tentativa.toLowerCase().equals(map.get(getPerguntaAtual()));
		
		if(acertou) {
			map.remove(getPerguntaAtual());
			nova_pergunta();
		}
		
		return acertou;
	}
	
	public String nova_pergunta() {		
		
		if(map.size() == 0) {
			gameOver();
			return "O jogo acabou po!";
		}
		
		int randValue = rand.nextInt(map.size());
		
		List<String> keysetList = new ArrayList<>();
		keysetList.addAll(map.keySet());
		
		perguntaAtual = keysetList.get(randValue);
		
		return perguntaAtual;
	}
	
	public boolean jogoAcabado() {
		return JOGO_ACABADO;
	}
	
	public String getPerguntaAtual() {
		return perguntaAtual;
	}
}
