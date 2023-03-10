package com.capstone.mini.petini.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AfterCareWorkingHourRequestDto {
    private String timeLabel;
    private String timeValue;
    private String startDate;
}
