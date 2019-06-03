package hello;

import java.util.List;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Sistema {
	

	ObjectContainer voluntarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bancos/voluntarios.db4o");
	ObjectContainer criancas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bancos/criancas.db4o");
	ObjectContainer locais = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bancos/locais.db4o");
	
	//Adicionar voluntario
	public boolean addVoluntario(Voluntario voluntario){
		
		if(isCpfAvailable(voluntario.getCpf())){
			

		    voluntarios.store(voluntario);
		    voluntarios.commit();
			
			return true;
		}
		
		return false;
		
	}
	
	//adicionar  criança
	public void addCrianca(Crianca crianca){
		criancas.store(crianca);
		criancas.commit();
	}
	
	//Adicionar local
	/*public void addLocal(Local local){
		locais.store(local);
	}*/
	
	public boolean addLocal(Local local){
			
			if(isNomeAvailable(local.getNome())){
				
	
			    locais.store(local);
			    locais.commit();
				
				return true;
			}
			
			return false;
			
	}

	
	//Buscar Voluntário por cpf
	public Voluntario buscarVoluntario(int cpf){
		
		
		Query query = voluntarios.query();
		query.constrain(Voluntario.class);
	    ObjectSet<Voluntario> allVoluntarios = query.execute();
		
	    for(Voluntario voluntario:allVoluntarios){
	    	if(voluntario.getCpf()==cpf){
	    		return voluntario;
	    	}
	    	
	    }
	    
	    return null;

		
	}
	
	
	//Buscar Voluntário por nome
	public List<Voluntario> buscarVolNome(String nome){
		
	 List<Voluntario> voluntariosEncontrados = new LinkedList<Voluntario>();
		
		Query query = voluntarios.query();
		query.constrain(Voluntario.class);
	    ObjectSet<Voluntario> allVoluntarios = query.execute();
		
	    for(Voluntario voluntario:allVoluntarios)
	    	if(voluntario.compararvn(nome)) voluntariosEncontrados.add(voluntario);
		if(voluntariosEncontrados.isEmpty())return null;
		else return voluntariosEncontrados;
	    	
	   
	    }
	
	//Buscar Criança por nome
	public List<Crianca> buscarCrianca(String nome){
		
			List<Crianca> criancasEncontradas = new LinkedList<Crianca>();
			
			Query query = criancas.query();
			query.constrain(Crianca.class);
		    ObjectSet<Crianca> allCriancas = query.execute();
			
		    for(Crianca crianca:allCriancas){
		    	
					 if(crianca.compararc(nome)) criancasEncontradas.add(crianca);
		    }
		    return criancasEncontradas;
		    
	}
	    
	
	//Buscar Local por nome
	public List<Local> buscarLocNome(String nome){
	
		List<Local> locaisEncontrados = new LinkedList<Local>();
		
		Query query = locais.query();
		query.constrain(Local.class);
	    ObjectSet<Local> allLocais = query.execute();
		
	    for(Local local:allLocais){
	    	
				 if(local.compararln(nome)) locaisEncontrados.add(local);
	    	}
	    	if(locaisEncontrados.isEmpty())return null;
	    	else return locaisEncontrados;
	    
	    }
	//Buscar Local por nome
	public List<Local> buscarLocInstituicao(String instituicao){
	
		List<Local> locaisEncontrados = new LinkedList<Local>();
		
		Query query = locais.query();
		query.constrain(Local.class);
	    ObjectSet<Local> allLocais = query.execute();
		
	    for(Local local:allLocais){
	    	
				 if(local.compararli(instituicao)) locaisEncontrados.add(local);
	    	}
	    	if(locaisEncontrados.isEmpty())return null;
	    	else return locaisEncontrados;
	    
	    }
		
	// metodos de verificação
	
	public boolean isCpfAvailable(int cpf){
		Query query = voluntarios.query();
		query.constrain(Voluntario.class);
		ObjectSet<Voluntario> allVoluntarios = query.execute();
		   
		for(Voluntario voluntario:allVoluntarios){
			if(voluntario.getCpf() == cpf) return false;
		}
		    
		return true;
	}

	public boolean isNomeAvailable(String nome){
		Query query = locais.query();
		query.constrain(Local.class);
		ObjectSet<Local> allLocais = query.execute();
		   
		for(Local local:allLocais){
			if(local.getNome() == nome) return false;
		}
		    
		return true;
	}
		 

	//delete Voluntario
	public void deleteVoluntario(int voluntarioId){
		Query query = voluntarios.query();
		query.constrain(Voluntario.class);
		List<Voluntario> allVoluntarios = query.execute();
		
		for(Voluntario voluntario:allVoluntarios){
			if(voluntario.getId()== voluntarioId){
				voluntarios.delete(voluntario);
				voluntarios.commit();
				break;
			}
		}
	 }
	
	//delete Crianca
	public void deleteCrianca(int criancaId){
		Query query = criancas.query();
		query.constrain(Crianca.class);
		List<Crianca> allCriancas = query.execute();
		
		for(Crianca crianca:allCriancas){
			if(crianca.getId()== criancaId){
				criancas.delete(crianca);
				criancas.commit();
				break;
			}
		}
	}

	//delete Local
	public void deleteLocal(int localid){
		Query query = locais.query();
		query.constrain(Local.class);
		List<Local> allLocais = query.execute();
		
		for(Local local:allLocais){
			if(local.getId()==localid){
				locais.delete(local);
				locais.commit();
				break;
			}
		}
	}


}

