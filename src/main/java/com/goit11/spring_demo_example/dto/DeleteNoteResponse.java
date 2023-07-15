package com.goit11.spring_demo_example.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeleteNoteResponse {
    private boolean success;
    private Error error;

    public enum Error {
        ok,
        invalidIdNote
    }


    public static DeleteNoteResponse success(){
        return DeleteNoteResponse.builder()
                .success(true)
                .error(DeleteNoteResponse.Error.ok)
                .build();
    }
    public static DeleteNoteResponse failed(DeleteNoteResponse.Error error){
        return DeleteNoteResponse.builder()
                .success(false)
                .error(Error.invalidIdNote)
                .build();
    }
}
