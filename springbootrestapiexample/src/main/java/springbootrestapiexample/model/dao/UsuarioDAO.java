package springbootrestapiexample.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootrestapiexample.model.Usuario;
import springbootrestapiexample.repository.UsuarioRepository;

@Service
public class UsuarioDAO {

	@Autowired
	UsuarioRepository  usuarioRepository;
	
	/*crear un usuario*/
	
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.crearUsuario(usuario);
	}
	
	/*buscar todos los usuario*/
	public List<Usuario> buscarTodos(){
		return usuarioRepository.buscarTodos();
	}
	
	/*buscar un usuario*/
	public Usuario buscarUno (int id) {
		return usuarioRepository.buscarUno(id);
	}
	
	
	/*borrar un usuario*/
	public void eliminarUsuario (Usuario usuario) {
		usuarioRepository.eliminarUsuario(usuario);
	}
	
}
