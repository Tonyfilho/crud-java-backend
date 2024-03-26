package com.pt.tony.crudjava;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.pt.tony.crudjava.enums.Category;
import com.pt.tony.crudjava.model.Course;
import com.pt.tony.crudjava.model.Lesson;
import com.pt.tony.crudjava.repository.CourseRepository;

@SpringBootApplication
public class CrudJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudJavaApplication.class, args);
	}

	/**So para titulo, estaremos iniciando e abastecendo o banco de dados aqui, isto é errado, mas é didatico */
	@Bean
	@Profile("dev") /**Temos que especificar  o profile, q neste caso será o DEv do application-dev */
	CommandLineRunner initDataBase (CourseRepository courseRepository) {
	

		return args -> {
			courseRepository.deleteAll(); // limpando o que existir
		 for(int i = 0; i< 20; i++) {
					Course c = new Course();
					c.setName("Angular Com Spring" +i);
					c.setCategory(Category.FRONT_END);			
					
					Lesson locaLesson = new Lesson();
					locaLesson.setName("Introduction");
					locaLesson.setYoutubeUrl("vRf1-Z4_7vI?si=ms6gI1ymDnpcOm");
					locaLesson.setCourse(c); /** setando o Objeto Course dentro da Entidade Lesson */
					c.getLessons().add(locaLesson);
					//courseRepository.save(c);

					Lesson l2 = new Lesson();
					l2.setName("Angular");
					l2.setYoutubeUrl("vRf1-Z4_7vI?si=ms6gI1ymDnpcOm");
					l2.setCourse(c); /** setando o Objeto Course dentro da Entidade Lesson */
					c.getLessons().add(l2);
					courseRepository.save(c);
			 };

		 };
		 
	}
}
