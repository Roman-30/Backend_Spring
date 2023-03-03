package ru.vsu.cs.javaweb.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.javaweb.dto.ContractDto;
import ru.vsu.cs.javaweb.entity.Contract;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractDto toDto(Contract client);
    Contract toEntity(ContractDto dto);
}
