package Intrumento;

public class Campana extends Instrumento{

	public Campana() {
		
	}

	@Override
	public void add(int numero) {
		
		for(int i = 0; i < notas.length; i++) {
			
			if(numero > 0) {
				if((notas[i] == 0)) {
					notas[i] = numero;
					break;
				}
			}
			
		}
		
	}

	@Override
	public int interpretar(int notaMusical) {
		
		return notas[notaMusical];
	}
	
}
