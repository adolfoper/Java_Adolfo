package Ejercicios_T5_Anot;

//Sin component scan (Da error al definir el bean codificador)
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CodificaConfig2 {
	
	@Bean
	public IProcesar palabras() {
		return new Palabras();
	}

	
	@Bean
	public ICodificar cesar() {
		return new Cesar();
	}
	
	@Bean
	public Codificador codificador() {
		return new Codificador(palabras(),cesar());
	}
	
}
