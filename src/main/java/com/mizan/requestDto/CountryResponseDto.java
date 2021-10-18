package com.mizan.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CountryResponseDto {
    private String id;
    private String name;
    private String directorName;
    private String directorEmail;
    private List<String> playerNames;
}
