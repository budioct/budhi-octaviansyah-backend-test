package budhioct.dev.restcontroller;

import budhioct.dev.dto.MuridDTO;
import budhioct.dev.service.MuridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/murid")
public class MuridRestController {

    @Autowired
    MuridService muridService;

    /**
     * Http Method: GET
     * endpoint: http://localhost:8080/api/v1/murid/list
     */
    @GetMapping(
            path = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, List<MuridDTO.MuridResponse>>> list() {
        List<MuridDTO.MuridResponse> muridResponses = muridService.muridList();
        Map<String, List<MuridDTO.MuridResponse>> response = new HashMap<>();
        response.put("murid_list", muridResponses);
        return ResponseEntity.ok(response);
    }

    /**
     * Http Method: Post
     * endpoint: http://localhost:8080/api/v1/murid/save
     *
     * request body:
     * {
     *     "name" : "test_budhi"
     * }
     */
    @PostMapping(
            path = "/save",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> save(@RequestBody MuridDTO.MuridRequest request) {
        muridService.muridSave(request);
        return ResponseEntity.ok("success");
    }

    /**
     * Http Method: Put
     * endpoint: http://localhost:8080/api/v1/murid/1/update
     *
     * request path variable: 1 ~ n
     * request body:
     * {
     *     "name" : "test_budhi"
     * }
     */
    @PutMapping(
            path = "/{id}/update",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> update(@PathVariable("id") Long id,
                                         @RequestBody MuridDTO.MuridRequestUpdate request
    ) {
        request.setId(id);
        muridService.muridUpdate(request);
        return ResponseEntity.ok("success");
    }

    /**
     * Http Method: Delete
     * endpoint: http://localhost:8080/api/v1/murid/1/delete
     *
     * request path variable: 1 ~ n
     */
    @DeleteMapping(
            path = "/{id}/delete",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> delete(@PathVariable("id") Long id,
                                         MuridDTO.MuridRequestDetail request) {
        request.setId(id);
        muridService.muridDelete(request);
        return ResponseEntity.ok("success");
    }
}
