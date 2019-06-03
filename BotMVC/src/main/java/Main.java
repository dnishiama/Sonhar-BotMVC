//https://github.com/giulianobertoti/RESTful_Android/blob/master/RockChords/app/src/main/java/com/example/giuliano/rockchords/MusicList.java

public class Main {

	private static Model model;
	
	public static void main(String[] args) throws Exception{

		model = Model.getInstance();
		initializeModel(model);
		View view = new View(model);
		model.registerObserver(view); //connection Model -> View
		view.receiveUsersMessages();

	}
	

	public static void initializeModel(Model model){
		/* 
		model.addCrianca(new Crianca("Renato", "Rua 1"));
		model.addCrianca(new Crianca("Valdiri", "Rua 2"));
		model.addCrianca(new Crianca("Douglas", "Rua 3"));
		
		model.addVoluntario(new Voluntario("Diego", "diego@gmail.com"));
		model.addVoluntario(new Voluntario("Marcelo", "marcelo@hotmail.com"));
		model.addVoluntario(new Voluntario("Pedro", "pedrobarros@ig.com.br"));
		
		model.addLocal(new Local("mt11","Madre Teresa"));
    	model.addLocal(new Local("mt2","Madre Teresa"));
    	model.addLocal(new Local("c1","Capuava"));
    	*/
	}

}