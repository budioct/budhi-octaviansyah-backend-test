package budhioct.dev.service;

import budhioct.dev.dto.MuridDTO;
import budhioct.dev.dto.PendidikanDTO;

import java.util.List;

public interface PendidikanService {

    List<PendidikanDTO.PendidikanResponse> pendidikanList();
    void pendidikanSave(PendidikanDTO.PendidikanRequest request);
    void pendidikanUpdate(PendidikanDTO.PendidikanRequestUpdate request);
    void pendidikanDelete(PendidikanDTO.PendidikanRequestDetail request);

}
