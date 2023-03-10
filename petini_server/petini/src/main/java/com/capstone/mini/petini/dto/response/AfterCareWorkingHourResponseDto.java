package com.capstone.mini.petini.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AfterCareWorkingHourResponseDto {
    private Long id;
    private String timeLabel;
    private String timeValue;
    private String startDate;
    private String status;
}
