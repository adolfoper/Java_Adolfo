package Ejercicios_T5_Anot;

//  El config tiene las clases de escaneo
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("Ejercicios_T5_Anot")

public class CodificaConfig {

	/*
	@Bean
	public IProcesar bloques() {
		return new Bloques();
	}
	
	@Bean
	public IProcesar palabras() {
		return new Palabras();
	}
	
	@Bean
	public ICodificar invertir() {
		return new Invertir();
	}
	
	@Bean
	public ICodificar cesar() {
		return new Cesar();
	}
	
	@Bean
	public Codificador codificador() {
		return new Codificador(bloques(),invertir());
	}
	*/
}
