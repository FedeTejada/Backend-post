package com.example.Post_api.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username","massage","jwt","status"})
public record AuthResponseDTO(String username, String message, String jwt,boolean status) {
}
