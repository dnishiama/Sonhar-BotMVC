import java.util.LinkedList;
import java.util.List;
import com.pengrad.telegrambot.model.Update;

public class Model implements Subject{
	
	private List<Observer> observers = new LinkedList<Observer>();
	private List<Crianca> criancas = new LinkedList<Crianca>();
	private List<Local> locais = new LinkedList<Local>();
	
	Connection connection = new Connection();
	
	private static Model uniqueInstance;
	
	private Model(){}
	
	public static Model getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Model();
		}
		return uniqueInstance;
	}
	
	public void registerObserver(Observer observer){
		observers.add(observer);
	}
	
	public void notifyObservers(long chatId, String studentsData){
		for(Observer observer:observers){
			observer.update(chatId, studentsData);
		}
	}
	
	public void addCrianca(Crianca crianca){
		this.criancas.add(crianca);
	}
	
	public void searchCrianca(Update update) throws Exception{
		int criancasData = 0;
		criancasData = connection.sendGetCri(update.message().text());
		System.out.println("Return do SendGet: " + connection.sendGetCri(update.message().text()));
		
		if(criancasData != 0){
			this.notifyObservers(update.message().chat().id(),"Idade: "+ criancasData + " anos.");
		} else {
			this.notifyObservers(update.message().chat().id(), "Criança nao encontrada");
		}
	}
		
	public void searchVoluntario(Update update) throws Exception{
	String voluntariosData = null;
	voluntariosData = connection.sendGetVol(update.message().text());
	System.out.println("Return do SendGet: " + connection.sendGetVol(update.message().text()));
	if(voluntariosData != null)
		{
			this.notifyObservers(update.message().chat().id(),"E-mail: "+voluntariosData);
		} 
	else 
		{
			this.notifyObservers(update.message().chat().id(), "Voluntario não encontrado");
		}
	}		
						 
	public void addLocal(Local local){
		this.locais.add(local);
	}	
		
	public void searchLocal(Update update) throws Exception{
		String locaisData = null;
		locaisData = connection.sendGetLoc(update.message().text());
		System.out.println("Return do SendGet: " + connection.sendGetLoc(update.message().text()));
		
		if(locaisData != null){
			this.notifyObservers(update.message().chat().id(), "Endereço: "+locaisData);
		} else {
			this.notifyObservers(update.message().chat().id(), "Local não encontrado");
		}
	}	

}
