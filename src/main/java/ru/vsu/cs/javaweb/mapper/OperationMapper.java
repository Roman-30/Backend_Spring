package ru.vsu.cs.javaweb.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.javaweb.dto.OperationDto;
import ru.vsu.cs.javaweb.entity.Operation;

@Mapper(componentModel = "spring")
public interface OperationMapper {
    OperationDto toDto(Operation client);
    Operation toEntity(OperationDto dto);
}
