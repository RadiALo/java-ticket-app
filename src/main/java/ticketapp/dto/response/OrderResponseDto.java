package ticketapp.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private Long userId;
    private LocalDateTime orderTime;
}
