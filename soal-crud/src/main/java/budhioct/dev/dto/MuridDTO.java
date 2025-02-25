package budhioct.dev.dto;

import budhioct.dev.entity.Murid;
import budhioct.dev.entity.Pendidikan;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class MuridDTO {

    @Getter
    @Setter
    @Builder
    public static class MuridResponse {
        private Long id;
        private String name;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime time_create;
        private List<PendidikanResponse> pendidikan;

    }

    @Getter
    @Setter
    @Builder
    public static class PendidikanResponse {
        private Long id;
        private String status;
        private LocalDateTime time_create;
    }

    @Getter
    @Setter
    @Builder
    public static class MuridRequest {
        private String name;
    }

    @Getter
    @Setter
    @Builder
    public static class MuridRequestUpdate {
        private Long id;
        private String name;
    }

    @Getter
    @Setter
    @Builder
    public static class MuridRequestDetail {
        private Long id;
    }

    public static MuridResponse toMuridResponse(Murid murid) {
        return MuridResponse.builder()
                .id(murid.getId())
                .name(murid.getName())
                .time_create(murid.getTimeAt())
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
