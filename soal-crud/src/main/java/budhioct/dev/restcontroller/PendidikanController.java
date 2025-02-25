package budhioct.dev.restcontroller;


import budhioct.dev.dto.PendidikanDTO;
import budhioct.dev.service.PendidikanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pendidikan")
public class PendidikanController {

    @Autowired
    PendidikanService pendidikanService;

    /**
     * Http Method: GET
     * endpoint: http://localhost:8080/api/v1/pendidikan/list
     */
    @GetMapping(
            path = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, List<PendidikanDTO.PendidikanResponse>>> list() {
        List<PendidikanDTO.PendidikanResponse> muridResponses = pendidikanService.pendidikanList();
        Map<String, List<PendidikanDTO.PendidikanResponse>> response = new HashMap<>();
        response.put("pendidikan_list", muridResponses);
        return ResponseEntity.ok(response);
    }

    /**
     * Http Method: Post
     * endpoint: http://localhost:8080/api/v1/pendidikan/1/save
     *
     * request path variable for murid: 1 ~ n
     * request body:
     * {
     *     "status" : "TK || SD || SMP || SMA || SMK || KULIAH || Putus Sekolah"
     * }
     */
    @PostMapping(
            path = "{id_murid}/save"
    )
    public ResponseEntity<String> save(@PathVariable(name = "id_murid") Long id_murid,
                                       @RequestBody PendidikanDTO.PendidikanRequest request) {
        request.setId_murid(id_murid);
        pendidikanService.pendidikanSave(request);
        return ResponseEntity.ok("success");
    }

    /**
     * Http Method: Put
     * endpoint: http://localhost:8080/api/v1/pendidikan/1/murid/1/update
     *
     * request path variable for pendidikan and murid: 1 ~ n
     * request body:
     * {
     *     "status" : "*TK || SD || SMP || SMA || SMK || KULIAH || Putus Sekolah"
     * }
     *
     * Response:
     * success
     */
    @PutMapping(
            path = "{id_pendidikan}/murid/{id_murid}/update",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> save(@PathVariable(name = "id_murid") Long id_murid,
                                       @PathVariable(name = "id_pendidikan") Long id_pendidikan,
                                       @RequestBody PendidikanDTO.PendidikanRequestUpdate request) {
        request.setId_pendidikan(id_pendidikan);
        request.setId_murid(id_murid);
        pendidikanService.pendidikanUpdate(request);
        return ResponseEntity.ok("success");
    }

    /**
     * Http Method: Delete
     * endpoint: http://localhost:8080/api/v1/pendidikan/1/delete
     *
     * request path variable: 1 ~ n
     */
    @DeleteMapping(
            path = "/{id}/delete",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> delete(@PathVariable("id") Long id,
                                         PendidikanDTO.PendidikanRequestDetail request) {
        request.setId(id);
        pendidikanService.pendidikanDelete(request);
        return ResponseEntity.ok("success");
    }

}
