package com.mizan.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryRequestDto {
    private String id;
    @NotNull
    @Size(min = 3)
    private String name;
    private String countryCode;
    private String directorId;
    private String playerId;

}
