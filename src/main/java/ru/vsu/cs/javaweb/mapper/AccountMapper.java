package ru.vsu.cs.javaweb.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.javaweb.dto.AccountDto;
import ru.vsu.cs.javaweb.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toDto(Account client);
    Account toEntity(AccountDto dto);
}
