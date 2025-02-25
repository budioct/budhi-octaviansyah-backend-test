package budhioct.dev.service.serviceImpl;

import budhioct.dev.dto.PendidikanDTO;
import budhioct.dev.entity.Murid;
import budhioct.dev.entity.Pendidikan;
import budhioct.dev.repository.MuridRepository;
import budhioct.dev.repository.PendidikanRepository;
import budhioct.dev.service.PendidikanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PendidikanServiceImpl implements PendidikanService {

    private final MuridRepository muridRepository;
    private final PendidikanRepository pendidikanRepository;

    @Transactional(readOnly = true)
    public List<PendidikanDTO.PendidikanResponse> pendidikanList() {

        List<PendidikanDTO.PendidikanResponse> list = pendidikanRepository.findAll()
                .stream()
                .map(PendidikanDTO::toPendidikanResponse).toList();

        return list;
    }

    @Transactional
    public void pendidikanSave(PendidikanDTO.PendidikanRequest request) {
        Murid murid = muridRepository.findById(request.getId_murid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "murid not found"));

        Pendidikan pendidikan = new Pendidikan();
        pendidikan.setMurid(murid);
        pendidikan.setStatus(request.getStatus());

        pendidikanRepository.save(pendidikan);
    }

    @Transactional
    public void pendidikanUpdate(PendidikanDTO.PendidikanRequestUpdate request) {
        Pendidikan pendidikan = pendidikanRepository.findById(request.getId_pendidikan())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "pendidikan not found"));

        pendidikan.setStatus(request.getStatus());

        pendidikanRepository.save(pendidikan);
    }

    @Transactional
    public void pendidikanDelete(PendidikanDTO.PendidikanRequestDetail request) {
        Pendidikan pendidikan = pendidikanRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "pendidikan not found"));

        pendidikanRepository.delete(pendidikan);
    }
}
