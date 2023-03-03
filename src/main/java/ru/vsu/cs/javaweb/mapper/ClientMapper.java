package ru.vsu.cs.javaweb.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.javaweb.dto.ClientDto;
import ru.vsu.cs.javaweb.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client client);
    Client toEntity(ClientDto dto);
}
