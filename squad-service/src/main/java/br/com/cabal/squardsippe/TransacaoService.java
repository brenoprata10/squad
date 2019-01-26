package br.com.cabal.squardsippe;

import br.com.cabal.squardsippe.model.Transacao;
import br.com.cabal.squardsippe.model.Usuario;
import br.com.cabal.squardsippe.model.dto.TransacaoDTO;
import br.com.cabal.squardsippe.model.dto.UsuarioDTO;
import br.com.cabal.squardsippe.repository.TransacaoRepository;
import br.com.cabal.squardsippe.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<TransacaoDTO> listar() {

        List<TransacaoDTO> transacaoDTOS = new ArrayList<>();
        this.transacaoRepository.findAll().forEach(u -> {
        	TransacaoDTO transacaoDTO = new TransacaoDTO();
            BeanUtils.copyProperties(u, transacaoDTO);
            transacaoDTOS.add(transacaoDTO);
        });
        return transacaoDTOS;
    }

    public TransacaoDTO salvar(TransacaoDTO transacaoDTO) {
		Transacao transacao = new Transacao();
    	BeanUtils.copyProperties(transacaoDTO, transacao);
        this.transacaoRepository.save(transacao);
        BeanUtils.copyProperties(transacao, transacaoDTO);
        return transacaoDTO;
    }

    public TransacaoDTO buscarPorId(Long id) {
        Optional<Transacao> optional = this.transacaoRepository.findById(id);
        TransacaoDTO transacaoDTO = new TransacaoDTO();
        BeanUtils.copyProperties(optional.get(), transacaoDTO);
        return transacaoDTO;
    }
}
