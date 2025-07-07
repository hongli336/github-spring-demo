package com.example.spring_demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Data
Generates:

Getters and setters for all fields

toString()

equals() and hashCode()

Use this when you want a full-featured POJO (standard for DTOs).

2. @NoArgsConstructor
Generates a no-arguments constructor: new APIResponse()

3. @AllArgsConstructor
Generates a constructor with all fields:
new APIResponse("Success", true)

 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse {
    public String message;
    private boolean status;
}
