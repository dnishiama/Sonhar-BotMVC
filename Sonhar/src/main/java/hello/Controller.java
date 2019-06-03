package hello;

import static spark.Spark.get;//
import static spark.Spark.post;

import java.io.UnsupportedEncodingException;
import java.util.List;//

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;//

import spark.Request;
import spark.Response;
import spark.Route;

public class Controller {
	
	
	private Sistema sistema;
	
	
	public Controller(Sistema sistema){
		this.sistema = sistema;
	}
	
	//busca voluntario  por cpf
	public void buscarVoluntario(){
		get("vol/:cpf", (req, res)->{
			
		   
		    int cpf=Integer.parseInt(req.params(":cpf"));		
			
			Voluntario voluntario= sistema.buscarVoluntario(cpf);
			return new Gson().toJson(voluntario);		
			
		});		
	}
	//busca crianca por nome
	public void buscarCrianca(){
		get("/cri/:nome", (req, res) -> {
		
			List<Crianca> criancasEncontradas = sistema.buscarCrianca(req.params(":nome"));	
			return new Gson().toJson(criancasEncontradas);
			
		});
	}
	// busca voluntario por nome
		public void buscarVolNome(){
			get("/volu/:nome", (req, res) -> {
				
				List<Voluntario> voluntariosEncontrados = sistema.buscarVolNome(req.params(":nome"));	
				return new Gson().toJson(voluntariosEncontrados);
				
			});
	
	}
	//buscar local por nome
		public void buscarLocNome(){
			get("/loc/:nome", (req, res) -> {
				
				List<Local> locaisEncontrados = sistema.buscarLocNome(req.params(":nome"));	
				return new Gson().toJson(locaisEncontrados);
				
			});
	
	}
	//buscar local por nome
		public void buscarLocInstituicao(){
			get("/loca/:instituicao", (req, res) -> {
						
				List<Local> locaisEncontrados = sistema.buscarLocInstituicao(req.params(":instituicao"));	
				return new Gson().toJson(locaisEncontrados);
						
			});
			
		}	
	
		
		//cadastrar criança
		
		public void setCrianca(){
			
			post("/crianca/", new Route() {
				@Override
	            public Object handle(final Request request, final Response response) throws UnsupportedEncodingException{
		        	
		           response.header("Access-Control-Allow-Origin", "*");

		           Gson gson = new Gson();
		           
		           String data = request.body();
		           
		           byte text[] = data.getBytes("ISO-8859-1");
		           String value = new String(text, "UTF-8");
		
		           Crianca crianca = gson.fromJson(value, Crianca.class);

	         	   try {
		            	
		            		sistema.addCrianca(crianca);
	
		            		JSONArray jsonResult = new JSONArray();
		 	         	    JSONObject jsonObj = new JSONObject();
		     
			        		jsonObj.put("status", 1);
			        				
			             	jsonResult.put(jsonObj);

			             	return jsonResult;

		        		} catch (JSONException e) {
		        				
		        			e.printStackTrace();
		        		}
	         	    
	         	    JSONArray jsonResult = new JSONArray();
	         	    JSONObject jsonObj = new JSONObject();
	         	   	
	         	    jsonObj.put("status", 0);
	        		
	             	jsonResult.put(jsonObj);
	             	
	             	return jsonResult;  	   
		        	
			   }
			});     

	         
	    }
		
	//cadastrar voluntario
		
	public void setVoluntario(){
			
		post("/voluntario/", new Route() {
				@Override
				public Object handle(final Request request, final Response response) throws UnsupportedEncodingException{
		        	
					response.header("Access-Control-Allow-Origin", "*");

					Gson gson = new Gson();
		           
					String data = request.body();
		           
					byte text[] = data.getBytes("ISO-8859-1");
					String value = new String(text, "UTF-8");
		
					Voluntario voluntario = gson.fromJson(value, Voluntario.class);

					try {
		            	
						boolean status = sistema.addVoluntario(voluntario);
	         		   
						if(status){
	
							JSONArray jsonResult = new JSONArray();
							JSONObject jsonObj = new JSONObject();
		     
							jsonObj.put("status", 1);
			        				
							jsonResult.put(jsonObj);

							return jsonResult;
						}

					} catch (JSONException e) {
		        				
						e.printStackTrace();
					}
	         	    
					JSONArray jsonResult = new JSONArray();
					JSONObject jsonObj = new JSONObject();
	         	   	
					jsonObj.put("status", 0);
	        		
					jsonResult.put(jsonObj);
	             	
					return jsonResult;  	   
		        	
				}
		});     
	}
	
	//cadastrar Local
	
		public void setLocal(){
				
			post("/local/", new Route() {
					@Override
					public Object handle(final Request request, final Response response) throws UnsupportedEncodingException{
			        	
						response.header("Access-Control-Allow-Origin", "*");

						Gson gson = new Gson();
			           
						String data = request.body();
			           
						byte text[] = data.getBytes("ISO-8859-1");
						String value = new String(text, "UTF-8");
			
						Local local = gson.fromJson(value, Local.class);

						try {
			            	
							boolean status = sistema.addLocal(local);
		         		   
							if(status){
		
								JSONArray jsonResult = new JSONArray();
								JSONObject jsonObj = new JSONObject();
			     
								jsonObj.put("status", 1);
				        				
								jsonResult.put(jsonObj);

								return jsonResult;
							}

						} catch (JSONException e) {
			        				
							e.printStackTrace();
						}
		         	    
						JSONArray jsonResult = new JSONArray();
						JSONObject jsonObj = new JSONObject();
		         	   	
						jsonObj.put("status", 0);
		        		
						jsonResult.put(jsonObj);
		             	
						return jsonResult;  	   
			        	
					}
			});     
		}
		
		//delete criança
		public void deletCrianca(){
			
			post("/crianca/delete", new Route() {
				@Override
	            public Object handle(final Request request, final Response response){
		        	
		           response.header("Access-Control-Allow-Origin", "*");

		           JSONObject json = new JSONObject(request.body());
		        	
		           
		        	
		           int number = Integer.parseInt(json.getString("number"));
		        	
		           
		           
		           
		           
	         	    
	         	   try {
		            		sistema.deleteCrianca(number);
		            		
		            		
		            		
		            		
		            		JSONArray jsonResult = new JSONArray();
		 	         	    JSONObject jsonObj = new JSONObject();
		     
			        		jsonObj.put("status", 1);
			        		
			        		
			             	jsonResult.put(jsonObj);
			             	
			             	
			             	
			             	return jsonResult;
		            		
		            	
		            	
		            	
		             	
		        		} catch (JSONException e) {
		        				
		        			e.printStackTrace();
		        		}
	         	    
	         	    JSONArray jsonResult = new JSONArray();
	         	    JSONObject jsonObj = new JSONObject();
	         	   	
	         	    jsonObj.put("status", 0);
	        		
	        		
	             	jsonResult.put(jsonObj);
	             	
	             	return jsonResult;
	         	   
	         	   
		        	
			   }
			});     

	         
	    }
		//delete voluntario
				public void deletVoluntario(){
					
					post("/voluntario/delete", new Route() {
						@Override
			            public Object handle(final Request request, final Response response){
				        	
				           response.header("Access-Control-Allow-Origin", "*");

				           JSONObject json = new JSONObject(request.body());
				        	
				           
				        	
				           int number = Integer.parseInt(json.getString("number"));
				        	
				           
				           
				           
				           
			         	    
			         	   try {
				            		sistema.deleteVoluntario(number);
				            		
				            		
				            		
				            		
				            		JSONArray jsonResult = new JSONArray();
				 	         	    JSONObject jsonObj = new JSONObject();
				     
					        		jsonObj.put("status", 1);
					        		
					        		
					             	jsonResult.put(jsonObj);
					             	
					             	
					             	
					             	return jsonResult;
				            		
				            	
				            	
				            	
				             	
				        		} catch (JSONException e) {
				        				
				        			e.printStackTrace();
				        		}
			         	    
			         	    JSONArray jsonResult = new JSONArray();
			         	    JSONObject jsonObj = new JSONObject();
			         	   	
			         	    jsonObj.put("status", 0);
			        		
			        		
			             	jsonResult.put(jsonObj);
			             	
			             	return jsonResult;
			         	   
			         	   
				        	
					   }
					});     

			         
			    }
				//delete local
				public void deletLocal(){
					
					post("/local/delete", new Route() {
						@Override
			            public Object handle(final Request request, final Response response){
				        	
				           response.header("Access-Control-Allow-Origin", "*");

				           JSONObject json = new JSONObject(request.body());
				        	
				           
				        	
				           int number = Integer.parseInt(json.getString("number"));
				        	
				           
				           
				           
				           
			         	    
			         	   try {
				            		sistema.deleteLocal(number);
				            		
				            		
				            		
				            		
				            		JSONArray jsonResult = new JSONArray();
				 	         	    JSONObject jsonObj = new JSONObject();
				     
					        		jsonObj.put("status", 1);
					        		
					        		
					             	jsonResult.put(jsonObj);
					             	
					             	
					             	
					             	return jsonResult;
				            		
				            	
				            	
				            	
				             	
				        		} catch (JSONException e) {
				        				
				        			e.printStackTrace();
				        		}
			         	    
			         	    JSONArray jsonResult = new JSONArray();
			         	    JSONObject jsonObj = new JSONObject();
			         	   	
			         	    jsonObj.put("status", 0);
			        		
			        		
			             	jsonResult.put(jsonObj);
			             	
			             	return jsonResult;
			         	   
			         	   
				        	
					   }
					});     

			         
			    }
		
}
	


