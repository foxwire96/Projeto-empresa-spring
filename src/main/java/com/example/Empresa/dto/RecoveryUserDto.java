package com.example.Empresa.dto;

import com.example.Empresa.Entity.Role;

import java.util.List;

public record RecoveryUserDto(

        Long id,
        String email,
        List<Role> roles

) {
}