package app.gt.dulcegusto.publimovil.dulcegusto;

import java.util.ArrayList;

/**
 * Created by carlos on 9/02/17.
 */

public class QuestionUtils {

    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> answers1 = new ArrayList<>();
    ArrayList<String> answers2 = new ArrayList<>();
    ArrayList<String> answers3 = new ArrayList<>();
    ArrayList<String> answers4 = new ArrayList<>();


    public QuestionUtils(){
        initializeQuestions();
        initializeAnswers();
    }

    /*
    * Following method will initialize all the questions required
    */
    private void initializeQuestions() {
        //System.out.println("initializeQuestions");
        questions.add("¿Cual es tu sexo?");
        questions.add("¿Que edad tienes?");
        questions.add("¿Cual es tu color favorito?");
        questions.add("¿A que hora te gusta tomar el cafe?");
        //System.out.println(questions.get(1));
    }

    /*
    * Following method will initialize all the answers required
    */
    private void initializeAnswers(){
        answers1.add("Hombre");
        answers1.add("Mujer");
        answers2.add("Menor de 18");
        answers2.add("Entre 18 y 24 años");
        answers2.add("Entre 25 y 29 años");
        answers2.add("Entre 30 y 39 años");

        answers2.add("Entre 40 y 59 años");
        answers2.add("Entre 60 a 69 años");
        answers2.add("Mas de 70 años");


        answers3.add("Amarillo");
        answers3.add("Azul");
        answers3.add("Blanco");
        answers3.add("Café");
        answers3.add("Morado/Violeta");
        answers3.add("Naranja");
        answers3.add("Negro");
        answers3.add("Rojo");
        answers3.add("Rosado");
        answers3.add("Verde");


        answers4.add("En la mañana");
        answers4.add("En la mañana y en la tarde");
        answers4.add("En la mañana y en la noche");
        answers4.add("En la tarde");
        answers4.add("En la noche");
        answers4.add("Todo el dia");


    }
/*
    private void initializeAnswers(){
        answers1.add("Hombre");
        answers1.add("Mujer");
        answers2.add("Menor de 18");
        answers2.add("Entre 18 y 24 años");
        answers2.add("Entre 25 y 29 años");
        answers2.add("Entre 30 y 39 años");

        answers2.add("Entre 40 y 59 años");
        answers2.add("Entre 60 a 69 años");
        answers2.add("Mas de 70 años");


        answers3.add("Amarillo");
        answers3.add("Azul");
        answers3.add("Azul turquesa");
        answers3.add("Blanco");
        answers3.add("Café");
        answers3.add("Celeste");
        answers3.add("Dorado");
        answers3.add("Gris");
        answers3.add("Morado/Violeta");
        answers3.add("Naranja");
        answers3.add("Negro");
        answers3.add("Plateado");
        answers3.add("Rojo");
        answers3.add("Rosado");
        answers3.add("Verde");


        answers4.add("En la mañana");
        answers4.add("En la mañana y en la tarde");
        answers4.add("En la mañana y en la noche");
        answers4.add("En la tarde");
        answers4.add("En la noche");
        answers4.add("Todo el dia");


    }
*/
}
