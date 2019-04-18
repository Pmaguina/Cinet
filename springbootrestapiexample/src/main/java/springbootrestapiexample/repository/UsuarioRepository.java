package springbootrestapiexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootrestapiexample.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario crearUsuario(Usuario usuario);

	public List<Usuario> buscarTodos();

	public Usuario buscarUno(int id);

	public void eliminarUsuario(Usuario usuario);

}
