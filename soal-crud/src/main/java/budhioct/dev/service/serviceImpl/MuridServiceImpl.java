package budhioct.dev.service.serviceImpl;

import budhioct.dev.dto.MuridDTO;
import budhioct.dev.entity.Murid;
import budhioct.dev.repository.MuridRepository;
import budhioct.dev.service.MuridService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuridServiceImpl implements MuridService {

    private final MuridRepository muridRepository;

    @Transactional(readOnly = true)
    public List<MuridDTO.MuridResponse> muridList() {

        List<MuridDTO.MuridResponse> list = muridRepository.findAll()
                .stream()
                .map(MuridDTO::toMuridResponse)
                .toList();

        return list;
    }

    @Transactional
    public void muridSave(MuridDTO.MuridRequest request) {
        Murid murid = new Murid();
        murid.setName(request.getName());

        muridRepository.save(murid);
    }

    @Transactional
    public void muridUpdate(MuridDTO.MuridRequestUpdate request) {
        Murid murid = muridRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "murid not found"));

        murid.setName(request.getName());

        muridRepository.save(murid);
    }

    @Transactional
    public void muridDelete(MuridDTO.MuridRequestDetail request) {
        Murid murid = muridRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "murid not found"));

        muridRepository.delete(murid);
    }
}
