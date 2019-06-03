package hello;

import static spark.Spark.*;


public class MainServer {
	
	final static Sistema sistema = new Sistema();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 2323;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		/**inicializarVoluntarios();
		inicializarCriancas();
		inicializarLocais();*/

		
		Controller controller = new Controller(sistema);
		controller.buscarVoluntario();
		controller.buscarCrianca();
		controller.buscarVolNome();
		controller.buscarLocNome();
		controller.buscarLocInstituicao();
		controller.deletCrianca();
		controller.deletVoluntario();
		controller.deletLocal();
		controller.setCrianca();
		controller.setVoluntario();
		controller.setLocal();
		
    }
    
    /**public static void inicializarVoluntarios(){
  
    	sistema.addVoluntario(new Voluntario(1,"Valdir",421389746,343916868,"valdir@gmail", 0, null));
    	sistema.addVoluntario(new Voluntario(2,"Jessica",47932043,402020348,"jessica@gmail.com", 0, null));
    	sistema.addVoluntario(new Voluntario(3,"Renato",47932044,402020345,"renato@gmail.com", 0, null));
    	sistema.addVoluntario(new Voluntario(4,"Douglas",421389747,343916867,"douglas@gmail", 0, null));
    }
    
    public static void inicializarCriancas(){
    	  
    	sistema.addCrianca(new Crianca(1,"Ana",10, 0, null));
    	sistema.addCrianca(new Crianca(3,"joao",12, 0, null));
    	sistema.addCrianca(new Crianca(4,"victor",12, 0, null));
    }
    
    public static void inicializarLocais(){
    	sistema.addLocal(new Local(1,"Aps1","Madre Teresa", "Estrada do Jaguari", null));
    	sistema.addLocal(new Local(3,"Teste","Fatec", "Avenida Cesare Mansueto Giulio Lattes", null));
    	sistema.addLocal(new Local(2,"Aps2","Capuava", "Estrada do Capuava", null));
    }
    */
}
