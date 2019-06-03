
import com.pengrad.telegrambot.model.Update;

public class ControllerSearchCrianca implements ControllerSearch{	
	
	private Model model;
	private View view;
	
	public ControllerSearchCrianca(Model model, View view){
		this.model = model; //connection Controller -> Model
		this.view = view; //connection Controller -> View
	}
	
	public void search(Update update) throws Exception{
		view.sendTypingMessage(update);
		model.searchCrianca(update);
	}

}