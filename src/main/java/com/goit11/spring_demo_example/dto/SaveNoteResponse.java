package com.goit11.spring_demo_example.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class SaveNoteResponse {
    private boolean success;
    private Error error;
    public enum Error {
        ok,
        invalidTitle
    }
    public static SaveNoteResponse success(){
        return SaveNoteResponse.builder()
                .success(true)
                .error(Error.ok)
                .build();
    }
    public static SaveNoteResponse failed(Error error){
        return SaveNoteResponse.builder()
                .success(false)
                .error(Error.invalidTitle)
                .build();
    }
}
