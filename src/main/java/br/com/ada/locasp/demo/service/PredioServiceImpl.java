package br.com.ada.locasp.demo.service;

import br.com.ada.locasp.demo.domain.Endereco;
import br.com.ada.locasp.demo.domain.Predio;
import br.com.ada.locasp.demo.dto.EnderecoDTO;
import br.com.ada.locasp.demo.dto.PredioSaveDTO;
import br.com.ada.locasp.demo.exceptions.ApartamentoNotFoundException;
import br.com.ada.locasp.demo.exceptions.PredioNotFoundException;
import br.com.ada.locasp.demo.repository.PredioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PredioServiceImpl implements PredioService {

    private final PredioRepository repository;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Predio> list() {
        return (List<Predio>) repository.findAll();
    }

    @Override
    public Predio save(Predio predio) {
        String url = "https://cdn.apicep.com/file/apicep/" + predio.getEndereco().getCep() + ".json";
        EnderecoDTO response = restTemplate.getForObject(url, EnderecoDTO.class);
        Endereco endereco = new Endereco();
        endereco.setCep(response.getCep());
        endereco.setLogradouro(response.getAddress() + " " + response.getDistrict() + " " + response.getCity());
        predio.setEndereco(endereco);
        return repository.save(predio);
    }

    @Override
    public Predio findById(Long id){
        return repository.findById(id).orElseThrow(ApartamentoNotFoundException::new);
    }

    @Override
    public Predio update(Long id, Predio predio){
        if (repository.existsById(id)) {
            predio.setId(id);
            return repository.save(predio);
        }
        throw new PredioNotFoundException();
    }

    @Override
    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new PredioNotFoundException();
        }
        repository.deleteById(id);
    }
}