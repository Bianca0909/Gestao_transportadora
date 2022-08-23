package br.com.devti.gestaotransportadora.service;

import java.util.List;

import br.com.devti.gestaotransportadora.entity.ColaboradorEntity;
import br.com.devti.gestaotransportadora.util.exception.NegocioException;
import br.com.devtigestaotransportadora.bo.ColaboradorBO;

public class ColaboradorService {

    public String cadastrarColaborador(ColaboradorEntity colaborador) throws NegocioException {
        ColaboradorBO colaboradorBo = new ColaboradorBO();
        return colaboradorBo.salvarColaborador(colaborador);
    }

    public List<ColaboradorEntity> listarColaborador() throws NegocioException {
        return new ColaboradorBO().listarColaboradores();
    }

    public void excluirColaborador(Integer id) throws NegocioException {
        new ColaboradorBO().excluirColaborador(id);
    }

    public String alterarColaborador(ColaboradorEntity colaborador) throws NegocioException {
        return new ColaboradorBO().alterarColaborador(colaborador);
    }

    public ColaboradorEntity buscarColaboradorPorId(Integer id) throws NegocioException {
        return new ColaboradorBO().buscarColaboradorPorId(id);
    }
    public List<ColaboradorEntity> buscarColaboradorFiltrado(ColaboradorEntity colaborador) throws NegocioException {
    	return new ColaboradorBO().buscarColaboradorFiltrado(colaborador);
    	}
}
