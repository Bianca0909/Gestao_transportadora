package br.com.devtigestaotransportadora.bo;

import br.com.devti.gestaotransportadora.DAO.ClienteDAO;
import br.com.devti.gestaotransportadora.DAO.ColaboradorDAO;
import br.com.devti.gestaotransportadora.entity.ClienteEntity;
import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import java.util.List;

public class ColaboradorBO {

    private void validarColaborador(ColaboradorEntity colaborador) throws NegocioException {
        if (colaborador == null) {
            throw new NegocioException("O colaborador nao pode ser nulo.");
        }
        if (colaborador.getName() == null || colaborador.getName().equals("")) {
            throw new NegocioException("O nome do colaborador deve ser preenchido.");
        }
        if (colaborador.getCpf() == null || colaborador.getCpf().equals("")) {
            throw new NegocioException("O documento do colaborador deve ser preenchido.");
        }

    }
      public String salvarColaborador(ColaboradorEntity colaborador) throws NegocioException {

        validarColaborador(colaborador);

        ColaboradorDAO colaboradorDao = new ColaboradorDAO();
        return colaboradorDao.salvarColaborador(colaborador);
    }
      
       public String alterarColaborador(ColaboradorEntity colaborador) throws NegocioException {

        validarColaborador(colaborador);

        return new ColaboradorDAO().alterarColaborador(colaborador);
    }

        public List<ColaboradorEntity> listarColaboradores() throws NegocioException {
        return new ColaboradorDAO().listarColaboradores();
    }
        
    public void excluirColaborador(int id) throws NegocioException {
        new ColaboradorDAO().excluirColaborador(id);
    }

    public ColaboradorEntity buscarColaboradorPorId(int id) throws NegocioException {
        return new ColaboradorDAO().buscarColaboradorPorId(id);
    }

}
