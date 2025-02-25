package budhioct.dev.service.serviceImpl;

import budhioct.dev.dto.MuridDTO;
import budhioct.dev.entity.Murid;
import budhioct.dev.repository.MuridRepository;
import budhioct.dev.service.MuridService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MuridServiceImpl implements MuridService {

    private final MuridRepository muridRepository;

    @Transactional(readOnly = true)
    public List<MuridDTO.MuridResponse> muridList() {

        List<Murid> list = muridRepository.findAll();

        return list.stream().map(MuridDTO::toMuridResponse).toList();
    }
}
