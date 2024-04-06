package interfaces;

import models.Livro;
import models.Usuario;

public interface TrocaDeLivros {
    public void solicitarTroca(int idDestino, int idOrigem, Usuario usuarioLogged);

    public void mostrarSolicitacoesDeTrocas(Usuario usuarioNormal);

    public void realizarTroca(Usuario usuarioLogged, int opcao);

    public void removerLivro(Usuario usuario, Livro livro);
}