import java.util.Map;


public record Moneda(
        String result,
        long time_last_update_unix,
        String time_last_update_utc,
        long time_next_update_unix,
        String time_next_update_utc,
        String base_code,
        String target_code,
        double conversion_rate
) {}
