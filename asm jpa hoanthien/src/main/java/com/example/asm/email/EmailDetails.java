package com.example.asm.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDetails {
    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
