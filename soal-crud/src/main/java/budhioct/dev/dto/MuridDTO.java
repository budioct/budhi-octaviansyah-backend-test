package budhioct.dev.dto;

import budhioct.dev.entity.Murid;
import budhioct.dev.entity.Pendidikan;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

public class MuridDTO {

    @Getter
    @Setter
    @Builder
    public static class MuridResponse {
        private Long id;
        private String name;
        private Timestamp timeAt;
        private List<PendidikanResponse> pendidikan;

    }

    @Getter
    @Setter
    @Builder
    public static class PendidikanResponse {
        private Long id;
        private String status;
        private Timestamp timeAt;
    }

    public static MuridResponse toMuridResponse(Murid murid) {
        return MuridResponse.builder()
                .id(murid.getId())
                .name(murid.getName())
                .pendidikan(murid.getPendidikans().stream().map(MuridDTO::toPendidikanResponse).toList())
                .build();
    }

    public static PendidikanResponse toPendidikanResponse(Pendidikan pendidikan) {
        return PendidikanResponse.builder()
                .id(pendidikan.getId())
                .status(pendidikan.getStatus())
                .build();
    }

}
