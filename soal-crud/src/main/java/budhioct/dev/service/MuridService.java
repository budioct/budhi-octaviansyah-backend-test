package budhioct.dev.service;

import budhioct.dev.dto.MuridDTO;

import java.util.List;

public interface MuridService {

    List<MuridDTO.MuridResponse> muridList();
    void muridSave(MuridDTO.MuridRequest request);
    void muridUpdate(MuridDTO.MuridRequestUpdate request);
    void muridDelete(MuridDTO.MuridRequestDetail request);
}
