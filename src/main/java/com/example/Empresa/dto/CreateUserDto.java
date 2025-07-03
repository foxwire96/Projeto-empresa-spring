package com.example.Empresa.dto;

import com.example.Empresa.Enum.RoleName;

public record CreateUserDto(

        String email,
        String password,
        RoleName role

) {
}