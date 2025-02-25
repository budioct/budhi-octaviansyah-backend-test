package budhioct.dev.restcontroller;

import budhioct.dev.dto.MuridDTO;
import budhioct.dev.service.MuridService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/murid")
public class MuridRestController {

    MuridService muridService;

    public Map<String, List<MuridDTO.MuridResponse>> list(){

    }
}
