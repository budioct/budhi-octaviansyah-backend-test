package budhioct.dev.dto;

import budhioct.dev.entity.Murid;
import budhioct.dev.entity.Pendidikan;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class PendidikanDTO {

    @Setter
    @Getter
    @Builder
    public static class PendidikanResponse {
        private Long id;
        private String status;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime time_create;
        private MuridRespose murid;
    }

    @Setter
    @Getter
    @Builder
    public static class MuridRespose {
        private Long id;
        private String name;
        private LocalDateTime time_create;
    }

    @Setter
    @Getter
    @Builder
    public static class PendidikanRequest {
        private Long id_murid;
        private String status;
    }

    @Setter
    @Getter
    @Builder
    public static class PendidikanRequestUpdate {
        private Long id_pendidikan;
        private Long id_murid;
        private String status;
    }

    @Setter
    @Getter
    @Builder
    public static class PendidikanRequestDetail {
        private Long id;
    }

    public static PendidikanResponse toPendidikanResponse(Pendidikan pendidikan) {
        return PendidikanResponse.builder()
                .id(pendidikan.getId())
                .status(pendidikan.getStatus())
                .time_create(pendidikan.getTimeAt())
                .murid(toMuridRespose(pendidikan.getMurid()))
                .build();
    }

    public static MuridRespose toMuridRespose(Murid murid){
        return MuridRespose.builder()
                .id(murid.getId())
                .name(murid.getName())
                .time_create(murid.getTimeAt())
                .build();
    }

}
