
import com.pengrad.telegrambot.model.Update;

public class ControllerSearchVoluntario implements ControllerSearch {	
	
	private Model model;
	private View view;
		
	public ControllerSearchVoluntario(Model model, View view){
		this.model = model; //connection Controller -> Model
		this.view = view; //connection Controller -> View
	}
	
	public void search(Update update) throws Exception{
		view.sendTypingMessage(update);
		model.searchVoluntario(update);
	}

}