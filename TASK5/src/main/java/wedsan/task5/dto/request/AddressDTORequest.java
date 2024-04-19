package wedsan.task5.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Represents a request Data Transfer Object for an address.
 */
public record AddressDTORequest(
        @NotBlank
        String street,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipCode,
        @NotBlank
        String city,
        @NotBlank
        String state,

        @NotBlank
        String houseNumber
) {
}
