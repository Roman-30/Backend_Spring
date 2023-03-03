package ru.vsu.cs.javaweb.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.javaweb.dto.ManagerDto;
import ru.vsu.cs.javaweb.entity.Manager;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    ManagerDto toDto(Manager client);
    Manager toEntity(ManagerDto dto);
}
